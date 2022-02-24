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
import in.sts.webappgradle.dao.GuestDao;
import in.sts.webappgradle.model.Booking;
import in.sts.webappgradle.model.Guests;


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
		HttpSession session = request.getSession();
		int bookingId=BookingDao.getLastId();
		String username=request.getParameter("username");
		String date=request.getParameter("date");
		String location=request.getParameter("location");
		String hotel=request.getParameter("hotel");
		int stay=Integer.parseInt(request.getParameter("stay"));
		int guest=Integer.parseInt(request.getParameter("guest"));
		ArrayList<Guests> guestList= new ArrayList<Guests>();
		
		for(int i=1;i<=guest;i++) {
			Guests guests= new Guests() ;
			String guestNo=request.getParameter("guest"+i+"");
			String guestFirstName=request.getParameter("firstname"+i+"");
			String guestLastName=request.getParameter("lastname"+i+"");
			String gender=request.getParameter("gender"+i+"");
			int age=Integer.parseInt(request.getParameter("age"+i+""));
			guests.setBookingid(bookingId);
			guests.setGuest(guestNo);
			guests.setFirstname(guestFirstName);
			guests.setLastname(guestLastName);
			guests.setGender(gender);
			guests.setAge(age);
			guestList.add(guests);
		}
		for(Guests gues:guestList) {
		System.out.println( gues.getBookingid()+"  "+gues.getFirstname()+"  "+gues.getGender()+" "+gues.getAge()+" "+gues.getLastname()+" "+gues.getGuest());
		}
		GuestDao.insertGuest(guestList);
		

		try {
			Booking bookingModel=new Booking();
			
			bookingModel.setUserid((Integer)session.getAttribute("userid"));
			bookingModel.setUsername(username);
			bookingModel.setDate(date);
			bookingModel.setLocation(location);
			bookingModel.setHotel(hotel);
			bookingModel.setStay(stay);
			bookingModel.setGuest(guest);

			ArrayList<Booking> bookingList=new ArrayList<>();
			bookingList.add(bookingModel);
			BookingDao.saveBooking(bookingList);



		}
		catch (Exception e) {
			// TODO: handle exception
		}


		response.sendRedirect("booked.jsp");
	}

}
