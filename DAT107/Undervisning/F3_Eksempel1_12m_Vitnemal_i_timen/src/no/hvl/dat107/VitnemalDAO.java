package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class VitnemalDAO {

    private EntityManagerFactory emf;

    public VitnemalDAO() {
        emf = Persistence.createEntityManagerFactory("vitnemalPU");
    }

    public Vitnemal finnVitnemalForStudent(int studNr) {
        
        EntityManager em = emf.createEntityManager();

        try {
        	return em.find(Vitnemal.class, studNr);

        } finally {
            em.close();
        }
    }

    public Karakter finnKarakter(int studNr, String emnekode) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
        	String queryString = "SELECT k FROM Karakter k "
        			+ "WHERE k.emnekode = :emnekode AND k.vitnemal.studnr = :studnr";
        	
        	TypedQuery<Karakter> query = em.createQuery(queryString, Karakter.class);
        	
        	query.setParameter("emnekode", emnekode);
        	query.setParameter("studnr", studNr);
        	
        	return query.getSingleResult();
        	
        } finally {
            em.close();
        }
    }
    
    public Karakter registrerKarakterForStudent(int studNr, String emnekode, 
    		LocalDate eksdato, String bokstav) {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
     
        Karakter k = null;
        
        try {
        	tx.begin();
        	
        	if (finnKarakter(studNr, emnekode) == null) {
        		
        		Vitnemal vitnemal = em.find(Vitnemal.class, studNr);
        		k = new Karakter(emnekode, eksdato, bokstav, vitnemal);
        		vitnemal.leggTilKarakter(k);
        		em.persist(k);  
        	
        	} else {
        		
        		k = finnKarakter(studNr,emnekode);
        		k.setEksdato(eksdato);
        		k.setBokstav(bokstav);
        		em.merge(k);
        	}
	        	    	
        	tx.commit(); 
        	
        } finally {
            em.close();
        }
        return k;
    }

}
















