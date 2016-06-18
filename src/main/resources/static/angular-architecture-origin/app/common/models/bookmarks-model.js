/**
 * Created by donghoon on 2016. 6. 11..
 */
angular.module('devarchi33.models.bookmarks', [])

    .service('BookmarksModel', function ($http, $q) {
        var model = this,
            URLS = {
                FETCH: '/bookmarks'
            },
            bookmarks;


        function extract(result) {
            return result.data;
        }

        function cacheBookmark(result) {
            bookmarks = extract(result);
            return bookmarks;
        }

        function findBookmarkById(bookmarkId) {
            return _.find(bookmarks, function (bookmark) {
                return bookmark.id === parseInt(bookmarkId, 10);
            })
        }

        model.getBookmarkById = function (bookmarkId) {

            var deffered = $q.defer();

            if (bookmarks) {
                deffered.resolve(findBookmarkById(bookmarkId));
            } else {
                model.getBookmarkList().then(function () {
                    deffered.resolve(findBookmarkById(bookmarkId));
                })
            }

            return deffered.promise;
        };

        model.getBookmarkList = function () {
            return (bookmarks) ? $q.when(bookmarks) : $http.get(URLS.FETCH).then(cacheBookmark);
        };

        model.createBookmark = function (bookmark) {
            if (bookmark.title !== "" && bookmark.url !== "") {
                bookmark.id = bookmarks.length;

                $http.put(URLS.FETCH, bookmark)
                    .then(function (response) {
                            alert('success to save ' + response);
                            console.log(response);
                        },
                        function (error) {
                            //TODO: _csrf token 처리하기.
                            alert('fail to save bookmark to server because: ' + error.data.message);
                            console.error(error);
                            bookmarks.push(bookmark);
                        });
            } else {
                alert("please input field...");
            }
        };

        model.updateBookmark = function (bookmark) {
            var index = _.findIndex(bookmarks, function (b) {
                return b.id === bookmark.id;
            })

            bookmarks[index] = bookmark;
        }

        model.deleteBookmark = function (bookmark) {
            var checkDelete = confirm("Really Delete?");

            if (checkDelete) {
                _.remove(bookmarks, function (b) {
                    return b.id === bookmark.id;
                })
            }
        }
    });

