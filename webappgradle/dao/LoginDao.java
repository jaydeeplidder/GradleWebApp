package in.sts.webappgradle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import in.sts.webappgradle.model.Login;
import in.sts.webappgradle.mysqlconnection.MysqlConnection;

public class LoginDao {
	final static Logger logger=Logger.getLogger(LoginDao.class);
	static ArrayList<Login> setloginList= new ArrayList<Login>();
	public Integer loginDao(String username,String password) 
	{	
		int userid = 0;
		Connection connection=null;
		String query="select  userId as user,name as username,email as E from signup where name=? and password=?";
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		try
		{
			connection=MysqlConnection.connectivity();
			preparedStatement=MysqlConnection.preparedstatement(query);

			if(preparedStatement!=null) {


				preparedStatement.setString(1,username);
				preparedStatement.setString(2,password);
				result=preparedStatement.executeQuery();

				while(result.next()) {


					logger.info(result.getInt("user"));

					userid=result.getInt("user");
					String user=result.getString("username");

					String email=result.getString("E");

					Login loginModel=new Login(userid,user,email);
					setloginList.add(loginModel);



					return userid;



				}


			}


			logger.info("Details SuccessFully Inserted");

		}
		catch(SQLException sqlException) {
			logger.error("Sql connection error!! found");

		}
		catch (Exception e) {
			logger.error("Exception error!! found");
		}
		finally {
			try {
				preparedStatement.close();
			} catch (SQLException sqlException) {
				logger.warn("preparedStatement not closed");
			}
			try {
				connection.close();
			} catch (SQLException sqlException) {
				logger.warn("MysqlConnection not closed");
			}

		}
		return userid;

	}

	public static  Integer getUserId(){
		int UserId=0;
		for(Login login:setloginList) {
			UserId=login.getUserid();
		}
		if(UserId!=0) {
			setloginList.clear();
		}
		return UserId;



	}



}
