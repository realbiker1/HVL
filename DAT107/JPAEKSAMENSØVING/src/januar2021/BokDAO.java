package januar2021;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import juni2020.Spiller;

public class BokDAO {
	
private EntityManagerFactory emf;
	
	public BokDAO() {
        emf = Persistence.createEntityManagerFactory("personPersistenceUnit");
    }
	
	public List<Bok> finnBokerAar(int aar) {

		EntityManager em = emf.createEntityManager();
        
        try {
            String queryString = "SELECT b FROM Bok b WHERE b.aar = :aar";
            TypedQuery<Bok> query = em.createQuery(queryString, Bok.class);
            query.setParameter("aar", aar);
            return query.getResultList();
            
        } finally {
            em.close();
        }
       
    }
	
	public List<Bok> finnBokMedForfatter(String fornavn, String etternavn) {
		
		EntityManager em = emf.createEntityManager();
        
        try {
            String queryString = "SELECT b FROM Bok b WHERE b.fornavn = :fornavn AND b.etternavn = :etternavn";
            TypedQuery<Bok> query = em.createQuery(queryString, Bok.class);
            query.setParameter("fornavn", fornavn);
            query.setParameter("etternavn", etternavn);
            return query.getResultList();
            
        } finally {
            em.close();
        }
       
    }
	
//	d) Tenk deg at søkeresultatet skal vises frem med f.eks. info om både forlag og forfattere.
//	Er det noe spesielt du må gjøre i løsningen i b) eller c) slik at disse dataene er
//	tilgjengelige etter retur fra BokDAO?
//
//	I begge tilfeller får vi en List av bok objekter. Vi lurer derfor på om vi får info om forlag
//	og forfattere fra databasen i dette søket. Default innstillingen er at enkeltdata (forlag) blir
//  hentet, men samlinger av data (forfattere) ikke blir hentet. Dette kalles lazy-fetching.
//
//	For å få hentet data om forfatterene i søket må man enten annotere med Eager fetching i 
//	bok-klassen slik:
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable( ... )
//	private List<Forfatter> forfattere;
//
//	Ellers kan vi tvinge fram uthenting av forfattere mens listen av bøker er i managed tilstand,
//	
//	List<Bok> resultat = query.getResultList();
//	
//	for (bok b : resultat) {
//		b.getForfattere().size();
//	}
//	return resultat;	
	

}
