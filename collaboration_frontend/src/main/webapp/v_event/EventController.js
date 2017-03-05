'use strict';

app.controller('EventController', ['$scope', 'EventService', '$location', '$rootScope',
                                function($scope, EventService, $location, $rootScope) {
	
	console.log("Event controller");
	
	var self = this;
    self.event={
    		eventid:'',
    		eventdt:'',
    		subject:'',
    		description:'',
    		venue:'',
    		showflag:''};
    self.events=[];
    
    self.fetchAllEvents = function()
    {
        EventService.fetchAllEvents().then(function(d)
    	{
        	self.events = d;
            console.log("Fetch all event sucess")
        },
        function(errResponse)
        {
        	console.error('Error while fetching Events'+ errResponse);
        }
      );
   };
    
   self.fetchAllEvents();
   
   self.createNewevent = function(event){
   	EventService.createNewevent(event)
   		.then(
   				self.reset,
   				function(errResponse)
   				{
   					console.error('Error while creating record');
   				}
   		);
   };
   self.deleteEvent = function(evid)
   {
	   EventService.deleteEvent(evid)
       	.then(
       			self.fetchAllEvents,    			
       			function(errResponse)
       			{
       				console.error('Error while deleting event');
       			}
       		);
   };
   
   self.delEvent = function(evid){
	   	if(confirm('Are you sure you want to Delete this Event?')) {
	   		self.deleteEvent(evid);
	   		
	   	}
  };
   self.submit = function()
   {
	   	self.createNewevent(self.event);
   		console.log("Saving new event", self.event);
   };

   self.reset = function()
   {
	    self.event={
	    	eventid:'',
	    	eventdt:'',
	    	subject:'',
	    	description:'',
	    	venue:'',
	    	showflag:''};
	    $scope.myform.$setPristine();
   };
}]);
