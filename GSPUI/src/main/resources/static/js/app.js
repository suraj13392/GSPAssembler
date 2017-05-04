var appEngage = angular.module('myAppNew', [ 'ui.router','xeditable']);

appEngage.config([ '$stateProvider', '$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {
			$urlRouterProvider.otherwise('/');
			$stateProvider.state('home', {
				url : '/',
				views : {
					'' : {
						templateUrl : 'template/homeMain.html'
					},
					'indexnav@home' : {
						templateUrl : 'template/indexNav.html'
					},
					'wrapper@home' : {
						templateUrl : 'template/home.html'
					},
					'footer@home' : {
						templateUrl : 'template/footer.html'
					}

				}
			}).state('dashboard', {
				url : '/dashboard',
				views : {
					'' : {
						templateUrl : 'template/dashboardMain.html'
					},
					'dashboardnav@dashboard' : {
						templateUrl : 'template/dashboardNav.html'
					},
					'dashboardwrapper@dashboard' : {
						templateUrl : 'template/dashboard.html'
					},
					'footer@dashboard' : {
						templateUrl : 'template/footer.html'
					}
				}
			}).state('dashboard.gstr1', {
		        url: '/gstr1',
		        templateUrl : 'template/gstr_form.html'
					
		    }).state('dashboard.gstr1-Summary', {
		        url: '/gstr1-Summary',
		        templateUrl : 'template/GSTR1_Summary.html'
					
		    }).state('dashboard.gstr2', {
		        url: '/gstr2',
		        templateUrl : 'template/gstr_form2.html'
					
		    }).state('dashboard.gstr2-Summary', {
		        url: '/gstr2-Summary',
		        templateUrl : 'template/GSTR2_Summary.html'
				
		    }).state('dashboard.stateMaster', {
		        url: '/stateMaster',
		        templateUrl : 'template/state.html'
					
		    }).state('dashboard.supplierMaster', {
		        url: '/supplierMaster',
		        templateUrl : 'template/supplier.html'
				
		    }).state('dashboard.recipientMaster', {
		        url: '/recipientMaster',
		        templateUrl : 'template/receipient.html'
				
		    }).state('dashboard.hsnMaster', {
		        url: '/hsnMaster',
		        templateUrl : 'template/hsnCode.html'
					
		    }).state('dashboard.download_return', {
		        url: '/download_return',
		        templateUrl : 'template/downloadReturn.html'
				
		    }).state('dashboard.GSTR_Template', {
		        url: '/GSTR_Template',
		        templateUrl : 'template/GSTR_Template.html'
		    }).state('dashboard.userprofile', {
		        url: '/userprofile',
		        templateUrl : 'template/userProfile.html'
					
		    }).state('dashboard.gstr1A', {
		        url: '/gstr1A',
		      	templateUrl : 'template/gstr1A.html'
					
		    }).state('dashboard.gstr1A-Summary', {
		        url: '/gstr1A-Summary',
		        templateUrl : 'template/gstr1ASummary.html'
					
		    }).state('dashboard.gstr3', {
		        url: '/gstr3',
		        templateUrl : 'template/gstr3-form.html'
					
		    }).state('dashboard.cashLedger', {
		        url: '/cashLedger',
		        templateUrl : 'template/cashLedger.html'
					
		    }).state('dashboard.itcLedger', {
		        url: '/ITCLedger',		      
				templateUrl : 'template/ITCLedger.html'
				
		    }).state('dashboard.liabilityLedger', {
		        url: '/liabilityLedger',
		        templateUrl : 'template/liabilityLedger.html'
					
		    })

		  
		} ])