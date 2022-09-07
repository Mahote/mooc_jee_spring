import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	// TODO : only handle POST request for authentication
	// @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		// TODO : get login / password from request parameters
		String login = req.getParameter("login");

		String password = req.getParameter("password");
		
		if ( login == null || password == null ) throw new ServletException("no login/password");
		boolean succeed = "admin".equals(login) && "admin".equals(password);
		
		// TODO : if auth is OK, 
		  // add something in session for next calls, 
		  // then redirect to "welcome.jsp"
		if(succeed){
			RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
			req.getSession().setAttribute("logged",(boolean) true); 
			rd.forward(req,resp);

		} else {
			RequestDispatcher rd = req.getRequestDispatcher("auth.jsp");
			req.setAttribute("errorMessage", "wrong credential");
			rd.forward(req,resp);
		}
		// TODO : if auth KO
		  // set an "errorMessage" in request attribute
		  // forward to auth.jsp with request dispatcher

	}
	
	// TODO : allow to disconnect with a GET to /auth with any parameter "logout" value
	// @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
	  HttpSession session = req.getSession();
	  String logout = req.getParameter("logout");
	  if (logout != null){
		session.setAttribute("logged", (boolean) false);
		req.setAttribute("logout", "logout");
		RequestDispatcher rd = req.getRequestDispatcher("auth.jsp");
		rd.forward(req,resp);
	  }
	  resp.sendError(500);
	}

}