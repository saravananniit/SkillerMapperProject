package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
//		ResultSet resultSet = null;
		Statement statement = null;

		try {
			System.out.println("welcome");
		Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/./sample/test", "sa", "");
			statement = connection.createStatement();
			String query="insert into test values(899,'ramas')";
			//resultSet = statement.executeQuery("SELECT EMPNAME FROM EMPLOYEEDETAILS");
			//while (resultSet.next()) {
				//System.out.println("EMPLOYEE NAME:"
					//	+ resultSet.getString("EMPNAME"));
			//}
			
			statement.execute(query);
			System.out.println("sucess");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			//	resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	}


