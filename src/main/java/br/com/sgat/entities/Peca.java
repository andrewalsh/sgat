package br.com.sgat.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="peca")
public class Peca implements Serializable{

	private long idPeca;
	private String codigoFabricante;
	private int qtd;
	private Double vlrCompra;
	private Double vlrVenda;
	private int critico;
	private String nomePeca;
	private Fabricante fabricante;
	private TipoDeEquipamento tipo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdPeca() {
		return idPeca;
	}
	public void setIdPeca(long idPeca) {
		this.idPeca = idPeca;
	}
	public String getCodigoFabricante() {
		return codigoFabricante;
	}
	public void setCodigoFabricante(String codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	@Column(precision=3, scale=2)
	public Double getVlrCompra() {
		return vlrCompra;
	}
	public void setVlrCompra(Double vlrCompra) {
		this.vlrCompra = vlrCompra;
	}
	
	@Column(precision=3, scale=2)
	public Double getVlrVenda() {
		return vlrVenda;
	}
	public void setVlrVenda(Double vlrVenda) {
		this.vlrVenda = vlrVenda;
	}
	public int getCritico() {
		return critico;
	}
	public void setCritico(int critico) {
		this.critico = critico;
	}
	public String getNomePeca() {
		return nomePeca;
	}
	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}
	
	@ManyToOne
	@JoinColumn(name="idFabricante",referencedColumnName="idFabricante",nullable=true)
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	@ManyToOne
	@JoinColumn(name="idtipoDeEquipamento",referencedColumnName="idTipoDeEquipamento",nullable=true)
	public TipoDeEquipamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeEquipamento tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPeca ^ (idPeca >>> 32));
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
		Peca other = (Peca) obj;
		if (idPeca != other.idPeca)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Peca [idPeca=" + idPeca + ", codigoFabricante=" + codigoFabricante + ", qtd=" + qtd + ", vlrCompra="
				+ vlrCompra + ", vlrVenda=" + vlrVenda + ", critico=" + critico + ", nomePeca=" + nomePeca
				+ ", fabricante=" + fabricante + ", tipo=" + tipo + "]";
	}
	
}
