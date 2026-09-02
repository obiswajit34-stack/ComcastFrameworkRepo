package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
Connection con;
	public void getDbconnection(String url , String username , String password) throws SQLException {
		try {
			
		
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		con=DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			
		}
	}
	public void getDbconnection() throws SQLException {
		try {
			
		
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		con=DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		}catch(Exception e) {
			
		}
	}
	
	public void closeDbconnection() throws SQLException {
		try {
           con.close();
		}catch(Exception e){
			
		}
	}
	
	public boolean executeQuery(String query) throws SQLException {

	    Statement stat = con.createStatement();

	    boolean result = stat.execute(query);

	    return result;
	}
	
	public ResultSet excuteSelectQuery(String query) throws SQLException {
		ResultSet result =null;
		try {
		Statement stat = con.createStatement();
		
	 result = stat.executeQuery(query);
		}catch(Exception e ) {
			
		}
		
		return result;
	}
	
	public int excuteNonselectQuery(String query) {
		int result =0;
		try {
			Statement stat = con.createStatement();
			result=stat.executeUpdate(query);
		}catch(Exception e) {
			
		}
		return result;
	}
}
