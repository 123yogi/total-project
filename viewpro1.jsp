<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
     <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <script src='<x:url value="/resources/js/jquery.min.js"></x:url>'></script>
  <script src='<x:url value="/resources/js/bootstrap.min.js"></x:url>'></script>
  <script src='<x:url value="/resources/js/angular.min.js"></x:url>'></script>
   
</head>
   <body>
   <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
    <ul class="nav navbar-nav">
            <li><a href="cont">Contact us</a></li>
      <li><a href="logout">Logout</a></li>
          </ul>
  </div>
</nav>
      <div class="container">
            <table class="table table-hover table-bordered">
            <tr><td rowspan="5">
            <img src='<x:url value="/resources/images/${chair.image}"/>'/></td></tr>
            <tr><td>${chair.chairId}</td></tr>
            <tr><td>${chair.chairName}</td></tr>
            <tr><td>${chair.chairPrice}</td></tr>
            <tr><td>${chair.chairDesc}</td></tr>
            <tr><td>${chair.chairStyle}</td></tr>
            <tr><td>${chair.warranty}</td></tr>
            <tr><td>${chair.primaryMeterial}</td></tr>
            <tr><td>${chair.capacity}</td></tr>
            
            
            <tr><td></td><td><a href="viewcart?id={{chair.chairId}}" class="btn btn-primary">Add Cart</a>
                             
            </table>
      </div>
   </body>
</html>