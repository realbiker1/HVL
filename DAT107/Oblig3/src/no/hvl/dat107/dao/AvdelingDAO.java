package no.hvl.dat107.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;

public class AvdelingDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("firmaPersistenceUnit");
	
	public Avdeling finnAvdelingMedId(String strID) {
		
		int id = 0;
		
		try {
			id = Integer.parseInt(strID);
		} catch (Exception e) {
			System.out.println("Avdelings ID må være et tall!");
		}	
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Avdeling.class, id);
			
		} finally {
			em.close();
		}
	}
	
	public Avdeling lagreNyAvdeling(String navnPaaNyAvdeling, Ansatt sjef) {
    	
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Avdeling nyAvdeling = null;
        
        try {
            tx.begin();
            
            Avdeling gammelAvdeling = sjef.getAvdeling();
            gammelAvdeling.fjernAnsatt(sjef);
            em.merge(gammelAvdeling);
            
            nyAvdeling = new Avdeling();
            nyAvdeling.setNavn(navnPaaNyAvdeling);
            nyAvdeling.setSjef(sjef);
            nyAvdeling.leggTilAnsatt(sjef);
            
            em.persist(nyAvdeling);
                        
            sjef.setAvdeling(nyAvdeling);
            em.merge(sjef);           
            
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        return nyAvdeling;
    }

}
