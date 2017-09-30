package br.com.sgat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.sgat.entities.CEPS;
import br.com.sgat.util.HibernateUtil;

public class CepsDAO {
	
	@SuppressWarnings("unchecked")
	public List<CEPS> buscarPorParametro(String valor){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<CEPS> ceps = null;
		try {
			Query query = session.getNamedQuery("CEPS.buscarPorParametro");
			query.setString("valor", "%"+valor+"%");
			ceps = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return ceps;
	}
	
	public CEPS buscarPorCep(String valor){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		CEPS cep = null;
		try {
			Query query = session.getNamedQuery("CEPS.buscarPorCep");
			query.setString("valor", valor);
			
			cep = (CEPS) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return cep;
	}
}
