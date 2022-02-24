package in.sts.webappgradle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.sts.webappgradle.dao.UsersDao;
import in.sts.webappgradle.model.Users;


@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		HttpSession session = request.getSession();
		
		int userid=	(int) session.getAttribute("userid");
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		int age=Integer.parseInt(request.getParameter("age"));
	
		String email=request.getParameter("email");
		BigDecimal phoneno=new BigDecimal(request.getParameter("phoneno"));
		String location=request.getParameter("location");
		BigDecimal pincode=new BigDecimal(request.getParameter("pincode"));

		Users usersModel=new Users();
		usersModel.setUserid(userid);
		usersModel.setUsername(firstname);
		usersModel.setLastname(lastname);
		usersModel.setAge(age);
		usersModel.setEmail(email);
		usersModel.setPhoneno(phoneno);
		usersModel.setLocation(location);
		usersModel.setPincode(pincode);

		ArrayList<Users> usersList=new ArrayList<Users>();
		usersList.add(usersModel);

		UsersDao.updateUser(usersList);


		out.println("<div align=\"center\">\r\n"
				+ "		<h2 style=\"font-style: italic;\">\r\n"
				+ "			 <span style=\"color: red; font-style: italic;\">Edit Profile Succesful please login again</span>\r\n"
				+ "		</h2>\r\n"
				+ "	</div>");
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
		requestDispatcher.include(request, response);

	}

}
