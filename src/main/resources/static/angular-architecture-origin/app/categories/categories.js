/**
 * Created by donghoon on 2016. 6. 11..
 */
angular.module('categories', [
    'devarchi33.models.categories'
])
    .config(function ($stateProvider) {
        $stateProvider.state("app.categories", {
            url: '/',
            views: {
                'categoriesTmpl@': {
                    templateUrl: '../../static/angular-architecture-origin/app/categories/categories.tmpl.html',
                    controller: 'CategoriesListCtrl as categoriesListCtrl'
                },
                'bookmarksTmpl@': {
                    templateUrl: '../../static/angular-architecture-origin/app/categories/bookmarks/bookmarks.tmpl.html',
                    controller: 'BookmarksListCtrl as bookmarksListCtrl'
                }
            }
        })
    })

    .controller("CategoriesListCtrl", function CategoriesCtrl($scope, CategoriesListModel) {
        var categoriesListCtrl = this;

        CategoriesListModel.getCategoryList()
            .then(function (result) {
                categoriesListCtrl.categories = result;
            });
    });

