package in.sts.webappgradle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import in.sts.webappgradle.model.Guests;
import in.sts.webappgradle.mysqlconnection.MysqlConnection;

public class GuestDao {
	final static Logger logger =Logger.getLogger(GuestDao.class);
	public  static void insertGuest(ArrayList<Guests> guestList) {


			Connection connection=null;
			PreparedStatement preparedStatement=null;
			int result = 0;
			try
			{



				connection=MysqlConnection.connectivity();
				String query="insert into guest values(guestId,?,?,?,?,?,?)";
				preparedStatement=MysqlConnection.preparedstatement(query);

				if(connection==null) {
					logger.error("MySQLconnection Not found");
				}



				if(preparedStatement!=null) {

					for(Guests guest:guestList) {
						
						preparedStatement.setInt(1,guest.getBookingid());
						preparedStatement.setString(2,guest.getGuest());
						preparedStatement.setString(3,guest.getFirstname());
						preparedStatement.setString(4,guest.getLastname());
						preparedStatement.setString(5, guest.getGender());
						preparedStatement.setInt(6, guest.getAge());
					
						result=preparedStatement.executeUpdate();

					}
				}
				else if(result!=0) {
					logger.info("Details SuccessFully Inserted");
				}
				logger.info("Details not Inserted");

			}
			catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
			catch (Exception exception) {
				logger.error("Mysqlconnection error found");
			}
			finally {
				try {
					preparedStatement.close();
				} catch (SQLException sqlException) {
					logger.warn("PreparedStatement not closed");
				}
				try {
					connection.close();
				} catch (SQLException sqlException) {
					logger.warn("MySqlConnection not closed");
				}
			}

		
	}
		}
