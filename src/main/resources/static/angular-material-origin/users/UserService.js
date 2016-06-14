(function () {
    'use strict';

    angular.module('users')
        .service('userService', ['$http', '$q', UserService]);

    /**
     * Users DataService
     * Uses embedded, hard-coded data model; acts asynchronously to simulate
     * remote data service call(s).
     *
     * @returns {{loadAll: Function}}
     * @constructor
     */
    function UserService($http, $q) {
        var URLS = {
                FETCH: '../../static/angular-material-origin/data/users.json'
            },
            users;

        function extract(result) {
            return result.data;
        }

        function cacheUsers(result) {
            users = extract(result);
            return users;
        }

        // Promise-based API
        return {
            loadAllUsers: function () {
                // Simulate async nature of real remote calls
                return (users) ? $q.when(users) : $http.get(URLS.FETCH).then(cacheUsers);
            }
        };
    }

})();
