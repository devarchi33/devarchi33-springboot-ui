/**
 * Created by donghoon on 2016. 6. 10..
 */
angular.module("App", [
    'ngAnimate',
    'ui.router',
    'categories',
    'categories.bookmarks'
])
    .run(function () {
        console.log("My app is ready!");
    })

    .config(function ($stateProvider, $urlRouterProvider) {

        $stateProvider.state('app', {
            url: '',
            abstract: true
        });

        $urlRouterProvider.otherwise("/");
    })

;