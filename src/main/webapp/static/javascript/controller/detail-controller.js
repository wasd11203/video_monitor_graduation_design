'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: DetailCtrl
 * @description
 * # DetailCtrl
 * Controller of the monitor
 */
angular.module('monitor')
    .controller('DetailCtrl', function ($scope, $rootScope,commonservice) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
    	console.log("管理者详细信息");

    	$scope.loadDetail = function(){
    		var param = {"mId":user.mId};
    		var url = "user/detail";
    		commonservice.postData(url,param).then(function(res){
    			console.info("当前用户详细信息",res.data);
    			$scope.user = res.data;
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    });
