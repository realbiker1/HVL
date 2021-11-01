package no.hvl.dat107.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.dat107.entity.Ansatt;

public class AnsattDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("firmaPersistenceUnit");
	
	public Ansatt finnAnsattMedID(String strID) {
		
		int id = 0;
		
		try {
			id = Integer.parseInt(strID);
		} catch (Exception e) {
			System.out.println("Ansatt ID må være et tall!");
		}	
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Ansatt.class, id);
			
		} finally {
			em.close();
		}
	}
	
	public List<Ansatt> finnAnsattMedBrukernavn(String brukernavn) {
		String user = brukernavn.toUpperCase();
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery(
					"SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn", Ansatt.class);
			query.setParameter("brukernavn", user);
			return query.getResultList();
			
		} finally {
			em.close();
		}
	}
	
	public List<Ansatt> finnAlleAnsatte() {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a", Ansatt.class);
			
			return query.getResultList();
		
		} finally {
			em.close();
		}
	}
	
	public void oppdatereStilling(int id, String nyStilling) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Ansatt ansatt = em.find(Ansatt.class, id);
			ansatt.setStilling(nyStilling);
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}	
		} finally {
			em.close();
		}
	}
	
	public void oppdatereLoenn(int id, int nyLoenn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Ansatt ansatt = em.find(Ansatt.class, id);
			ansatt.setMaanedsloenn(nyLoenn);
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}	
		} finally {
			em.close();
		}
	}
	
	public void lagreNyAnsatt(Ansatt nyAnsatt) {
	
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			em.persist(nyAnsatt);
			
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}
	
	
}
