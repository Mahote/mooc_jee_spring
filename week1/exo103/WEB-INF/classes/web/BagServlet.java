package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

// TODO: this class should extends something to be a usable servlet.
// TODO: add an annotation here to map your servlet on an URL.
@WebServlet("/bag")
public class BagServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.write("<body>");
		out.write("<form method=\"post\">");
		out.write("ref : <input name=\"ref\"> <BR>");
		out.write("qty : <input name=\"qty\"> <BR>");
		out.write("<input type=\"submit\" value=\"envoi\"></form>"); 
		Bag bag = (Bag) req.getSession().getAttribute("Bag");
		if(!(bag == null)){
			bag.print(out);
		}
		
		out.write("</body>");
		
		// TODO : print a html form using printwriter.
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String ref = req.getParameter("ref");
		String qty = req.getParameter("qty");
		int qtyint = 0;
		if(ref == null || ref.isEmpty()){
			res.sendError(400);
		}
		try{
				qtyint = Integer.valueOf(qty);
			}
		catch(NumberFormatException e){
				res.sendError(400);
			}
		if(qty == null || qty.isEmpty()){
			res.sendError(400);
		}
		HttpSession session = req.getSession();
		Bag bag = (Bag) session.getAttribute("Bag");
		if(bag == null){
			bag = new Bag();
			session.setAttribute("Bag", bag);
		}
		bag.setItem(ref,qtyint);
		res.sendRedirect(req.getContextPath()+"/bag");

	}
	
	
	

}
