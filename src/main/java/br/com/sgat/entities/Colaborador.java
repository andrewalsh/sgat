package br.com.sgat.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="colaborador")
public class Colaborador implements Serializable{
	private long idColaborador;
	private Pessoa pessoa;
	private Cargo cargo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdColaborador() {
		return idColaborador;
	}
	public void setIdColaborador(long idColaborador) {
		this.idColaborador = idColaborador;
	}
	
	@ManyToOne
	@JoinColumn(name="idPessoa",referencedColumnName="idPessoa",nullable=false)
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@ManyToOne
	@JoinColumn(name="idCargo",referencedColumnName="idCargo",nullable=false)
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idColaborador ^ (idColaborador >>> 32));
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
		Colaborador other = (Colaborador) obj;
		if (idColaborador != other.idColaborador)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Colaborador [idColaborador=" + idColaborador + ", pessoa=" + pessoa + ", cargo=" + cargo + "]";
	}
}
