package januar2021;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import juni2020.Spiller;

@Entity
public class Forlag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String navn;
	private String telefon;
	private String hjemmeside;
	
	@OneToMany(mappedBy = "forlag")
	private List<Bok> bøker;

}