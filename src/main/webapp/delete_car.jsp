<%@page import="com.jspiders.CarDekho_Servlets.jdbc.CarJdbc"%>
<%@page import="com.jspiders.CarDekho_Servlets.Object.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	List<Car> cars = CarJdbc.SearchAll();

	if (cars != null && cars.size() > 0) {
	%>
	<div align="center">
		<table border="1px solid" bordercolor="#ff00ff">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Price</th>
			</tr>

			<%
			for (Car car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getPrice()%></td>
			</tr>

			<%
			}
			%>
		</table>
	</div>

	<%
	} else {
	%>
	<div align="center">
		<h4>Car details unavailable</h4>
	</div>
	<%
	}
	%>


	<br>


	<div align="center">

		<form action="delete_car" method="post">


			<table border="1px solid black">

				<tr>

					<td>Id</td>
					<td><input type="text" name="id"></td>

				</tr>

			</table>

			<input type="submit" value="Delete">




		</form>

		<br>


	</div>

	<%!String message;%>
	<%
	message = (String) request.getAttribute("message");
	%>
	<div align="center">
		<%
		if (message != null) {
		%>
		<h4><%=message%>
		</h4>
		<%
		}
		%>
	</div>



</body>
</html>