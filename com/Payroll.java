package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Payroll {
	public static void main(String args[]){  
		try{  
					
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		System.out.println("loaded");
		
		final String url = "jdbc:mysql://localhost:3306/payroll_service";
		final String userName = "root";
		final String password = "Mysql";
		
	
		Connection con=DriverManager.getConnection(url,userName,password); 
		System.out.println("Connected with db...");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee_payroll" );  
		
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("Name")+" "+rs.getString("Gender"));  
		}
		
		con.close();  			
		}catch(Exception e){ System.out.println(e);}  
		}  
}
