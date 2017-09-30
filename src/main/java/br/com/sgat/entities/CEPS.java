package br.com.sgat.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ceps")
@NamedQueries({
	@NamedQuery(name="CEPS.buscarPorParametro",query="from CEPS c where c.RUA like:valor"),
	@NamedQuery(name="CEPS.buscarPorCep",query="from CEPS c where c.CEP =:valor")
})
public class CEPS implements Serializable{
	private Long idCEPS;
	private String CEP;
	private String RUA;
	private String BAIRRO;
	private String CIDADE;
	private String UF;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdCEPS() {
		return idCEPS;
	}
	public void setIdCEPS(Long idCEPS) {
		this.idCEPS = idCEPS;
	}
	public String getCEP() {
		return CEP;
	}
	
	@Column(unique=true)
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getRUA() {
		return RUA;
	}
	public void setRUA(String rUA) {
		RUA = rUA;
	}
	public String getBAIRRO() {
		return BAIRRO;
	}
	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}
	public String getCIDADE() {
		return CIDADE;
	}
	public void setCIDADE(String cIDADE) {
		CIDADE = cIDADE;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCEPS == null) ? 0 : idCEPS.hashCode());
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
		CEPS other = (CEPS) obj;
		if (idCEPS == null) {
			if (other.idCEPS != null)
				return false;
		} else if (!idCEPS.equals(other.idCEPS))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CEPS [idCEPS=" + idCEPS + ", CEP=" + CEP + ", RUA=" + RUA + ", BAIRRO=" + BAIRRO + ", CIDADE=" + CIDADE
				+ ", UF=" + UF + "]";
	}
}
