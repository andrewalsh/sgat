package br.com.sgat.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="ordemdeservico")
public class OrdemDeServico implements Serializable{

	private long idOrdemDeServico;
	private String numero;
	private Date dataInicio;
	private Date dataFim;
	private Equipamento equipamento;
	private String defeitoReclamado;
	private String laudoTecnico;
	private String acessorios;
	private String obs;
	private Colaborador cadastradoPor;
	private Colaborador tecResponsavel;
	private MaoDeObra maoDeObra;
	private Double subTotalPeca;
	private Double subTotalMO;
	private double valorTotal;
	private EnderecoDeAtendimento enderecoDeAtendimento;
	
	@Id
	@GeneratedValue
	public long getIdOrdemDeServico() {
		return idOrdemDeServico;
	}
	public void setIdOrdemDeServico(long idOrdemDeServico) {
		this.idOrdemDeServico = idOrdemDeServico;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	@ManyToOne
	@JoinColumn(name="idEquipamento",referencedColumnName="idEquipamento",nullable=false)
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public String getDefeitoReclamado() {
		return defeitoReclamado;
	}
	public void setDefeitoReclamado(String defeitoReclamado) {
		this.defeitoReclamado = defeitoReclamado;
	}
	public String getLaudoTecnico() {
		return laudoTecnico;
	}
	public void setLaudoTecnico(String laudoTecnico) {
		this.laudoTecnico = laudoTecnico;
	}
	public String getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	@ManyToOne
	@JoinColumn(name="cadastradoPor",referencedColumnName="idColaboradorador",nullable=false)
	public Colaborador getCadastradoPor() {
		return cadastradoPor;
	}
	public void setCadastradoPor(Colaborador cadastradoPor) {
		this.cadastradoPor = cadastradoPor;
	}
	
	@ManyToOne
	@JoinColumn(name="tecResponsavel",referencedColumnName="idColaborador",nullable=false)
	public Colaborador getTecResponsavel() {
		return tecResponsavel;
	}
	public void setTecResponsavel(Colaborador tecResponsavel) {
		this.tecResponsavel = tecResponsavel;
	}
	
	@ManyToOne
	@JoinColumn(name="idMaoDeObra",referencedColumnName="idMaoDeObra",nullable=true)
	public MaoDeObra getMaoDeObra() {
		return maoDeObra;
	}
	public void setMaoDeObra(MaoDeObra maoDeObra) {
		this.maoDeObra = maoDeObra;
	}
	public Double getSubTotalPeca() {
		return subTotalPeca;
	}
	public void setSubTotalPeca(Double subTotalPeca) {
		this.subTotalPeca = subTotalPeca;
	}
	public Double getSubTotalMO() {
		return subTotalMO;
	}
	public void setSubTotalMO(Double subTotalMO) {
		this.subTotalMO = subTotalMO;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@ManyToOne
	@JoinColumn(name="enderecoDeAtendimento",referencedColumnName="idEnderecoDeAtendimento",nullable=false)
	public EnderecoDeAtendimento getEnderecoDeAtendimento() {
		return enderecoDeAtendimento;
	}
	public void setEnderecoDeAtendimento(EnderecoDeAtendimento enderecoDeAtendimento) {
		this.enderecoDeAtendimento = enderecoDeAtendimento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idOrdemDeServico ^ (idOrdemDeServico >>> 32));
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
		OrdemDeServico other = (OrdemDeServico) obj;
		if (idOrdemDeServico != other.idOrdemDeServico)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrdemDeServico [idOrdemDeServico=" + idOrdemDeServico + ", numero=" + numero + ", dataInicio="
				+ dataInicio + ", dataFim=" + dataFim + ", equipamento=" + equipamento + ", defeitoReclamado="
				+ defeitoReclamado + ", laudoTecnico=" + laudoTecnico + ", acessorios=" + acessorios + ", obs=" + obs
				+ ", cadastradoPor=" + cadastradoPor + ", tecResponsavel=" + tecResponsavel + ", maoDeObra=" + maoDeObra
				+ ", subTotalPeca=" + subTotalPeca + ", subTotalMO=" + subTotalMO + ", valorTotal=" + valorTotal
				+ ", enderecoDeAtendimento=" + enderecoDeAtendimento + "]";
	}
}
