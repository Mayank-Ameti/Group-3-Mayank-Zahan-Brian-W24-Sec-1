package hotelManagementSystem;

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	public Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","Mayank@1672"); // Make sure to change with you MySQL workbench username and password
			s=c.createStatement();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}	
