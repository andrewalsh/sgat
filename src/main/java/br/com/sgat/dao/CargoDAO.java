package br.com.sgat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sgat.entities.Cargo;
import br.com.sgat.util.HibernateUtil;

public class CargoDAO {

	public void salvar(Cargo cargo) {
		Session session= HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(cargo);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}finally {
			session.close();
		}
	}
	
	public Cargo buscarPorCodigo(long id) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Cargo cargo = null;
		try {
			Query query = session.getNamedQuery("Cargo.buscarPorCodigo");
			query.setLong("id", id);
			cargo = (Cargo) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return cargo;
	}
	
	public void atualizar(Cargo cargo) {
		Session session= HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(cargo);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> listar(){
		Session session= HibernateUtil.getFabricaDeSessoes().openSession();
		List<Cargo> cargos = null;
		try {
			Query query = session.getNamedQuery("Cargo.listar");
			cargos = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return cargos;
	}
}
