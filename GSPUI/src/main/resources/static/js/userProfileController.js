appEngage.controller("userProfileController",["$scope",'$http','GSTR2Service','$q','$rootScope',function($scope,$http,GSTR2Service,$q,$rootScope){
	
	$('#dashboardDiv').css("display","none");
	

	
    $(".register-part02 a").click(function(){
		$(".register-part07").removeClass("active-underline");
           $(".register-part02").addClass("active-underline");
           $(".register-part01,.register-part03,.register-part04,.register-part05,.register-part06,.register-part07").removeClass("active-underline");
           $('#accordion-Place1 .panel-collapse:not(".in")').collapse('show');
    });
    $(".register-part01 a").click(function(){
           $(".register-part01").addClass("active-underline");
           $(".register-part02,.register-part03,.register-part04,.register-part05,.register-part06,.register-part07").removeClass("active-underline");
    });
    $(".register-part03 a").click(function(){
           $(".register-part03").addClass("active-underline");
          $(".register-part01,.register-part02,.register-part04,.register-part05,.register-part06,.register-part07").removeClass("active-underline");
           $('#accordionPart-Partner1 .panel-collapse:not(".in")').collapse('show');
    });
     $(".register-part04 a").click(function(){
        $(".register-part04").addClass("active-underline");
		 $(".register-part01,.register-part03,.register-part02,.register-part05,.register-part06,.register-part07").removeClass("active-underline");
        $('#accordionPart-AuthorizedSign1 .panel-collapse:not(".in")').collapse('show');
   });
   
   $(".register-part05 a").click(function(){
	   $(".register-part05").addClass("active-underline"); 
	     $(".register-part01,.register-part03,.register-part04,.register-part02,.register-part06,.register-part07").removeClass("active-underline");
	   $('#accordion-State1 .panel-collapse:not(".in")').collapse('show');
  });
   $(".register-part06 a").click(function(){
   	$(".register-part06").addClass("active-underline");
	$(".register-part01,.register-part03,.register-part04,.register-part05,.register-part02,.register-part07").removeClass("active-underline"); 
  });
   $(".register-part07 a").click(function(){
   	$(".register-part07").addClass("active-underline");
	$(".register-part01,.register-part03,.register-part04,.register-part05,.register-part02,.register-part06").removeClass("active-underline"); 
  });
   
   
   
   /*$scope.userModel={legalName:null,tradeName:null,panNumber:null,commencementDt:null,gstnRegistrationDt:null,organizationStatus:null,businessDtls:{stateCd:null,stateJurisdiction:null,wardCircleSectorNum:null,centerJurisdiction:null,rangeCd:null,commissionarateCd:null,divisionCd:null},gstnregistrationDtlses:[],goodsDtlses:[],serviceDtlses:[],organizationAddresses:[],parties:[]};*/
   
   	if (!String.prototype.includes) {
	    String.prototype.includes = function() {
	        'use strict';
	        return String.prototype.indexOf.apply(this, arguments) !== -1;
	    };
	}
   
    $scope.getCitizen=function(id){
    	  var citizenValue = $("input[name="+id+"]:checked").val();
    	  if(citizenValue=="Yes"){ $("#"+id).css("display","block"); } 
    	  else{ $("#"+id).css("display","none");}
    	  }
    
   
    
    $scope.getListCollpase=function(id){
    	
    	for(i=0;i<$("#userTab2 .panel-collapse").length;i++)
    		{
    			if(id==$("#userTab2 .panel-collapse")[i].id)
    				{
    				 $('#'+id+'.panel-collapse:not(".in")').collapse('show');
    				}
    			else{
    				 $('.panel-collapse.in').collapse('hide');
    			}
    		}
    	}
 $scope.getPartCollpase=function(id){
    	
    	for(i=0;i<$("#userTab3 .panel-collapse").length;i++)
    		{
    			if(id==$("#userTab3 .panel-collapse")[i].id)
    				{
    				 $('#'+id+'.panel-collapse:not(".in")').collapse('show');
    				}
    			else{
    				 $('.panel-collapse.in').collapse('hide');
    			}
    		}

    	}
		
/*Start : Authorized Signatory*/
    $scope.getPartCollpase=function(id){
      
       for(i=0;i<$("#userTab4 .panel-collapse").length;i++)
              {
                    if(id==$("#userTab4 .panel-collapse")[i].id)
                           {
                            $('#'+id+'.panel-collapse:not(".in")').collapse('show');
                           }
                    else{
                            $('.panel-collapse.in').collapse('hide');
                    }
              }
       }
    /*End : Authorized Signatory*/
    
   
 $scope.placeList=[{id: 'Place1', emailList:[{"emailid":"email1"}],mobileList:[{"mobileid":"mobile1","preferreddayList":[{"preferredid":"preferred1"}]}]}];
    
    $(document.body).on('click', '.changeType' ,function(){
           $(this).closest('.phone-input').find('.type-text').text($(this).text());
           $(this).closest('.phone-input').find('.type-input').val($(this).data('type-value'));
          
           var type_value=$(this).closest('.phone-input').find('.type-text').text($(this).text())[0].innerHTML;
           var ulId=$(".changeType").parent().parent()[1].id;
           if((type_value=="Mobile")||(type_value=="Phone")){
                  //$("#mobile_preferredday").css("display","block");
        	   var newuiId= ulId.substr(ulId.indexOf("-")+1,ulId.length);
        	   $("#preferred-"+newuiId).css("display","block");
        	 /*  
				for(i=0;i<$scope.placeList.length;i++){
					for(j=0;j<$scope.placeList[i].mobileList.length;j++)
						{
							if( (ulId.includes($scope.placeList[i].mobileList[j].mobileid)) || ($scope.placeList[i].mobileList[j].preferreddayList.length!=0)){
								var newItemNo = $scope.placeList[i].mobileList[j].preferreddayList.length+1;
								$scope.placeList[i].mobileList[j].preferreddayList.push({'preferredid':'preferred'+newItemNo});
							}
						}
				}*/

                  }
           		else{
                 // $("#mobile_preferredday").css("display","none");
                  }
    		});
   
    
    $scope.nextTabOpen=function(tabName){
    	var currentTab=tabName;
    	var nextTab=currentTab.length-1;
    	
    	
    }
  
    /*Start - Added by Sumedh */
    
    $scope.statelist = [{id: 'State1',gstrList:[{"gstrid":"gstr1"}]}]; 
    
    $scope.addgstinList  = function(id){
   	 for(i=0;i<$scope.statelist.length;i++){
			if(id.includes($scope.statelist[i].id))
			{
				var newItemNo = $scope.statelist[i].gstrList.length+1;
				$scope.statelist[i].gstrList.push({'gstrid':'gstr'+newItemNo});
			}
		 }
		}
    
    $scope.removegstinList = function(id) {
    for(i=0;i<$scope.statelist.length;i++){
		if(id.includes($scope.statelist[i].id))
		{
		var lastItem = $scope.statelist[i].gstrList.length-1;
		$scope.statelist[i].gstrList.splice(lastItem);
		}
		}
		}
    $scope.addGSTRList =function(){
   	 var newItemNo = $scope.statelist.length+1;
        $scope.statelist.push({'id':'State'+newItemNo,'gstrList':[{'gstrid':'gstrid1'}]});
        $('#userTab4 .panel-collapse.in').collapse('hide');
    }
    
    $scope.goodsDetail=[{
    	DescId: "Good 1",
    	hsnCode: "1234",
    	},{
    	DescId: "Good 2",
    	hsnCode: "2345",
    	}]
    
    $scope.addgoodsdetail = function () {
    $scope.goodsDetail.push({
    	DescId: $scope.newDescId,
    	hsnCode: $scope.newHSN
    });
    $scope.resetAll();
    }
    
    $scope.servicesDetail=[{
     	ServicesDescId: "Service 1",
     	sacCode: "1234",
     	},{
     	ServicesDescId: "Service 2",
     	sacCode: "2345",
     	}]
     $scope.addservicesdetail = function () {
     $scope.servicesDetail.push({
     	ServicesDescId: $scope.newServicesDescId,
     	sacCode: $scope.newSAC
     });
     $scope.resetAll();
     }
    $scope.resetAll=function(){
    	
    	$scope.newDescId=""
    	$scope.newHSN=""
    	$scope.newSAC=""
    	$scope.newServicesDescId=""
    }
    
    $scope.getorganisation = function(name){
    	if (name=="organisation"){
    		{$("#partyDiv").css("display","none");}
    		$("#orgDiv").css("display","block");
    	}
    	else{$("#partyDiv").css("display","block");
		$("#orgDiv").css("display","none");}
    }
    $scope.partydetails = [{id: 'Organisation1',partydetailsList:[{"partydetailid":"partydetail1"}]}]; 
                 
                 $scope.addpartydetailsinList  = function(id){
                	 for(i=0;i<$scope.partydetails.length;i++){
     					if(id.includes($scope.partydetails[i].id))
     					{
     						var newItemNo = $scope.partydetails[i].partydetailsList.length+1;
     						$scope.partydetails[i].partydetailsList.push({'partydetailid':'partydetail'+newItemNo});
     					}
     				 }
     				}
                 
                 $scope.removepartydetails = function(id) {
                 for(i=0;i<$scope.partydetails.length;i++){
         			if(id.includes($scope.partydetails[i].id))
         			{
         			var lastItem = $scope.partydetails[i].partydetailsList.length-1;
         			$scope.partydetails[i].partydetailsList.splice(lastItem);
         			}
         			}
         			}
                 $scope.addpartyList =function(){
                	 var newItemNo = $scope.partydetails.length+1;
                     $scope.partydetails.push({'id':'Organisation'+newItemNo,'partydetailsList':[{'partydetailid':'partydetailid1'}]});
                     $('#userTab6 .panel-collapse.in').collapse('hide');
                 }
                  
    $scope.orgdetails = [{id: 'Details',orgdetailsList:[{"orgdetailid":"orgdetail1"}]}]; 
                  
                  $scope.addorgdetailsinList  = function(id){
                 	 for(i=0;i<$scope.orgdetails.length;i++){
      					if(id.includes($scope.orgdetails[i].id))
      					{
      						var newItemNo = $scope.orgdetails[i].orgdetailsList.length+1;
      						$scope.orgdetails[i].orgdetailsList.push({'orgdetailid':'orgdetail'+newItemNo});
      					}
      				 }
      				}
                  
                  $scope.removeorgdetails = function(id) {
                  for(i=0;i<$scope.orgdetails.length;i++){
          			if(id.includes($scope.orgdetails[i].id))
          			{
          			var lastItem = $scope.orgdetails[i].orgdetailsList.length-1;
          			$scope.orgdetails[i].orgdetailsList.splice(lastItem);
          			}
          			}
          			}
    
    
    /*End - Added by Sumedh */
    

$scope.partnerList=[{id: 'Partner1', emailList:[{"emailid":"email1"}],mobileList:[{"mobileid":"mobile1"}],preferreddayList:[{"preferredid":""}]}];
$scope.addNewChoice = function(id) {
		if(id.includes("Place")){
		for(i=0;i<$scope.placeList.length;i++){
		if(id.includes($scope.placeList[i].id))
		{
		var newItemNo = $scope.placeList[i].mobileList.length+1;
		$scope.placeList[i].mobileList.push({'mobileid':'mobile'+newItemNo});
		}
		}
		}
		else if(id.includes("Partner")){
		for(i=0;i<$scope.partnerList.length;i++){
		if(id.includes($scope.partnerList[i].id))
		{
		var newItemNo = $scope.partnerList[i].mobileList.length+1;
		$scope.partnerList[i].mobileList.push({'mobileList':'mobile'+newItemNo});
		}
		}
		}
		 /* Start : Added By Dipti on 17/04/16 */
              else if(id.includes("AuthorizedSign")){
                    for(i=0;i<$scope.authorizedList.length;i++){
                    if(id.includes($scope.authorizedList[i].id))
                    {
                    var newItemNo = $scope.authorizedList[i].mobileList.length+1;
                    $scope.authorizedList[i].mobileList.push({'mobileList':'mobile'+newItemNo});
                    }
                   }
              }
              /* End : Added By Dipti on 17/04/16 */
		else{}
		    
      };
	  
	   /*Start : Authorized Signatory*/
      $scope.authorizedList=[{id: 'AuthorizedSign1', emailList:[{"emailid":"email1"}],mobileList:[{"mobileid":"mobile1"}],preferreddayList:[{"preferredid":""}]}];
      $scope.addNewChoice = function(id) {
             if(id.includes("Place")){
                    for(i=0;i<$scope.placeList.length;i++){
                    if(id.includes($scope.placeList[i].id))
                    {
                    var newItemNo = $scope.placeList[i].mobileList.length+1;
                    $scope.placeList[i].mobileList.push({'mobileid':'mobile'+newItemNo});
                    }
                    }
             }
             else if(id.includes("Partner")){
                    for(i=0;i<$scope.partnerList.length;i++){
                    if(id.includes($scope.partnerList[i].id))
                    {
                    var newItemNo = $scope.partnerList[i].mobileList.length+1;
                    $scope.partnerList[i].mobileList.push({'mobileList':'mobile'+newItemNo});
                    }
                    }
             }
             else if(id.includes("AuthorizedSign")){
                    for(i=0;i<$scope.authorizedList.length;i++){
                    if(id.includes($scope.authorizedList[i].id))
                    {
                    var newItemNo = $scope.authorizedList[i].mobileList.length+1;
                    $scope.authorizedList[i].mobileList.push({'mobileList':'mobile'+newItemNo});
                    }
                    }
             }
             else{}
                 
      };
      /*End : Authorized Signatory*/
        
      $scope.removeChoice = function(id) {
			if(id.includes("Place")){
			for(i=0;i<$scope.placeList.length;i++){
			if(id.includes($scope.placeList[i].id))
			{
			var lastItem = $scope.placeList[i].mobileList.length-1;
			$scope.placeList[i].mobileList.splice(lastItem);
			}
			}
			}
			else if(id.includes("Partner")){
			for(i=0;i<$scope.partnerList.length;i++){
			if(id.includes($scope.partnerList[i].id))
			{
			var lastItem = $scope.partnerList[i].mobileList.length-1;
			$scope.partnerList[i].mobileList.splice(lastItem);
			}
			}
			}
			/* Start : Added By Dipti on 17/04/16 */
                     else if(id.includes("AuthorizedSign")){
                     for(i=0;i<$scope.authorizedList.length;i++){
                     if(id.includes($scope.authorizedList[i].id))
                     {
                     var lastItem = $scope.authorizedList[i].mobileList.length-1;
                     $scope.authorizedList[i].mobileList.splice(lastItem);
                     }
                     }
                     }
                     /* End : Added By Dipti on 17/04/16 */
			else{}
      };
      $scope.addEmailChoice=function(id){
			//var placeid=$(".accordionplace .panel-default").attr("id");
			if(id.includes("Place")){
			for(i=0;i<$scope.placeList.length;i++){
			if(id.includes($scope.placeList[i].id))
			{
			var newItemNo = $scope.placeList[i].emailList.length+1;
			$scope.placeList[i].emailList.push({'emailid':'email'+newItemNo});
			}
			}
			}
			else if(id.includes("Partner")){
			for(i=0;i<$scope.partnerList.length;i++){
			if(id.includes($scope.partnerList[i].id))
			{
			var newItemNo = $scope.partnerList[i].emailList.length+1;
			$scope.partnerList[i].emailList.push({'emailid':'email'+newItemNo});
			}
			}
			}
			 /* Start : Added By Dipti on 17/04/16 */
                     else if(id.includes("AuthorizedSign")){
                           for(i=0;i<$scope.authorizedList.length;i++){
                           if(id.includes($scope.authorizedList[i].id))
                           {
                           var newItemNo = $scope.authorizedList[i].emailList.length+1;
                            $scope.authorizedList[i].emailList.push({'emailid':'email'+newItemNo});
                           }
                           }
                     }
                     /* End : Added By Dipti on 17/04/16 */
			else{}
      	}
     
           $scope.removeEmailChoice = function(id) {
				if(id.includes("Place")){
				for(i=0;i<$scope.placeList.length;i++){
					if(id.includes($scope.placeList[i].id))
					{
					var lastItem = $scope.placeList[i].emailList.length-1;
					$scope.placeList[i].emailList.splice(lastItem);
					}
				 }
				}
				else if(id.includes("Partner")){
				for(i=0;i<$scope.partnerList.length;i++){
					if(id.includes($scope.partnerList[i].id))
					{
					var lastItem = $scope.partnerList[i].emailList.length-1;
					$scope.partnerList[i].emailList.splice(lastItem);
					}
				}
				}
	   /* Start : Added By Dipti on 17/04/16 */
			   else if(id.includes("AuthorizedSign")){
					  for(i=0;i<$scope.authorizedList.length;i++){
							 if(id.includes($scope.authorizedList[i].id))
							 {
							 var lastItem = $scope.authorizedList[i].emailList.length-1;
							 $scope.authorizedList[i].emailList.splice(lastItem);
							 }
			   }
			   }
			   /* End : Added By Dipti on 17/04/16 */
			   else{}
             };
            

             
            
             $scope.addPlacedetails=function(){
                   
                    var newItemNo = $scope.placeList.length+1;
                    //var newMobileNo = $scope.placeList[newItemNo].mobileList.length+1;
                      $scope.placeList.push({'id':'Place'+newItemNo,'emailList':[{'emailid':'email1'}],'mobileList':[{'mobileid':'mobile1'}]});
                      $('#userTab2 .panel-collapse.in').collapse('hide');

             }
            
             //$scope.partnerList=[{id: 'Partner1'}];
             $scope.addpartnerdetails=function(){
                    var newItemNo = $scope.partnerList.length+1;
                    $scope.partnerList.push({'id':'Partner'+newItemNo,'emailList':[{'emailid':'email1'}],'mobileList':[{'mobileid':'mobile1'}]});
				$('#userTab3 .panel-collapse.in').collapse('hide');
	
             }
			 
			  /* Start : Added By Dipti */
             $scope.addAutorizedDetails=function(){
                 var newItemNo = $scope.authorizedList.length+1;
                 $scope.authorizedList.push({'id':'AuthorizedSign'+newItemNo,'emailList':[{'emailid':'email1'}],'mobileList':[{'mobileid':'mobile1'}]});
                         $('#userTab7 .panel-collapse.in').collapse('hide');
      
             }
             /* End : Added By Dipti */
   
}]);