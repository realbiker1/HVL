package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "forelesning3")
public class Karakter {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int karnr;
	private String emnekode;
	private LocalDate eksdato;
	private String bokstav;
	
	@ManyToOne
	@JoinColumn(name = "StudNr", referencedColumnName = "StudNr")
	private Vitnemal vitnemal;
	
	public Karakter() {}
	
	public Karakter(String emnekode, LocalDate eksdato, String bokstav, Vitnemal vitnemal) {
		this.emnekode = emnekode;
		this.eksdato = eksdato;
		this.bokstav = bokstav;
		this.vitnemal = vitnemal;
		this.vitnemal.leggTilKarakter(this);	
	}

	@Override
	public String toString() {
		return "Karakter [karnr=" + karnr + ", emnekode=" + emnekode + ", eksamenensdato=" + eksdato + ", bokstav=" + bokstav + "]";
	}

	public void setBokstav(String bokstav) {
		this.bokstav = bokstav;		
	}

	public int getKarnr() {
		return karnr;
	}

	public void setKarnr(int karnr) {
		this.karnr = karnr;
	}

	public String getEmnekode() {
		return emnekode;
	}

	public void setEmnekode(String emnekode) {
		this.emnekode = emnekode;
	}

	public LocalDate getEksdato() {
		return eksdato;
	}

	public void setEksdato(LocalDate eksdato) {
		this.eksdato = eksdato;
	}

	public Vitnemal getVitnemal() {
		return vitnemal;
	}

	public void setVitnemal(Vitnemal vitnemal) {
		this.vitnemal = vitnemal;
	}

	public String getBokstav() {
		return bokstav;
	}
	
	
	
}