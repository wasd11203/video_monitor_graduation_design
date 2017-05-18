'use strict';

/**
 * @ngdoc function
 * @name monitor.controller: UserDetailCtrl
 * @description
 * # DetailCtrl
 * Controller of the monitor
 */
angular.module('monitor')
    .controller('UserDetailCtrl', function ($scope, $rootScope,commonservice,FileUploader) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
    	console.log("管理者详细信息");
    	var param = {"mId":$rootScope.user.mId};
    	
    	$scope.loadDetail = function(){
    		var param = {"mId":$rootScope.user.mId}; 
    		var url = "user/detail";
    		commonservice.postData(url,param).then(function(res){
    			console.info("当前用户详细信息",res.data);
    			$scope.user = res.data;
    		},function(res){
    			alert(res.status);
    		});
    		
    	}
    	
    	$scope.changeIconFlag = false;
    	$scope.changeIcon = function (){
    		$scope.changeIconFlag = !$scope.changeIconFlag;
    		
    		return false;
    	}
    	
    	$scope.uploader = new FileUploader({
            url: 'icon/upload',
            alias :'picFileMpf',
            autoUpload :false,
            queueLimit :1
        });
        // FILTERS

    	$scope.uploader.filters.push({
            name: 'imageFilter',
            fn: function(item /*{File|FileLikeObject}*/, options) {
                var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
        });

    	$scope.updateUserDetailAction = function(param){
    		var url = "user/update";
    		commonservice.postData(url,param).then(function(res){
    			console.info("更新用户信息",res.data);
    			$scope.user.mPic = param.mPic;
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
        $scope.remove =function(uploader){
        	uploader.clearQueue() ;
        	return false;
        }
        
        // CALLBACKS
        $scope.uploader.onCompleteItem = function(fileItem, response, status, headers) {
//          console.info('onCompleteItem', response);
//          $scope.img = response.fileName;
          var param = {"mId":$scope.user.mId,"mPic":response.fileName};
          $scope.updateUserDetailAction(param);
//          uploader.clearQueue() ;
        };
        $scope.uploader.onWhenAddingFileFailed = function(item /*{File|FileLikeObject}*/, filter, options) {
        	$scope.uploader.queue[0].remove();
        	$scope.uploader.addToQueue(item);
            console.info('onWhenAddingFileFailed', item, filter, options);
//        	$scope.uploader.queue[0].remove();
        };
//        $scope.uploader.onAfterAddingFile = function(fileItem) {
//            console.info('onAfterAddingFile', fileItem);
//        };
//        $scope.uploader.onAfterAddingAll = function(addedFileItems) {
//            console.info('onAfterAddingAll', addedFileItems);
//        };
//        $scope.uploader.onBeforeUploadItem = function(item) {
//            console.info('onBeforeUploadItem', item);
//        };
//        $scope.uploader.onProgressItem = function(fileItem, progress) {
//            console.info('onProgressItem', fileItem, progress);
//        };
//        $scope.uploader.onProgressAll = function(progress) {
//            console.info('onProgressAll', progress);
//        };
//        $scope.uploader.onSuccessItem = function(fileItem, response, status, headers) {
//            console.info('onSuccessItem', fileItem, response, status, headers);
//        };
//        $scope.uploader.onErrorItem = function(fileItem, response, status, headers) {
//            console.info('onErrorItem', fileItem, response, status, headers);
//        };
//        $scope.uploader.onCancelItem = function(fileItem, response, status, headers) {
//            console.info('onCancelItem', fileItem, response, status, headers);
//        };
//
//        $scope.uploader.onCompleteAll = function() {
//            console.info('onCompleteAll');
//        };
    	
//        console.info('uploader', uploader);
    	
    });
