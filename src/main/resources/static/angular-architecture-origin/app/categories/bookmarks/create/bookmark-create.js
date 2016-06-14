/**
 * Created by donghoon on 2016. 6. 11..
 */
angular.module('categories.bookmarks.create', [])

    .config(function ($stateProvider) {
        $stateProvider
            .state('app.categories.bookmarks.create', {
                url: '/bookmark/create',
                templateUrl: '../../static/angular-architecture-origin/app/categories/bookmarks/create/bookmark-create.tmpl.html',
                controller: 'CreateBookmarkCtrl as createBookmarkCtrl'
            })
    })

    .controller('CreateBookmarkCtrl', function ($state, $stateParams, BookmarksModel) {

        var createBookmarkCtrl = this;

        function returnToBookmarks() {
            $state.go('app.categories.bookmarks', {
                category: $stateParams.category
            })
        }

        function cancelCreating() {
            returnToBookmarks();
        }

        function createBookmark(bookmark) {
            BookmarksModel.createBookmark(bookmark);
            returnToBookmarks();
        }

        function resetForm() {
            createBookmarkCtrl.newBookmark = {
                title: '',
                url: '',
                category: $stateParams.category
            }
        }

        resetForm();

        createBookmarkCtrl.cancelCreating = cancelCreating;
        createBookmarkCtrl.createBookmark = createBookmark;
    })
;

