package br.com.sgat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sgat.entities.TipoDeEquipamento;
import br.com.sgat.util.HibernateUtil;

public class TipoDeEquipamentoDAO {
	
	public void salvar(TipoDeEquipamento tipoDeEquipamento) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(tipoDeEquipamento);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}

	
	public void atualizar(TipoDeEquipamento tipoDeEquipamento) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(tipoDeEquipamento);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}
	
	public TipoDeEquipamento buscarPorCodigo(long id) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		TipoDeEquipamento tipoDeEquipamento = null;
		try {
			Query query = session.getNamedQuery("TipoDeEquipamento.buscarPorCodigo");
			query.setLong("id", id);
			tipoDeEquipamento = (TipoDeEquipamento) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return tipoDeEquipamento;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoDeEquipamento> listar(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<TipoDeEquipamento> tipoDeEquipamentos = null;
		try {
			Query query = session.getNamedQuery("TipoDeEquipamento.listar");
			tipoDeEquipamentos = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return tipoDeEquipamentos;
	}
}
