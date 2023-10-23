package src.main.java.com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import src.main.java.com.connection.DbConnection;
import src.main.java.com.dao.UserDao;
import src.main.java.com.dto.User;

@WebServlet("/userLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -912817062678620507L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try(PrintWriter out = resp.getWriter())
		{
			String email = req.getParameter("loginEmail");
			String password = req.getParameter("loginPassword");
			
			try
			{
				UserDao dao = new  UserDao(DbConnection.getConnection());
				User user = dao.userLogin(email, password);
				if( user == null )
				{
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
					requestDispatcher.include(req, resp);
					out.print("Login Unsuccessfull");
				}
				else
				{
					HttpSession session = req.getSession();
					session.setAttribute("auth", user);
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
					requestDispatcher.forward(req, resp);
				}
			}
			catch (Exception e)
			{
				out.print(e.getMessage()) ;
			}
		}
		
		
		
	}

}
