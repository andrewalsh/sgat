package br.com.sgat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sgat.entities.MaoDeObra;
import br.com.sgat.util.HibernateUtil;

public class MaoDeObraDAO {
	
	public void salvar(MaoDeObra maoDeObra) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(maoDeObra);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}
	
	public void atualizar(MaoDeObra maoDeObra) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(maoDeObra);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}
	
	public MaoDeObra buscrPorCodigo(long id) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		MaoDeObra maoDeObra = null;
		try {
			Query query = session.getNamedQuery("MaoDeObra.buscarPorCodigo");
			query.setLong("id", id);
			maoDeObra = (MaoDeObra) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return maoDeObra;
	}
	
	@SuppressWarnings("unchecked")
	public List<MaoDeObra> listar(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<MaoDeObra> maoDeObras = null;
		try {
			Query query = session.getNamedQuery("MaoDeObra.listar");
			maoDeObras = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return maoDeObras;
	}

}
