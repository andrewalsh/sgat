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

@SuppressWarnings("serial")
@Entity
@Table(name="pecasutilizadas")
public class PecasUtilizadas implements Serializable{

	private long idPecasUtilizadas;
	private Peca peca;
	private OrdemDeServico ordemDeServico;
	private Date data;
	private int qtdPeca;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdPecasUtilizadas() {
		return idPecasUtilizadas;
	}
	public void setIdPecasUtilizadas(long idPecasUtilizadas) {
		this.idPecasUtilizadas = idPecasUtilizadas;
	}
	
	@ManyToOne
	@JoinColumn(name="idPeca",referencedColumnName="idPeca",nullable=false)
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	@ManyToOne
	@JoinColumn(name="os",referencedColumnName="idOrdemDeServico",nullable=false)
	public OrdemDeServico getOrdemDeServico() {
		return ordemDeServico;
	}
	public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQtdPeca() {
		return qtdPeca;
	}
	public void setQtdPeca(int qtdPeca) {
		this.qtdPeca = qtdPeca;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPecasUtilizadas ^ (idPecasUtilizadas >>> 32));
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
		PecasUtilizadas other = (PecasUtilizadas) obj;
		if (idPecasUtilizadas != other.idPecasUtilizadas)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PecasUtilizadas [idPecasUtilizadas=" + idPecasUtilizadas + ", peca=" + peca + ", ordemDeServico="
				+ ordemDeServico + ", data=" + data + ", qtdPeca=" + qtdPeca + "]";
	}
	
}
