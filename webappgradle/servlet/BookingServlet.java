package in.sts.webappgradle.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.sts.webappgradle.dao.BookingDao;

import in.sts.webappgradle.model.Booking;
import in.sts.webappgradle.model.Login;


@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();


		ArrayList<Booking> bookingDetailsList=BookingDao.getAllBookingDeatails((Integer)session.getAttribute("userid"));
		session.setAttribute("bookingDetailsList", bookingDetailsList);

		for(Booking b:bookingDetailsList) {
			System.out.println(b.getUsername());
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("checkbooking.jsp");
		requestDispatcher.include(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String date=request.getParameter("date");
		String location=request.getParameter("location");
		String hotel=request.getParameter("hotel");
		int stay=Integer.parseInt(request.getParameter("stay"));
		int guest=Integer.parseInt(request.getParameter("guest"));

		try {
			Booking bookingModel=new Booking();
			Login loginModel=new Login();
			loginModel.setBooking(bookingModel);
			loginModel.getBooking().setUsername(username);
			loginModel.getBooking().setDate(date);
			loginModel.getBooking().setLocation(location);
			loginModel.getBooking().setHotel(hotel);
			loginModel.getBooking().setStay(stay);
			loginModel.getBooking().setGuest(guest);

			ArrayList<Booking> bookingList=new ArrayList<>();
			bookingList.add(loginModel.getBooking());
			BookingDao.bookingDao(bookingList);



		}
		catch (Exception e) {
			// TODO: handle exception
		}


		response.sendRedirect("booked.jsp");
	}

}
