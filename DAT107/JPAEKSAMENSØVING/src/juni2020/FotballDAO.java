package juni2020;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FotballDAO {
	
	private EntityManagerFactory emf;
	
	public FotballDAO() {
        emf = Persistence.createEntityManagerFactory("personPersistenceUnit");
    }
	
	public void registrerResultat(int kampid, int h, int b) {
		
		EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {  	
        	Kamp kamp = em.find(Kamp.class, kampid);
        	
        	if (kamp != null) {
        		tx.begin();
        		kamp.setHmaal(h);
        		kamp.setBmaal(b);
        		tx.commit();
        	}
        	
        } catch (Throwable e) {
        	tx.rollback();   
        	
        } finally {
        	em.close();
        }
	
	}
	
	public List<Spiller> hentSpillere(int lagid) {

		EntityManager em = emf.createEntityManager();
        
        try {
            String queryString = "SELECT s FROM Spiller s";
            TypedQuery<Spiller> query = em.createQuery(queryString, Spiller.class);
            return query.getResultList();
            
        } finally {
            em.close();
        }
       
    }
	
	public List<Kamp> finnKamperTilLag(int lagid) {
		EntityManager em = emf.createEntityManager();
		
		try {
			String queryString = "SELECT k FROM Kamp k WHERE k.lagid = :lagid ORDER BY k.kampdato";
			TypedQuery<Kamp> query = em.createQuery(queryString, Kamp.class);
			query.setParameter("lagid", lagid);
			return query.getResultList(); 
		
		} finally {
			em.close();
		}
	}
	
}
