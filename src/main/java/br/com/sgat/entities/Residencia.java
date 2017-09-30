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
@Table(name="residencia")
public class Residencia implements Serializable{
	private long idResidencia;
	private String numero;
	private String complemento;
	private Colaborador colaborador;
	private CEPS ceps;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdResidencia() {
		return idResidencia;
	}
	public void setIdResidencia(long idResidencia) {
		this.idResidencia = idResidencia;
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
	@JoinColumn(name="idColaborador",referencedColumnName="idColaborador",nullable=false)
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	@ManyToOne
	@JoinColumn(name="idCEPS",referencedColumnName="idCEPS",nullable=false)
	public CEPS getCeps() {
		return ceps;
	}
	public void setCeps(CEPS ceps) {
		this.ceps = ceps;
	}
	@Override
	public String toString() {
		return "Residencia [idResidencia=" + idResidencia + ", numero=" + numero + ", complemento=" + complemento
				+ ", colaborador=" + colaborador + ", ceps=" + ceps + "]";
	}
}
