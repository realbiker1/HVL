package oppgave1;

import java.io.IOException;
import org.apache.cxf.transport.commons_text.StringEscapeUtils;

import java.io.PrintWriter;

import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/handleliste")
public class handleliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!LoggInnUtil.erInnlogget(request)) {
			response.sendRedirect("logginn");
		}

		else {

			LinkedList<String> vogn = (LinkedList<String>) request.getSession().getAttribute("handlelisteSesjon");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=ISO-8859-1");

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<h2>" + "Min handleliste" + "</h2>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("</head>");

			out.println("<body>");
			out.println("<form action=\"handleliste\" method=\"post\">");
			out.println(" <input type=\"submit\" value=\"Legg til\" style=\"display: inline\">");
			out.println(" <input type=\"text\" name=\"nyVare\" style=\"display: inline\">");
			
			//Looper igjennom listen når varer blir lagt til
			for (String s : vogn) {
				out.println("<p>" + s + " <button type=\"submit\" value=\"" + s + "\" name=\"slett\"> Slett </button>"
						+ "</p>");

			}

			out.println("</body>");
			out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!LoggInnUtil.erInnlogget(request)) {
			response.sendRedirect("logginn");
		} else {
			Validator validator = new Validator();
			// Varer som legges til i handleliste
			// Ufarliggjøring av brukerinput
			String vareInn = StringEscapeUtils.escapeHtml4(request.getParameter("nyVare"));
			// Varer som slettes fra handleliste
			// Ufarliggjøring av brukerinput
			String vareUt = StringEscapeUtils.escapeHtml4(request.getParameter("slett"));
			HttpSession sesjon = request.getSession();

			// Opptatering av handlelisten
			LinkedList<String> vogn = (LinkedList<String>) sesjon.getAttribute("handlelisteSesjon");
			if (validator.validVareInn(vareInn)) {
				vogn.add(vareInn);
			} else if (validator.validVareUt(vareUt)) {
				if (!vogn.isEmpty())
					vogn.remove(vareUt);
			}

			response.sendRedirect("handleliste");
		}

	}
}
