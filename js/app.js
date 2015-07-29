/**
 * Created by TITUS on 28.07.2015.
 */
define(['angularAMD', 'angular-route'], function (angularAMD) {
    var app = angular.module('app', ['ngRoute']);

    app.config(function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/login', angularAMD.route({
                templateUrl: 'templates/login.html',
                controller: 'LoginCtrl',
                controllerUrl: 'ctrls/login'
            }))
            .when('/registration', angularAMD.route({
                templateUrl: 'templates/registration.html',
                controller: 'RegistrationCtrl',
                controllerUrl: 'ctrls/registration'
            }))
            .otherwise({
                redirectTo: '/login'
            });

        //Commented until solve problems with one page routing without hash
        //$locationProvider.html5Mode(true);
    });


    return angularAMD.bootstrap(app);
});