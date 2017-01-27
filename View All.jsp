<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<style>
table, th, td {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 15px;
}
table tr:nth-child(odd) {
  background-color: #f1f1f1;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>

<head>
<script src="<c:url value="resources/js/angular.min.js"/>"></script>           
 <script>
      var app=angular.module('tabApp',[]);
      app.controller('tabCtrl',function($scope,$http){
    	  $http.get("search").then(function(response){
    		  alert(response.data);
    		  $scope.data1=response.data
    		  })
      });
      
   </script>
</head>
<body>

  
   <div class="container">
   
   <div class="container" style="margin-top:4%" ng-app="tabApp" ng-controller="tabCtrl">
        <input class="form-control" placeholder="Search" type="text" ng-model="str">
        
                
        
        
       
       <table>
<thead>
<tr>
    <th>ProductId</th>
    <th>ProductName</th>
    <th>ProductValue</th>
    
</tr>
</thead>

<tbody>
<tr ng-repeat="contact in data1 |filter:str ">
     <td>{{contact.proId}}</td>
    <td>{{contact.proName}}</td>
    <td>{{contact.proValue}}</td>
      <td> 
        <a  href=><a href="view1?&com={{contact.proName}}" class="btn btn-info" role="button">View</a> |
         
        <a  href=><a href="#" class="btn btn-info" role="button">edit</a> ||
        <a  href=><a href="#" class="btn btn-info" role="button">delete</a> |
    </td>
 </tr>
 
</tbody>
</table>

   </div>
   
   </div>
</body>
</html>
