package mum.edu.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.Director;

@Transactional
public class DaoDirector {
	// EntityManagerFactory emf =
	// Persistence.createEntityManagerFactory("cs544");
	// EntityManager em = emf.createEntityManager();
	// EntityTransaction tx = em.getTransaction();

	private SessionFactory sf;

	public DaoDirector(SessionFactory sf) {
		this.sf = sf;
	}

	public void addDirector(Director director) {

		try {
			sf.getCurrentSession().persist(director);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteDirector(Director director) {
		try {
			// tx.begin();
			// em.remove(director);
			// tx.commit();
			sf.getCurrentSession().delete(director);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateDirector(Director director) {
		try {
			// tx.begin();
			// em.merge(director);
			// tx.commit();
			sf.getCurrentSession().merge(director);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Director getDirector(int id){
		Director director= new Director();
		try {
			
			sf.getCurrentSession().get(Director.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return director;
	}

}
