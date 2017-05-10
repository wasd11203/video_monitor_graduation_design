'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: VideoManagerCtrl
 * @description
 * # VideoManagerCtrl
 * Controller of the monitor
 */
angular.module('monitor')
    .controller('VideoManagerCtrl', function ($scope, $rootScope,$state,commonservice) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
    	console.log("视频列表");

    	$scope.param = {"mId":user.mId,"curPage":1};
    	$scope.init = function(){
    		$scope.searchByMark($scope.param);
    	}
    	
    	
    	$scope.searchByMark = function(param){
    		var url = "user/detail";
    		commonservice.postData(url,param).then(function(res){
    			console.info("当前页视频列表:",res.data);
    			$scope.list = res.data.list;
    			$scope.count = res.data.count;
    			
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    });
