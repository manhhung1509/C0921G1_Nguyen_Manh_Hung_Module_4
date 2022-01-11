<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Customer</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/form_insert.css">
    <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css">
</head>
<body>
<div class="container contact">
    <div class="row">
        <div class="col-md-3">
            <div class="contact-info">
                <img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
                <h2>Update Customer</h2>
                <h4>We would love to hear from you !</h4>
            </div>
        </div>
        <div class="col-md-9" style="padding-top: 5px">
            <form action="/updateCustomer" method="post">
                <div class="contact-form">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="cId">Customer Id:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cId" name="cId" value="${customer.id}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="name">Customer Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" value="${customer.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="email">Email:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email" name="email" value="${customer.email}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="address">Address:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="address" name="address" value="${customer.address}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <span><input type="submit" name="action" value="update" class="btn btn-default"></span>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>