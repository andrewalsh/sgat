package br.com.sgat.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgat.dao.CepsDAO;
import br.com.sgat.dao.ClienteDAO;
import br.com.sgat.dao.EnderecoDeAtendimentoDAO;
import br.com.sgat.entities.CEPS;
import br.com.sgat.entities.Cliente;
import br.com.sgat.entities.EnderecoDeAtendimento;
import br.com.sgat.entities.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private Cliente cliente;
	private EnderecoDeAtendimento enderecoDeAtendimento;
	private CEPS cep;
	private List<CEPS> ceps;
	private List<Cliente> clientes;
	private List<EnderecoDeAtendimento> enderecosDeAtendimento;
	private String parametroPesquisa;
	private String valorPesquisa;

	public Cliente getCliente() {
		if (this.cliente == null) {
			this.cliente = new Cliente();
			this.cliente.setPessoa(new Pessoa());
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EnderecoDeAtendimento getEnderecoDeAtendimento() {
		if (this.enderecoDeAtendimento == null) {
			this.enderecoDeAtendimento = new EnderecoDeAtendimento();
			this.enderecoDeAtendimento.setCeps(new CEPS());
			this.enderecoDeAtendimento.setCliente(new Cliente());
			this.enderecoDeAtendimento.getCliente().setPessoa(new Pessoa());
		}
		return enderecoDeAtendimento;
	}

	public void setEnderecoDeAtendimento(EnderecoDeAtendimento enderecoDeAtendimento) {
		this.enderecoDeAtendimento = enderecoDeAtendimento;
	}

	public CEPS getCep() {
		if (this.cep == null) {
			this.cep = new CEPS();
		}
		return cep;
	}

	public void setCep(CEPS cep) {
		this.cep = cep;
	}

	public List<CEPS> getCeps() {
		return ceps;
	}

	public void setCeps(List<CEPS> ceps) {
		this.ceps = ceps;
	}

	public String getParametroPesquisa() {
		return parametroPesquisa;
	}

	public void setParametroPesquisa(String parametroPesquisa) {
		this.parametroPesquisa = parametroPesquisa;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getValorPesquisa() {
		return valorPesquisa;
	}

	public void setValorPesquisa(String valorPesquisa) {
		this.valorPesquisa = valorPesquisa;
	}

	public List<EnderecoDeAtendimento> getEnderecosDeAtendimento() {
		return enderecosDeAtendimento;
	}

	public void setEnderecosDeAtendimento(List<EnderecoDeAtendimento> enderecosDeAtendimento) {
		this.enderecosDeAtendimento = enderecosDeAtendimento;
	}

	public void pesquisarCliente() {
		EnderecoDeAtendimentoDAO dao = new EnderecoDeAtendimentoDAO();
		switch (parametroPesquisa) {
		case "nome":
			try {
				enderecosDeAtendimento = dao.buscarPorNome(valorPesquisa);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "cpf":
			try {
				enderecosDeAtendimento = dao.buscarPorCpf(valorPesquisa);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "rg":
			try {
				enderecosDeAtendimento = dao.buscarPorRg(valorPesquisa);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "fixo":
			try {
				enderecosDeAtendimento = dao.buscarPortelefoneFixo(valorPesquisa);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "celular":
			try {
				enderecosDeAtendimento = dao.buscarPortelefoneCelular(valorPesquisa);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			break;
		}
	}

	public void buscarPorCep() {
		CepsDAO dao = new CepsDAO();
		try {
			this.cep = dao.buscarPorCep(this.cep.getCEP());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarPorRua() {
		CepsDAO dao = new CepsDAO();
		try {
			this.ceps = dao.buscarPorParametro(this.cep.getRUA());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public void popularCep(CEPS ceps) {
		this.cep = ceps;
	}

	public void popularEnderecoDeAtendimento(EnderecoDeAtendimento enderecoDeAtendimento) {
		this.enderecoDeAtendimento = enderecoDeAtendimento;
		this.cliente = enderecoDeAtendimento.getCliente();
		this.cep = enderecoDeAtendimento.getCeps();
	}

	public void salvar() {
		if (this.enderecoDeAtendimento.getCliente().getIdCliente() <= 0) {
			ClienteDAO dao = new ClienteDAO();
			try {
				enderecoDeAtendimento.setCeps(cep);
				enderecoDeAtendimento.setCliente(cliente);
				dao.salvar(cliente, enderecoDeAtendimento);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		} else if (this.enderecoDeAtendimento.getCliente().getIdCliente() > 0) {
			salvarNovoEnderecoDeAtendimento();
		}

	}
	
	public List<String> autoComplete(){
		List<String> resultado = new ArrayList<>();
		try {
			ClienteDAO dao = new ClienteDAO();
			resultado = dao.listarCPF();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}return resultado;
	}

	private void salvarNovoEnderecoDeAtendimento() {
		ClienteDAO dao = new ClienteDAO();
		try {
			enderecoDeAtendimento.setCeps(cep);
			dao.salvarNovoEnderecoDeAtendimento(cliente, enderecoDeAtendimento);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
