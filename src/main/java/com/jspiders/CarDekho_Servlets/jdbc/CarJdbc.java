package com.jspiders.CarDekho_Servlets.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspiders.CarDekho_Servlets.Object.Car;

public class CarJdbc {

	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;

	private static void openConnection() throws SQLException {
		
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_dekho_servlet", "root", "root");
	}

	private static void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
		
	}

	public static int addCar(int id, String name, String brand, double price) {
		int res = 0;
		try {
			openConnection();
			
			query = "insert into cars values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, brand);
			preparedStatement.setDouble(4, price);
			res = preparedStatement.executeUpdate();
			System.out.println(res + " row(s) affected");
			
			closeConnection();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}
	
	public static List<Car>  SearchAll() {
		
		List<Car> cars = new ArrayList<>();
		
		try {
			
			openConnection();
			
			query = "select * from cars";
			preparedStatement= connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Car car = new Car();
				car.setId(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setPrice(resultSet.getDouble(4));

				cars.add(car);
				
			}
			closeConnection();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return cars;
		
	}
	
	 public static int updateCar(int id, String name, String brand, double price) {
	        
	        int rowsAffected=0;
	        try {
	            
	            openConnection();
	             
	            String sql = "UPDATE cars SET name = ?, brand = ?, price = ? WHERE id = ?";
	            
	            preparedStatement = connection.prepareStatement(sql);
	            
	            
	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, brand);
	            preparedStatement.setDouble(3, price);
	            preparedStatement.setInt(4, id);
	            
	            
	            rowsAffected = preparedStatement.executeUpdate();  
	            
	            closeConnection();
	            
	        } 
	        
	        catch (SQLException e) {
	            e.printStackTrace();
	          
	        }
	        return rowsAffected;
	    }
	 
	 
	 public static int deleteCar(int id) {
			int res = 0;
			try {
				openConnection();
				
				query = "delete from cars where id =? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				
				res = preparedStatement.executeUpdate();
				System.out.println(res + " row(s) affected");
				
				closeConnection();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			return res;

		}

	
}
