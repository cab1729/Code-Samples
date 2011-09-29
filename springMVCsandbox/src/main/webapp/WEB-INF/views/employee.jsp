<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link type="text/css" rel="stylesheet" 
	href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />

<script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"> </script>

<title>Spring MVC 3 - HR Manager</title>
</head>
<body>
<h2>HR Manager</h2>
<form:form method="post" action="add.html" commandName="employee">
	<table>
		<tr>
			<td><form:label path="firstName"><spring:message code="label.firstname" /></form:label></td>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td><form:label path="lastName"><spring:message code="label.lastname" /></form:label></td>
			<td><form:input path="lastName" /></td>
		</tr>	
		<tr>
			<td><form:label path="email"><spring:message code="label.email" /></form:label></td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><form:label path="phoneNumber"><spring:message code="label.phonenumber" /></form:label></td>
			<td><form:input path="phoneNumber" /></td>
		</tr>
		<tr>
			<td><form:label path="hireDate"><spring:message code="label.hiredate" /></form:label></td>
			<td><form:input path="hireDate" /></td>
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ElementDecoration({
					elementId: "hireDate",
					widgetType: "dijit.form.DateTextBox",
					widgetAttr: { datePattern : "MM-dd-yyyy", required : true }	 }));
			</script>
		</tr>
		<tr>
			<td><form:label path="jobId"><spring:message code="label.jobid" /></form:label></td>
			<td><form:input path="jobId" /></td>
		</tr>
		<tr>
			<td><form:label path="departmentId"><spring:message code="label.departmentid" /></form:label></td>
			<td><form:input path="departmentId" /></td>
		</tr>
		<tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addemployee"/>"/>
        </td>
    </tr>
	</table>
</form:form>
<h3>Employees</h3>
<c:if test="${!empty employeeList}">
<table class="data">
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Dept</th>
		<th>JobId</th>
		<th>ManagerId</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach items="${employeeList}" var="employee">
		<tr>
			<td>${employee.lastName }, ${employee.firstName }</td>
			<td>${employee.email }</td>
			<td>${employee.phoneNumber }</td>
			<td>${employee.departmentId }</td>
			<td>${employee.jobId }</td>
			<td>${employee.managerId }</td>
			<td><a href="delete/${employee.employeeId}">delete</a></td>
		</tr>
	</c:forEach>
</table>
</c:if>
</body>
</html>