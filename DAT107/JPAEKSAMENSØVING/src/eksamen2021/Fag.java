package eksamen2021;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Fag{

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kode;

	private String navn;
	private int stp;
	private String semester;

	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "ansvarlig_id")
    private Person person;
	
	public Fag(String kode2, String navn2, int stp2, char semester2, int ansvarlig_id) {
	}

}