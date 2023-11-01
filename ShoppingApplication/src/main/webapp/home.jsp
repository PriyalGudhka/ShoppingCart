<%-- 
    Document   : home
    Created on : Feb 7, 2023, 12:23:19 PM
    Author     : priyalgudhka
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Items Available</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body style="background-color:#D3D3D3;">
        <div style=" width: 100%; text-align: center ">
            <form method="GET" action="HomePage">
                <nav class="navbar navbar-dark bg-dark justify-content-center">
                    <input class="mr-5 btn btn-info" type="submit" value="Books" name="itemsPurchased"/>
                    <input class="mr-5 btn btn-info" type="submit" value="Laptops" name="itemsPurchased"/>
                    <input class="mr-5 btn btn-info" type="submit" value="CDs" name="itemsPurchased"/>
                </nav>
            </form>
        </div>
        <div style=" width: 100%; text-align: center ">
            <form method="get" action="HomePage"> <br>                                
                <c:forEach var="item" items="${sessionScope.itemsAdded}">
                    <div class="col-md-12">
                        <input  type="checkbox" name="addItem" value="${item}">
                        <c:out value="${item}" />
                    </div>
                    <br>
                </c:forEach>
                <c:if test = "${sessionScope.itemsAdded.size() < 1}">
                    <h3> Add Items to your shopping bag by clicking on Continue Shopping</h3>
                </c:if>
                <div style="text-align: center">
                    <c:if test = "${sessionScope.itemsAdded.size() > 0}">
                        <br> <input class="btn btn-info" type="submit" value="ADD TO BAG">
                    </c:if>
                    <div>
                        <br><br> <h4 style="text-align: center;"><a href="cart" class="badge badge-info text-white pt-2 pb-2 pl-2 pr-2" >VIEW BAG</a></h4><br>                       
                    </div>
            </form>
        </div>
    </div>
</body>
</html>
