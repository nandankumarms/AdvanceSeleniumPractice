package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDBTestSelectQuery {
	public static void main(String[] args) throws SQLException {
		String expectedTestCaseName="CreateORG";
		
		//Step1 : Load and register the Driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	
		//Establish the connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
		
		
		try {
			//Create Statement and execute query.
		    ResultSet result=connection.createStatement().executeQuery("select * from project");
		
		    //Print the data returned by executeQuery
		    result.next();
		    
		   String actualTestCaseName=result.getString(2);
		   
		   System.out.println(expectedTestCaseName+" "+ actualTestCaseName);
		   
		} catch (Exception e) {
			
		}
		
		
	   finally {
		 //Close database connection
		   connection.close();
	}
	   
	   
	   //Validate the expected tc_name with actual test case name
	   // Use try catch finally and write the proper optimized program for JDBC
	
	}}
		
		
