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

    	$scope.param = {"mId":$rootScope.user.mId,"curPage":1};

    	/**
	     * 分页插件配置
	     */
	    $scope.paginationConf = {
            currentPage: 1,//当前页
            totalItems: 0,//所有的记录数
            itemsPerPage: 4,//每页的记录数
            pagesLength: 15,// 用于计算可被点击的总页数
            perPageOptions: [15],// 用于选择的 每页显示的记录数 数组
            onChange: function(){
            	
            	$scope.param.curPage = $scope.paginationConf.currentPage;
            	$scope.searchByKeywordsAction($scope.param);
            }
        };
    	
	    /**
	     * 初始化
	     */
    	$scope.init = function(){
    		$scope.searchByKeywordsAction($scope.param);
    	}
    	
    	/**
    	 * 上下架操作
    	 */
    	$scope.updateValidStatus = function(video){
    		$scope.updateVideoStatusParam.vId = video.vId;
    		if(video.invalid == 1){
    			$scope.updateVideoStatusParam.invalid = 0;
    			video.invalid = 0;
    		}else{
    			$scope.updateVideoStatusParam.invalid = 1;
    			video.invalid = 1;
    		}
    		
    		$scope.updateVideoStatusAction();
    		
    		return false;
    	}
    	/**
    	 * 禁止评论与允许评论操作
    	 */
    	$scope.updateCommentStatus = function(video){
    		$scope.updateVideoStatusParam.vId = video.vId;
    		if(video.disComment == 1){
    			$scope.updateVideoStatusParam.disComment = 0;
    			video.disComment = 0;
    		}else{
    			$scope.updateVideoStatusParam.disComment = 1;
    			video.disComment = 1;
    		}
    		
    		$scope.updateVideoStatusAction();
    		
    		return false;
    	}
    	/**
    	 * 删除操作
    	 */
    	$scope.updateDelStatus = function(video){
    		$scope.updateVideoStatusParam.vId = video.vId;
    		if(video.isDel == 1){
    			$scope.updateVideoStatusParam.isDel = 0;
    		}else{
    			$scope.updateVideoStatusParam.isDel = 1;
    		}
    		
    		$scope.updateVideoStatusAction();
    		
    		$scope.param.curPage = 1;
    		$scope.searchByKeywordsAction($scope.param);
    		return false;
    	}
    	
    	/**
    	 * 根据不同条件查询Action
    	 */
    	$scope.searchByKeywordsAction = function(param){
    		var url = "resource/search";
    		commonservice.postData(url,param).then(function(res){
    			console.info("当前页视频列表:",res.data);
    			$scope.list = res.data.list;
    			$scope.paginationConf.totalItems = res.data.count;
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	$scope.updateVideoStatusParam = {'vId':'','isDel':'','disComment':'','invalid':''};
    	
    	/**
    	 * 更新视频状态Action
    	 */
    	$scope.updateVideoStatusAction = function(){
    		var url = "resource/update";
    		var param = $scope.updateVideoStatusParam;
    		commonservice.postData(url,param).then(function(res){
    			console.info("更新结果:",res.data);
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	$scope.go = function(toState,video){
    		$state.go(toState,{vId:video.vId},[]);
    		return false;
    	}
    	
    });
