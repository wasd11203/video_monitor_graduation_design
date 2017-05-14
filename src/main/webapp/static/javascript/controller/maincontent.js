'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: MaincontentCtrl
 * @description
 * # MaincontentCtrl
 * Controller of the monitor
 */
angular.module('monitor')
    .controller('MaincontentCtrl', function ($scope,$rootScope,commonservice,$state,localStorage) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
    	$scope.user = $rootScope.user;
    	$scope.logout = function(){
    		var url = "account/logout";
    		var param = {"mId":$scope.user.mId};
    		localStorage.clear();
			$rootScope.user = null;
			$scope.user = null;
			
    		commonservice.postData(url, param).then(function(response) {
				
//    			if(response.data.code == 0){
    				
    				$state.go("login",{},[]);
//    			}else{
//    				console.log("登出失败");
//    			}
				
			}, function(response) {
//				alert(response.status);
//				if(response.status == 401){
//					alert("用户名密码错误！");
//				}
				console.log("网络出错");
			});
    	}
    });
