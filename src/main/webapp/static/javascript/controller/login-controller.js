'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: LoginCtrl
 * @description # LoginCtrl Controller of the monitor
 */
angular.module('monitor').controller('LoginCtrl',
		function($scope, $state, commonservice,localStorage,$interval) {
			this.awesomeThings = [ 'HTML5 Boilerplate', 'AngularJS', 'Karma' ];

			/**
			 * 验证码相关配置
			 */
			$scope.remain = "发送验证码";
			var counts = 60;
			var timer = null;
			
			/**
			 * 用户验证时向后台发送请求时携带参数
			 */
			$scope.param = {
					"username" : "",
					"password" : ""
				};
			
			/**
			 * 发送 校验验证码 时携带参数
			 */
			$scope.verify = {
					"verifyCode" : "",
					"mPhone":""
				};
			
			$scope.toLogin = function(){
				var url = "account/login";
				var param = $scope.param;
				commonservice.auth(url, param).then(function(response) {
					localStorage.setObject("user",response.data.user);
					$scope.bool = !$scope.bool;
					$scope.verify.mPhone = response.data.user.mPhone;
					
//					$state.go("maincontent.hello",{},[]);
				}, function(response) {
//					alert(response.status);
					if(response.status == 401){
						alert("用户名密码错误！");
					}
				});
			}
			
			/**
			 * 创建一个定时器
			 * @returns
			 */
			function createInterval (){
				$scope.disBtn = true;
				timer = $interval( function() {
					console.log("A");
					if(counts == 0){
						if(timer){
							$interval.cancel(timer);
							timer = null;
							$scope.disBtn = false;
							$scope.remain = "发送验证码";
						}
					}else{
						$scope.remain = (counts--) + "S 后可重发";
					}
				  },1000);
			}
			
			/**
			 * 告知后台发送验证码
			 */
			$scope.toSendVerifyCode = function(){
				
				if(!timer){
					createInterval();
				}
				
				var url = "account/send";
				var param = {"mPhone":$scope.verify.mPhone};
				commonservice.postData(url, param).then(function(response) {
					
					console.log(response);
				}, function(response) {
					alert("失败");
				});
			}
			
			/**
			 * 校验验证码
			 */
			$scope.toCheckVerifyCode = function(){
				var url = "account/check";
				var param = $scope.verify;
				commonservice.postData(url, param).then(function(response) {
					if(response.data.code == 0){
						$state.go("maincontent.hello",{},[]);
						
						if(!timer){
							createInterval();
						}
						
					}else{
						alert("验证码错误");
					}
				}, function(response) {
					alert("失败");
				});
			}

			/**
			 * 回到登录窗口
			 */
			$scope.backToLogin = function(){
				$scope.bool = !$scope.bool;
				
				if(timer){
					$interval.cancel(timer);
					timer = null;
					$scope.disBtn = false;
					$scope.remain = "发送验证码";
				}
				$scope.param = {
					"username" : "",
					"password" : ""
				};
				
				$scope.verify = {
					"verifyCode" : "",
					"phone":""
				};
				localStorage.clear();
				
				return false;
			}
		});
