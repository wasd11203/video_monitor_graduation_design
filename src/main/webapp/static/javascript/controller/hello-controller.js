'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: HelloCtrl
 * @description
 * # HelloCtrl
 * Controller of the monitor
 */
angular.module('monitor')
    .controller('HelloCtrl', function ($scope, $rootScope,$state) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
    	$scope.init = function(){
    		$scope.mNickname = $rootScope.user.mNickname;
    	}

    });
