<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Cutomer</h1>


            <p class="lead">Customer Details:</p>
        </div>

         <h3>Basic Info:</h3>

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="user.name" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="user.mail" id="email" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="user.phone" id="phone" class="form-Control" />
        </div>

        <br/>

        <h3>Billing Address:</h3>

        <div class="form-group">
            <label for="streetName">Street Name</label>
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="apartmentNumber">Apartment Number</label>
            <form:input path="billingAddress.apartmentNumber" id="apartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="billingAddress.city" id="city" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="state">State</label>
            <form:input path="billingAddress.state" id="state" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="country">Country</label>
            <form:input path="billingAddress.country" id="country" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="zipCode">Zipcode</label>
            <form:input path="billingAddress.zipCode" id="zipCode" class="form-Control" />
        </div>

        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />

        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

        
