package dao.implementation;

import java.util.List;
import util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.interfaces.FaturaDAO;
import model.Fatura;

public class FaturaDAOImplementation implements FaturaDAO {
	
	@Override
	public void inserir(Fatura c) {
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
	public void remover(Fatura p) {
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
	public void atualizar(Fatura c) {
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
	public List<Fatura> listarTodosOsFaturas() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Fatura> list = null;

		try {
			Query query = session.createQuery("from Fatura c");
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return list;
	}
	
}