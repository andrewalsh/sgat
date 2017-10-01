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
@Table(name="fabricante")
@NamedQueries({
	@NamedQuery(name="Fabricante.listar",query="from Fabricante f"),
	@NamedQuery(name="Fabricante.buscarPorCodigo",query="from Fabricante f where f.idFabricante=:id")
})
public class Fabricante implements Serializable{
	private long idFabricante;
	private String nome;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdFabricante() {
		return idFabricante;
	}
	public void setIdFabricante(long idFabricante) {
		this.idFabricante = idFabricante;
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
		result = prime * result + (int) (idFabricante ^ (idFabricante >>> 32));
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
		Fabricante other = (Fabricante) obj;
		if (idFabricante != other.idFabricante)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Fabricante [idFabricante=" + idFabricante + ", nome=" + nome + "]";
	}
}
