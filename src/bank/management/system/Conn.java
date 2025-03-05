package bank.management.system;
import java.sql.*;
public class Conn {
	
	Connection c;
	Statement s;
	//craete Connection
	public Conn(){
		try {
			c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "shailu");
			s = c.createStatement();
			
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
