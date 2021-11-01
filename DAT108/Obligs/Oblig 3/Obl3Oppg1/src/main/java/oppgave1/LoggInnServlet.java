package oppgave1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logginn")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String errorMessage = "Gi inn passord:";
		String errorCode = request.getParameter("error");

		if (errorCode != null && errorCode.equals("invalidusername")) {
			errorMessage = "Passordet du ga inn var feil, prøv igjen:";
		}
		
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(errorMessage);
		out.println("<form action=\"logginn\" method=\"post\">");
		out.println("  <fieldset>");
		out.println("    <p><input type=\"text\" name=\"passord\"></p>");
		out.println("    <p><input type=\"submit\" value=\"Logg inn\"></p>");
		out.println("  </fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String passord = request.getParameter("passord");

    	//Innlogging validering
		if (!LoggInnUtil.erGyldigPassord(passord, "pwd123")) {
			//Bruker hidden-parameter for errormelding
			response.sendRedirect("logginn" + "?error=invalidusername");
			
		}
		else {
			LoggInnUtil.loggUt(request);
			LoggInnUtil.loggInn(request);
			response.sendRedirect("handleliste");
			
		}
	}
}

