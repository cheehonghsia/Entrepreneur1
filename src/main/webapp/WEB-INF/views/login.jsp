<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Login | voiceworksLABS</title>
		
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
	<body id="login" onload="document.f.j_username.focus();">
		<div class="container">
		  	<div class="row">	  		
			  	<div class="col-md-4 col-md-offset-4">
			  		<div class="logo">
			  		
			  		</div>
			  		<!-- <div class="alert alert-danger">Something terrible happened. <a href="#">Let's see if this fixes it.</a></div> -->
					<form name='loginForm' action="<c:url value="j_spring_security_check" />" method="post">
						<div class="form-group">
							<label for="InputUsername">Username</label>
							<label class="pull-right"><a title="Forgot your username?" href="#">I Forgot</a></label>
							<input type="text" class="form-control" id="InputUsername" name="j_username" tabindex="1">
							<span class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
						</div>
						<div class="form-group">
							<label for="InputPassword">Password</label>
							<label class="pull-right"><a title="Forgot your password?" href="#">I Forgot</a></label>
							<input type="password" class="form-control" id="InputPassword" name="j_password" tabindex="2">						
						</div>
						<!-- <div class="form-group">
							<input type="checkbox" id="RememberMe"><label for="RememberMe">Remember me</label>
						</div> -->
						<button type="submit" class="btn btn-default" tabindex="3">Log In</button>
						
					</form>			  
				</div>
			</div>
		</div>	
	<!-- jQuery -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=<c:url value="/resources/js/bootstrap.js" />></script>
	</body>
</html>











<%-- 
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



  <jsp:body>

      <div class="grid-12">
          <h1>
              <s:message code="page.login.h1.title" text="Login" />
          </h1>
      </div>
      <c:if test="${param.failed == '1'}">
          <div class="line">
              <div class="grid-6">
                  <div class="message message-error">
                      <p>
                          <i class="icon-cross margin-right">&nbsp;</i>
                          <s:message code="authentication.failed" text="Username and/or password is invalid" />
                      </p>
                  </div>
              </div>
          </div>
      </c:if>
      <form id="loginForm" action="j_spring_security_check" method="POST">
          <div class="line line-form">
              <div class="grid-2 prefix-2">
                  <label>
                      <s:message code="field.username" text="Username" />
                  </label>
              </div>
              <div class="grid-4">
                  <input type="text" name="j_username" id="j_username" />
              </div>
              <div class="grid-2 suffix-2">&nbsp;</div>
          </div>
          <div class="line line-form">
              <div class="grid-2 prefix-2">
                  <label>
                      <s:message code="field.password" text="Password" />
                  </label>
              </div>
              <div class="grid-4">
                  <input type="password" name="j_password" id="j_password" />
              </div>
              <div class="grid-2 suffix-2">&nbsp;</div>
          </div>
          <div class="line line-form">
              <div class="grid-4 prefix-4 suffix-4">
                  <button type="submit" class="button-positive margin-right">
                      <b>
                          <b>
                              <s:message code="button.login" text="Login" />
                          </b>
                      </b>
                  </button>
                  <p>
                      <a href="forgot-password.html">
                          <s:message code="link.forgotPassword" text="Forgot password?" />
                      </a>
                  </p>
              </div>
          </div>
      </form>
      
   </jsp:body>

 --%>