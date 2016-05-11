package mum.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.Movie;



@Transactional
public class DaoMovie {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
		private SessionFactory sf;
	
		public DaoMovie(SessionFactory sf) {
			this.sf = sf;
		}
		
		public void addMovie(Movie movie){
		
		try {
//			tx.begin();
//			em.persist(movie);
//			tx.commit();
			sf.getCurrentSession().persist(movie);
			

		} catch (Exception e){
			e.printStackTrace();
		}

	}
		
		public void deleteMovie(Movie movie){
			try{
//				tx.begin();
//				em.remove(movie);
//				tx.commit();
				sf.getCurrentSession().delete(movie);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public void updateMovie(Movie movie){
			try{
//				tx.begin();
//				em.merge(movie);
//				tx.commit();
				sf.getCurrentSession().merge(movie);
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	
		public Movie findMovie(int id){
			Movie m = new Movie();
			try{
//				tx.begin();
//				m = em.find(Movie.class, id);
//				tx.commit();
				sf.getCurrentSession().get(Movie.class, id);
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			return m;
		}
//		
//		public List<Movie> findMovie(String name){
//			List<Movie> mv = new ArrayList<Movie>();
//			try{
//				tx.begin();
//				Query q = em.createQuery("From Movie mv where mv.name like : name");
//				q.setParameter("name", name);
//				tx.commit();
//			} catch (Exception e){
//				System.out.println(e.getMessage());
//			}
//			return mv;
//		}
//		
//		public List<Movie> findByActor(String name){
//			List<Movie> mv = new ArrayList<Movie>();
//			try{
//				tx.begin();
//				Query q = em.createQuery("From Movie m join m.actor ac where ac.name =:name");
//				q.setParameter("name", name);
//				tx.commit();
//			}  catch (Exception e){
//				System.out.println(e.getMessage());
//			}
//			return mv;
//		}
//		
//		public List<Movie> findByDirector(String name){
//			List<Movie> mv = new ArrayList<Movie>();
//			try{
//				tx.begin();
//				Query q = em.createQuery("From Movie m join m.director dc where dc.name =:name");
//				q.setParameter("name", name);
//				tx.commit();
//			}  catch (Exception e){
//				System.out.println(e.getMessage());
//			}
//			return mv;
//		}
//		
//		public List<Movie> findByGenre(String genre){
//			List<Movie> mv = new ArrayList<Movie>();
//			try{
//				tx.begin();
//				Query q = em.createQuery("From Movie m where :genre in (m.genre)");
//				q.setParameter("genre", genre);
//				tx.commit();
//			}  catch (Exception e){
//				System.out.println(e.getMessage());
//			}
//			return mv;
//		}
//		
//		public List<Movie> findByRating(String rating){
//			List<Movie> mv = new ArrayList<Movie>();
//			try{
//				tx.begin();
//				Query q = em.createQuery("From Movie m where :rating in (m.rating)");
//				q.setParameter("rating", rating);
//				tx.commit();
//			}  catch (Exception e){
//				System.out.println(e.getMessage());
//			}
//			return mv;
//		}
//		
}
