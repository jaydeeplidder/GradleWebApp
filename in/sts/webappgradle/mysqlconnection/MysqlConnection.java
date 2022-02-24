package in.sts.webappgradle.mysqlconnection;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MysqlConnection  {

	static Connection connect;
	static PreparedStatement ptsmt;
	public static Connection connectivity() throws Exception {

		

		Context context= new InitialContext();
		DataSource dataSource= (DataSource)context.lookup("java:comp/env/jdbc/UsersDB");
		connect=dataSource.getConnection();

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
