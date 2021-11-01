package no.hvl.dat107;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/*
		 * Ting å prøve: 
		 * a) Hente ut todo med pk=2 
		 * b) Hente ut alle todos 
		 * c.i)   Hente ut SINGLE todo med tekst="Handle mat" 
		 * c.ii)  Hente ut SINGLE todo med tekst="Vaske bilen" (som ikke finnes) 
		 * c.iii) Hente ut LISTE av todos med tekst="Handle mat" 
		 * c.iv)  Hente ut LISTE av todos med tekst="Vaske bilen" (som ikke finnes) 
		 * d) Legge til en ny todo med pk=4 
		 * e) Slette todo med pk=4 
		 * f) Endre tekst på todo med pk=3
		 * g) Endre tekst på todo med pk=3, alternativ måte
		 */

		// Hjelpeklasse for å snakke med databasen
		// DAO er en forkortelse for Data Access Object, og er et vanlig navn på slike
		TodoDAO todoDAO = new TodoDAO();

		// a)
		Todo todoa = todoDAO.finnTodoMedPk(2);
		
		System.out.println("\na) Hente ut todo med pk=2");
		System.out.println("   " + todoa);

		
		// b)
		List<Todo> alleTodos = todoDAO.finnAlleTodos();
		
		System.out.println("\nb) Hente ut alle todos");
		alleTodos.forEach(t -> System.out.println("   " + t));

		
		// c)
		Todo todoci = todoDAO.finnTodoMedTekst("Handle mat");
		System.out.println(todoci);
			
		Todo todocii = todoDAO.finnTodoMedTekst("Gjøre lekser");
		System.out.println(todocii);
		
		List<Todo> todosciii = todoDAO.finnTodosMedTekst("Handle mat");
		System.out.println(todosciii);

		List<Todo> todosciv = todoDAO.finnTodosMedTekst("Vaske bilen");
		System.out.println(todosciv);
		
		
		// d)
		System.out.println("\nd) Legge til en ny todo med pk=6");

		Todo todony = new Todo(6, "Mate fiskene");
		todoDAO.lagreNyTodo(todony);
		
		Todo todod = todoDAO.finnTodoMedPk(6);
		System.out.println("   Henter ut todo med pk=6");
		System.out.println("   " + todod);
	
		pauseOgSjekkDatabasen("\nSjekk at vi har fått en ny rad med id=6 og tekst=Mate fiskene.");

		System.out.println("\nProgrammet er ferdig! :)");
	}

	private static void pauseOgSjekkDatabasen(String prompt) {
		System.out.println(prompt);
		System.out.println("Trykk \"ENTER\" for å fortsette ...");
		scanner.nextLine();
	}
}
