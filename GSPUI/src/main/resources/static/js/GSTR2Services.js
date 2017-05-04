appEngage.factory('GSTR2Service', ['$http','$q','$rootScope',function($http,$q,$rootScope) {
  
	return{ 
			getGSTRData : function() {
			        var promise=$http.get("json/GSTN2_ISDCredit.json").then(function(response)
			                    {
			                         return response.data;
			                    });
			                 
			        return promise;
			  },
			 getGSTR1Summary : function(){
				 var promise=$http.get("json/GetGSTR1Summary.json").then(function(response)
		                    {
		                         return response.data;
		                    });
		                 
		        return promise;
			 },
			 getGSTR2Summary : function(){
				 var promise=$http.get("json/GetGSTR2Summary.json").then(function(response)
		                    {
		                         return response.data;
		                    });
		                 
		        return promise;
			 },
			 getGSTR1ASummary : function(){
				 var promise=$http.get("json/GetGSTR1ASummary.json").then(function(response)
		                    {
		                         return response.data;
		                    });
		                 
		        return promise;
			 },
			 getGSTR3 : function(){
                           var promise=$http.get("json/GetGSTR3.json").then(function(response)
                                  {
                                       return response.data;
                                  });
                              
                      return promise;
			 },
			 getCashLedgerService : function(){
                           var promise=$http.get("json/cashLedger.json").then(function(response)
                                  {
                                       return response.data;
                                  });
                              
                      return promise;
             },
             getITCLedgerService : function(){
                 var promise=$http.get("json/ITCLedger.json").then(function(response)
                        {
                             return response.data;
                        });
                    
                 	return promise;
             },
			 getLiabilityLedgerService : function(){
                           var promise=$http.get("json/liabilityLedger.json").then(function(response)
                                  {
                                       return response.data;
                                  });
                              
                      return promise;
             }
		};

}]);