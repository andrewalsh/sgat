package br.com.sgat.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="movimentoestoque")
public class MovimentoEstoque implements Serializable{

	private long idMovimentoEstoque;
	private Peca peca;
	private String tipoMovimento;
	private Date dataMovimento;
	private boolean entrada;
	private boolean saida;
	private Colaborador movimentadoPor;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdMovimentoEstoque() {
		return idMovimentoEstoque;
	}
	public void setIdMovimentoEstoque(long idMovimentoEstoque) {
		this.idMovimentoEstoque = idMovimentoEstoque;
	}
	
	@ManyToOne
	@JoinColumn(name="idPeca",referencedColumnName="idPeca",nullable=false)
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	public String getTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDataMovimento() {
		return dataMovimento;
	}
	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}
	public boolean isEntrada() {
		return entrada;
	}
	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}
	public boolean isSaida() {
		return saida;
	}
	public void setSaida(boolean saida) {
		this.saida = saida;
	}
	
	@ManyToOne
	@JoinColumn(name="movimentadoPor",referencedColumnName="idColaboradorador",nullable=false)
	public Colaborador getMovimentadoPor() {
		return movimentadoPor;
	}
	public void setMovimentadoPor(Colaborador movimentadoPor) {
		this.movimentadoPor = movimentadoPor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idMovimentoEstoque ^ (idMovimentoEstoque >>> 32));
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
		MovimentoEstoque other = (MovimentoEstoque) obj;
		if (idMovimentoEstoque != other.idMovimentoEstoque)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MovimentoEstoque [idMovimentoEstoque=" + idMovimentoEstoque + ", peca=" + peca + ", tipoMovimento="
				+ tipoMovimento + ", dataMovimento=" + dataMovimento + ", entrada=" + entrada + ", saida=" + saida
				+ ", movimentadoPor=" + movimentadoPor + "]";
	}
}
