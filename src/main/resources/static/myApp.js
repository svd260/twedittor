/**
 * Created by sumanthdommaraju on 1/26/17.
 */
var app = angular.module('myApp',[]);

// app.factory('HomeFeedService',function($http) {
//
//     var REST_SERVICE_URI = 'http://localhost:8080/Spring4MVCAngularJSExample/user/';
//
//     var factory = {
//         fetchAllUsers: fetchAllUsers,
//         createUser: createUser,
//         updateUser: updateUser,
//         deleteUser: deleteUser
//     };
//
//     return factory;
//
//     function fetchAllUsers() {
//         var deferred = $q.defer();
//         $http.get(REST_SERVICE_URI)
//             .then(
//                 function (response) {
//                     deferred.resolve(response.data);
//                 },
//                 function (errResponse) {
//                     console.error('Error while fetching Users');
//                     deferred.reject(errResponse);
//                 }
//             );
//         return deferred.promise;
//     }
//
//     function createUser(user) {
//         var deferred = $q.defer();
//         $http.post(REST_SERVICE_URI, user)
//             .then(
//                 function (response) {
//                     deferred.resolve(response.data);
//                 },
//                 function (errResponse) {
//                     console.error('Error while creating User');
//                     deferred.reject(errResponse);
//                 }
//             );
//         return deferred.promise;
//     }
// });

app.controller('HomeFeedController', function ($scope, $http) {
    $http.get("http://localhost:8080/")
        .then(function(response) {
            $scope.home = response.data;
        })
});
