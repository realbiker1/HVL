package eksamen2021;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import januar2021.Bok;

@Entity
public class Person{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fornavn;
	private String etternavn;
	private LocalDate fødselsdato;
	
	
	@OneToMany(mappedBy = "person")
	private List<Underviser> Underviser;

}