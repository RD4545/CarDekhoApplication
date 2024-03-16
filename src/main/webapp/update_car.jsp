<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Car Details</title>
</head>
<body>

	

    <div align="center">
        <h4>Update Car Details</h4>
        <form action="update_car" method="post">
            <table border="1">
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Brand</td>
                    <td><input type="text" name="brand"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price"></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Update">
        </form>
    </div>
   
    <div align="center">
        <% String message = (String)request.getAttribute("message");
        if (message != null && !message.isEmpty()) { %>
            <h4><%= message %></h4>
        <% } %>
    </div>
</body>
</html>
