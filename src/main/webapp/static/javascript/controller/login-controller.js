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
			 * 用户登陆
			 */
			$scope.param = {
					"username" : "",
					"password" : ""
				};
			$scope.toLogin = function(){
				var url = "account/login";
				var param = $scope.param;
				commonservice.auth(url, param).then(function(response) {
					localStorage.setObject("temp",response.data.user);
					
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
			$scope.remain = "发送验证码";
			var counts = 60;
			var timer = null;
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
			 * 发送验证码
			 */
			$scope.verify = {
					"verifyCode" : "",
					"mPhone":""
				};
			$scope.toSendVerifyCode = function(){
				
				if(!timer){
					createInterval();
				}
				
				var url = "account/send";
				var param = {"mPhone":$scope.verify.mPhone};
				commonservice.postData(url, param).then(function(res) {
					console.log(res);
					if(res.data.alibaba_aliqin_fc_sms_num_send_response){
	    				$scope.errMsg = null;
	    			}else{
	    				if(timer){
	  	       	    		 $scope.disBtn = false;
	  	       	    		 $scope.btnContent = '发送验证码';
	  	       	    		 $interval.cancel(timer);
	  	       	    		 timer = null;
	  	       	    	 }
	    				$scope.errMsg = "验证码发送失败";
	    			}
				}, function(response) {
//					alert("失败");
					$scope.errMsg = "请重试";
	    			if(timer){
	       	    		 $scope.disBtn = false;
	       	    		 $scope.btnContent = '发送验证码';
	       	    		 $interval.cancel(timer);
	       	    		 timer = null;
	       	    	 }
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
						
						localStorage.setObject("user",localStorage.getObject("temp"));
						
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
