'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: VideoUploadCtrl
 * @description
 * # VideoUploadCtrl
 * Controller of the monitor
 */
angular.module('monitor')
    .controller('VideoUploadCtrl', function ($scope, $rootScope,$state,commonservice,FileUploader) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
//    	console.log("上传视频");
    	$scope.param = {"vTitle":'',"vName":'',"vPic":'',"vIntroduce":'',"vPath":'',"duration":"","vSecId":'',"mId":user.mId};
    	
    	/**
    	 * 视频展示图片上传
    	 */
    	$scope.videoImgUploader = new FileUploader({
            url: 'video-img/upload',
            alias :'picFileMpf',
            autoUpload :false,
            queueLimit :1
        });
        // FILTERS

    	$scope.videoImgUploader.filters.push({
            name: 'imageFilter',
            fn: function(item /*{File|FileLikeObject}*/, options) {
                var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
        });
    	
    	$scope.remove =function(uploader){
    		console.log(uploader.queue);
        	uploader.clearQueue() ;
        	return false;
        }
    	
    	 // CALLBACKS
        $scope.videoImgUploader.onCompleteItem = function(fileItem, response, status, headers) {
//          console.info('onCompleteItem', response);
        	$scope.param.vPic = response.fileName;
        };
        $scope.videoImgUploader.onWhenAddingFileFailed = function(item /*{File|FileLikeObject}*/, filter, options) {
        	if($scope.videoImgUploader.queue[0]){
        		$scope.videoImgUploader.queue[0].remove();
            	$scope.videoImgUploader.addToQueue(item);
                console.info('onWhenAddingFileFailed', item, filter, options);
        	}else{
        		alert("不支持此文件类型上传");
        	}
        	
        };
        
        /**
         * 视频文件上传配置
         */
        $scope.videoUploader = new FileUploader({
            url: 'video/upload',
            alias :'picFileMpf',
            autoUpload :false,
            queueLimit :1
        });
        // FILTERS

    	$scope.videoUploader.filters.push({
            name: 'videoFilter',
            fn: function(item /*{File|FileLikeObject}*/, options) {
                var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                return '|mp4|webm|ogg|'.indexOf(type) !== -1;
            }
        });
    	
    	$scope.remove =function(uploader){
        	uploader.clearQueue() ;
        	return false;
        }
    	
    	 // CALLBACKS
        $scope.videoUploader.onCompleteItem = function(fileItem, response, status, headers) {
//          console.info('onCompleteItem', response);
        	$scope.param.vPath = response.fileName;
        };
        $scope.videoUploader.onWhenAddingFileFailed = function(item /*{File|FileLikeObject}*/, filter, options) {
        	
        	if($scope.videoImgUploader.queue[0]){
        		$scope.videoUploader.queue[0].remove();
            	$scope.videoUploader.addToQueue(item);
                console.info('onWhenAddingFileFailed', item, filter, options);
        	}else{
        		alert("不支持此文件类型上传");
        	}
        	
        };
    	
    	$scope.init = function(){
    		$scope.loadNavAll();
    	}
    	
    	/**
    	 * 获取所有分类列表
    	 */
    	$scope.loadNavAll = function(){
    		var url = "nav/loadAll";
    		commonservice.postData(url,{}).then(function(res){
    			console.info("所有的类别",res.data);
    			$scope.nav = res.data;
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 下拉列表联动
    	 */
    	$scope.changeSecList = function(){
    		angular.forEach($scope.nav, function(data,index,array){
				//data等价于array[index]
    			if($scope.vTopId == data.vTopId){
    				$scope.newTop = data;
    			}
			});
    		if ($scope.newTop == $scope.top) {
    			$scope.top = {};
    		}else{
    			$scope.top = $scope.newTop;
    		}
    		return false;
    	}
    	
    	/**
    	 * 向后台发送 创建视频记录请求
    	 */
    	$scope.createVideoAction = function(){
    		var url = "resource/create";
    		var param = $scope.param;
    		commonservice.postData(url,param).then(function(res){
    			console.info("创建视频结果",res.data);
    			$state.reload();
    		},function(res){
    			alert(res.status);
    		});
    	}
    	$scope.vTopId = 0;
    });
