package dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.interfaces.TipoQuartoDAO;
import model.TipoQuarto;
import util.HibernateUtil;

public class TipoQuartoDAOImplementation implements TipoQuartoDAO {

	@Override
	public void inserir(TipoQuarto c) {
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
	public void remover(TipoQuarto p) {
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
	public void atualizar(TipoQuarto c) {
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
	public List<TipoQuarto> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<TipoQuarto> list = null;

		try {
			Query query = session.createQuery("from TipoQuarto c");
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public TipoQuarto find(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		TipoQuarto findObject;
		
		try {
			findObject = (TipoQuarto) session.get(TipoQuarto.class, id);
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return findObject;
	}

}