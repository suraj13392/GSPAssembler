appEngage.controller("gstrController",["$scope",'$http','$q','$rootScope','$state','$stateParams',function($scope,$http,$q,$rootScope,$state,$stateParams){
	
	 $('#dashboardDiv').css("display","none");

	$("#form_table").hide();
	$("#download_link").css("display","none");
	
	    
           
	  $('#files').change(handleFile);
	  
	 $scope.dataArray=[];  
	   var result={
	   	sheetName:"",
	   	data:""
	   };
	    function handleFile(e) {
     //Get the files from Upload control
        var files = e.target.files;
        var i, f;
     //Loop through files
        for (i = 0, f = files[i]; i != files.length; ++i) {
            var reader = new FileReader();
            var name = f.name;
            reader.onload = function (e) {
                var data = e.target.result;

               
                var workbook = XLSX.read(data, { type: 'binary' });
                
                
                
                var sheet_name_list = workbook.SheetNames;
                sheet_name_list.forEach(function (y) { /* iterate through sheets */
                    //Convert the cell value to Json
                    var roa = XLSX.utils.sheet_to_json(workbook.Sheets[y]);
					
					roa.forEach(function(e, i) {
						  // Iterate over the keys of object
						  Object.keys(e).forEach(function(key) {
						    
						    // Copy the value
						    var val = e[key],
						      newKey = key.replace(/\s|\/|\(|\)+/g, '_');
						    
						    // Remove key-value from object
						    delete roa[i][key];
						
						    // Add value with new key
						    roa[i][newKey] = val;
						  });
						});

					
                    if (roa.length > 0) {
                    	result = new Object();
                    	result.sheetName=y;
                        result.data = roa;
                        $scope.dataArray.push(result);
                    }
                });
               //Get the first column first cell value
               // alert("hi:"+result[0].GSTIN);
               
              
            };
            reader.readAsArrayBuffer(f);
        }
        
        $rootScope.name=$scope.name;
        $rootScope.GSTN=$scope.GSTN;
        $rootScope.turnover=$scope.turnover;
        $rootScope.monthSel=$scope.monthSel;
        $rootScope.yearSel=$scope.yearSel;
           
        
    }
    
    $scope.submitFile=function(name,event){
    
   /* 	if($("#files").val()=="" || $("#GSTN_id").val()=="")
    	{
    		
			if($("#GSTN_id").val()==""){
						$("#GSTN_id").parent().addClass("has-error");
						}
			
    		if($("#files").val()=="")
    		{
    		$("#files").parent().parent().addClass("has-error");
    		$("#files").css("border-color","#a94442");
    		}
    		$("#errorMessageDiv").css("display","block");
    		$("#errorMsgTxt").html("Please Insert Mandatory Fields");
    		$("#form_table").css("display","none");
    	}
    	else
    	{*/
    	event.preventDefault();
    	
    	$("#form_table").hide();
    	$("#files").css("border-color","#838383");	
    	$("#GSTN_id").parent().removeClass("has-error");
    	$("#files").parent().removeClass("has-error");
    	$("#errorMessageDiv ,#successMessageDiv").css("display","none");
    	$("#table1 tr td").remove();
		
		$("#download_link").css("display","block");
    /*	$("#form_table").css("display","block");*/
    	$('#GSTN_id,#sel1,#sel2,#nameGstn,#turnover').attr('readonly', 'readonly');
    	
    	  $("#form_table").delay(500).hide(0, function() {
    	        $("#form_table").show();
    	    });
    	  
    		$("#table2 tr:nth-child(3),#table2 tr:nth-child(5)").css("color","black");
    		$("#subViewDtis-1392,#subViewDtis-1369").remove()
    	  
    	  if(name=="gstr1Status")
		  {
		  	console.log("");
		  	$("#table2 tr:nth-child(3),#table2 tr:nth-child(5)").css("color","red");
		  	
		   var parenttbl = document.getElementById("IN-1369");
		     var newel = document.createElement('td');
		     var elementid = document.getElementsByTagName("td").length
		     newel.setAttribute('id','subViewDtis-1369');
		     newel.innerHTML = "<a>View Details</a>"
		     parenttbl.appendChild(newel);
		     
		     var parenttbl = document.getElementById("IN-1392");
		     var newel = document.createElement('td');
		     var elementid = document.getElementsByTagName("td").length
		     newel.setAttribute('id','subViewDtis-1392');
		     newel.innerHTML = "<a>View Details</a>"
		     parenttbl.appendChild(newel);
		  }
    		
    		
    	  $("#subViewDtis-1369").click(function(){
    		  $("#error__modal").modal('show');
    	  })
    	    $("#subViewDtis-1392").click(function(){
    		  $("#error__modal").modal('show');
    		  $("#error-label").text("RET102: Invalid Supply Type");
    	  })
    	
    	
    	 $scope.name=$rootScope.name;
         $scope.GSTN=$rootScope.GSTN;
         $scope.turnover=$rootScope.turnover;
          $scope.monthSel= $rootScope.monthSel;
           $scope.yearSel=$rootScope.yearSel;
         
    	 var trHTML = '';
    	   var IGST,CGST,SGST;
    	   $scope.table1Data=[];
    	    $scope.table2Data=[]; $scope.table3Data=[];$scope.table4Data=[];$scope.table5Data=[];$scope.table6Data=[];$scope.table7Data=[];
    	    $scope.table8Data=[];$scope.table9Data=[];$scope.table10Data=[];$scope.table11Data=[];$scope.table12Data=[];
    	    $scope.table13Data=[];$scope.table14Data=[];$scope.table15Data=[];
               for(i=0;i<$scope.dataArray.length;i++)
               {
	              if($scope.dataArray[i].sheetName=="5")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			  
	               			$scope.table1Data.push($scope.dataArray[i].data[j]);
	               			}
	               	}
	               else	if($scope.dataArray[i].sheetName=="5A")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table2Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	               	 else 	if($scope.dataArray[i].sheetName=="6")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table3Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
					else if($scope.dataArray[i].sheetName=="6A")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table4Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
					else if($scope.dataArray[i].sheetName=="7")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table5Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
					else if($scope.dataArray[i].sheetName=="7A")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table6Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
					else if($scope.dataArray[i].sheetName=="8")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table7Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	               else	if($scope.dataArray[i].sheetName=="8A")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table8Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	               else	if($scope.dataArray[i].sheetName=="10")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table9Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	              else 	if($scope.dataArray[i].sheetName=="10A")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table10Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	               	else	if($scope.dataArray[i].sheetName=="9")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table11Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	               else	if($scope.dataArray[i].sheetName=="11")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table12Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	               	else if($scope.dataArray[i].sheetName=="11A")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table13Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	              else 	if($scope.dataArray[i].sheetName=="12")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table14Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	               else	if($scope.dataArray[i].sheetName=="14")
	               	{
	               		for(j=0;j<$scope.dataArray[i].data.length;j++)
	               		{
	               			
							    $scope.table15Data.push($scope.dataArray[i].data[j]);
	               		}
	               	}
	               	else{}
					
					
	              }       
       /*  }   */
         
         $rootScope.lab1=document.getElementById('lab1').textContent;$rootScope.lab2=document.getElementById('lab2').textContent;
         $rootScope.lab3=document.getElementById('lab3').textContent;$rootScope.lab4=document.getElementById('lab4').textContent;
         $rootScope.lab5=document.getElementById('lab5').textContent;$rootScope.lab6=document.getElementById('lab6').textContent;
         $rootScope.lab7=document.getElementById('lab7').textContent;$rootScope.lab8=document.getElementById('lab8').textContent;
         $rootScope.lab9=document.getElementById('lab9').textContent;$rootScope.lab10=document.getElementById('lab10').textContent;
         $rootScope.lab11=document.getElementById('lab11').textContent;$rootScope.lab12=document.getElementById('lab12').textContent;
         $rootScope.lab13=document.getElementById('lab13').textContent;$rootScope.lab14=document.getElementById('lab14').textContent;
         $rootScope.lab15=document.getElementById('lab15').textContent;$rootScope.lab16=document.getElementById('lab16').textContent;
         $rootScope.lab17=document.getElementById('lab17').textContent;$rootScope.lab18=document.getElementById('lab18').textContent;
         
         
          $rootScope.table1=document.getElementById('table1');$rootScope.table2=document.getElementById('table2');
          $rootScope.table3=document.getElementById('table3');$rootScope.table4=document.getElementById('table4');
          $rootScope.table5=document.getElementById('table5');$rootScope.table6=document.getElementById('table6');
          $rootScope.table7=document.getElementById('table7');$rootScope.table8=document.getElementById('table8');
          $rootScope.table9=document.getElementById('table9');$rootScope.table10=document.getElementById('table10');
          $rootScope.table11=document.getElementById('table11');$rootScope.table12=document.getElementById('table12');
          $rootScope.table13=document.getElementById('table13');$rootScope.table14=document.getElementById('table14');
          $rootScope.table15=document.getElementById('table15');$rootScope.table16=document.getElementById('table16');
          $rootScope.table17=document.getElementById('table17');$rootScope.table18=document.getElementById('table18');
    }
    
     
    $scope.exportAction = function(){
		
		
	/*	var type=$("input[type='radio'][name='optradio']:checked").val();*/
		var type=$("#download_sel").val();
		
		var type2=$("#lastDownloadSel").val();
		
		  
		if(type=="PDF" || type2=="PDF"){
			/*
			$("#menuContent_1").find(".table").tableExport({type:'pdf', escape:false});
						*/
						
						
						
			  var pdf = new jsPDF('l', 'mm', [300, 300]);

   var res1 = $rootScope.table1;
  var res = pdf.autoTableHtmlToJson(res1);

  var elem2 = $rootScope.table2;
  var data2 = pdf.autoTableHtmlToJson(elem2);
  
    var elem3 = $rootScope.table3;
  var data3 = pdf.autoTableHtmlToJson(elem3);
  
   var elem4 =$rootScope.table4;
  var data4 = pdf.autoTableHtmlToJson(elem4);
  
   var elem5 = $rootScope.table5;
  var data5 = pdf.autoTableHtmlToJson(elem5);
  
   var elem6 = $rootScope.table6;
  var data6 = pdf.autoTableHtmlToJson(elem6);
  
   var elem7 = $rootScope.table7;
  var data7 = pdf.autoTableHtmlToJson(elem7);
  
   var elem8 = $rootScope.table8;
  var data8 = pdf.autoTableHtmlToJson(elem8);
  
   var elem9 = $rootScope.table9;
  var data9 = pdf.autoTableHtmlToJson(elem9);
  
   var elem10 = $rootScope.table10;
  var data10 = pdf.autoTableHtmlToJson(elem10);
  
   var elem11 = $rootScope.table11;
  var data11 = pdf.autoTableHtmlToJson(elem11);
  
  var elem12 = $rootScope.table12;
  var data12 = pdf.autoTableHtmlToJson(elem12);
  var elem13 = $rootScope.table13;
  var data13 = pdf.autoTableHtmlToJson(elem13);
  var elem14 = $rootScope.table14;
  var data14 = pdf.autoTableHtmlToJson(elem14);
  var elem15 = $rootScope.table15;
  var data15 = pdf.autoTableHtmlToJson(elem15);
  var elem16 =$rootScope.table16;
  var data16 = pdf.autoTableHtmlToJson(elem16);
  var elem17 = $rootScope.table17;
  var data17 = pdf.autoTableHtmlToJson(elem17);
  var elem18 = $rootScope.table18;
  var data18 = pdf.autoTableHtmlToJson(elem18);
  
  

  var header = function(data) {
   pdf.setFontSize(15);
    pdf.setTextColor(40);
    pdf.setFontStyle('normal');
  //  doc.addImage(headerImgData, 'JPEG', data.settings.margin.left, 20, 50, 50);
  var lab1="GSTR1";
   pdf.text(lab1, data.settings.margin.left, 500);
  };

//var endPos = pdf.autoTableEndPosY();

pdf.autoTable(res.columns, res.data, {
    startY: pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
    beforePageContent: header,
    startY: 50,
    drawHeaderRow: function(row, data) {
      row.height = 26;
    },
	headerStyles: {fillColor: [204, 204, 204],textColor: 20},
     styles: {
      overflow: 'linebreak',
      fontSize: 8,
      tableWidth: 'auto',
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
      drawHeaderRow: function(row, data) {
     row.height = 20;
    },
     margin: {horizontal: 10, top: 10, bottom: 10}
    
});
  var header2 = function(data) {
   pdf.setFontSize(15);
    pdf.setTextColor(40);
    pdf.setFontStyle('bold');
  //  doc.addImage(headerImgData, 'JPEG', data.settings.margin.left, 20, 50, 50);
  var lab1=document.getElementById('lab2').textContent;
   pdf.text(lab1, data.settings.margin.left, 50);
  };
 // pdf.addPage();
pdf.autoTable(data2.columns, data2.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
    // beforePageContent: header2,
	headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
       fontSize: 8,
      tableWidth: 'auto',
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 20;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data3.columns, data3.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
     //beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
     fontSize: 8,
      tableWidth: 'auto',
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 20;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data4.columns, data4.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
    // beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
       fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 20;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data5.columns, data5.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
    // beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
      fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data6.columns, data6.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
   //  beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
      fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data7.columns, data7.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
    // beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
       fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data8.columns, data8.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
    // beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
      fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
    row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data9.columns, data9.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
   //  beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
     fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
    row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data10.columns, data10.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
   //  beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
      fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data11.columns, data11.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
   //  beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
     fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data12.columns, data12.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
     //beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
       fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data13.columns, data13.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
   //  beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
      fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
    row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data14.columns, data14.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
   //  beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
      fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data15.columns, data15.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
    // beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
       fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
   row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data16.columns, data16.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
  //   beforePageContent: header,
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
      fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
    row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data17.columns, data17.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
     fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
     row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});
//pdf.addPage();
pdf.autoTable(data18.columns, data18.data, {
     startY : pdf.autoTableEndPosY() + 10,
     pageBreak: 'auto',
     theme: 'grid',
	 headerStyles: {fillColor: [204, 204, 204],textColor: 20},
      styles: {
      overflow: 'linebreak',
      fontSize: 8,
      tableWidth: 280,
      columnWidth: 'auto',
	  valign: 'middle',
       rowHeight: 10
    },
       drawHeaderRow: function(row, data) {
   row.height = 30;
    },
    margin: {horizontal: 10, top: 10, bottom: 10}
});

  pdf.save('Test.pdf');
 
}
						
				
		
		if(type=="Excel" || type2=="Excel"){
			
 
                     var opts = [{sheetid:'5',header:true},{sheetid:'5A',header:false},{sheetid:'6',header:true},{sheetid:'6A',header:false},
                                 {sheetid:'7',header:false},{sheetid:'7A',header:false},{sheetid:'8',header:false},{sheetid:'8A',header:false},
                                 {sheetid:'9',header:false},{sheetid:'10',header:true},{sheetid:'10A',header:true},{sheetid:'11',header:true},
                                 {sheetid:'11A',header:true},{sheetid:'12',header:true},{sheetid:'14',header:true}];
                    
                     //Sheet 5
                     var res1 = alasql('SELECT GSTIN_UIN AS GSTIN_UIN,Invoice_No AS Invoice_No,Invoice_Date AS Invoice_Date,Invoice_Value AS Invoice_Value,Invoice_Goods_Services AS Invoice_Goods_Services,\
                                         Invoice_HSN_SAC AS Invoice_HSN_SAC,Invoice_TaxableValue AS Invoice_Taxable_Value,IGST_Rate AS IGST_Rate,IGST_Amt AS IGST_Amt,\
                                         CGST_Rate AS CGST_Rate,CGST_Amt AS CGST_Amt,SGST_Rate AS SGST_Rate,SGST_Amt AS SGST_Amt,\
                                         POS_only_if_different_from_the_location_of_recipient_ AS POS,\
                                         Indicate_if_supply_attracts_reverse_charge AS Indicate_if_supply_attracts_reverse_charge,\
                                         Tax_on_this_Invoice_is_paid_under_provisional_assessment AS Tax_on_this_Invoice_is_paid_under_provisional_assessment,\
                                         GSTIN_of_ecommerce_operator_if_applicable_ AS GSTIN_of_ecommerce_operator from ?',[$scope.table1Data]);
                    
                     //Sheet 5A
                     var res2 = alasql('SELECT Original_IN_No AS Original_Invoice_No,Original_IN_Date AS Original_Invoice_Date,GSTIN_UIN AS GSTIN_UIN,\
                                         Rev_Original_IN_No AS Revised_Original_Invoice_No,Rev_Original_IN_Date AS Revised_Original_Invoice_Date,\
                                         Rev_Original_IN_Value AS Revised_Original_Invoice_Value,Rev_Original_IN_Goods_Services AS Revised_Original_Invoice_Goods_Services,\
                                        Rev_Original_IN_HSN_SAC AS Revised_Original_Invoice_HSN_SAC,Rev_Original_IN_TaxableValue AS Revised_Original_Invoice_Taxable_Value,\
                                         IGST_Rate AS IGST_Rate, IGST_Amt AS IGST_Amt,CGST_Rate AS CGST_Rate,CGST_Amt AS CGST_Amt,SGST_Rate AS SGST_Rate,SGST_Amt AS SGST_Amt,\
                                         POS_only_if_different_from_the_location_of_recipient_ AS POS,\
                                         Indicate_if_supply_attracts_reverse_charge AS Indicate_if_supply_attracts_reverse_charge,\
                                         Tax_on_this_Invoice_is_paid_under_provisional_assessment AS Tax_on_this_Invoice_is_paid_under_provisional_assessment,\
                                         GSTIN_of_commerce_operator_if_applicable_ AS GSTIN_of_ecommerce_operator from ?',[$scope.table2Data]);
                    
                     //Sheet 6
                     var res3 = alasql('SELECT RecipientsStatecode AS Recipients_State_Code,NameOfTheRecipient AS Name_Of_The_Recipient,\
                                         Invoice_No AS Invoice_No,Invoice_Date AS Invoice_Date,Invoice_Value AS Invoice_Value,Invoice_Goods_Services AS Invoice_Goods_Services,\
                                         Invoice_HSN_SAC AS Invoice_HSN_SAC,Invoice_TaxableValue AS Invoice_TaxableValue,\
                                         IGST_Rate AS IGST_Rate, IGST_Amt AS IGST_Amt,\
                                         POS_only_if_different_from_the_location_of_recipient_ AS POS,\
                                         Indicate_if_supply_attracts_reverse_charge AS Indicate_if_supply_attracts_reverse_charge,\
                                         Tax_on_this_Invoice_is_paid_under_provisional_assessment AS Tax_on_this_Invoice_is_paid_under_provisional_assessment from ?',[$scope.table3Data]);
                    
                     //Sheet 6A
                     var res4 = alasql('SELECT Original_Invoice_No AS Original_Invoice_No,Original_Invoice_No_Date AS Original_Invoice_Date,\
                                         RecipientStateCode AS Recipient_State_Code,\
                                         Revised_Invoice_No AS Revised_Invoice_No,Revised_Invoice_Date AS Revised_Invoice_Date,Revised_Invoice_Goods_Services AS Revised_Invoice_Value,\
                                      Revised_Invoice_HSN_SAC AS Revised_Invoice_Goods_Services,Revised_Invoice_Taxable_Value AS Revised_Invoice_HSN_SAC,\
                                         IGST_Rate AS IGST_Rate, IGST_Amt AS IGST_Amt,\
                                         POS_only_if_different_from_the_location_of_recipient_ AS POS,\
                                         Tax_on_this_Invoice_is_paid_under_provisional_assessment AS Tax_on_this_Invoice_is_paid_under_provisional_assessment from ?',[$scope.table4Data]);
                    
                     //Sheet 7
                     var res5 = alasql('SELECT Goods_Services AS Goods_Services,HSN_SAC AS HSN_SAC,\
                                         Statecode AS State_code_Place_of_Supply,AggregateTaxableValue AS AggregateTaxableValue,\
                                         IGST_Rate AS IGST_Rate, IGST_Amt AS IGST_Amt,CGST_Rate AS CGST_Rate,CGST_Amt AS CGST_Amt,SGST_Rate AS SGST_Rate,SGST_Amt AS SGST_Amt,\
                                         Tax_on_this_Invoice_is_paid_under_provisional_assessment AS Tax_on_this_Invoice_is_paid_under_provisional_assessment from ?',[$scope.table5Data]);
                    
                     //Sheet 7A
                     var res6 = alasql('SELECT OriginalDetails_Month_TaxPeriod AS Original_Details_Month_TaxPeriod,OriginalDetails_Goods_Services AS OriginalDetails_Goods_Services,\
                                         OriginalDetails_HSN_SAC AS OriginalDetails_HSN_SAC,OriginalDetails_StateCode AS Original_Details_State_Code,\
                                         RevisedDetails_Goods_Services AS Revised_Details_Goods_Services,RevisedDetails_HSN_SAC AS RevisedDetails_HSN_SAC,RevisedDetails_Statecode AS RevisedDetails_Statecode,\
                                         AggregateTaxableValue AS AggregateTaxableValue,\
                                         IGST_Rate AS IGST_Rate, IGST_Amt AS IGST_Amt,CGST_Rate AS CGST_Rate,CGST_Amt AS CGST_Amt,SGST_Rate AS SGST_Rate,SGST_Amt AS SGST_Amt,\
                                         Tax_on_this_Invoice_is_paid_under_provisional_assessment AS Tax_on_this_Invoice_is_paid_under_provisional_assessment from ?',[$scope.table6Data]);
                          
                    
                     //Sheet 8
                     var res7 = alasql('SELECT GSTIN_UIN_NameOfRecipient AS GSTIN_UIN_Name_Of_Recipient,TypeOfNote_Debit_Credit_ AS Type_Of_Note_Debit_Credit,\
                                         DebitNote_creditnote_No AS DebitNote_CreditNote_No,DebitNote_creditnote_Date AS DebitNote_CreditNote_Date,\
                                         Original_No AS Original_Invoice_No,Original_Date AS Original_Invoice_Date,DifferentialValue_Plus_or_Minus AS DifferentialValue_Plus_or_Minus,\
                                         DifferentialTax_IGST_Rate AS DifferentialTax_IGST_Rate, DifferentialTax_IGST_Amt AS DifferentialTax_IGST_Amt,\
                                         DifferentialTax_CGST_Rate AS DifferentialTax_CGST_Rate,DifferentialTax_CGST_Amt AS DifferentialTax_CGST_Amt,\
                                         DifferentialTax_SGST_Rate AS DifferentialTax_SGST_Rate,DifferentialTax_SGST_Amt AS DifferentialTax_SGST_Amt from ?',[$scope.table7Data]);
                    
                     //Sheet 8A
                     var res8 = alasql('SELECT GSTIN_UIN_NameOfRecipient AS GSTIN_UIN_Name_Of_Recipient,TypeOfNote_Debit_Credit_ AS Type_Of_Note_Debit_Credit,\
                                         Original_No AS Original_No,Original_Date AS Original_Date,Revised_No AS Revised_No,Revised_Date AS Revised_Date,\
                                         Original_Invoice_No AS Original_Invoice_Details_No,Original_Invoice_No_Date AS Original_Invoice_Details_Date,\
                                         DifferentialTax_IGST_Rate AS DifferentialTax_IGST_Rate, DifferentialTax_IGST_Amt AS DifferentialTax_IGST_Amt,\
                                         DifferentialTax_CGST_Rate AS DifferentialTax_CGST_Rate,DifferentialTax_CGST_Amt AS DifferentialTax_CGST_Amt,\
                                         DifferentialTax_SGST_Rate AS DifferentialTax_SGST_Rate,DifferentialTax_SGST_Amt AS DifferentialTax_SGST_Amt from ?',[$scope.table8Data]);
                    
                     //Sheet 9
                     var res11 = alasql('SELECT Description AS Description,Goods_Services AS Goods_Services,\
                                         NilRated_Amount AS NilRated_Amount,\
                                         Exempted_Amount AS Exempted_Amount,NonGSTsupplies_Amount AS NonGSTsupplies_Amount from ?',[$scope.table11Data]);
                    
                    
                     //Sheet 10
                     var res9 = alasql('SELECT Description AS Description,Invoice_No  AS Invoice_No,Invoice_Date AS Invoice_Date,\
                                         Invoice_Value AS Invoice_Value,Invoice_Date AS Invoice_Date,Invoice_Goods_Services AS Invoice_Goods_Services,\
                                         Invoice_HSN_SAC AS Invoice_HSN_SAC,Invoice_TaxableValue AS Invoice_TaxableValue,\
                                         ShippingBill_No AS ShippingBill_No,ShippingBill_Date AS ShippingBill_Date,\
                                         IGST_Rate AS IGST_Rate, IGST_Amt AS IGST_Amt,CGST_Rate AS CGST_Rate,CGST_Amt AS CGST_Amt,SGST_Rate AS SGST_Rate,SGST_Amt AS SGST_Amt,\
                                         Tax_on_this_Invoice_is_paid_under_provisional_assessment__assessment_ AS Tax_on_this_Invoice_is_paid_under_provisional_assessment from ?',[$scope.table9Data]);
                    
                    
                     //Sheet 10A
                     var res10 = alasql('SELECT Description AS Description,Original_Invoice_No AS Original_Invoice_No,\
                                         Original_Invoice_No_Date AS Original_Invoice_No_Date,\
                                         Revised_Invoice_No AS Revised_Invoice_No,Revised_Invoice_Date AS Revised_Invoice_Date,Revised_Invoice_Goods_Services AS Revised_Invoice_Goods_Services,\
                                         Revised_Invoice_HSN_SAC AS Revised_Invoice_HSN_SAC,Revised_Invoice_Taxable_Value AS Revised_Invoice_Taxable_Value,\
                                         ShippingBill_No AS ShippingBill_No,ShippingBill_Date AS ShippingBill_Date,\
                                         IGST_Rate AS IGST_Rate, IGST_Amt AS IGST_Amt,CGST_Rate AS CGST_Rate,CGST_Amt AS CGST_Amt,SGST_Rate AS SGST_Rate,SGST_Amt AS SGST_Amt,\
                                         Tax_on_this_Invoice_is_paid_under_provisional_assessment__assessment_ AS Tax_on_this_Invoice_is_paid_under_provisional_assessment from ?',[$scope.table10Data]);
                    
                    
                     //Sheet 11
                     var res12 = alasql('SELECT GSTIN_UIN_NameOfCustomer__ AS GSTIN_UIN_NameOfCustomer,StateCode AS StateCode,\
                                         DocumentNo AS DocumentNo,Date AS Date,Goods_Service AS Goods_Service,HSN_SAC AS HSN_SAC,\
                                         Amount_of_advance_received_Value_of_Supply_provided_without_raising_a_bill AS Amount_of_advance_received_Value_of_Supply_provided_without_raising_a_bill,\
                                         TAX_IGST_Rate AS TAX_IGST_Rate,TAX_IGST_Amt AS TAX_IGST_Amt,TAX_CGST_Rate AS TAX_CGST_Rate,TAX_CGST_Amt AS TAX_CGST_Amt,TAX_SGST_Rate AS TAX_SGST_Rate,TAX_SGST_Amt AS TAX_SGST_Amt\
                                         from ?',[$scope.table12Data]);
                    
                     //Sheet 11A
                     var res13 = alasql('SELECT OriginalDetails_GSTIN_UIN_Nameofcustomer AS OriginalDetails_GSTIN_UIN_Nameofcustomer,\
                                         OriginalDetails_DocumentNo AS OriginalDetails_DocumentNo,\
                                         OriginalDetails_Date AS OriginalDetails_Date,\
                                         RevisedDetails_GSTIN_UIN_Nameofcustomer AS RevisedDetails_GSTIN_UIN_Nameofcustomer,RevisedDetails_StateCode AS RevisedDetails_StateCode,\
                                         RevisedDetails_DocumentNo AS RevisedDetails_DocumentNo,RevisedDetails_Date AS RevisedDetails_Date,\
                                         RevisedDetails_Goods_Services AS RevisedDetails_Goods_Services,RevisedDetails_HSN_SAC AS RevisedDetails_HSN_SAC,\
                                         Amount_of_advance_received_Value_of_Supply_provided_without_raising_a_bill AS Amount_of_advance_received_Value_of_Supply_provided_without_raising_a_bill,\
                                         TAX_IGST_Rate AS TAX_IGST_Rate, TAX_IGST_Amt AS TAX_IGST_Amt,TAX_CGST_Rate AS TAX_CGST_Rate,TAX_CGST_Amt AS TAX_CGST_Amt,\
                                         TAX_SGST_Rate AS TAX_SGST_Rate,TAX_SGST_Amt AS TAX_SGST_Amt from ?',[$scope.table13Data]);
                    
                     //Sheet 12
                     var res14 = alasql('SELECT InvoiceNo AS InvoiceNo,TransactionId AS TransactionId,\
                                         TAX_IGST_Rate AS TAX_IGST_Rate, TAX_IGST_Amt AS TAX_IGST_Amt,TAX_CGST_Rate AS TAX_CGST_Rate,TAX_CGST_Amt AS TAX_CGST_Amt,\
                                         TAX_SGST_Rate AS TAX_SGST_Rate,TAX_SGST_Amt AS TAX_SGST_Amt from ?',[$scope.table14Data]);
                    
                     //Sheet 14
                     var res15 = alasql('SELECT SrNo AS Sr_No,SeriesNumberOfInvoices AS SeriesNumberOfInvoices,\
                                      FromDate AS FromDate,ToDate AS ToDate,\
                                         TotalNumberOfInvoices AS TotalNumberOfInvoices,NumberOfCancelledInvoices AS NumberOfCancelledInvoices,\
                                         NetNumberOfInvoicesIssued AS NetNumberOfInvoicesIssued from ?',[$scope.table15Data]);
                    
                     var res = alasql('SELECT * INTO XLSX("gstr1.xlsx",?) FROM ?',
                     [opts,[res1,res2,res3,res4,res5,res6,res7,res8,res11,res9,res10,res12,res13,res14,res15]]);

/* 			var dt = new Date();
							
			var lab1=$rootScope.lab1;
				
		     var tab_text=lab1+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    var textRange; var j=0;
		    tab = $rootScope.table1; // id of table
		
		    for(j = 0 ; j < tab.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		
		    tab_text=tab_text+"</table>";
		    
		     var lab2=$rootScope.lab2;
		    tab_text=tab_text+"<br/>"+lab2+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tabT2 = $rootScope.table2;
		    
		    for(j = 0 ; j < tabT2.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tabT2.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab3=$rootScope.lab3;
		    tab_text=tab_text+"<br/>"+lab3+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab1 = $rootScope.table3;
		    
		    for(j = 0 ; j < tab1.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab1.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab4=$rootScope.lab4;
		      tab_text=tab_text+"<br/>"+lab4+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab2 = $rootScope.table4;
		    
		    for(j = 0 ; j < tab2.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab2.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab5=$rootScope.lab5;
		      tab_text=tab_text+"<br/>"+lab5+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab3 = $rootScope.table5;
		    
		    for(j = 0 ; j < tab3.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab3.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab6=$rootScope.lab6;
		      tab_text=tab_text+"<br/>"+lab6+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab4 = $rootScope.table6;
		    
		    for(j = 0 ; j < tab4.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab4.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab7=$rootScope.lab7;
		      tab_text=tab_text+"<br/>"+lab7+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab5 =$rootScope.table7;
		    
		    for(j = 0 ; j < tab5.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab5.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab8=$rootScope.lab8;
		      tab_text=tab_text+"<br/>"+lab8+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab6 = $rootScope.table8;
		    
		    for(j = 0 ; j < tab6.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab6.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab9=$rootScope.lab9;
		      tab_text=tab_text+"<br/>"+lab9+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab7 =$rootScope.table9;
		    
		    for(j = 0 ; j < tab7.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab7.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab10=$rootScope.lab10;
		      tab_text=tab_text+"<br/>"+lab10+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab8 = $rootScope.table10;
		    
		    for(j = 0 ; j < tab8.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab8.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		     var lab11=$rootScope.lab11;
		      tab_text=tab_text+"<br/>"+lab11+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab9 = $rootScope.table11;
		    
		    for(j = 0 ; j < tab9.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab9.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		     var lab12=$rootScope.lab12;
		      tab_text=tab_text+"<br/>"+lab12+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab10 = $rootScope.table12;
		    
		    for(j = 0 ; j < tab10.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab10.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		     var lab13=$rootScope.lab13;
		      tab_text=tab_text+"<br/>"+lab13+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab11 = $rootScope.table13;
		    
		    for(j = 0 ; j < tab11.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab11.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab14=$rootScope.lab14;
		      tab_text=tab_text+"<br/>"+lab14+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab12 = $rootScope.table14;
		    
		    for(j = 0 ; j < tab12.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab12.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab16=$rootScope.lab15;
		      tab_text=tab_text+"<br/>"+lab16+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab13 = $rootScope.table15;
		    
		    for(j = 0 ; j < tab13.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab13.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		     var lab17=$rootScope.lab17;
		      tab_text=tab_text+"<br/>"+lab17+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab14 = $rootScope.table16;
		    
		    for(j = 0 ; j < tab14.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab14.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		     var lab18=$rootScope.lab18;
		      tab_text=tab_text+"<br/>"+lab17+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab15 = $rootScope.table17;
		    
		    for(j = 0 ; j < tab15.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab15.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		      tab_text=tab_text+"<br/>"+lab18+"<br/><table border='2px'><tr bgcolor='#87AFC6'>";
		    tab16 = $rootScope.table18;
		    
		    for(j = 0 ; j < tab16.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab16.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }
		    
		    tab_text=tab_text+"</table>";
		    
		    
		    tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
		    tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
		    tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params
		
		    var ua = window.navigator.userAgent;
		    var msie = ua.indexOf("MSIE "); 
		
		    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
		    {
		        txtArea1.document.open("txt/html","replace");
		        txtArea1.document.write(tab_text);
		        txtArea1.document.close();
		        txtArea1.focus(); 
		        sa=txtArea1.document.execCommand("SaveAs",true,"Say Thanks to Sumit.xls");
		    }  
		    else                 //other browser not tested on IE 11
		        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  
		
		    return (sa);
			 */
		}
		
	}
	
    $scope.saveGstr1=function(){
    	 /* $("#successMessageDiv").delay(100).hide(0, function() {*/
    		  $("#successMessageDiv").slideDown("fast");
  	 /*   });*/
		$("#successMsgTxt").html("<i class='fa fa-check'></i>&nbsp;GSTR1 Save Successfully");
    }
	$scope.printAction =function(){
		/*
		 var printContent = $("#menuContent_1")[0].innerText;
					window.print(printContent);
					*/
				var GSTN=$scope.GSTN;
				var name=$scope.name;
			
						 
			   newWin= window.open("", "popup", "width=1100, height=600, top=5, left=5");
			 
			 	newWin.document.write("<h1 style='padding-left:40%;'>GSTR1</h1>");
			 	
			 	
			 	
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
        	 		htmlToPrint14=htmlToPrint;htmlToPrint15=htmlToPrint;
        	 	
        	 	
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
			   
			 
			   newWin.print();
			   
			 
	}
    	
}]);