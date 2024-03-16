package com.jspiders.CarDekho_Servlets.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.CarDekho_Servlets.Object.Car;
import com.jspiders.CarDekho_Servlets.jdbc.CarJdbc;

@WebServlet("/search_car")
public class SearchAll extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Car> cars = CarJdbc.SearchAll();
		req.setAttribute("cars", cars);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("search_car.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	
}
