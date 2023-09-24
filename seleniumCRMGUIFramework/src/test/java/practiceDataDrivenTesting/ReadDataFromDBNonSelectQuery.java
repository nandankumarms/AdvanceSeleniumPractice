package practiceDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDBNonSelectQuery {
	public static void main(String[] args) throws SQLException {
		//Step 1 : Load and register the drivers
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//Establish the connection between Java and Database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
		
		//Create statement
		Statement statement=con.createStatement();
		
		//Execute non select query
		int result=statement.executeUpdate("insert into project values(001,'CreateORG','FaceBook');");
		
		System.out.println(result);
	}

}
