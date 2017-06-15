package dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.interfaces.ConsumoDAO;
import model.Consumo;
import util.HibernateUtil;

public class ConsumoDAOImplementation implements ConsumoDAO {

	@Override
	public void inserir(Consumo c) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(c);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();	
			}
			
		} finally {
			session.close();
		}
	}

	@Override
	public void remover(Consumo p) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(p);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();	
			}
			
		} finally {
			session.close();
		}
	}

	@Override
	public void atualizar(Consumo c) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(c);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();	
			}
			
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consumo> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Consumo> list = null;

		try {
			Query query = session.createQuery("from Consumo c");
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Consumo find(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Consumo findObject;
		
		try {
			findObject = (Consumo) session.get(Consumo.class, id);
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return findObject;
	}

}