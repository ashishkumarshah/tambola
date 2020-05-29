package com.phodu.tambola.profile.data;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.phodu.tambola.data.EntityManagerUtil;
import com.phodu.tambola.profile.Profile;

public class ProfileDAO {
	private EntityManager em = EntityManagerUtil.getEntityManager();

	public Profile load(long id) {
		return em.find(Profile.class, id);
	}


	public void create(Profile entity) {
		executeInsideTransaction(entityManager -> entityManager.persist(entity));
	}
	
	public Profile update(Profile entity) {
		return null;
	}

	
	public void delete(Profile entity) {
		
	}
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			action.accept(em);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

}
