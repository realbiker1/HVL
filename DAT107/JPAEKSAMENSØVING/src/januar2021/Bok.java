package januar2021;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import juni2020.Lag;

@Entity
public class Bok {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tittel;
	private int aar;
	private int ISBN;
	
	@ManyToOne
	@JoinColumn(name = "forlag_id", referencedColumnName = "id")
	private Forlag forlag;
	
	@ManyToMany
	@JoinTable(
			name = "forfatter_av_bok",
			joinColumns = @JoinColumn(name="bok_id"),
			inverseJoinColumns = @JoinColumn(name="forfatter_id"))
	private List<Forfatter> forfattere;

}
