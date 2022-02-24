package in.sts.webappgradle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import in.sts.webappgradle.model.Booking;
import in.sts.webappgradle.mysqlconnection.MysqlConnection;

public class BookingDao {

	static int result=0;
	final static Logger logger =Logger.getLogger(BookingDao.class);
	public static void saveBooking(ArrayList<Booking> bookingList)
	{

		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try
		{



			connection=MysqlConnection.connectivity();
			String query="insert into booking values(bookingId,?,?,?,?,?,?,?)";
			preparedStatement=MysqlConnection.preparedstatement(query);

			if(connection==null) {
				logger.error("MySQLconnection Not found");
			}



			if(preparedStatement!=null) {

				for(Booking booking:bookingList) {
					
					preparedStatement.setInt(1,booking.getUserid());
					preparedStatement.setString(2,booking.getUsername());
					preparedStatement.setString(3,booking.getDate());
					preparedStatement.setString(4, booking.getLocation());
					preparedStatement.setString(5,booking.getHotel());
					preparedStatement.setInt(6, booking.getStay());
					preparedStatement.setInt(7,booking.getGuest());
					result=preparedStatement.executeUpdate();

				}
			}
			else if(result!=0) {
				logger.info("Details SuccessFully Inserted");
			}
			logger.info("Details SuccessFully Inserted");

		}
		catch(SQLException sqlException) {
			logger.error("SqlConnection Not found");
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

	public static ArrayList<Booking> getAllBookingDeatails(int userId){

		ArrayList<Booking> bookingDeatilsList= new ArrayList<Booking>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result;
		try
		{

			connection=MysqlConnection.connectivity();
			String query="select name,date,location,hotel,stay,guest from booking where userId=?";
			preparedStatement=MysqlConnection.preparedstatement(query);
			if(preparedStatement!=null) {


				preparedStatement.setInt(1,userId);

				result=preparedStatement.executeQuery();

				while(result.next()) {
					String username=result.getString("name");
					String date=result.getString("date");
					String location=result.getString("location");
					String hotel=result.getString("hotel");
					int stay=result.getInt("stay");
					int guest=result.getInt("guest");
					Booking bookingModel=new Booking(userId,username,date,location,hotel,stay,guest);

					bookingDeatilsList.add(bookingModel);


				}


			}


			logger.info("BookingDetails SuccessFully Fetched");


		}
		catch(SQLException sqlException) {
			logger.error("SqlConnection Not found");
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


		return bookingDeatilsList;
		

	}
	
	public static Integer getLastId() {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result;
		int id=0;
		try
		{



			connection=MysqlConnection.connectivity();
			String query="SELECT bookingid FROM booking WHERE bookingid = (SELECT MAX(bookingid) FROM booking)";
			preparedStatement=MysqlConnection.preparedstatement(query);

			if(connection==null) {
				logger.error("MySQLconnection Not found");
			}
			result=preparedStatement.executeQuery();
			
			while(result.next()) {
				id=result.getInt("bookingid");
				id=id+1;
				return id;
			}
	
			 if(result!=null) {
				logger.info("Details SuccessFully Inserted");
			}
			logger.info("Details not Inserted");

		}
		catch(SQLException sqlException) {
			logger.error("SqlConnection Not found");
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
		return id;
	}

}
