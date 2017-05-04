appEngage.run(function(editableOptions) {
  editableOptions.theme = 'bs3';
});


appEngage.controller("gstr2Controller",['$scope','$http','GSTR2Service','$q','$rootScope',function($scope,$http,GSTR2Service,$q,$rootScope){
	
	 $('#dashboardDiv').css("display","none");
		
	$("#form_table2").hide();
	$("#download_link").css("display","none");
	
	
	
	$scope.getData=function(){
		$("#download_link").css("display","block");
		$("#errorMessageDiv ,#successMessageDiv").css("display","none");
    	/*$("#form_table").css("display","block");*/
    	
    	 $("#form_table2").delay(500).hide(0, function() {
 	        $("#form_table2").show();
 	    });
 	  
    	
   /* 	GSTR2Service.getGSTRData().then(function(data)
 			   {
 		 			console.log("Service GSTR:"+data);
 			   });*/
		
    	$http.get("json/GSTR2_AmmendedGoodsInvoice.json").then(function(response) {
	        $scope.jsonData = response.data;
	    });
	    
	    $http.get("json/GSTR2_ServiceBills.json").then(function(response) {
	        $scope.jsonServiceBills = response.data;
	    });
	    
	      $http.get("json/GSTR2_AmmendedServiceBills.json").then(function(response) {
	        $scope.jsonAmmendedSerBill = response.data;
	    });
	    
	     $http.get("json/GSTR2_CDNInvoice.json").then(function(response) {
	        $scope.jsonCDNInvoice = response.data;
	    });
	    
	    $http.get("json/GSTR2_CDNAInvoice.json").then(function(response) {
	        $scope.jsonCDNAInvoice = response.data;
	    });
	    
	     $http.get("json/GSTR2_NilRatedInvoice.json").then(function(response) {
	        $scope.jsonNilRated = response.data;
	    });
	    
	     $http.get("json/GSTN2_ISDCredit.json").then(function(response) {
	        $scope.jsonISDCredit = response.data;
	    });
	    
	     $http.get("json/GSTR2_TDSCredit.json").then(function(response) {
	        $scope.jsonTDSCredit = response.data;
	    });
	     
	     $http.get("json/GSTR2_TCSCredit.json").then(function(response) {
	        $scope.jsonTCSCredit = response.data;
	    });
	    
	    $http.get("json/GSTR2_ITCReceived.json").then(function(response) {
	        $scope.jsonITCreceived = response.data;
	    });
	    
	     $http.get("json/GSTR2_TaxLiability.json").then(function(response) {
	        $scope.jsonTaxLiability = response.data;
	    });
	    
	    $http.get("json/GSTR2_AmendedTaxLiability.json").then(function(response) {
	        $scope.jsonAmendedTaxLiability = response.data;
	    });
	    
	    $http.get("json/GSTR2_TaxReverseCharger.json").then(function(response) {
	        $scope.jsonTaxReverserCharges = response.data;
	    });
	    
	    $http.get("json/GSTR2_ITC.json").then(function(response) {
	        $scope.jsonITC = response.data;
	    });
	    
	     $http.get("json/GSTR2_ImportGoodsInvoices.json").then(function(response) {
	        $scope.jsonImportGoodsInvoices = response.data;
	    });
	    
	     $http.get("json/GSTR2_AmmendedB2BAInvoice.json").then(function(response) {
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
	    
	    $http.get("json/GSTR2_B2B.json").then(function(response) {
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
	}
	
	
    $scope.saveGstr2=function(){
   	 /* $("#successMessageDiv").delay(100).hide(0, function() {*/
   		  $("#successMessageDiv").slideDown("fast");
 	 /*   });*/
		$("#successMsgTxt").html("<i class='fa fa-check'></i>&nbsp;GSTR2 Save Successfully");
   }

  $scope.saveTableData = function(data, id) {
    //$scope.user not updated yet
   
    //angular.extend(data, {oboe_num: id});
       //return $http.post('/saveUser', data);
   console.log("Save user:"+data);
   
  };

  // remove user
  $scope.removeTableData = function(index) {
    $scope.users.splice(index, 1);
  };

  $scope.addTableData = function() {
   
  };

 
   $scope.exportAction = function(){
		
		var type=$("#download_sel").val();
		
				
				if(type=="Excel"){
					
					 
					var opts = [{sheetid:'5',headers:true},{sheetid:'5A',headers:true},{sheetid:'6',headers:true},{sheetid:'6A',headers:true},{sheetid:'7',headers:true},{sheetid:'7A',headers:true},{sheetid:'8',headers:true},{sheetid:'9',headers:true},
								{sheetid:'10A',headers:true},{sheetid:'10B',headers:true},{sheetid:'11',headers:true},{sheetid:'12',headers:true},
								{sheetid:'12A',headers:true},{sheetid:'13',headers:true},{sheetid:'14',headers:true},{sheetid:'14A',headers:true}];
				 
			 var res1=alasql('SEARCH / AS @b  UNION ALL(  itms / AS @c RETURN (@b->boe_num AS Bill_No,@b->boe_dt AS Bill_Date,@b->boe_val AS Bill_Value,@c->hsn_sc AS HSN,@c->txval AS Taxable_Value,\
							@c->irt AS IGST_Rate,@c->iamt AS IGST_Amt,@c->elg AS Eligiblity_ITC,@c->tx_i AS TotalTAx_ITC,@c->tc_i AS ITCAvaiable_Month)) from ?\
				',[$scope.jsonImportGoodsInvoices.imp_g]);
				
			var res2=alasql('SEARCH / AS @b  UNION ALL(  itms / AS @c RETURN (@b->oboe_num AS Original_Bill_No,@b->oboe_dt AS Original_Bill_Date,@b->boe_num AS Revisied_Bill_No,\
							@b->boe_dt AS Revisied_Bill_Date,@b->boe_val AS Revisied_Bill_Value, @c->hsn_sc AS HSN,@c->txval AS Taxable_Value,\
							@c->irt AS IGST_Rate,@c->iamt AS IGST_Amt,@c->elg AS Eligiblity_ITC,@c->tx_i AS TotalTAx_ITC,@c->tc_i AS ITCAvaiable_Month)) from ?\
				',[$scope.jsonData.imp_ga]);
				
			var res3=alasql('SEARCH / AS @b  UNION ALL(  itms / AS @c RETURN (@b->i_num AS Invoice_No,@b->i_dt AS Invoice_Date,@b->i_val AS Invoice_Value,\
							 @c->hsn_sc AS Invoice_SAC,@c->txval AS Invoice_Taxable_Value,\
							@c->irt AS IGST_Rate,@c->iamt AS IGST_Amt,@c->tia AS Total_ITC,@c->iam AS ITC_Current_Month)) from ?\
				',[$scope.jsonServiceBills.imp_s]);
				
			var res4=alasql('SEARCH / AS @b  UNION ALL(  itms / AS @c RETURN (@b->oi_num AS Original_Invoice_No,@b->oi_dt AS Original_Invoice_Date,@b->i_num AS Revisied_Invoice_No,\
							 @b->i_dt AS Revisied_Invoice_Date,@b->i_val AS Revisied_Invoice_Value,@c->hsn_sc AS Invoice_SAC,@c->txval AS Invoice_Taxable_Value,\
							@c->irt AS IGST_Rate,@c->iamt AS IGST_Amt,@c->tia AS Total_ITC,@c->iam AS ITC_Current_Month)) from ?\
				',[$scope.jsonAmmendedSerBill.imp_sa]);
				
			var res5=alasql('SEARCH / AS @b  UNION ALL(  cdn / AS @c RETURN (@b->cgstin AS GSTIN,@b->typ AS Type_Note,@c->nt_num AS Note_No,\
							 @c->nt_dt AS Note_Date,@c->i_num AS Original_Invoice_No,@c->i_dt AS Original_Invoice_Date,@c->val AS Differential_Value,\
							@c->irt AS Differential_IGST_Rate,@c->iamt AS Differential_IGST_Amt,@c->crt AS Differential_CGST_Rate,@c->camt AS Differential_CGST_Amt,@c->srt AS Differential_SGST_Rate,@c->samt AS Differential_SGST_Amt,@c->elg AS Eligiblity_ITC, \
							@c->itc.tx_i AS ITC_IGST_Amt,@c->itc.tx_c AS ITC_CGST_Amt,@c->itc.tx_s AS ITC_SGST_Amt,@c->itc.tc_i AS ITC_CMonth_IGSTAmt ,\
							@c->itc.tc_c AS ITC_CMonth_CGSTAmt,@c->itc.tc_s AS ITC_CMonth_SGSTAmt)) from ?\
				',[$scope.jsonCDNInvoice.cdn_Data]);
				
			
			var res6=alasql('SEARCH / AS @b  UNION ALL(  itc  AS @c RETURN (@b->cgstin AS GSTIN,@b->ont_num AS Type_Note,@b->ont_dt AS Note_No,\
							 @b->cgstin AS Note_Date,@b->nt_num AS Original_Invoice_No,@b->nt_dt AS Original_Invoice_Date,@b->typ AS Differential_Value,\
							@b->val AS Differential_IGST_Rate,@b->irt AS Differential_IGST_Amt,@b->iamt AS Differential_IGST_Amt,@b->crt AS Differential_CGST_Rate,@b->camt AS Differential_CGST_Amt,@b->srt AS Differential_SGST_Rate,@b->samt AS Differential_SGST_Amt,@b->elg AS Eligiblity_ITC, \
							@c->tx_i AS ITC_IGST_Amt,@c->tx_c AS ITC_CGST_Amt,@c->tx_s AS ITC_SGST_Amt,@c->tc_i AS ITC_CMonth_IGSTAmt ,\
							@c->tc_c AS ITC_CMonth_CGSTAmt,@c->tc_s AS ITC_CMonth_SGSTAmt)) from ?\
				',[$scope.jsonCDNAInvoice.cdna]);
				
			var res8= alasql('SELECT hsn_sc AS HSN_SAC,cpddr AS Compounding_Taxable_Person,uredr AS Unregistered_Taxable_Person,exptdsply AS Exempt_Supply,\
								nilsply AS Nil_Rated_Supplier, ngsply AS NON_GST_Supply from ?\
							',[$scope.jsonNilRated.nil]);
			
			var res9= alasql('SELECT gstin_isd AS GSTIN_ISD,i_num AS Invoice_No,i_dt AS Invoice_Date,Invoice_Value AS SAC,\
								ig_cr AS ISD_IGST, cg_cr AS ISD_CGST,sg_cr AS ISD_SGST from ?\
							',[$scope.jsonISDCredit.isd_rcd]);
				
			var res10A=alasql('SEARCH / AS @b  UNION ALL(  tds_invoices / AS @c RETURN (@c->ctin AS GSTIN,@c->i_num AS Invoice_No,@c->i_dt AS Invoice_Date,\
							 @c->i_val AS Invoice_Value,@c->pay_dt AS Date_Payment_Mode,@c->tds_val AS TDS_Value,@c->irt AS TDS_IGST_Rate,\
							@c->iamt AS TDS_IGST_Amt,@c->crt AS TDS_CGST_Rate,@c->camt AS TDS_CGST_Amt,@c->srt AS TDS_SGST_Rate,@c->samt AS TDS_SGST_Amt)) from ?\
				',[$scope.jsonTDSCredit.tds_credit]);
				
			
			var res10B=alasql('SELECT ctin AS GSTIN,mid AS Merchant_ID,sup_val AS GrossValue_Supplier,\
							 tx_val AS Taxable_Value,tcs_irt AS TDS_IGST_Rate,\
							tcs_iamt AS TDS_IGST_Amt,tcs_crt AS TDS_CGST_Rate,tcs_camt AS TDS_CGST_Amt,tcs_srt AS TDS_SGST_Rate,tcs_samt AS TDS_SGST_Amt from ?',[$scope.jsonTCSCredit.tcs_data]);
				
			var res11=alasql('SELECT i_num AS OriginalInvoice_No,i_dt AS OriginalInvoice_Date,o_ig AS IGST_Earlier,\
							 n_ig AS IGST_Current_Month,o_cg AS CGST_Earlier,\
							n_cg AS CGST_Current_Month,o_sg AS SGST_Earlier,n_sg AS SGST_Current_Month from ?\
				',[$scope.jsonITCreceived.itc_rcd]);
				
			var res12=alasql('SEARCH / AS @b  UNION ALL(  itms / AS @c RETURN (@b->rtin AS GSTIN,@b->st_cd AS State_Code,@b->dnum AS Document_No,\
							 @b->dt AS Document_Date,@c->ty AS Goods_Services,@c->hsn_sc AS HSN_SAC,@c->txval AS Taxable_Value,\
							@c->irt AS IGST_Rate,@c->iamt AS IGST_TAX,@c->crt AS CGST_Rate,@c->camt AS CGST_TAX,@c->srt AS SGST_Rate,@c->samt AS SGST_TAX)) from ?\
				',[$scope.jsonTaxLiability.txi]);
			
			var res12A=alasql('SEARCH / AS @b  UNION ALL(  itms / AS @c RETURN (@b->ogstin AS Original_GSTIN,@b->odnum AS Original_Document_No,@b->otdt AS Original_Document_Date,\
							 @b->rtin AS Revised_GSTIN, @b->st_cd AS State_Code, @b->dnum AS Revisied_Document_No,@b->dt AS Revisied_Document_Date,@c->ty AS Goods_Services,@c->hsn_sc AS HSN_SAC,@c->txval AS Taxable_Value,\
							@c->irt AS IGST_Rate,@c->iamt AS IGST_TAX,@c->crt AS CGST_Rate,@c->camt AS CGST_TAX,@c->srt AS SGST_Rate,@c->samt AS SGST_TAX)) from ?\
				',[$scope.jsonAmendedTaxLiability.atxi]);
			
			var res13= alasql('SEARCH / AS @b  UNION ALL(  itms / AS @c RETURN (@b->rtin AS GSTN,@b->dnum AS Invoice_No,@b->dt AS Invoice_Date,@c->ty AS Type,@c->hsn_sc AS HSN_SAC)) from ?\
				',[$scope.jsonTaxLiability.txi]);
				
			var res14= alasql('SELECT des AS Description,iamt AS ITC_IGST_Amt,camt AS ITC_CGST_Amt,\
							 samt AS ITC_SGST_Amt from ?\
				',[$scope.jsonITC.itc_rvsl]);
			
			var res14A= alasql('SELECT des AS Description,iamt AS ITC_IGST_Amt,iint AS ITC_IGST_Interest,\
							 camt AS ITC_CGST_Amt,cint AS ITC_CGST_Intereset,samt AS ITC_SGST_Amt,sint AS ITC_SGST_Interest from ?\
				',[$scope.jsonITC.itc_rvsl]);
				
			
   				  var res = alasql('SELECT * INTO XLSX("restest.xlsx",?) FROM ?',
                     [opts,[res1,res2,res3,res4,res5,res6,res8,res9,res10A,res10B,res11,res12,res12A,res13,res14,res14A]]); 
					
				}
				
			else
			{
				/*
				 var table= tableTojson($("#table3").get(0));
								 var doc=new jsPDF('l','pt','letter',true);
									 doc.cellInitialize();
									 $.each(table,function(i,row){
										 $.each(row,function(j,cell){
										 doc.cell(1,10,90,100,cell,i,j);
										 });
									 });
								doc.save("test.pdf");*/
				var doc = new jsPDF();

			// We'll make our own renderer to skip this editor
			var specialElementHandlers = {
			    '#table3': function(element, renderer){
			        return true;
			    }
			};
			
					doc.fromHTML($('#table3').get(0),{
					    'elementHandlers': specialElementHandlers
					});
					  doc.save('TestHTMLDoc.pdf');
			}
		
		
		}
		
	function tableTojson(table){
		var data=[],headers=[],sub_headers=[];
		
 		for( var i=0;i<table.rows[0].cells.length;i++)
 		{
 			headers[i]=table.rows[0].cells[i].innerHTML;
 			if(table.rows[0].cells[i].colSpan>0)
 			{
 				sub_headers[i]=table.rows[1].cells[i].innerHTML;
 			}
 			
 		}
 		data.push(headers,sub_headers);
 		
 		for(i=0;i<table.rows.length;i++)
 		{
 			var tablerows=table.rows[i];
 			 var rowData=[];
 			 for(var j=0;j<tablerows.cells.length;j++)
 			 {
 			 	rowData[headers[j]]=tablerows.cells[j].innerHTML;
 			 }
 			data.push(rowData);
 		}
		return data;
	}
 
 	$scope.printAction =function(){
		/*
		 var printContent = $("#menuContent_1")[0].innerText;
					window.print(printContent);
					*/
				var GSTN=$scope.GSTN;
				var name=$scope.name;
			
						 
			   newWin= window.open("", "popup", "width=1100, height=600, top=5, left=5");
			 
			 	newWin.document.write("<h1 style='padding-left:40%;'>GSTR2</h1>");
			 	
			 	
			 	
			 	var htmlToPrint  = '' +
			        '<style type="text/css">' +
			        'table th, table td {' +
			        'border:1px solid #000;'  +
			        '}' +'table {' +
			        ' border-collapse: collapse;'  +
			        '}' +
			        '</style>';
			        
        	 	htmlToPrint1=htmlToPrint;	htmlToPrint2=htmlToPrint;	htmlToPrint3=htmlToPrint;	htmlToPrint4=htmlToPrint;	htmlToPrint5=htmlToPrint;
        	 		htmlToPrint6=htmlToPrint;	htmlToPrint7=htmlToPrint;	htmlToPrint8=htmlToPrint;	htmlToPrint9=htmlToPrint;
        	 		htmlToPrint10=htmlToPrint; htmlToPrint11=htmlToPrint; htmlToPrint12=htmlToPrint; htmlToPrint13=htmlToPrint;
        	 		htmlToPrint14=htmlToPrint; htmlToPrint15=htmlToPrint; htmlToPrint16=htmlToPrint;
        	 	
        	 	
        	 	var Tab1=document.getElementById("Tab1");
        	 	var Tab2=document.getElementById("Tab2");
        	 	var Tab3=document.getElementById("Tab3");
        	 	var Tab4=document.getElementById("Tab4");
        	 	var Tab5=document.getElementById("Tab5");
        	 	var Tab6=document.getElementById("Tab6");
        	 	var Tab7=document.getElementById("Tab7");
        	 	var Tab8=document.getElementById("Tab8");
        	 	var Tab9=document.getElementById("Tab9");
        	 	var Tab10=document.getElementById("Tab10");
        	 	var Tab11=document.getElementById("Tab11");
        	 	var Tab12=document.getElementById("Tab12");
        	 	var Tab13=document.getElementById("Tab13");
        	 	var Tab14=document.getElementById("Tab14");
        	 	var Tab15=document.getElementById("Tab15");
        	 	var Tab16=document.getElementById("Tab16");
        	 	var Tab17=document.getElementById("Tab17");
        	 	
        	 	htmlToPrint += Tab1.outerHTML;
        	 	htmlToPrint1 += Tab2.outerHTML;
        	 	htmlToPrint2 += Tab3.outerHTML;
        	 	htmlToPrint3 += Tab4.outerHTML;
        	 	htmlToPrint4 += Tab5.outerHTML;
        	 	htmlToPrint5 += Tab6.outerHTML;
        	 	htmlToPrint6 += Tab7.outerHTML;
        	 	htmlToPrint7 += Tab8.outerHTML;
        	 	htmlToPrint8 += Tab9.outerHTML;
        	 	htmlToPrint9 += Tab10.outerHTML;
        	 	htmlToPrint10 += Tab11.outerHTML;
        	 	htmlToPrint11 += Tab12.outerHTML;
        	 	htmlToPrint12 += Tab13.outerHTML;
        	 	htmlToPrint13 += Tab14.outerHTML;
        	 	htmlToPrint14 += Tab15.outerHTML;
        	 	htmlToPrint15 += Tab16.outerHTML;
        	 	htmlToPrint16 += Tab17.outerHTML;
        	 
			   newWin.document.write(htmlToPrint+"<br/><br/>");
			   newWin.document.write(htmlToPrint1+"<br/><br/>");
			   newWin.document.write(htmlToPrint2+"<br/><br/>");
			   newWin.document.write(htmlToPrint3+"<br/><br/>");
			   newWin.document.write(htmlToPrint4+"<br/><br/>");
			   newWin.document.write(htmlToPrint5+"<br/><br/>");
			   newWin.document.write(htmlToPrint6+"<br/><br/>");
			   newWin.document.write(htmlToPrint7+"<br/><br/>");
			   newWin.document.write(htmlToPrint8+"<br/><br/>");
			   newWin.document.write(htmlToPrint9+"<br/><br/>");
			   newWin.document.write(htmlToPrint10+"<br/><br/>");
			   newWin.document.write(htmlToPrint11+"<br/><br/>");
			   newWin.document.write(htmlToPrint12+"<br/><br/>");
			   newWin.document.write(htmlToPrint13+"<br/><br/>");
			   newWin.document.write(htmlToPrint14+"<br/><br/>");
			   newWin.document.write(htmlToPrint15+"<br/><br/>");
			    newWin.document.write(htmlToPrint16+"<br/><br/>");
			   
			 
			   newWin.print();
			   
			 
	}
	
}]);