package com.phodu.tambola.board.data;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.phodu.tambola.board.TambolaBoard;
import com.phodu.tambola.data.DAO;
import com.phodu.tambola.data.EntityManagerUtil;

public class BoardDAO implements DAO<TambolaBoard> {
	private EntityManager em = EntityManagerUtil.getEntityManager();

	@Override
	public TambolaBoard load(long id) {
		return em.find(TambolaBoard.class, id);
	}

	@Override
	public void create(TambolaBoard entity) {
		executeInsideTransaction(entityManager -> entityManager.persist(entity));
	}

	@Override
	public TambolaBoard update(TambolaBoard entity) {
		long id = entity.getId();
		executeInsideTransaction(entityManager -> entityManager.merge(entity));
		return load(id);

	}

	@Override
	public void delete(TambolaBoard entity) {
		executeInsideTransaction(entityManager -> entityManager.remove(entity));

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
