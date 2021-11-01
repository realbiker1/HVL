package no.hvl.dat107.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ansatt", schema = "oblig3")
public class Ansatt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansdato;
	private String stilling;
	private int maanedsloenn;
	
	@ManyToOne
    @JoinColumn(name = "avd_id")
   	private Avdeling avdeling;
	
//	@OneToMany(mappedBy="ansatt")
//	private List<Prosjekt> prosjekter;
	
	public Ansatt() {}
	
	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansdato, String stilling, int maanedsloenn, Avdeling avdeling) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansdato = ansdato;
		this.stilling = stilling;
		this.maanedsloenn = maanedsloenn;
		this.avdeling = avdeling;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsdato() {
		return ansdato;
	}

	public void setAnsdato(LocalDate ansdato) {
		this.ansdato = ansdato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMaanedsloenn() {
		return maanedsloenn;
	}

	public void setMaanedsloenn(int maanedsloenn) {
		this.maanedsloenn = maanedsloenn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	public List<Prosjekt> getProsjekter() {
		return prosjekter;
	}

	public void setProsjekter(List<Prosjekt> prosjekter) {
		this.prosjekter = prosjekter;
	}

	@Override
	public String toString() {
		return "Ansatt [id=" + id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", ansdato=" + ansdato + ", stilling=" + stilling + ", maanedsloenn=" + maanedsloenn + ", avdeling=" + avdeling.getNavn() + "]";
	}
	
	public void skrivUt() {
        System.out.printlns(this.toString());
    }
	
	
}
