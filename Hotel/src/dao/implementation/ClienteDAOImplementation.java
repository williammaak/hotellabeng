package dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.interfaces.ClienteDAO;
import model.Cliente;
import util.HibernateUtil;

public class ClienteDAOImplementation implements ClienteDAO {

	@Override
	public void inserir(Cliente c) {
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
	public void remover(Cliente p) {
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
	public void atualizar(Cliente c) {
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
	public List<Cliente> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Cliente> list = null;

		try {
			Query query = session.createQuery("from Cliente c");
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Cliente find(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Cliente findObject;
		
		try {
			findObject = (Cliente) session.get(Cliente.class, id);
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return findObject;
	}

}