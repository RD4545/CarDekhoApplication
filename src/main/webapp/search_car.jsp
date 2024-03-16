<%@page import="com.jspiders.CarDekho_Servlets.Object.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
body {
	display : flex;
	justify-content : center;
	align-items : center;
	height : 100vh;
	
	background-color: black;
	color: white;
}
</style>

</head>
<body>
	<%
	List<Car> cars = (List<Car>) request.getAttribute("cars");

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

</body>
</html>
