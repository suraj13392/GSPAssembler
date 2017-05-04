appEngage.controller("gstHeadController",["$scope",'$http','$q','$rootScope',function($scope,$http,$q,$rootScope){
    $('body').css("padding-right","0px");
  
}])

appEngage.controller("loginNavController",["$scope",'$http','$q','$rootScope',function($scope,$http,$q,$rootScope){
    
	
	$scope.signIn=function(){
		$rootScope.userName=$scope.userName;		
	}
	hideNav();
	$scope.signOut=function(){
		$rootScope.userName="";
		hideNav();
	}
	
	
	function hideNav(){
	if($rootScope.userName!="" && $rootScope.userName!=undefined){
		$(".dashboard-menu").css("display","block");
		$(".index-menu").css("display","none");
		}
		else{
			$(".dashboard-menu").css("display","none");
			$(".index-menu").css("display","block");
		}
	}
	
	
    
}])

appEngage.controller("dashboardNavController",["$scope",'$http','$q','$rootScope',function($scope,$http,$q,$rootScope){
	$scope.dashboardsignOut=function(){
		$rootScope.userName="";
		dashboardhideNav();
	}
	function dashboardhideNav(){
		if($rootScope.userName!="" && $rootScope.userName!=undefined){
			$(".dashboard-menu").css("display","block");
			$(".index-menu").css("display","none");
			}
			else{
				$(".dashboard-menu").css("display","none");
				$(".index-menu").css("display","block");
			}
		}
	
}]);

appEngage.controller("dashboardController",["$scope",'$http','$q','$rootScope',function($scope,$http,$q,$rootScope){
	$("#news").click(function(){
		$("#news").addClass("active");
		$("#ind_notification").removeClass("active");
		$("#newsContent").css("display","block");
		$("#notificationContent1").css("display","none");
	});
	$("#ind_notification").click(function(){
		$("#news").removeClass("active");
		$("#ind_notification").addClass("active");
		$("#newsContent").css("display","none");
		$("#notificationContent1").css("display","block");
	});

}]);

appEngage.controller("dashboardMainController",["$scope",'$http','$q','$rootScope','$state','$stateParams',function($scope,$http,$q,$rootScope,$state,$stateParams){
	$('body').removeClass('modal-open');
	
	$('.modal-backdrop').remove();
	
	$('#dashboardDiv').css("display","block");
	/* if($state.current.url!=="/dashboard"){
		 $('#dashboardDiv').css("display","none");
	 }
	 else{
		 $('#dashboardDiv').css("display","block");
	     } */
	
}]);

appEngage.controller("newHomeController",["$scope",'$http','$q','$rootScope',function($scope,$http,$q,$rootScope){
	
	/*width& Height for section3*/
	$(".firstDiv-image-style").css("width",document.getElementById("first-img").offsetWidth);
	$(".firstDiv-image-style").css("height",(document.getElementById("first-img").offsetHeight)/3);
	
	
	/*width& Height for section1*/
	/*$(".banner-img-style").css("width",document.getElementById("banner-img").offsetWidth);
	$(".banner-img-style").css("height",document.getElementById("banner-img").offsetHeight);*/
	
	 
	/*Read More Code start*/
    var showChar = 200;
    var showChar1 = 100;// How many characters are shown by default
    var ellipsestext = "...";
    var moretext = "Read More";
    var lesstext = "Show less";
    

    $('.more').each(function() {
        var content = $(this).html();
        if(content.length > showChar) {
            var c = content.substr(0, showChar);
            var h = content.substr(showChar, content.length - showChar);
            var html = c + '<span class="moreellipses">' + ellipsestext+ '&nbsp;</span><span class="morecontent"><span>' + h + '</span><br/><a href="" class="morelink" style="float: right;">' + moretext + '</a></span>';
            $(this).html(html);
        }
    });
    $('.more1').each(function() {
        var content = $(this).html();
        if(content.length > showChar1) {
            var c = content.substr(0, showChar1);
            var h = content.substr(showChar1, content.length - showChar1);
            var html = c + '<span class="moreellipses">' + ellipsestext+ '&nbsp;</span><span class="morecontent"><span>' + h + '</span>&nbsp;&nbsp;<a href="" class="morelink">' + moretext + '</a></span>';
            $(this).html(html);
        }
    });
    $('.more3').each(function() {
        var content = $(this).html();
        if(content.length > showChar1) {
            var c = content.substr(0, showChar1);
            var h = content.substr(showChar1, content.length - showChar1);
            var html = c + '<span class="moreellipses">' + ellipsestext+ '&nbsp;</span><span class="morecontent"><span>' + h + '</span><br/><a href="" class="morelink" >' + moretext + '</a></span>';
            $(this).html(html);
        }
    });
 
  /*  $(".morelink").click(function(){
        if($(this).hasClass("less")) {
            $(this).removeClass("less");
            $(this).html(moretext);
        } else {
            $(this).addClass("less");
            $(this).html(lesstext);
        }
        $(this).parent().prev().toggle();
        $(this).prev().toggle();
        return false;
    });*/
	
    
    /*Read More Code End*/
	

}]);
