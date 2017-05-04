	appEngage.controller("gstr3Controller",["$scope",'$http','GSTR2Service','$q','$rootScope','$state','$stateParams',function($scope,$http,GSTR2Service,$q,$rootScope,$state,$stateParams){
	
	$('#dashboardDiv').css("display","none");
	
	$("#gstr3_table").css("display","none");
	$("#gstr3ButtonGroup").css("display","none");
	
	
	  $scope.steps = [
    'Turn Over Details',
    'Outward Supplies',
    'Inward Supplies',
	'Total Tax Liability',
	'TCS Credit',
	'TDS Credit',
	'ITC Credit',
	'Tax Paid',
	'Refund Claim'
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

  $scope.hasNextStep = function(){
    var stepIndex = $scope.getCurrentStepIndex();
    var nextStep = stepIndex + 1;
    // Return true if there is a next step, false if not
    return !_.isUndefined($scope.steps[nextStep]);
  };

  $scope.hasPreviousStep = function(){
    var stepIndex = $scope.getCurrentStepIndex();
    var previousStep = stepIndex - 1;
    // Return true if there is a next step, false if not
    return !_.isUndefined($scope.steps[previousStep]);
  };

  $scope.incrementStep = function() {
    if ( $scope.hasNextStep() )
    {
      var stepIndex = $scope.getCurrentStepIndex();
      var nextStep = stepIndex + 1;
      $scope.selection = $scope.steps[nextStep];
    }
  };

  $scope.decrementStep = function() {
    if ( $scope.hasPreviousStep() )
    {
      var stepIndex = $scope.getCurrentStepIndex();
      var previousStep = stepIndex - 1;
      $scope.selection = $scope.steps[previousStep];
    }
  };

	
	
	
	  $scope.getGSTR3Data=function(){
             
              $("#gstr3_table").css("display","block");
              $("#gstr3ButtonGroup").css("display","block");
             
              GSTR2Service.getGSTR3().then(function(data){
                    $scope.gstr3Data=data;
                   
              });
             
       }
	
}]);