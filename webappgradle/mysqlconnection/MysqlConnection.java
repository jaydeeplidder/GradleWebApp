package in.sts.webappgradle.mysqlconnection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlConnection  {

	static Connection connect;
	static PreparedStatement ptsmt;
	public static Connection connectivity() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/hotel";
		String user="root";
		String pass="root";


		connect=DriverManager.getConnection(url,user,pass);

		if(connect!=null) {

			System.out.println("connection Successful");
			return connect;
		}
		System.out.println("Not connected");
		return connect;
	}



	public static PreparedStatement preparedstatement(String Query) throws SQLException
	{

		return ptsmt=connect.prepareStatement(Query);
	}

	public static void closeMysqlconnection() throws SQLException
	{
		if(ptsmt!=null)
		{
			ptsmt.close();
		}
		if(connect!=null)
		{
			connect.close();
		}
		System.out.println("Connection closed");
	}

}
