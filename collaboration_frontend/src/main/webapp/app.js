var app = angular.module('myApp', ['ngRoute', 'ngCookies']);

app.config(function($routeProvider)
{
	$routeProvider	

	.when('/', {
		templateUrl: 'v_home/welcome.html',
		controller: 'HomeController'
	})
	
});
