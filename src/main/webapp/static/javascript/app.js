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
				'ngResource', 'smart-table', 'ui.tree', 'ngDialog', 'angular-loading-bar', 'http-auth-interceptor', 'ngFileUpload', 'ngCookies',
				'ngSanitize', 'ui.router', 'ngAnimate', 'ui.bootstrap', 'ng.ueditor','ui-notification','tm.pagination'
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
	.state('maincontent.detail', {
		url : '/detail',
		views:{
			'':{
				templateUrl : 'views/user-detail.html',
				controller : 'DetailCtrl',
				controllerAs : 'detailCtrl'
			}
		}
		
	})
	.state('maincontent.videomanager', {
		url : '/video',
		views:{
			'':{
				templateUrl : 'views/video-manager.html',
				controller : 'VideoManagerCtrl',
				controllerAs : 'videoManagerCtrl'
			}
		}
		
	})
	.state('maincontent.uploadvideo', {
		url : '/uploadvideo',
		views:{
			'':{
				templateUrl : 'views/upload-video.html',
				controller : 'VideoUploadCtrl',
				controllerAs : 'videoUploadCtrl'
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