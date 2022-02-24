package in.sts.webappgradle.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import in.sts.webappgradle.model.Users;
import in.sts.webappgradle.mysqlconnection.MysqlConnection;


public class UsersDao {
	static int result=0;
	final static Logger logger=Logger.getLogger(UsersDao.class);
	
	
	public static void insertUser(ArrayList<Users> userList)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try
		{

			connection=MysqlConnection.connectivity();
			String query="insert into users values(userId,?,?,?,?,?,?,?,?)";
			preparedStatement=MysqlConnection.preparedstatement(query);

			if(connection==null) {
				logger.info("Connection problem");
			}


			if(preparedStatement!=null) {

				for(Users users:userList) {

					preparedStatement.setString(1,users.getFirstname());
					preparedStatement.setString(2,users.getLastname());
					preparedStatement.setInt(3,users.getAge());
					preparedStatement.setString(4,users.getEmail());
					preparedStatement.setString(5,users.getPassword());
					preparedStatement.setBigDecimal(6, users.getPhoneno());
					preparedStatement.setString(7,users.getLocation());
					preparedStatement.setBigDecimal(8, users.getPincode());

					result=preparedStatement.executeUpdate();

				}
			}
			
			logger.info("Details SuccessFully SignedUp");

		}
		catch(SQLException sqlException) {
			logger.error("SQlException found");
		}
		catch (Exception e) {
			logger.error("Exception found");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.warn("Connection not closed");
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.warn("Preparedstatement not closed properply");
			}
		}
	}
	
	
	
	public ArrayList<Users> loginUser(String username,String password) 
	{	
		 ArrayList<Users> userDetails= new ArrayList<Users>();
		int userid = 0;
		Connection connection=null;
		String query="select * from users where firstname=? and password=?";
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


//					logger.info(result.getInt("user"));

					userid=result.getInt("userId");
					String firstname=result.getString("firstname");
					String lastname=result.getString("lastname");
					int age=result.getInt("age");
					String email=result.getString("email");
					String pass=result.getString("password");
					BigDecimal phoneno=result.getBigDecimal("phoneno");
					String location=result.getString("location");
					BigDecimal pincode=result.getBigDecimal("pincode");
					Users usersModel=new Users(userid,firstname,lastname,age,email,pass,phoneno,location,pincode);
					userDetails.add(usersModel);

					logger.info("Successfully Logged In");

					



				}


			}


			

		}
		catch(SQLException sqlException) {
			logger.error("Sql connection error!! found");

		}
		catch (Exception e) {
			e.printStackTrace();
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
		return userDetails;
	}

	

	public static void updateUser(ArrayList<Users> userList)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try
		{

			connection=MysqlConnection.connectivity();
			String query="update users set firstname=?,lastname=?,age=?,email=?,phoneno=?,location=?,pincode=? where userId=?";
			preparedStatement=MysqlConnection.preparedstatement(query);

			if(connection==null) {
				logger.info("Connection problem");
			}


			if(preparedStatement!=null) {

				for(Users users:userList) {

					preparedStatement.setString(1,users.getFirstname());
					preparedStatement.setString(2,users.getLastname());
					preparedStatement.setInt(3,users.getAge());
					preparedStatement.setString(4,users.getEmail());
					
					preparedStatement.setBigDecimal(5, users.getPhoneno());
					preparedStatement.setString(6,users.getLocation());
					preparedStatement.setBigDecimal(7, users.getPincode());
					preparedStatement.setInt(8, users.getUserid());
					result=preparedStatement.executeUpdate();

				}
			}
			
			logger.info("Details SuccessFully Updated");

		}
		catch(SQLException sqlException) {
			logger.error("SQlException found");
		}
		catch (Exception e) {
			logger.error("Exception found");
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.warn("Connection not closed");
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.warn("Preparedstatement not closed properply");
			}
		}
	}
	
	public static ArrayList<Users> getAllUses(){
		ArrayList<Users> getUsersList= new ArrayList<Users>();
		
		Connection connection=null;
		String query="select * from users ";
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		try
		{
			connection=MysqlConnection.connectivity();
			preparedStatement=MysqlConnection.preparedstatement(query);

		
				result=preparedStatement.executeQuery();

				while(result.next()) {


//					logger.info(result.getInt("user"));

					int userid=result.getInt("userId");
					String firstname=result.getString("firstname");
					String lastname=result.getString("lastname");
					int age=result.getInt("age");
					String email=result.getString("email");
					String pass=result.getString("password");
					BigDecimal phoneno=result.getBigDecimal("phoneno");
					String location=result.getString("location");
					BigDecimal pincode=result.getBigDecimal("pincode");
					Users usersModel=new Users(userid,firstname,lastname,age,email,pass,phoneno,location,pincode);
					getUsersList.add(usersModel);

				

				}
				logger.info("Got all the userDetails");

		}
		catch(SQLException sqlException) {
			logger.error("Sql connection error!! found");

		}
		catch (Exception e) {
			e.printStackTrace();
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

		return getUsersList;
		
	}
	
}
