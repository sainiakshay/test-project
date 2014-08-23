package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import TransferObjects.CategoriesTO;
import TransferObjects.UserTO;


public class MedicalPredictionDAO {
	
	public boolean insertLoginDetails(UserTO user){
		
		boolean isSuccess = true;
		String sql = "INSERT INTO Login (email, password) VALUES (?, ?)";
		Connection conn=null;
		String urn = "jdbc:mysql://localhost:3306/MedicalPredictionApp";
		
		try{
			java.lang.Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(urn,"root","testing123");
			PreparedStatement stmt = conn.prepareStatement(sql);
			//stmt.setString(1, user.getUserName());
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		}
		catch(SQLException e){
			isSuccess = false;
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}
	
		public String checkUserLogin(UserTO user){
				
				String sql = "SELECT * FROM Login where email = '"+ user.getEmail() +"' AND password = '"+user.getPassword()+"';";
				Connection conn=null;
				String urn = "jdbc:mysql://localhost:3306/MedicalPredictionApp";
				String userName = "";
				
				try{
					java.lang.Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection(urn,"root","testing123");
					PreparedStatement stmt = conn.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						userName = rs.getString("email");
					}
					rs.close();
					stmt.close();
					conn.close();
				}
				catch(SQLException e){
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return userName;
	}
	
	public void insertCategoriesTO(CategoriesTO cat){
		
		String sql = "INSERT INTO Categories (region,age,sex,year,noOfDeaths) VALUES (?, ?, ?, ?, ?)";
		Connection conn=null;
		String urn = "jdbc:mysql://localhost:3306/MedicalPredictionApp";
		
		try{
			java.lang.Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(urn,"root","testing123");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cat.getRegion());
			stmt.setString(2, cat.getAge());
			stmt.setString(3, cat.getSex());
			stmt.setDouble(4, cat.getYear());
			stmt.setDouble(5, cat.getNoOfDeaths());
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
