package br.com.sgat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sgat.entities.Peca;
import br.com.sgat.util.HibernateUtil;


public class PecaDAO {
	
	public void salvar(Peca peca) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(peca);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}
	
	public void atualizar(Peca peca) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(peca);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}

	public Peca buscarPorCodigo(long id) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Peca peca = null;
		try {
			Query query = session.getNamedQuery("Peca.buscarPorCodigo");
			query.setLong("id", id);
			peca = (Peca) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return peca;
	}
	
	@SuppressWarnings("unchecked")
	public List<Peca> listar(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Peca> pecas = null;
		try {
			Query query = session.getNamedQuery("Peca.listar");
			pecas = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return pecas;
	}
}
