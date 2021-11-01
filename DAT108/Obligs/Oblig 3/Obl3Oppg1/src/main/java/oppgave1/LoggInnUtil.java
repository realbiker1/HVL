package oppgave1;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggInnUtil {


	public static boolean erInnlogget(HttpServletRequest request ) {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("passord") != null;
	}

	public static void loggInn(HttpServletRequest request) {

		loggUt(request);
		
		HttpSession sesjon = request.getSession();
		sesjon.setAttribute("passord", "passord");
		// Logges ut etter 45 sekunder
		sesjon.setMaxInactiveInterval(45);
		// Oppretter en ny liste hver gang man logger inn
		sesjon.setAttribute("handlelisteSesjon", new LinkedList<String>());
	}

	public static void loggUt(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
	}
	public static boolean erGyldigPassord(String passord, String korrektPassord) {
		return passord != null && passord.equals(korrektPassord);
	}

}



