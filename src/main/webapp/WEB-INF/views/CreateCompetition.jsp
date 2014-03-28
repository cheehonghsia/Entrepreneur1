<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
 	<jsp:include page="Header.jsp" />
 
  	<div class="container-fluid" id="wrap">
  		<div class="col-md-12 heading">
	  		<h1>Create competition</h1>
  		</div>
  		
		<div class="col-md-5">
			<form:form role="form" method="post"  commandName="timeDrivenCompetition">
				<div class="form-group">
					<label for="InputUsername">Competition name</label>					
					<form:input cssClass="form-control" id="competitionName"  path="name"  tabindex="1" />
					<span class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
				</div>
				<div class="form-group">
			    	<label>Start date</label>
			    	<form:input cssClass="form-control" path="startDate" id="dpd1" />
		
					<label>End date</label>
			    	<form:input cssClass="form-control" path="EndDate" id="dpd2" />
				</div>
				<h4>Add project</h4>
		    	<button type="submit" class="btn btn-default" tabindex="3">Create competition</button>			
			</form:form>	  	 
		</div>
			
  	</div>

  <jsp:include page="Footer.jsp" />