<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Employee Email</title>
</head>
<body>
<f:view>
<h:form id="GetEmpInfoView">
	<h:panelGrid columns="2">
		<h:outputLabel rendered="true" value="emp Id: "></h:outputLabel>
		<h:inputText value="#{getEmpInfoController.empId }"></h:inputText>
		<h:outputLabel rendered="#{getEmpInfoController.empId > 0}" value="email: "></h:outputLabel>
		<h:outputText id="empEmail" rendered="#{getEmpInfoController.empId > 0}" value="#{getEmpInfoController.email }"></h:outputText>
	</h:panelGrid>
	<h:commandButton action="#{getEmpInfoController.getEmail}" value="getEmpEmail"></h:commandButton>
</h:form>
</f:view>
</body>
</html>