'use strict';

/**
 * @ngdoc overview
 * @name monitor
 * @description
 * # monitor
 *
 * Main module of the application.
 */
angular.module(
		'monitor',
		[
				'ngResource', 'smart-table', 'ui.tree', 'ngDialog', 'angular-loading-bar', 'http-auth-interceptor', 'angularFileUpload', 'ngCookies',
				'ngSanitize', 'ui.router', 'ngAnimate', 'ui.bootstrap', 'ng.ueditor','ui-notification','tm.pagination',
				'angular-bootstrap-select','ng.thumbnail'
		]).config(function($stateProvider, $urlRouterProvider, $httpProvider){

	$stateProvider
	/**
	 * 主要内容页 路由配置
	 */
	.state('maincontent', {
		url : '/maincontent',
		views:{
			'maincontent':{
				templateUrl : 'views/maincontent.html',
				controller : 'MaincontentCtrl',
				controllerAs : 'maincontentCtrl'
			}
		}
		
	})
	.state('maincontent.hello', {
		url : '/hello',
		views:{
			'':{
				templateUrl : 'views/hello.html',
				controller : 'HelloCtrl',
				controllerAs : 'helloCtrl'
			}
		}
		
	})
	.state('maincontent.user-detail', {
		url : '/user-detail',
		views:{
			'':{
				templateUrl : 'views/user-detail.html',
				controller : 'UserDetailCtrl',
				controllerAs : 'userDetailCtrl'
			}
		}
		
	})
	.state('maincontent.video-manager', {
		url : '/video',
		views:{
			'':{
				templateUrl : 'views/video-manager.html',
				controller : 'VideoManagerCtrl',
				controllerAs : 'videoManagerCtrl'
			}
		}
		
	})
	.state('maincontent.video-upload', {
		url : '/uploadvideo',
		views:{
			'':{
				templateUrl : 'views/upload-video.html',
				controller : 'VideoUploadCtrl',
				controllerAs : 'videoUploadCtrl'
			}
		}
		
	})
	.state('maincontent.video-detail', {
		url : '/videodetail?:vId',
		views:{
			'':{
				templateUrl : 'views/video-detail.html',
				controller : 'VideoDetailCtrl',
				controllerAs : 'videoDetailCtrl'
			}
		}
		
	});

	$urlRouterProvider.otherwise('maincontent/hello');
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
})
.config(function(NotificationProvider){
	NotificationProvider.setOptions({
            maxCount:3
        });
});