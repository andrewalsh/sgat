package br.com.sgat.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="maodeobra")
@NamedQueries({
	@NamedQuery(name="MaoDeObra.listar",query="from MaoDeObra m"),
	@NamedQuery(name="MaoDeObra.buscarPorCodigo",query="from MaoDeObra m where m.idMaoDeObra=:id")
})
public class MaoDeObra implements Serializable{

	private long idMaoDeObra;
	private String nome;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdMaoDeObra() {
		return idMaoDeObra;
	}
	public void setIdMaoDeObra(long idMaoDeObra) {
		this.idMaoDeObra = idMaoDeObra;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idMaoDeObra ^ (idMaoDeObra >>> 32));
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
		MaoDeObra other = (MaoDeObra) obj;
		if (idMaoDeObra != other.idMaoDeObra)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MaoDeObra [idMaoDeObra=" + idMaoDeObra + ", nome=" + nome + "]";
	}
}
