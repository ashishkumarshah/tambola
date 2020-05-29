package com.phodu.tambola.ticket.data;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.phodu.tambola.data.DAO;
import com.phodu.tambola.data.EntityManagerUtil;
import com.phodu.tambola.ticket.TambolaTicket;

public class TicketDAO implements DAO<TambolaTicket>{
	private EntityManager em = EntityManagerUtil.getEntityManager();
	
	@Override
	public TambolaTicket load(long id) {
		return em.find(TambolaTicket.class, id);
	}

	@Override
	public void create(TambolaTicket entity) {
		executeInsideTransaction(entityManager -> entityManager.persist(entity));
	}

	@Override
	public TambolaTicket update(TambolaTicket entity) {
		long id = entity.getId();
		executeInsideTransaction(entityManager -> entityManager.merge(entity));
		return load(id);
	}

	@Override
	public void delete(TambolaTicket entity) {
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
