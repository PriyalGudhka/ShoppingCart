<%-- 
    Document   : cart
    Created on : Feb 7, 2023, 12:22:29 PM
    Author     : priyalgudhka
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchased Items</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body style="background-color:#D3D3D3;">
        <div style="text-align: center">
            <h3 style="text-align: center">Items Added to Shopping Bag</h3>    
            <form method="post" action="HomePage">
                <div text-align: center">
                    <c:forEach var="item" items="${sessionScope.bagItems}">
                        <input  type="checkbox" name="removedItems" value="${item}" />
                        <c:out value="${item}" /><br>
                    </c:forEach>
                    <c:if test = "${sessionScope.bagItems.size() < 1 || sessionScope.bagItems == null}">
                        <h3> Add Items to Shopping Bag</h3>
                    </c:if>
                </div>
                <div style="text-align: center">
                    <c:if test = "${sessionScope.bagItems.size() > 0}">
                        <input type="submit" value="Delete Item">
                    </c:if>
                </div>
            </form>
            <div style="text-align: center">
                <h2><a href="home">Continue Shopping?</a><br></h2>
            </div>

        </div>
    </body>
</html>
