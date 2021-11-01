package oppgave1;

public class Validator {

	// Validering for robust brukerinput (tom streng) for varer
	// som blir lagt til i handleliste
	public boolean validVareInn(String streng) {

		return streng != null && !streng.equals("") && !streng.matches("\\s+");
	}

	// Validering for varer som blir slettet fra handleliste
	public boolean validVareUt(String streng) {

		return streng != null && !streng.equals("");
	}

}