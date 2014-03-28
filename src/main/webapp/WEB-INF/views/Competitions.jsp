<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Competitions | voiceworksLABS</title>
		
		<!-- CSS -->
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    	<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
    	<link href="<c:url value="/resources/css/css.css" />" rel="stylesheet">

		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		<nav class="navbar navbar-default navbar-static-top hidden-md hidden-lg" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle pull-left" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>					
					</ul>
				</div>				
			</div>
		</nav>
		
		<div class="brand-logo hidden-xs hidden-sm"></div>  	
	  	<ul class="primary-nav hidden-xs hidden-sm">
	  		<li>
	 			<a href="#">
	 				<span class="nav-icon" id="nav-user-profile"></span>
	 				<span class="nav-label">Dirk de Ron</span>
	 			</a>
	 		</li>
	 		<li class="active">
	 			<a href="#">
	 				<span class="nav-icon" id="nav-competitions"></span>
	 				<span class="nav-label">Competitions</span>
	 			</a>
	 		</li>
	 		<li>
	 			<a href="./Projects">
	 				<span class="nav-icon" id="nav-projects"></span>
	 				<span class="nav-label">Projects</span>
	 			</a>
	 		</li>
	 		<li>
	 			<a href="#">
	 				<span class="nav-icon" id="nav-help"></span>
	 				<span class="nav-label">Help</span>
	 			</a>
	 		</li>	
		</ul>
	  	<div class="container-fluid" id="wrap">
	  		<div class="col-md-12 heading">
		  		<h1 class="inline-block">Competitions</h1>
		  		<div class="btn-group pull-right">
					<button type="button" class="btn btn-default" >
						<a href="./CreateCompetition">Create competition</a>
					</button>
		  		</div>
	  		</div>
	  		
	  		<div class="col-md-12">
	  			<ul class="media-list">
	  				<li>
				  		<div class="media">
					  		<div class="media-body">
					  		
					  				<c:if test="${not empty competitions}">
									    <table>
									        <c:forEach var="competition" items="${competitions}">
									        	<h4 class="media-heading"><a href="#">${competition.name}<span class="badge"> live</span></a></h4>
									        </c:forEach>
									    </table>
									</c:if>	
									
						  	</div>						 
						</div>
	  				</li>
	  			</ul>   		
	  		</div>  		
	 
	  	</div>

	<!-- jQuery -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=<c:url value="/resources/js/bootstrap.js" />></script>
	</body>
</html>