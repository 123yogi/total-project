<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
     
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  </head>
   
</head>

<div class="container-wrapper">
 
    <div class="container">
    <script>
function myFunction() {
    alert("Item added into cart");
}
</script>
    
    <!--  <form:form commandName="CartItem" method="post" action="viewcart">-->
        <div class="page-header">
            <h1>Product Detail</h1>


            <p class="lead">Here is the detail information of the product:</p>
        </div>

        <div class="container" ng-app = "cartApp">
            <div class="row">
                <div class="col-md-5">
                  <!-- <img src="<c:url value="/resources/images/${product.productId}.jpg" />" alt="image" style="width:100%"/> -->
                    <img src='<x:url value="/resources/images/${chair.image}"/>'/>
                </div>
                <div class="col-md-5">
                
                    <h3><strong>Name</strong>:${chair.chairName}</h3>
                    <p><strong>Desc</strong> : ${chair.chairDesc}</p>
                    <p><strong>Warranty</strong>: ${chair.warranty}</p>
                    <p><strong>Style</strong>: ${chair.chairStyle}</p>
                    <p><strong>Rs.</strong>${chair.chairPrice}</p>

                    <br/>

                    <c:set var = "role" scope="page" value="${param.role}" />
                    <c:set var = "url" scope="page" value="/product/productList/all" />
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>
                  <sec:authorize access="hasRole('ROLE_USER')">
                   <p ng-controller="cartCtrl">
                     <!--   <a href="<c:url value ="${url}" />" class="btn btn-default">Back</a> -->
                    <!--  <a href="ret" class="btn btn-default"><span class="glyphicon glyphicon-hand-right">Back</a>  -->                   
                    <a href="viewcart?chairId=${chair.chairId}" class="btn btn-warning btn-large" ng-click="myFunction()"><span class="glyphicon glyphicon-shopping-cart"></span>ADD TO CART</a>     
                      
                   
                      
                      <!-- <input type="submit" value="Order Now" class="btn"/>  -->
                     <!--   <a href="viewcart?chairId=${chair.chairId}" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a> -->
                    </p>
                    </sec:authorize>
                    
                </div>
            </div>
        </div>
        </form:form>
        <!-- <script src="<c:url value="/resources/js/controller.js" /> "></script> -->
        </div></div></html>
        




