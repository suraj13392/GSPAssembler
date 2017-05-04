appEngage.controller("gstr1Summary",["$scope",'$http','GSTR2Service','$q','$rootScope',function($scope,$http,GSTR2Service,$q,$rootScope){
	
	 $('#dashboardDiv').css("display","none");
	 
	
	$("#paginationSum").addClass('hide');
	$("#form_tableSummary").css("display","none");
	
	
	$scope.getSummary=function(){
		
		$("#paginationSum").removeClass('hide');
		$("#form_tableSummary").css("display","block");
		
		GSTR2Service.getGSTR1Summary().then(function(data){
	 			$scope.summaryData=data;
	 			
	 			for(i=0;i<$scope.summaryData.sec_sum.length;i++)
				{
					if($scope.summaryData.sec_sum[i].sec_nm=="b2b"){
						$scope.b2bData=$scope.summaryData.sec_sum[i];
						}
					else if($scope.summaryData.sec_sum[i].sec_nm=="b2ba"){
						$scope.b2baData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="cdnr"){
						$scope.cdnrData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="cdnra"){
						$scope.cdnraData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="b2cl"){
						$scope.b2clData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="b2cls"){
						$scope.b2clsData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="exp"){
						$scope.expData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="expa"){
						$scope.expaData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="txpd"){
						$scope.txpdData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="at"){
						$scope.atData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="ata"){
						$scope.ataData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="b2cs"){
						$scope.b2csData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="b2csa"){
						$scope.b2csaData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="hsn"){
						$scope.hsnData=$scope.summaryData.sec_sum[i];
					}
					else
					{
						$scope.nilData=$scope.summaryData.sec_sum[i];
					}
				}
	 		});
	}

	
}]);


appEngage.controller("gstr1ASummary",["$scope",'$http','GSTR2Service','$q','$rootScope',function($scope,$http,GSTR2Service,$q,$rootScope){
	
	 $('#dashboardDiv').css("display","none");
	 
	
	$("#paginationGStr1ASummary").addClass('hide');
	$("#GSTR1A_tableSummary").css("display","none");
	
	
	$scope.getGstr1ASummaryCtrl=function(){
		
		$("#paginationGStr1ASummary").removeClass('hide');
		$("#GSTR1A_tableSummary").css("display","block");
		
		GSTR2Service.getGSTR1ASummary().then(function(data){
	 			$scope.summaryData=data;
	 			
	 			for(i=0;i<$scope.summaryData.sec_sum.length;i++)
				{
					if($scope.summaryData.sec_sum[i].sec_nm=="B2B"){
						$scope.b2bData=$scope.summaryData.sec_sum[i];
						}
					else if($scope.summaryData.sec_sum[i].sec_nm=="B2BA"){
						$scope.b2baData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="CDN"){
						$scope.cdnData=$scope.summaryData.sec_sum[i];
					}
					else if($scope.summaryData.sec_sum[i].sec_nm=="CDNA"){
						$scope.cdnaData=$scope.summaryData.sec_sum[i];
					}
					else{}
					
				}
	 		});
	}

	
}]);


appEngage.controller("gstr2Summary",["$scope",'$http','GSTR2Service','$q','$rootScope',function($scope,$http,GSTR2Service,$q,$rootScope){
	 $('#dashboardDiv').css("display","none");
	
    $("#paginationSum2").addClass('hide');
    $("#form_tableSummary").css("display","none");
    
  //Start : Added on 05/04/17 by Dipti
	
	$scope.getGstr2Summary=function(){
        
        $("#paginationSum2").removeClass('hide');
        $("#form_tableSummary").css("display","block");
        
        GSTR2Service.getGSTR2Summary().then(function(data){
                     $scope.summaryData=data;
                     
                      for(i=0;i<$scope.summaryData.section_summary.length;i++)
                     {
                            if($scope.summaryData.section_summary[i].sec_nm=="b2b"){
                                   $scope.b2bData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="b2ba"){
                                   $scope.b2baData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="cdn"){
                                   $scope.cdnData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="cdna"){
                                   $scope.cdnaData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="isd"){
                                   $scope.isdData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="tds"){
                                   $scope.tdsData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="tcs"){
                                   $scope.tcsData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="impg"){
                                   $scope.impgData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="impga"){
                                   $scope.impgaData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="imps"){
                                   $scope.impsData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="impsa"){
                                   $scope.impsaData=$scope.summaryData.section_summary[i];
                            }
                            else if($scope.summaryData.section_summary[i].sec_nm=="nil"){
                                   $scope.nilData=$scope.summaryData.section_summary[i];
                            }
                            else
                            {
                                   $scope.nilData=$scope.summaryData.section_summary[i];
                            }
                     }
              });
	}
	//End : Added on 05/04/17 by Dipti
	
}]);

appEngage.controller("gstrTemplateController",["$scope",'$http','GSTR2Service','$q','$rootScope',function($scope,$http,GSTR2Service,$q,$rootScope){
	
	$('#dashboardDiv').css("display","none");
	
	
}]);



