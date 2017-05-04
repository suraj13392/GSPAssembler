appEngage.controller("homeController",["$scope",'$http','$q','$rootScope',function($scope,$http,$q,$rootScope){
	/*$("#latestSignIn").removeClass("hide");*/
	 $("#signup_div").css("display","none");
	$("#sign_div").css("display","none");
	$(".header-note").removeClass('hide');
	
}]);





appEngage.controller("stateController",["$scope",'$http','$q','$rootScope',function($scope,$http,$q,$rootScope){
	$('#dashboardDiv').css("display","none");
	
	
	 $(".del_row").css("display","none");
	$("#sign_div").css("display","none");
	$(".header-note").addClass('hide')
var tdata=[{
	stateCode:"11",
	stateName:"Delhi",
	check : "false"
	},
	{
	stateCode:"12",
	stateName:"Haryana",
	check : "false"
	},
	{
	stateCode:"14",
	stateName:"Punjab",
	check : "false"
	},
	{
	stateCode:"17",
	stateName:"Himachal Pradesh",
	check : "false"
	},
	{
	stateCode:"18",
	stateName:"Jammu & Kashmir",
	check : "false"
	},
	{
	stateCode:"19",
	stateName:"Uttar Pradesh",
	check : "false"
	},
	{
	stateCode:"20",
	stateName:"Maharashtra",
	check : "false"
	},
	{
	stateCode:"21",
	stateName:"Gujrat",
	check : "false"
	},
	{
	stateCode:"22",
	stateName:"Assam",
	check : "false"
	},
	{
	stateCode:"23",
	stateName:"Kerala",
	check : "false"
	},
	{
	stateCode:"24",
	stateName:"Orissa",
	check : "false"
	},
	{
	stateCode:"25",
	stateName:"Rajasthan",
	check : "false"
	},
	{
	stateCode:"26",
	stateName:"Manipur",
	check : "false"
	},
	{
	stateCode:"27",
	stateName:"Punjab",
	check : "false"
	}]
	
	
	$("#mytable #checkall").click(function () {
	if ($("#mytable #checkall").is(':checked')) {
	$("#mytable input[type=checkbox]").each(function () {	
	$(this).prop("checked", true);
	});
	} else {
	$("#mytable input[type=checkbox]").each(function () {
	$(this).prop("checked", false);});
	}
	});
	
	 var t="";
	 $scope.tableArray=[];
	for(var i=0;i<tdata.length;i++)
	{
	/*  var t= "<tr><td><input type='checkbox' name='record'></td><td>" + tdata[i].stateCode+ "</td><td>" + tdata[i].stateName + "</td></tr>";
	 $("table tbody").append(t); */
	 $scope.tableArray.push(tdata[i]);
	}
	
	
		

 var dataArray=[];  
		var sel_state={
		stateCode:"",
		stateName:"",
		check:"false"
		}
	$scope.state_btn=function()
	{
		dataArray=[];
		var arr =$("table tbody").find('input[name="record"]');
			
		 $("table tbody").find('input[name="record"]').each(function(index)
		 //for(i=0;i<$("table tbody").find('input[name="record"]').length;i++)
		 {
            if($(this).is(":checked")){
            	sel_state = new Object();
            		sel_state.stateCode=$(this).closest("tr").find('td:eq(1)').text();
            		sel_state.stateName=$(this).closest("tr").find('td:eq(2)').text();
					sel_state.check=true;
					
					for(var i=0;i<tdata.length;i++)
					{
						if(sel_state.stateCode==tdata[i].stateCode)
						{
							tdata[i].check=true;
						}
					}
					
            		dataArray.push(sel_state);
								
            	}
				else{
					var dTable=$(this).closest("tr").find('td:eq(1)').text();
					for(var i=0;i<tdata.length;i++)
					{
						if(dTable==tdata[i].stateCode)
						{
							tdata[i].check=false;
						}
					}
				}
            //}
          });
          $("#mytable tbody").empty();
		  //$scope.tableArray=[];
         for(var j=0;j<dataArray.length;j++)
         {
         	 var t= "<tr><td><input type='checkbox' name='record'></td><td>" + dataArray[j].stateCode+ "</td><td>" +dataArray[j].stateName + "</td><td><buttton type='submit' data-toggle='modal' data-target='#deleteModal' style='cursor:pointer' id='delete_state'><i class='glyphicon glyphicon-trash'></i></button></td></tr>";
		 $("#mytable tbody").append(t);  
		  //$scope.tableArray.push(dataArray[j]);
		 
         }
		// $("#last_deltd").css("display","block");
         $(".del_row").css("display","block");
         $("#save_state").css("display","none");
		 $("#state_manage").css("display","block");
		 $("#checkall").css("display","block");
		 
	
	}
		
		
	$scope.deleteRecord=function(){
		  $("table tbody").find('input[name="record"]').each(function(){
            	if($(this).is(":checked")){
					var stateCodeData=$(this).closest("tr").find('td:eq(1)').text();
					for(var i=0;i<tdata.length;i++)
					{
						if(stateCodeData==tdata[i].stateCode)
						{
							tdata[i].check=false;
						}
					}
                    $(this).parents("tr").remove();
                }
            });
        };
	
	$scope.state_manage=function(){
		 $("#mytable tbody").empty();
		 $(".del_row").css("display","none");
		 $("#save_state").css("display","block");
		 $("#state_manage").css("display","none");
		//$scope.tableArray=[];
		var t="";
		for(var i=0;i<tdata.length;i++){
			
			// $scope.tableArray.push(tdata[i]);
			if(tdata[i].check == true)
			{
			t= "<tr><td><input type='checkbox' name='record' checked='checked'></td><td>" + tdata[i].stateCode+ "</td><td>" + tdata[i].stateName + "</td></tr>";
			$("table tbody").append(t);
			}
			else{
				t= "<tr><td><input type='checkbox' name='record'></td><td>" + tdata[i].stateCode+ "</td><td>" + tdata[i].stateName + "</td></tr>";
			$("table tbody").append(t);
			}
			
		}
	}
	

}]);




appEngage.controller("hsnController",["$scope",'$http','$q','$rootScope',function($scope,$http,$q,$rootScope){
	$('#dashboardDiv').css("display","none");
	
	
		
	 $(".del_row").css("display","none");
	$("#sign_div").css("display","none");
	$(".header-note").addClass('hide')
var HSNdata=[{
	HSNCode:"3208 10 10",
	HSNName:"Enamels",
	check : "false"
	},
	{
	HSNCode:"3208 10 20",
	HSNName:"Lacquers",
	check : "false"
	},
	{
	HSNCode:"0101 00 00",
	HSNName:"Horses",
	check : "false"
	},
	{
	HSNCode:"0102 00 00",
	HSNName:"Bovine animals",
	check : "false"
	},
	{
	HSNCode:"0103 00 00",
	HSNName:"swine",
	check : "false"
	},
	{
	HSNCode:"3208 10 90",
	HSNName:"Other",
	check : "false"
	},
	{
	HSNCode:"0104 00 00",
	HSNName:"sheep and goats",
	check : "false"
	}]
	
	
	$("#mytable #checkall").click(function () {
	if ($("#mytable #checkall").is(':checked')) {
	$("#mytable input[type=checkbox]").each(function () {	
	$(this).prop("checked", true);
	});
	} else {
	$("#mytable input[type=checkbox]").each(function () {
	$(this).prop("checked", false);});
	}
	});
	
	 var t="";
	 $scope.HSNtableArray=[];
	for(var i=0;i<HSNdata.length;i++)
	{
	 /* var t= "<tr><td><input type='checkbox' name='record'></td><td>" + tdata[i].HSNCode+ "</td><td>" + tdata[i].HSNName + "</td></tr>";
	 $("table tbody").append(t); */
	 $scope.HSNtableArray.push(HSNdata[i]);
	}
	
		

 var dataHSNArray=[];  
		var sel_HSN={
		HSNCode:"",
		HSNName:"",
		check:"false"
		}
	$scope.HSNSave_btn=function()
	{
		dataHSNArray=[];
		var arr =$("table tbody").find('input[name="record"]');
			
		 $("table tbody").find('input[name="record"]').each(function(index)
		 //for(i=0;i<$("table tbody").find('input[name="record"]').length;i++)
		 {
            if($(this).is(":checked")){
            	sel_HSN = new Object();
            		sel_HSN.HSNCode=$(this).closest("tr").find('td:eq(1)').text();
            		sel_HSN.HSNName=$(this).closest("tr").find('td:eq(2)').text();
					sel_HSN.check=true;
					for(var i=0;i<HSNdata.length;i++)
					{
						if(sel_HSN.HSNCode==HSNdata[i].HSNCode)
						{
							HSNdata[i].check=true;
						}
					}
            		dataHSNArray.push(sel_HSN);
            
            	}
				else{
					var HSNDTable=$(this).closest("tr").find('td:eq(1)').text();
					for(var i=0;i<HSNdata.length;i++)
					{
						if(HSNDTable==HSNdata[i].HSNCode)
						{
							HSNdata[i].check=false;
						}
					}
				}
            //}
          });
          $("#mytable tbody").empty();
         for(var j=0;j<dataHSNArray.length;j++)
         {
         	var t= "<tr><td><input type='checkbox' name='record'></td><td>" + dataHSNArray[j].HSNCode+ "</td><td>" +dataHSNArray[j].HSNName + "</td><td><buttton type='submit' data-toggle='modal' data-target='#deleteModal' style='cursor:pointer' id='delete_state'><i class='glyphicon glyphicon-trash'></i></button></td></tr>";
		 $("#mytable tbody").append(t);
		 
         }
         $(".del_row").css("display","block");
         $("#save_HSN").css("display","none");
		 $("#HSN_manage").css("display","block");
		 $("#checkall").css("display","block");
		 
	
	}
		
	
	$scope.deleteHSNRecord=function(){
		  $("table tbody").find('input[name="record"]').each(function(){
            	if($(this).is(":checked")){
					var HSNCODEData=$(this).closest("tr").find('td:eq(1)').text();
					for(var i=0;i<HSNdata.length;i++)
					{
						if(HSNCODEData==HSNdata[i].HSNCode)
						{
							HSNdata[i].check=false;
						}
					}
                    $(this).parents("tr").remove();
                }
            });
        };
		
			$scope.HSN_manage=function(){
		 $("#mytable tbody").empty();
		 $(".del_row").css("display","none");
		 $("#save_HSN").css("display","block");
		 $("#HSN_manage").css("display","none");
		//$scope.tableArray=[];
		var t="";
		for(var i=0;i<HSNdata.length;i++){
			
			// $scope.tableArray.push(tdata[i]);
			if(HSNdata[i].check == true)
			{
			t= "<tr><td><input type='checkbox' name='record' checked='checked'></td><td>" + HSNdata[i].HSNCode+ "</td><td>" + HSNdata[i].HSNName + "</td></tr>";
			$("table tbody").append(t);
			}
			else{
				t= "<tr><td><input type='checkbox' name='record'></td><td>" + HSNdata[i].HSNCode+ "</td><td>" + HSNdata[i].HSNName + "</td></tr>";
			$("table tbody").append(t);
			}
			
		}
	}
	
	

}]);

appEngage.controller("supplierController",["$scope",'$http','AllService','$q','$rootScope','$filter','filteredListService',function($scope,$http,AllService,$q,$rootScope,$filter,filteredListService){
	$('#dashboardDiv').css("display","none");
	
	$("#sign_div").css("display","none");
	$(".header-note").addClass('hide');
	  $scope.pageSize = 10;
 // $scope.allItems = getDummyData(); 
    $scope.reverse = false;
 	$scope.arrData=[];
 	
 	  $scope.resetAll = function () {
	        $scope.filteredList = $scope.allItems;
	        $scope.arrData=$scope.filteredList;
	        $scope.newEmpId = '';
	        $scope.newName = '';
	        $scope.newEmail = '';
	        $scope.searchText = '';
	        $scope.currentPage = 0;
	        $scope.Header = ['','',''];
	    }
 	  
 	  $scope.allItems=[{
 			GSTINId: "",
 	        supplierName: "",
 			}]
 	    $scope.AllSupplier=null;
 	  
 	  AllService.getAllSupplier().then(function(data)
			   {
 		  		$scope.AllSupplier=data;
 		  		
 		  		
			    for(i=0;i<$scope.AllSupplier.length;i++)
			    	{
			    	$scope.allItems=new Object();
			    	 $scope.allItems.GSTINId=$scope.AllSupplier[i].supplierId;
			    	 $scope.allItems.supplierName=$scope.AllSupplier[i].supplierDetails;
			    	 $scope.arrData[i]= $scope.allItems;
			    	}
			   
			});
 	  	    

    $scope.add = function () {
      /*  $scope.allItems.push({
            GSTINId: $scope.newEmpId,
            supplierName: $scope.newName
        });*/
        
     $scope.arrData.GSTINId=$scope.newEmpId;
   	 $scope.arrData.supplierName=$scope.newName;
        
        $scope.supplierDetails={
        		"supplierId" :"",
        		"supplierDetails" : ""
        }
        $scope.supplierDetails.supplierId = $scope.newEmpId;
        $scope.supplierDetails.supplierDetails = $scope.newName;
       
       // $scope.resetAll();
        
        AllService.saveSupplier($scope.supplierDetails).then(
                function(response){
                	console.log("response:"+response);
                	
                	  AllService.getAllSupplier().then(function(data)
               			   {
                		  		$scope.AllSupplier=data;
                		  		                		  		
               			    for(i=0;i<$scope.AllSupplier.length;i++)
               			    	{
               			    	$scope.allItems=new Object();
               			    	 $scope.allItems.GSTINId=$scope.AllSupplier[i].supplierId;
               			    	 $scope.allItems.supplierName=$scope.AllSupplier[i].supplierDetails;
               			    	 $scope.arrData[i]= $scope.allItems;
               			    	}
               			});
                	  	    
                });
        
    }

    $scope.search = function () {
        $scope.filteredList = 
       filteredListService.searched($scope.allItems, $scope.searchText);
        
        if ($scope.searchText == '') {
            $scope.filteredList = $scope.allItems;
        }
        $scope.pagination(); 
    }


    // Calculate Total Number of Pages based on Search Result
    $scope.pagination = function () {
        $scope.ItemsByPage = filteredListService.paged( $scope.filteredList, $scope.pageSize );         
    };

    $scope.setPage = function () {
        $scope.currentPage = this.n;
    };

    $scope.firstPage = function () {
        $scope.currentPage = 0;
    };

    $scope.lastPage = function () {
        $scope.currentPage = $scope.ItemsByPage.length - 1;
    };

    $scope.range = function (input, total) {
        var ret = [];
        if (!total) {
            total = input;
            input = 0;
        }
        for (var i = input; i < total; i++) {
            if (i != 0 && i != total - 1) {
                ret.push(i);
            }
        }
        return ret;
    };
    
    $scope.sort = function(sortBy){
        $scope.resetAll();  
        
        $scope.columnToOrder = sortBy; 
             
        //$Filter - Standard Service
        $scope.filteredList = $filter('orderBy')($scope.filteredList, $scope.columnToOrder, $scope.reverse); 

        if($scope.reverse)
             iconName = 'glyphicon glyphicon-chevron-up';
         else
             iconName = 'glyphicon glyphicon-chevron-down';
              
        if(sortBy === 'EmpId')
        {
            $scope.Header[0] = iconName;
        }
        else if(sortBy === 'name')
        {
            $scope.Header[1] = iconName;
        }else {
            $scope.Header[2] = iconName;
        }
         
        $scope.reverse = !$scope.reverse;   
        
        $scope.pagination();    
    };
    
    //By Default sort ny Name
     $scope.sort ('name');  
	
	
	
	
	save=function(){
		
		document.getElementById('gstnNo').readOnly = true;
		document.getElementById('sup_detail').readOnly = true;
		
	}
	
	$scope.deleteSup=function(supplierId)
	{
		$scope.deleteData={
				"supplierId" : null
		}
		
		$scope.deleteData.supplierId=supplierId;
		/* AllService.deleteSupplier($scope.deleteData).then(function(data){
			 
			console.log("Data:"+data);*/
			 
				for(i=0;i<$scope.arrData.length;i++)
				{
					if(supplierId==$scope.arrData[i].GSTINId)
					{
						var index = $scope.arrData.indexOf($scope.arrData[i]);
						 //$scope.allItems[i];
					}
				}
				if (index > -1) {
					$scope.arrData.splice(index, 1);
				}
			 
		/* });*/
		
	
	}
	
	$scope.editSup=function(id){
		
		for(i=0;i<$scope.arrData.length;i++)
		{
			if(id==$scope.arrData[i].GSTINId)
			{
				$scope.newEmpId=$scope.arrData[i].GSTINId;
           		 $scope.newName=$scope.arrData[i].supplierName;
			}
		}
		
		$("#editSupplierBtn").css("display","block");
		$("#addSupplierBtn").css("display","none");
		document.getElementById("gstinId").readOnly = true;
		$("#gstinId").attr("readonly","readonly'");
		
	}
	
	$scope.editSupData=function(){
		
		 $scope.supplierDetails={
	        		"supplierId" :"",
	        		"supplierDetails" : ""
	        }
	        $scope.supplierDetails.supplierId = $scope.newEmpId;
	        $scope.supplierDetails.supplierDetails = $scope.newName;
	       
	        AllService.editSupplier($scope.supplierDetails).then(function(data)
       			   {
        		  			console.log("Edited"+data);
        		  			$scope.supplierEdit=data;
        		  			
        		  			for(i=0;i<$scope.arrData.length;i++)
        		  			{
        		  				if($scope.arrData[i].GSTINId==$scope.supplierEdit.data.supplierId)
        		  					{
        		  					$scope.arrData[i].GSTINId=$scope.supplierEdit.data.supplierId;
        		     				$scope.arrData[i].supplierName=$scope.supplierEdit.data.supplierDetails;
        		  					}
        		  			
        		  			}
        		  
       			});
	        
		$("#gstinId").attr("readonly",false);
		$scope.newEmpId="";
		$scope.newName="";
		$("#editSupplierBtn").css("display","none");
		$("#addSupplierBtn").css("display","block");
		
	}
}]);

var TableCtrl =appEngage.controller("receipientController",["$scope",'$http','$q','$rootScope','$filter','filteredListService',function($scope,$http,$q,$rootScope,$filter,filteredListService){
	$('#dashboardDiv').css("display","none");
	
		
	$("#sign_div").css("display","none");
	$(".header-note").addClass('hide')
	  $scope.pageSize = 10;
 // $scope.allItems = getDummyData(); 
    $scope.reverse = false;
 	$scope.arrData=[];
    $scope.resetAll = function () {
        $scope.filteredList = $scope.allItems;
        $scope.arrData=$scope.filteredList;
        $scope.newEmpId = '';
        $scope.newName = '';
        $scope.newEmail = '';
        $scope.searchText = '';
        $scope.currentPage = 0;
        $scope.Header = ['','',''];
    }

$scope.allItems=[{
			GSTINId: "GSTN123",
            recipientName: "ABC Pvt ltd",
			},{
			GSTINId: "GSTN565",
            recipientName: "XYZ Pvt ltd",
			}]
    $scope.add = function () {
        $scope.allItems.push({
            GSTINId: $scope.newEmpId,
            recipientName: $scope.newName
        });
        $scope.resetAll();
    }

    $scope.search = function () {
        $scope.filteredList = 
       filteredListService.searched($scope.allItems, $scope.searchText);
        
        if ($scope.searchText == '') {
            $scope.filteredList = $scope.allItems;
        }
        $scope.pagination(); 
    }


    // Calculate Total Number of Pages based on Search Result
    $scope.pagination = function () {
        $scope.ItemsByPage = filteredListService.paged( $scope.filteredList, $scope.pageSize );         
    };

    $scope.setPage = function () {
        $scope.currentPage = this.n;
    };

    $scope.firstPage = function () {
        $scope.currentPage = 0;
    };

    $scope.lastPage = function () {
        $scope.currentPage = $scope.ItemsByPage.length - 1;
    };

    $scope.range = function (input, total) {
        var ret = [];
        if (!total) {
            total = input;
            input = 0;
        }
        for (var i = input; i < total; i++) {
            if (i != 0 && i != total - 1) {
                ret.push(i);
            }
        }
        return ret;
    };
    
    $scope.sort = function(sortBy){
        $scope.resetAll();  
        
        $scope.columnToOrder = sortBy; 
             
        //$Filter - Standard Service
        $scope.filteredList = $filter('orderBy')($scope.filteredList, $scope.columnToOrder, $scope.reverse); 

        if($scope.reverse)
             iconName = 'glyphicon glyphicon-chevron-up';
         else
             iconName = 'glyphicon glyphicon-chevron-down';
              
        if(sortBy === 'EmpId')
        {
            $scope.Header[0] = iconName;
        }
        else if(sortBy === 'name')
        {
            $scope.Header[1] = iconName;
        }else {
            $scope.Header[2] = iconName;
        }
         
        $scope.reverse = !$scope.reverse;   
        
        $scope.pagination();    
    };
    
    //By Default sort ny Name
     $scope.sort ('name');  
	
	
	
	
	
	save=function(){
		
		document.getElementById('gstnNo').readOnly = true;
		document.getElementById('sup_detail').readOnly = true;
		
	}
	
	$scope.deleteRec=function(GSTIN_Id)
	{
		for(i=0;i<$scope.allItems.length;i++)
		{
			if(GSTIN_Id==$scope.allItems[i].GSTINId)
			{
				var index = $scope.allItems.indexOf($scope.allItems[i]);
				 //$scope.allItems[i];
			}
		}
		if (index > -1) {
			$scope.allItems.splice(index, 1);
		}
	}
	
	$scope.editRec=function(id){
		
		for(i=0;i<$scope.allItems.length;i++)
		{
			if(id==$scope.allItems[i].GSTINId)
			{
				$scope.newEmpId=$scope.allItems[i].GSTINId;
           		 $scope.newName=$scope.allItems[i].recipientName;
			}
		}
		
		$("#editRecipientBtn").css("display","block");
		$("#addRecipientBtn").css("display","none");
		document.getElementById("gstinId").readOnly = true;
		$("#gstinId").attr("readonly","readonly'");
		
	}
	
	$scope.editRecData=function(){
		for(i=0;i<$scope.allItems.length;i++)
		{
			if($scope.newEmpId==$scope.allItems[i].GSTINId)
			{
				$scope.allItems[i].GSTINId=$scope.newEmpId;
				$scope.allItems[i].recipientName=$scope.newName;
			}
		}
		$("#gstinId").attr("readonly",false);
		$scope.newEmpId="";
		$scope.newName="";
		$("#editRecipientBtn").css("display","none");
		$("#addRecipientBtn").css("display","block");
		
	}
}]);
