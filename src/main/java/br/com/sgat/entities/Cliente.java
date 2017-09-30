package br.com.sgat.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="cliente")
@NamedQueries({
	@NamedQuery(name="Cliente.listar",query="from Cliente c"),
	@NamedQuery(name="Cliente.buscarPorCodigo",query="from Cliente c where c.idCliente=:id"),
	@NamedQuery(name="Cliente.buscarPorNome",query="from Cliente c where c.pessoa.nome like:nome"),
	@NamedQuery(name="Cliente.buscarPorCpf",query="from Cliente c where c.pessoa.cpf=:cpf"),
	@NamedQuery(name="Cliente.buscarPorRg",query="from Cliente c where c.pessoa.rg=:rg"),
	@NamedQuery(name="Cliente.buscarPorTelefoneFixo",query="from Cliente c where c.pessoa.telefoneFixo=:telResidencia"),
	@NamedQuery(name="Cliente.buscarPorTelefoneCelular",query="from Cliente c where c.pessoa.telefoneCelular=:telefoneCelular"),
	@NamedQuery(name="Cliente.lisrarCpf",query="select c.pessoa.cpf from Cliente c")
})
public class Cliente implements Serializable{
	private long idCliente;
	private Pessoa pessoa;
	private Date dataCadastro;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	@ManyToOne
	@JoinColumn(name="idPessoa", referencedColumnName="idPessoa", nullable=false)
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCliente ^ (idCliente >>> 32));
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
		Cliente other = (Cliente) obj;
		if (idCliente != other.idCliente)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", pessoa=" + pessoa + ", dataCadastro=" + dataCadastro + "]";
	}
}
