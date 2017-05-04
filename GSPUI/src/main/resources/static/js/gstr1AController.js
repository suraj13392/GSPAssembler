appEngage.controller("gstr1AController",["$scope",'$http','$q','$rootScope','$state','$stateParams',function($scope,$http,$q,$rootScope,$state,$stateParams){
	
	$('#dashboardDiv').css("display","none");
	
	$("#gstr1AButtonGroup").css("display","none");
	$("#gstr1_table").css("display","none");
	
	$scope.getGstr1AData=function(){
		$("#gstr1AButtonGroup").css("display","block");
    	$("#gstr1_table").css("display","block");
    	
	     $http.get("json/GSTR1A_B2BA.json").then(function(response) {
		        $scope.jsonAB2BAInvoice = response.data;
		        
		        var newB2BaData={};
		        $scope.B2BaData=[];
		        
		        for(i=0;i<$scope.jsonAB2BAInvoice.b2ba.length;i++)
		        	{
		        	/*$scope.jsonAB2BAInvoice.b2ba[i].inv['ctin']=$scope.jsonAB2BAInvoice.b2ba[i].ctin;
		        	$scope.jsonAB2BAInvoice.b2ba[i].inv['cfs']=$scope.jsonAB2BAInvoice.b2ba[i].cfs;*/
		        	//newData=new Object();
			        	for(j=0;j<$scope.jsonAB2BAInvoice.b2ba[i].inv.length;j++)
		        		{
		        		$scope.jsonAB2BAInvoice.b2ba[i].inv[j]['ctin']=$scope.jsonAB2BAInvoice.b2ba[i].ctin;
			        	$scope.jsonAB2BAInvoice.b2ba[i].inv[j]['cfs']=$scope.jsonAB2BAInvoice.b2ba[i].cfs;
			        	
			        	newB2BaData=$scope.jsonAB2BAInvoice.b2ba[i].inv[j];
			        	$scope.B2BaData[i]=$scope.jsonAB2BAInvoice.b2ba[i].inv[j];
		        		}
		        	
		        	}
		    });
	     
        $http.get("json/GSTR1A_B2B.json").then(function(response) {
	        $scope.jsonB2BInvoice = response.data;
	        
	        var newData={};
	        $scope.newB2BData=[];
	   
	        
	      for(i=0;i<$scope.jsonB2BInvoice.b2b.length;i++)
	        	{
	        	/*$scope.jsonB2BInvoice.b2b[i].inv['ctin']=$scope.jsonB2BInvoice.b2b[i].ctin;
	        	$scope.jsonB2BInvoice.b2b[i].inv['cfs']=$scope.jsonB2BInvoice.b2b[i].cfs;*/
	        	//newData=new Object();
	        	for(j=0;j<$scope.jsonB2BInvoice.b2b[i].inv.length;j++)
	        		{
	        		$scope.jsonB2BInvoice.b2b[i].inv[j]['ctin']=$scope.jsonB2BInvoice.b2b[i].ctin;
		        	$scope.jsonB2BInvoice.b2b[i].inv[j]['cfs']=$scope.jsonB2BInvoice.b2b[i].cfs;
		        	
	        		newData=$scope.jsonB2BInvoice.b2b[i].inv[j];
		        	$scope.newB2BData[i]=$scope.jsonB2BInvoice.b2b[i].inv[j];
	        		}
	        	
	        	}
	    });
        
        $http.get("json/GSTR1A_CDNInvoice.json").then(function(response) {
	        $scope.jsonCDNInvoices = response.data;
	    });
        
        
        $http.get("json/GSTR1A_CDNAInvoice.json").then(function(response) {
	        $scope.jsonCDNAInvoices = response.data;
	    });
	}
}]);