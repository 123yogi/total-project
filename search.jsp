<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
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
    <% String str=request.getParameter("pro");%>
 <script src="<c:url value="resources/js/angular.min.js"/>"></script> 
   <div class="container">
   
   <div class="container" style="margin-top:4%" ng-app="tabApp" ng-controller="tabCtrl">
        <input class="form-control" placeholder="Search" type="text" ng-model="str">
        
       
       <%if(!(str.equals("all")))
       {
       %>
       <h3>
       <%=str %>
       </h3>
       <table class="table table-bordered">
          <thead>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Prost Cost</th>
            </tr>
          </thead>
          <tbody>
             

<tr ng-repeat="x in data1 | filter:str">
                <td>{{x.proId}}</td>
                <td>{{x.proName}}</td>
                <td>{{x.proValue}}</td>
                <td><a  href=><a href="view1?&com={{x.proName}}" class="btn btn-info" role="button">View</a> |
         
        <a  href=><a href="#" class="btn btn-info" role="button">edit</a> ||
        <a  href=><a href="#" class="btn btn-info" role="button">delete</a> |</a></a></a></td>
             </tr> 
          </tbody>
       </table>
       <%}
       else{
    	   
       %>
       
       
       <table ><tr ng-repeat="x in data1 "><td>
             <table  class="table table-bordered" style="margin-top:10%">
          <tbody>
             <tr ng-repeat="y in x | filter:str">
                <td>{{y.proId}}</td>
                <td>{{y.proName}}</td>
                <td>{{y.proValue}}</td>
                <td><a href="E:/yogi/yogipro/mavenapp/src/main/webapp/WEB-INF/view/view1.jsp?&com={{y.proName}}" class="btn btn-info" role="button">View</a> / <a href="edit"class="btn btn-info" role="button">Edit</a> / <a href="delete" class="btn btn-info" role="button">Delete</a></td>
             </tr>
          </tbody>
       </table></td></tr></table>
       <%} %>      
   </div>
   <script>
      var app=angular.module('tabApp',[]);
      app.controller('tabCtrl',function($scope,$http){
    	  $http.get("<%=str%>").then(function(response){$scope.data1=response.data})
      });
      
   </script>
   
   </div>
</body>
</html>
