package practice_datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class SampleTestDataBase {

	public static void main(String[] args) throws SQLException {
		
	//	Connection conn=null;
		
		//try {
		//step 1: load/register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		//step 2 : connect to database
		 Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		System.out.println("===========Done============");
		//step 3 : create Sql statement
		Statement stat = conn.createStatement();
		//step 4 : execute select query & get result
		
		ResultSet resultset = stat.executeQuery("select * from project");
		while(resultset.next()) {
			System.out.println(resultset.getString(1) + "\t" +resultset.getString(2)+"\t"+resultset.getString(3));
		}
		//}//catch(Exception e){
		//	System.out.println("handle exception");
		/*	}
		finally {
			//step 5: close the connection
			conn.close();
			System.out.println("==========Close the connection=======");
		}
		//resultset.next();*/
		//step 5: close the connection
		conn.close();
		
		
	}
}
											