import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dist")
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		
		Writer out = resp.getWriter();
		out.write("<body>");
		out.write("<FORM METHOD=POST>");
		out.write("p1lat : <INPUT NAME=\"p1lat\">");
		out.write("p1lng : <INPUT NAME=\"p1lng\"> <BR>");
		out.write("p2lat : <INPUT NAME=\"p2lat\">"); 
		out.write("p2lng : <INPUT NAME=\"p2lng\"> <br>");
		out.write("<input type=submit value=\"envoi\"></form>");

		out.write("</body");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {

		double p1lat = Double.parseDouble((String) req.getParameter("p1lat"));
		double p1lng = Double.parseDouble((String) req.getParameter("p1lng"));
		double p2lat = Double.parseDouble((String) req.getParameter("p2lat"));
		double p2lng = Double.parseDouble((String) req.getParameter("p2lng"));

		double R = 6371;
		double phi1 = p1lat * Math.PI/180;
		double phi2 = p2lat * Math.PI/180;

		double deltaphi = (p2lat - p1lat) * Math.PI/180;
		double deltalambda = (p2lng - p1lng) * Math.PI/180;

		double a = Math.sin(deltaphi/2) * Math.sin(deltaphi/2) +
			Math.cos(phi1) * Math.cos(phi2) * 
			Math.sin(deltalambda/2) * Math.sin(deltalambda/2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		double d = R * c;

		
		Writer out = resp.getWriter();
		out.write("<body>");
		out.write("distance : " + Math.round(d * 10.0)/10.0);
		out.write("</body>");
	}

}
