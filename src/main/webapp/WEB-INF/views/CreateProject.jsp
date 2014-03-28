<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<jsp:include page="Header.jsp" />

  	<div class="container-fluid" id="wrap">
  		<div class="col-md-12 heading">
	  		<h1>Create project</h1>
  		</div>
  		
		<div class="col-md-5">
			<form:form role="form"  method="post"  commandName="predefinedProject">
				<div class="form-group">
					<label for="InputUsername">Project name</label>					
					<form:input cssClass="form-control" path="name" id="projectName" tabindex="1" />
					<span class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
				</div>
				<div class="form-group">
					<label for="InputUsername">Description</label>					
					<form:input cssClass="form-control" path="description" id="projectDescription" tabindex="1" />
					<span class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
				</div>
				<div class="form-group">
					<label for="InputUsername">Points</label>					
					<form:input cssClass="form-control" path="point" id="projectPoint" tabindex="1" />
					<span class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
				</div>
				<button type="submit" class="btn btn-default" tabindex="3">Submit project</button>			
			</form:form>	  	
		</div>	  	
  	</div>
<jsp:include page="Footer.jsp" />