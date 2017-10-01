package br.com.sgat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sgat.entities.Fabricante;
import br.com.sgat.util.HibernateUtil;

public class FabricanteDAO {
	
	public void salvar(Fabricante fabricante) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(fabricante);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}

	public void atualizar(Fabricante fabricante) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(fabricante);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}

	public Fabricante buscarPorCodigo(long id) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Fabricante fabricante = null;
		try {
			Query query = session.getNamedQuery("Fabricante.buscarPorCodigo");
			query.setLong("id", id);
			fabricante = (Fabricante) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return fabricante;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> listarFabricantes(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Fabricante> fabricantes = null;
		try {
			Query query = session.getNamedQuery("Fabricante.listar");
			fabricantes = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return fabricantes;
	}
	
}
