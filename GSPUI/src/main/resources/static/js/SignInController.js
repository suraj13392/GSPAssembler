appEngage.controller("signInController",["$scope",'$http','$q','$rootScope',function($scope,$http,$q,$rootScope){
    $(".header-note").removeClass('hide');
	$("#signIN").css("display","none");
	$("#signup_div").css("display","block");
	
	$(".primary-nav").css("display","block");
	$("#leftSideMenu").css("display","none");
	
     $scope.signIn= function(){
        console.log("Sign in")
        $rootScope.user=true;
        $(".menu-home").addClass("hide")
         $(".menu-dashbord").removeClass("hide")
         $(".header-note").addClass('hide');
        $("#signup_div").css("display","none");
    }
}]);