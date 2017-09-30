package br.com.sgat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sgat.entities.Cliente;
import br.com.sgat.entities.EnderecoDeAtendimento;
import br.com.sgat.entities.Pessoa;
import br.com.sgat.util.HibernateUtil;

public class ClienteDAO {

	public void salvar(Cliente cliente, EnderecoDeAtendimento enderecoDeAtendimento) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			Pessoa p = cliente.getPessoa();
			transaction = session.beginTransaction();
			session.save(p);
			cliente.setPessoa(p);
			session.save(cliente);
			session.save(enderecoDeAtendimento);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void salvarNovoEnderecoDeAtendimento(Cliente cliente, EnderecoDeAtendimento enderecoDeAtendimento) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(cliente.getPessoa());
			session.update(cliente);
			session.save(enderecoDeAtendimento);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Cliente> clientes = null;
		try {
			Query query = session.getNamedQuery("Cliente.listar");
			clientes = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarPorNome(String nome){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Cliente> clientes = null;
		try {
			Query query = session.getNamedQuery("Cliente.buscarPorNome");
			query.setString("nome", "%"+nome+"%");
			clientes = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarPortelefoneFixo(String telefone){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Cliente> clientes = null;
		try {
			Query query = session.getNamedQuery("Cliente.buscarPorTelefoneFixo");
			query.setString("telefoneResidencia", telefone);
			clientes = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarPortelefoneCelular(String telefone){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Cliente> clientes = null;
		try {
			Query query = session.getNamedQuery("Cliente.buscarPorTelefoneCelular");
			query.setString("telefoneCelular", telefone);
			clientes = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> listarCPF(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<String> listaDeCpf = null;
		try {
			Query query = session.getNamedQuery("Cliente.lisrarCpf");
			listaDeCpf = query.list();
		} catch (RuntimeException e) {
			throw e;
		}return listaDeCpf;
	}

	public Cliente buscarPorCodigo(long id) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Cliente cliente = null;
		try {
			Query query = session.getNamedQuery("Cliente.buscarPorCodigo");
			query.setLong("idCliente", id);
			cliente = (Cliente) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return cliente;
	}
	
	public Cliente buscarPorRg(String rg) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Cliente cliente = null;
		try {
			Query query = session.getNamedQuery("Cliente.buscarPorRg");
			query.setString("rg", rg);
			cliente = (Cliente) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return cliente;
	}
	
	public Cliente buscarPorCpf(String cpf) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Cliente cliente = null;
		try {
			Query query = session.getNamedQuery("Cliente.buscarPorCpf");
			query.setString("cpf", cpf);
			cliente = (Cliente) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}return cliente;
	}
	
	public void atualizar(Cliente cliente) {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			Pessoa p = cliente.getPessoa();
			transaction = session.beginTransaction();
			session.update(p);
			session.update(cliente);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null) {
				transaction.rollback();
			}throw e;
		}finally {
			session.close();
		}
	}
}
