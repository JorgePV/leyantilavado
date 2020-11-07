<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources" var="urlPublic"/>

<link rel="stylesheet" type="text/css" href="${urlPublic }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${urlPublic }/bootstrap/css/bootstrap.css">

<script language="javascript" type="text/javascript" src="${urlPublic }/bootstrap/js/bootstrap.js"></script>
<script language="javascript" type="text/javascript" src="${urlPublic }/bootstrap/js/bootstrap.min.js"></script>
<!-- URL EXTERNO -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<nav class="navbar navbar-expand-md navbar-light bg-light">
    <!--<a href="#" class="navbar-brand">Brand</a>-->
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav">
            <a href="home" class="nav-item nav-link">Inicio</a>
            <a href="reporte" class="nav-item nav-link">reporte</a>
            <a href="consulta" class="nav-item nav-link">consulta</a>
            <a href="usuario" class="nav-item nav-link disabled" tabindex="-1">usuario</a>
        </div>
        <div class="navbar-nav ml-auto">
        	<%=session.getAttribute("name")%>
            <a href="contenido?action=logout" class="nav-item nav-link">Logout</a>
        </div>
    </div>
</nav>
<title>Antilavado</title>
</head>



