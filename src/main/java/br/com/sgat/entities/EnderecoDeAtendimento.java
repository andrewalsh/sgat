package br.com.sgat.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="enderecodeatendimento")
@NamedQueries({
	@NamedQuery(name="EnderecoDeAtendimento.buscarPorNome",query="from EnderecoDeAtendimento e where e.cliente.pessoa.nome like:nome"),
	@NamedQuery(name="EnderecoDeAtendimento.buscarPorCpf",query="from EnderecoDeAtendimento e where e.cliente.pessoa.cpf=:cpf"),
	@NamedQuery(name="EnderecoDeAtendimento.buscarPorRg",query="from EnderecoDeAtendimento e where e.cliente.pessoa.rg=:rg"),
	@NamedQuery(name="EnderecoDeAtendimento.buscarPorTelefoneFixo",query="from EnderecoDeAtendimento e where e.cliente.pessoa.telefoneFixo=:telefoneFixo"),
	@NamedQuery(name="EnderecoDeAtendimento.buscarPorTelefoneCelular",query="from EnderecoDeAtendimento e where e.cliente.pessoa.telefoneCelular=:telefoneCelular"),
})
public class EnderecoDeAtendimento implements Serializable{
	private long idEnderecoDeAtendimento;
	private String numero;
	private String complemento;
	private Cliente cliente;
	private CEPS ceps;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdEnderecoDeAtendimento() {
		return idEnderecoDeAtendimento;
	}
	public void setIdEnderecoDeAtendimento(long idEnderecoDeAtendimento) {
		this.idEnderecoDeAtendimento = idEnderecoDeAtendimento;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@ManyToOne
	@JoinColumn(name="idCliente", referencedColumnName="idCliente", nullable=false)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne
	@JoinColumn(name="idCEPS", referencedColumnName="idCEPS", nullable=false)
	public CEPS getCeps() {
		return ceps;
	}
	public void setCeps(CEPS ceps) {
		this.ceps = ceps;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEnderecoDeAtendimento ^ (idEnderecoDeAtendimento >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoDeAtendimento other = (EnderecoDeAtendimento) obj;
		if (idEnderecoDeAtendimento != other.idEnderecoDeAtendimento)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EnderecoDeAtendimento [idEnderecoDeAtendimento=" + idEnderecoDeAtendimento + ", numero=" + numero
				+ ", complemento=" + complemento + ", cliente=" + cliente + ", ceps=" + ceps + "]";
	}
}
