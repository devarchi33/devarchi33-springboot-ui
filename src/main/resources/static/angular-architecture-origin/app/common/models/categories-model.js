/**
 * Created by donghoon on 2016. 6. 11..
 */
angular.module('devarchi33.models.categories', [])

    .service('CategoriesListModel', function ($http, $q) {
        var model = this,
            URLS = {
                FETCH: '../../static/angular-architecture-origin/data/categories.json'
            },
            categories,
            currentCategory;

        function extract(result) {
            return result.data;
        }

        function cacheCategories(result) {
            categories = extract(result);
            return categories;
        }

        model.setCurrentCategory = function (categoryName) {
            model.getCategoryByName(categoryName)
                .then(function (category) {
                    currentCategory = category;
                })
        };

        model.getCurrentCategory = function () {
            return currentCategory;
        };

        model.getCurrentCategoryName = function () {
            return currentCategory ? currentCategory.name : "";
        };

        model.getCategoryList = function () {
            return (categories) ? $q.when(categories) : $http.get(URLS.FETCH).then(cacheCategories);
        };

        model.getCategoryByName = function (categoryName) {

            var deffered = $q.defer();

            function findCategory() {
                return _.find(categories, function (c) {
                    return c.name == categoryName;
                })
            }

            if (categories) {
                deffered.resolve(findCategory());
            } else {
                model.getCategoryList()
                    .then(function () {
                        deffered.resolve(findCategory());
                    })
            }

            return deffered.promise;
        }

    });

