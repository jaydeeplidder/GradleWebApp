package in.sts.webappgradle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import in.sts.webappgradle.model.SignUp;
import in.sts.webappgradle.mysqlconnection.MysqlConnection;


public class SignUpDao {
	static int result=0;
	final static Logger logger=Logger.getLogger(SignUpDao.class);
	public static void insertToSignUpDao(ArrayList<SignUp> signupList)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try
		{

			connection=MysqlConnection.connectivity();
			String query="insert into signup values(userId,?,?,?,?,?,?)";
			preparedStatement=MysqlConnection.preparedstatement(query);

			if(connection==null) {
				logger.info("Connection problem");
			}


			if(preparedStatement!=null) {

				for(SignUp sign:signupList) {

					preparedStatement.setString(1,sign.getUsername());
					preparedStatement.setString(2,sign.getEmail());
					preparedStatement.setString(3,sign.getPassword());
					preparedStatement.setBigDecimal(4, sign.getPhoneno());
					preparedStatement.setString(5,sign.getLocation());
					preparedStatement.setBigDecimal(6, sign.getPincode());

					result=preparedStatement.executeUpdate();

				}
			}
			else if(result!=0) {
				logger.info("Details SuccessFully Inserted");
			}
			logger.info("Details SuccessFully Inserted");

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

}
