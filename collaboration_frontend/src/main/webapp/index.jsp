<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Sergey Pozhilov (GetTemplate.com)">

<title>iNiitian Collaboration</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">


<!-- Custom styles for our template -->
<link rel="stylesheet" href="resources/assets/css/main.css">
   <script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<!--  <script src="resources/js/angular.js"></script>
 --><script src="resources/js/angular-route.min.js"></script>
<script src="resources/js/angular-cookies.min.js"></script>



</head>

</head>

<body ng-app="myApp" 
	ng-controller="UserProfileController as ctrl">
	<div ng-show="currentUser.useremail==undefined">
		<div ng-include="'v_common/common.html'"></div>
	</div>
	<div ng-show="currentUser.useremail!==undefined">
		<div ng-show="currentUser.currentrole=='Role_Student'">
			<div ng-include="'v_common/userview.html'"></div>
		</div>
	</div>
	<div ng-show="currentUser.useremail!==undefined">
		<div ng-show="currentUser.currentrole=='Role_Admin'">
			<div ng-include="'v_common/adminview.html'"></div>
		</div>
	</div>
	


	<br />
	<br />


	<div class="row">
		<div class="col-md-3 col-sm-6 highlight">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Blogs</h3>
				</div>
				<div class="panel-body fixed-panel"
					style="text-align: justify; font-size: 15px; height: 450px;">
					<marquee behavior="scroll" direction="up" onmouseover="this.stop()"
						onmouseout="this.start()">
						<div ng-repeat="ub in ctrl.blogs | filter: {blogStatus: 'A'}">
							<li><a href="#">{{ub.blogTitle}}</a></li>
							{{ub.blogDescription}}
						</div>
					</marquee>
				</div>
			</div>
		</div>

<div class="col-md-6 col-sm-6 highlight">
	<div id="myContainer" style=" width: 100%;">

 		
		
			<div ng-view></div>
	
	</div>		
		<div id="myContainer"
	style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
	<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000">
		<!-- Indicators -->
		
		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="resources/images/col.jpg" alt="Chania"
					style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
			</div>

			<div class="item">
				<img src="resources/images/blog.jpg" alt="Chania"
					style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
			</div>
			<div class="item">
				<img src="resources/images/job.jpg" alt="Chania"
					style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
			</div>

			<div class="item">
				<img src="resources/images/chat.jpg" alt="Flower"
					style="height: 350px; width: 100%; overflow: hidden; cursor: pointer">
			</div>

		</div>

		<!-- Left and right controls -->
		
	</div>

</div>
				
		
		
		
			<h3 class="widget-title">About NIIT</h3>
			<div class="widget-body">
				<p style="text-align: justify;">NIIT is a leading Skills and
					Talent Development Corporation that is building a manpower pool for
					global industry requirements. The company, which was set up in 1981
					to help the nascent IT industry overcome its human resource
					challenges, today ranks among the world’s leading training
					companies owing to its vast, yet comprehensive array of talent
					development programs. With a footprint across 40 nations, NIIT
					offers training and development solutions to Individuals,
					Enterprises and Institutions.</p>
			</div>

</div>

		<div class="col-md-3 col-sm-6 highlight">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Career</h3>
				</div>
				<div class="panel-body fixed-panel"
					style="text-align: justify; font-size: 15px; height: 200px;">
					<marquee behavior="scroll" direction="up" onmouseover="this.stop()"
						onmouseout="this.start()">
						<div ng-repeat="uj in ctrl.jobs">
							<li><a href="#">{{uj.title}}</a></li>
							{{uj.description}}<br/>
							{{uj.companyname}}<br/>
							{{uj.postdate}}
							{{uj.location}}

						</div>
					</marquee>
				</div>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Event</h3>
				</div>
				<div class="panel-body fixed-panel"
					style="text-align: justify; font-size: 15px; height: 200px;">
					<marquee behavior="scroll" direction="up" onmouseover="this.stop()"
						onmouseout="this.start()">
						<div ng-repeat="ue in ctrl.events">
							<li><a href="#">{{ue.subject}}</a></li>
											{{ue.description}}
											{{ue.eventdt}}</br/>
											{{ue.venue}}
						
							
						</div>
					</marquee>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<section id="social">
		<div class="container">
			<div class="wrapper clearfix">
				<!-- AddThis Button BEGIN -->
				<div class="addthis_toolbox addthis_default_style">
					<a class="addthis_button_facebook_like"
						fb:like:layout="button_count"></a> <a class="addthis_button_tweet"></a>
					<a class="addthis_button_linkedin_counter"></a> <a
						class="addthis_button_google_plusone" g:plusone:size="medium"></a>
				</div>
			</div>
		</div>
	</section>
	<footer id="footer" class="top-space">

		<div class="footer2">

			<div class="row">
				<div class="col-md-6 widget">
					<div class="widget-body">
						<p class="simplenav">NIIT, Vadodara</p>
					</div>
				</div>

				<div class="col-md-6 widget">
					<div class="widget-body">
						<p class="text-right">
							Copyright &copy; 2017, by Bhoomi Desai <a href="#/home"
								rel="designer">(NIIT)</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		</div>

	</footer>
	<script src="resources/assets/js/headroom.min.js"></script>
	<script src="resources/assets/js/jQuery.headroom.min.js"></script>
	<script src="resources/assets/js/template.js"></script>

	<script src="app.js"></script>
	<script src="v_home/HomeController.js"></script>
	<script src="v_usertype/UserTypeController.js"></script>
	<script src="v_usertype/UserTypeService.js"></script>
	<script src="v_userrole/UserRoleController.js"></script>
	<script src="v_userrole/UserRoleService.js"></script>
	<script src="v_user/UserProfileController.js"></script>
	<script src="v_user/UserProfileService.js"></script>
	<script src="v_job/JobController.js"></script>
	<script src="v_job/JobService.js"></script>
	<script src="v_event/EventController.js"></script>
	<script src="v_event/EventService.js"></script>

	<script src="v_blog/BlogController.js"></script>
	<script src="v_blog/BlogService.js"></script>
	<script src="v_forum/ForumController.js"></script>
	<script src="v_forum/ForumService.js"></script>    
	<script src="v_friend/FriendController.js"></script>
	<script src="v_friend/FriendService.js"></script>

	<script src="v_chat/ChatController.js"></script>
	<script src="v_chat/ChatService.js"></script>
	<script src="v_chat/sockjs.min.js"></script>
	<script src="v_chat/stomp.min.js"></script>
	<script src="v_chat/lodash.min.js"></script>
</body>
</html>