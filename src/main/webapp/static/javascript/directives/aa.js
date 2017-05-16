
angular.module('aa', ['ngAnimate']).animation('.slide', ['$animateCss',function($animateCss) {
	return {
	    enter: function(element) {
	      return $animateCss(element, {
	        event: 'enter',
	        structural: true,
	        from: { marginLeft:-150,opacity:0},
	        to: { marginLeft:0,opacity:1}
	      });
	    },
	    leave: function(element) {
		      return $animateCss(element, {
		        event: 'leave',
		        structural: true,
		        from: { marginLeft:0,opacity:1},
		        to: { marginLeft:-150,opacity:0}
		      });
		    }
	  }
}]);


angular.module('bb', ['ngAnimate']).animation('.slide2', ['$animateCss',function($animateCss) {
	return {
	    enter: function(element) {
	      return $animateCss(element, {
	        event: 'enter',
	        structural: true,
	        from: { marginLeft:150,opacity:0},
	        to: { marginLeft:0,opacity:1}
	      });
	    },
	    leave: function(element) {
		      return $animateCss(element, {
		        event: 'leave',
		        structural: true,
		        from: { marginLeft:0,opacity:1},
		        to: {marginLeft:150, opacity:0}
		      });
		    }
	  }
}]);
