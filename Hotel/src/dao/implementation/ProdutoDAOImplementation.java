package dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.interfaces.ProdutoDAO;
import model.Produto;
import util.HibernateUtil;

public class ProdutoDAOImplementation implements ProdutoDAO {

	@Override
	public void inserir(Produto c) {
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
	public void remover(Produto p) {
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
	public void atualizar(Produto c) {
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
	public List<Produto> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Produto> list = null;

		try {
			Query query = session.createQuery("from Produto c");
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Produto find(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Produto findObject;
		
		try {
			findObject = (Produto) session.get(Produto.class, id);
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return findObject;
	}

}