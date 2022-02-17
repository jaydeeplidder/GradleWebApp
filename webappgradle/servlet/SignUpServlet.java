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

import in.sts.webappgradle.dao.SignUpDao;
import in.sts.webappgradle.model.SignUp;


@WebServlet("/register")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username=request.getParameter("username");

		String password=request.getParameter("password");
		String email=request.getParameter("email");
		BigDecimal phoneno=new BigDecimal(request.getParameter("phoneno"));
		String location=request.getParameter("location");
		BigDecimal pincode=new BigDecimal(request.getParameter("pincode"));

		SignUp signupModel=new SignUp();

		signupModel.setUsername(username);
		signupModel.setEmail(email);
		signupModel.setPassword(password);
		signupModel.setPhoneno(phoneno);
		signupModel.setLocation(location);
		signupModel.setPincode(pincode);

		ArrayList<SignUp> signupList=new ArrayList<SignUp>();
		signupList.add(signupModel);

		SignUpDao.insertToSignUpDao(signupList);


		out.println("<div align=\"center\">\r\n"
				+ "		<h2 style=\"font-style: italic;\">\r\n"
				+ "			 <span style=\"color: red; font-style: italic;\">SignUp Successful Please Login</span>\r\n"
				+ "		</h2>\r\n"
				+ "	</div>");
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
		requestDispatcher.include(request, response);
	}

}
