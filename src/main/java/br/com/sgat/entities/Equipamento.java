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
@Table(name="equipamento")

public class Equipamento implements Serializable{

	private long idEquipamento;
	private Fabricante fabricante;
	private TipoDeEquipamento tipo;
	private String modelo;
	private String serie;
	private String patrimonio;
	private String capacidade;
	private Cliente cliente;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdEquipamento() {
		return idEquipamento;
	}
	public void setIdEquipamento(long idEquipamento) {
		this.idEquipamento = idEquipamento;
	}
	
	@ManyToOne
	@JoinColumn(name="idFabricante",referencedColumnName="idFabricante",nullable=false)
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	@ManyToOne
	@JoinColumn(name="idTipoDeEquipamento",referencedColumnName="idTipoDeEquipamento",nullable=false)
	public TipoDeEquipamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeEquipamento tipo) {
		this.tipo = tipo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	
	@ManyToOne
	@JoinColumn(name="idCliente",referencedColumnName="idCliente",nullable=false)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEquipamento ^ (idEquipamento >>> 32));
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
		Equipamento other = (Equipamento) obj;
		if (idEquipamento != other.idEquipamento)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Equipamento [idEquipamento=" + idEquipamento + ", fabricante=" + fabricante + ", tipo=" + tipo
				+ ", modelo=" + modelo + ", serie=" + serie + ", patrimonio=" + patrimonio + ", capacidade="
				+ capacidade + ", cliente=" + cliente + "]";
	}
}
