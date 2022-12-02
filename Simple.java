
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
public class Simple{

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//step1 : Load and register the Driver
		
		/*
		 * A third party DB vendor class which implements java.sqlDriver(1) is called "Driver".
		 * 
		 * This class object 
		 */
		
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		System.out.println("Driver registerd successfully");
		
		String url="jdbc:mysql://127.0.0.1:3306/?user=root";
		String username="root";
		String password="root";
		
		Connection connection = DriverManager.getConnection(url,username,password);
		
		//jdbc:mysql://127.0.0.1:3306/?user=root
		
		System.out.println("Connection object is created :: "+connection);
		
		System.out.println("Implementation class name of connection is :: "+connection.getClass().getName());
	
		//create statement object
		
		Statement statement = connection.createStatement();
		
		System.out.println("Statement object is created :: "+statement);
		
		String sqlSelectQuery="select SID,SNAME,SAGE,SADDR from  enterprisejava.student";
		
		ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
		
		System.out.println("resultSet object is created :: " +resultSet);
		
		System.out.println("SID		SNAME		SAGE	ADDR");	
		
		while(resultSet.next())
		{
			Integer id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			Integer age = resultSet.getInt(3);
			String add = resultSet.getString(4);
			
			System.out.println(id+"\t\t"+name+"\t\t"+age+"\t\t"+add);
		}
		
		connection.close();
		
		System.out.println("Connection closed");
		
	}

}
