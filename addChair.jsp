<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />
  <script src='<c:url value="/resources/js/jquery.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/angular.min.js"></c:url>'></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="h1">Home</a></li>
       <li><a href="cont">Contact us</a></li>
     </ul>
  </div>
</nav>
    <div class="container" ng-app="imgApp" ng-controller="imgCtrl">
    <c:url var="addChair" value="addChair"></c:url>
   <form:form commandName="chair" method="post" action="storechair" enctype="multipart/form-data">
       <table class="table table-bordered" >
           
           <tr><td><form:label path="chairName">Chair Name :</form:label></td>
               <td><form:input path="chairName"/>
               <font color="red"><form:errors path="chairName"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="chairPrice">Chair Price :</form:label></td>
               <td><form:input path="chairPrice"/>
               <font color="red"><form:errors path="chairPrice"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="chairDesc">Description :</form:label></td>
               <td><form:input path="chairDesc"/>
               <font color="red"><form:errors path="chairDesc"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="chairStyle">Style :</form:label></td>
               <td><form:input path="chairStyle"/>
               <font color="red"><form:errors path="chairStyle"></form:errors></font></td>
               
               
                              
               
               
           </tr>
           <tr><td><form:label path="warranty">Warranty :</form:label></td>
               <td><form:input path="warranty"/>
               <font color="red"><form:errors path="warranty"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="primaryMeterial">Primary Meterial :</form:label></td>
               <td><form:input path="primaryMeterial"/>
               <font color="red"><form:errors path="primaryMeterial"></form:errors></font></td>
           </tr>
           
           <tr><td><form:label path="capacity">Capacity :</form:label></td>
               <td><form:input path="capacity"/>
               <font color="red"><form:errors path="capacity"></form:errors></font></td>
           </tr>          
           <tr><td><form:label path="img">Chair Image :</form:label></td>
               <td><form:input path="img" type="file"/>
               <font color="red"><form:errors path="img"></form:errors></font></td>
               
           </tr>
           <tr><td></td>
               <td><input type="submit" value="submit" class="btn"/></td>
           </tr>
           
       </table>
   </form:form> 
   
</body>
</html>