/**
 * Created by TITUS on 28.07.2015.
 */
require.config({
    baseUrl: 'app/',

    // alias libraries paths.  Must set 'angular'
    paths: {
        'angular': 'libs/angular.min',
        'angular-route': 'libs/angular-route.min',
        'angular-animate': 'libs/angular-animate.min',

        'angularAMD': 'libs/angularAMD',

        'jquery': 'libs/jquery.min',

        'css': 'libs/require-css.min'
    },

    // Add angular modules that does not support AMD out of the box, put it in a shim
    shim: {
        'angularAMD': ['angular'],
        'angular-route': ['angular'],
        'angular-animate': ['angular'],
        'angular-aria': ['angular'],
        'angular-material': ['angular']
    },

    // kick start application
    deps: ['css', 'app']
});