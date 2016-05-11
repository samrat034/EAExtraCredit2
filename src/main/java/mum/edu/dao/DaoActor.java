package mum.edu.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.domain.Actor;


@Transactional
public class DaoActor {
	
	private SessionFactory sf;
		
	public DaoActor(SessionFactory sf){
		this.sf=sf;
		
	}
	
			public void addActor(Actor actor){
					
					try {
					sf.getCurrentSession().persist(actor);	
					} catch (Exception e){
						e.printStackTrace();
					}
			
				}
			
			public void deleteActor(Actor actor){
				try{
					sf.getCurrentSession().delete(actor);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			public void updateActor(Actor actor){
				try{
					sf.getCurrentSession().merge(actor);
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			public Actor getActor(int id) {
				Actor act = new Actor();
				try{
					sf.getCurrentSession().get(Actor.class,id);
				} catch(Exception e){
					e.printStackTrace();
				}
				return act;
			}
				
	
}
