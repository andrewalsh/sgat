package br.com.sgat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sgat.entities.EnderecoDeAtendimento;
import br.com.sgat.util.HibernateUtil;

public class EnderecoDeAtendimentoDAO {

	public void salvar(EnderecoDeAtendimento enderecoDeAtendimento) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(enderecoDeAtendimento);
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
	public List<EnderecoDeAtendimento> listarPorCliente(long id){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<EnderecoDeAtendimento> enderecoDeAtendimento = null;
		try {
			Query query = session.getNamedQuery("EnderecoDeAtendimento.listarPorCliente");
			query.setLong("idCliente", id);
			enderecoDeAtendimento = query.list();
		}catch(RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return enderecoDeAtendimento;
	}
	
	@SuppressWarnings("unchecked")
	public List<EnderecoDeAtendimento> buscarPorNome(String nome){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<EnderecoDeAtendimento> clientes = null;
		try {
			Query query = session.getNamedQuery("EnderecoDeAtendimento.buscarPorNome");
			query.setString("nome", "%"+nome+"%");
			clientes = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<EnderecoDeAtendimento> buscarPortelefoneFixo(String telefone){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<EnderecoDeAtendimento> clientes = null;
		try {
			Query query = session.getNamedQuery("EnderecoDeAtendimento.buscarPorTelefoneFixo");
			query.setString("telefoneFixo", telefone);
			clientes = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<EnderecoDeAtendimento> buscarPortelefoneCelular(String telefone){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<EnderecoDeAtendimento> clientes = null;
		try {
			Query query = session.getNamedQuery("EnderecoDeAtendimento.buscarPorTelefoneCelular");
			query.setString("telefoneCelular", telefone);
			clientes = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return clientes;
	}

	@SuppressWarnings("unchecked")
	public List<EnderecoDeAtendimento> buscarPorRg(String rg) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<EnderecoDeAtendimento> cliente = null;
		try {
			Query query = session.getNamedQuery("EnderecoDeAtendimento.buscarPorRg");
			query.setString("rg", rg);
			cliente = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<EnderecoDeAtendimento> buscarPorCpf(String cpf) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<EnderecoDeAtendimento> cliente = null;
		try {
			Query query = session.getNamedQuery("EnderecoDeAtendimento.buscarPorCpf");
			query.setString("cpf", cpf);
			cliente = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return cliente;
	}
}
