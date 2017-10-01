package br.com.sgat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sgat.entities.Residencia;
import br.com.sgat.util.HibernateUtil;

public class ResidenciaDAO {
	
	public void salvar(Residencia residencia) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(residencia.getColaborador().getPessoa());
			session.save(residencia.getColaborador());
			session.save(residencia);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}
	
	public void atualizar(Residencia residencia) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(residencia.getColaborador().getPessoa());
			session.update(residencia.getColaborador());
			session.update(residencia);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Residencia> listar(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Residencia> residencias = null;
		try {
			Query query = session.getNamedQuery("Residencia.listar");
			residencias = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return residencias;
	}

}
