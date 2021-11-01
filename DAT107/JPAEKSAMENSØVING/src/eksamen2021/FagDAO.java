package eksamen2021;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FagDAO {
	
private EntityManagerFactory emf;
	
	public FagDAO() {
        emf = Persistence.createEntityManagerFactory("personPersistenceUnit");
    }
	
	public void lagNyttFag(String kode, String navn,int stp, char semester, int ansvarlig_id) {

		 EntityManager em = emf.createEntityManager();
		 EntityTransaction tx = em.getTransaction();

		        try {
		            tx.begin();
		            Fag nyttFag = new Fag(kode, navn, stp, semester, ansvarlig_id);

		            em.persist(nyttFag);

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
