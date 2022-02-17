package in.sts.webappgradle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import in.sts.webappgradle.model.Booking;
import in.sts.webappgradle.model.Login;
import in.sts.webappgradle.mysqlconnection.MysqlConnection;

public class BookingDao {

	static int result=0;
	final static Logger logger =Logger.getLogger(BookingDao.class);
	public static void bookingDao(ArrayList<Booking> bookingList)
	{

		Login login = new Login();

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
					login.setBooking(booking);
					preparedStatement.setInt(1,LoginDao.getUserId());
					preparedStatement.setString(2,login.getBooking().getUsername());
					preparedStatement.setString(3,login.getBooking().getDate());
					preparedStatement.setString(4, login.getBooking().getLocation());
					preparedStatement.setString(5,login.getBooking().getHotel());
					preparedStatement.setInt(6, login.getBooking().getStay());
					preparedStatement.setInt(7, login.getBooking().getGuest());
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
					Booking bookingModel=new Booking(username,date,location,hotel,stay,guest);

					bookingDeatilsList.add(bookingModel);


				}


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


		return bookingDeatilsList;


	}

}
