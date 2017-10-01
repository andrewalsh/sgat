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
@Table(name="cargo")
@NamedQueries({
	@NamedQuery(name="Cargo.listar",query="from Cargo c"),
	@NamedQuery(name="Cargo.buscarPorCodigo",query="from Cargo c where c.idCargo=:id")
})
public class Cargo implements Serializable{
	private long idCargo;
	private String nome;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(long idCargo) {
		this.idCargo = idCargo;
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
		result = prime * result + (int) (idCargo ^ (idCargo >>> 32));
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
		Cargo other = (Cargo) obj;
		if (idCargo != other.idCargo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cargo [idCargo=" + idCargo + ", nome=" + nome + "]";
	}
}
