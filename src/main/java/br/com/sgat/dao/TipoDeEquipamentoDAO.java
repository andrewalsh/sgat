package br.com.sgat.dao;

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
				
			}
		}
	}

}
