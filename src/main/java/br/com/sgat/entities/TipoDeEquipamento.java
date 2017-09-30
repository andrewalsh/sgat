package br.com.sgat.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tipodeequipamento")
public class TipoDeEquipamento implements Serializable{
	private long idTipoDeEquipamento;
	private String nome;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdTipoDeEquipamento() {
		return idTipoDeEquipamento;
	}
	public void setIdTipoDeEquipamento(long idTipoDeEquipamento) {
		this.idTipoDeEquipamento = idTipoDeEquipamento;
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
		result = prime * result + (int) (idTipoDeEquipamento ^ (idTipoDeEquipamento >>> 32));
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
		TipoDeEquipamento other = (TipoDeEquipamento) obj;
		if (idTipoDeEquipamento != other.idTipoDeEquipamento)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TipoDeEquipamento [idTipoDeEquipamento=" + idTipoDeEquipamento + ", nome=" + nome + "]";
	}
	
}
