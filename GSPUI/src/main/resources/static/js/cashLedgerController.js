appEngage.controller("cashLedgerController",["$scope",'$http','GSTR2Service','$q','$rootScope','$state','$stateParams',function($scope,$http,GSTR2Service,$q,$rootScope,$state,$stateParams){

$('#dashboardDiv').css("display","none");

$("#cashLedger_table").css("display","none");
$("#cashLedgerButtonGroup").css("display","none");
$("#paginationCash").css("display","none");


	  $scope.steps = [
    'Opening Balance Details',
    'Transaction Details',
    'Closing Balance Details'
  ];
  $scope.selection = $scope.steps[0];

  /*$scope.getCurrentStepIndex = function(){
    // Get the index of the current step given selection
    return _.indexOf($scope.steps, $scope.selection);
  };

  // Go to a defined step index
  $scope.goToStep = function(index) {
    if ( !_.isUndefined($scope.steps[index]) )
    {
      $scope.selection = $scope.steps[index];
    }
  };*/


$scope.getCashLedger=function(event){
	event.preventDefault();
$("#cashLedger_table").css("display","block");
$("#cashLedgerButtonGroup").css("display","block");
$("#paginationCash").css("display","block");

GSTR2Service.getCashLedgerService().then(function(data){
                    $scope.cashLedger=data;
                   
              });
}

$("#subcash").css("display","none");
$scope.getTransactionAllData=function(refNumber){
	console.log(refNumber);
	$("#subcash").css("display","block");
	for(i=0;i<$scope.cashLedger.tr.length;i++)
	{
		if($scope.cashLedger.tr[i].refNo==refNumber)
		{
			$scope.allTransactionalDetails=$scope.cashLedger.tr[i];
		}
	}
	
}



}]);



appEngage.controller("ITCLedgerController",["$scope",'$http','GSTR2Service','$q','$rootScope',function($scope,$http,GSTR2Service,$q,$rootScope){

$('#dashboardDiv').css("display","none");

$("#ITCLedger_table").css("display","none");
$("#ITCLedgerButtonGroup").css("display","none");
$("#paginationCash").css("display","none");



$scope.getITCLedger=function(event){
	event.preventDefault();
$("#ITCLedger_table").css("display","block");
$("#ITCLedgerButtonGroup").css("display","block");
$("#paginationCash").css("display","block");

GSTR2Service.getITCLedgerService().then(function(data){
                    $scope.ITCLedger=data;
                   
              });
}

$("#subcash").css("display","none");

$scope.getITCTransactionData=function(db_no){
	$("#subcash").css("display","block");
	for(i=0;i<$scope.ITCLedger.tr.length;i++)
	{
		if($scope.ITCLedger.tr[i].db_no==db_no)
		{
			$scope.allITCTransactionalDetails=$scope.ITCLedger.tr[i];
		}
	}
	
}

}]);


appEngage.controller("liabilityLedgerController",["$scope",'$http','GSTR2Service','$q','$rootScope','$state','$stateParams',function($scope,$http,GSTR2Service,$q,$rootScope,$state,$stateParams){

$('#dashboardDiv').css("display","none");

$("#liabilityLedger_table").css("display","none");
$("#liabilityLedgerButtonGroup").css("display","none");
$("#paginationCash").css("display","none");


	  $scope.steps = [
    'Transaction Details',
    'Overdue Details'
  ];
  $scope.selection = $scope.steps[0];

  $scope.getCurrentStepIndex = function(){
    // Get the index of the current step given selection
    return _.indexOf($scope.steps, $scope.selection);
  };

  // Go to a defined step index
  $scope.goToStep = function(index) {
    if ( !_.isUndefined($scope.steps[index]) )
    {
      $scope.selection = $scope.steps[index];
    }
  };


$scope.getLiabilityLedger=function(event){
	event.preventDefault();
$("#liabilityLedger_table").css("display","block");
$("#liabilityLedgerButtonGroup").css("display","block");
$("#paginationCash").css("display","block");

GSTR2Service.getLiabilityLedgerService().then(function(data){
                    $scope.liabilityLedger=data;
                   
              });
}

$("#subcash").css("display","none");
$scope.getTransactionAllData=function(trans_cd){
	
	$("#subcash").css("display","block");
	for(i=0;i<$scope.liabilityLedger.tr.length;i++)
	{
		if($scope.liabilityLedger.tr[i].trans_cd==trans_cd)
		{
			$scope.allTransactionalDetails=$scope.liabilityLedger.tr[i];
		}
	}
	
}



}]);
