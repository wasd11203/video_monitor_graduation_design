'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: MaincontentCtrl
 * @description
 * # MaincontentCtrl
 * Controller of the monitor
 */
angular.module('monitor')
    .controller('navCtrl', function ($scope, $rootScope,$state) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
    	$scope.param = {};
    	
    	$scope.init=function (){
    		$scope.param.mId = user.mId;
    		console.log(user);
    	}
    	
    	$scope.go =function(toState){
    		$state.go(toState,$scope.param,[]);
//    		alert("a");
    		return false;
    	}
    	
    });
