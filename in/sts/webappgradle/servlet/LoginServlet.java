package in.sts.webappgradle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import in.sts.webappgradle.dao.UsersDao;
import in.sts.webappgradle.model.Login;
import in.sts.webappgradle.model.Users;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		Logger logger=Logger.getLogger(LoginServlet.class);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username").trim();

		String password=request.getParameter("password").trim();
		try {
			Login login=new Login();
			login.setUsername(username);
			login.setPassword(password);

			UsersDao usersDao=new UsersDao();

			HttpSession session = request.getSession();


			ArrayList<Users> userDetails=usersDao.loginUser(username,password);// return the userId;
			int userId=0;
			for(Users user: userDetails) {
				userId=user.getUserid();
			}
			if(userId!=0)
			{
				session.setAttribute("user", username);  
				session.setAttribute("userid",userId);
				session.setAttribute("userdetails",userDetails);
				
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");  
				requestDispatcher.forward(request, response);  

			}
			else
			{

				out.println("<div align=\"center\">\r\n"
						+ "		<h2 style=\"font-style: italic;\">\r\n"
						+ "			 <span style=\"color: red; font-style: italic;\">Incorrect username or password!!</span>\r\n"
						+ "		</h2>\r\n"
						+ "	</div>");
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
				requestDispatcher.include(request, response);
				//		    	response.sendRedirect("login.jsp");
			}
		} 
		catch(Exception e){
			logger.error("Exception Found");
		}
	}

}
