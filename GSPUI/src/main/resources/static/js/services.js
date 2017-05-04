appEngage.factory('AllService', ['$http','$q','$rootScope',function($http,$q,$rootScope) {
	
	return{ 
		 getAllSupplier : function() {
		        var promise=$http.get("http://localhost:8090/api/emp/getAllSupplier").then(function(response)
		                    {
		                         return response.data;
		                    });
		                 
		        return promise;
		  },
		 saveSupplier : function(model){
		      var promise=$http.post("http://localhost:8090/api/emp/saveSupplier",model).then(function(response)
		    		  {
		                    return response;
		    		  },
		          function(errResponse){
		                    return $q.reject(errResponse);
		    		  });
		      return promise;
		  },
		  editSupplier : function(model){
		      var promise=$http.put("http://localhost:8090/api/emp/editSupplier",model).then(function(response)
		    		  {
		                    return response;
		    		  },
		          function(errResponse){
		                    return $q.reject(errResponse);
		    		  });
		      return promise;
		  },
		  deleteSupplier : function(model){
		      var promise=$http.post("http://localhost:8090/api/emp/deleteSupplier",model).then(function(response)
		    		  {
		                    return response;
		    		  },
		          function(errResponse){
		                    return $q.reject(errResponse);
		    		  });
		      return promise;
		  },
		  registerUser :function(model){
			  var promise=$http.post("http://localhost:8090/api/emp/registerUser",model).then(function(response)
		    		  {
		                    return response;
		    		  },
		          function(errResponse){
		                    return $q.reject(errResponse);
		    		  });
		      return promise;
		  }
		  
		  
	};
	
}]);