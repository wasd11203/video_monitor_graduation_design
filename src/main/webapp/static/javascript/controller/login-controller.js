'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: LoginCtrl
 * @description # LoginCtrl Controller of the monitor
 */
angular.module('monitor').controller('LoginCtrl',
		function($scope, $state, commonservice,localStorage) {
			this.awesomeThings = [ 'HTML5 Boilerplate', 'AngularJS', 'Karma' ];

			$scope.param = {
					"username" : "",
					"password" : ""
				};
			$scope.toLogin = function(){
				var url = "account/login";
				var param = $scope.param;
				commonservice.auth(url, param).then(function(response) {
					localStorage.setObject("user",response.data.user);
					$state.go("maincontent.hello",{},[]);
				}, function(response) {
//					alert(response.status);
					if(response.status == 401){
						alert("用户名密码错误！");
					}
				});
			}
			

		});
