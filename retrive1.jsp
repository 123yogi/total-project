<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
<h1>Hello... <%=request.getAttribute("loggedInUser")%></h1>

    <div class="container">
        
<div ng-app="myApp" ng-controller="customersCtrl">
<input type="text" class="form-control" ng-model="searchBy.chairName"/>
<table class="table table-hover table-bordered">
  <tr>
       <th>Chair Id</th>
       <th>Chair Name</th>
       <th>Chair Price</th>
       <th>Chair Desc</th>
      
  </tr>
  <tr ng-repeat="x in names | filter:searchBy">
    <td>{{x.chairId}}</td>
    <td>{{x.chairName}}</td>
    <td>{{x.chairPrice}}</td>
    <td>{{x.chairDesc}}</td>
    <td><a href="viewPro?id={{x.chairId}}" class="btn btn-info">View</a>  <a href="editChair?id={{x.chairId}}" class="btn btn-info">Edit</a>  <a href="delete?id={{x.chairId}}" class="btn btn-info">Delete</a></td>
  </tr>
</table>
<a href="newchair" class="btn btn-info">Add Product</a>
</div>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("list")
    .then(function (response) {$scope.names = response.data;});
});
</script>
</div>
</body>
</html>



