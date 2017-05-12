'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: VideoDetailCtrl
 * @description
 * # VideoDetailCtrl
 * Controller of the monitor
 */
angular.module('monitor')
    .controller('VideoDetailCtrl', function ($scope,commonservice,$stateParams,$state) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	console.log($stateParams);
    	console.log("视频详细信息");

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
            	
            	$scope.commmentParam.curPage = $scope.paginationConf.currentPage;
            	$scope.loadCurPageCommentsAction();
            }
        };
    	
    	$scope.commmentParam = {"vId":$stateParams.vId,"curPage":1};
    	
    	/**
    	 * 加载视频详细信息
    	 */
    	$scope.loadVideoDetail = function(){
    		var param = $stateParams;
    		var url = "resource/detail";
    		commonservice.postData(url,param).then(function(res){
    			console.info("视频详细信息",res.data);
    			$scope.video = res.data;
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 加载当前页的评论
    	 */
    	$scope.loadCurPageCommentsAction = function(){
    		var url = "comment/list/json";
    		var param = $scope.commmentParam;
    		commonservice.postData(url,param).then(function(res){
    			console.info("查询评论结果",res.data);
    			$scope.comments = res.data.list;
    			$scope.paginationConf.totalItems = res.data.count;
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 更新评论的删除装态
    	 */
    	$scope.updateCommentDelStatus =function(comment){
    		var param = {"dcId":comment.dcId,"isDel":''};
    		if(comment.isDel == 0){
    			param.isDel = 1;
    		}else{
    			param.isDel = 0;
    		}
    		$scope.updateCommentAction(param);
    		
    		$scope.commmentParam.curPage = 1;
    		$scope.loadCurPageCommentsAction();
    		
    		return false;
    	}
    	
    	$scope.updateCommentAction = function(param){
    		var url = "comment/update";
    		commonservice.postData(url,param).then(function(res){
    			console.info("更新评论结果",res.data);
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	$scope.goBack = function(){
    		$state.go('maincontent.video-manager',{},[]);
    		return false;
    	}
    	
    	
    });
