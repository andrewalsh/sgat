package br.com.sgat.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgat.dao.TipoDeEquipamentoDAO;
import br.com.sgat.entities.TipoDeEquipamento;
import br.com.sgat.util.FacesUtilBean;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TipoDeEquipamentoBean implements Serializable{

	private TipoDeEquipamento tipoDeEquipamento;
	private List<TipoDeEquipamento> tipoDeEquipamentos;
	
	
	public TipoDeEquipamento getTipoDeEquipamento() {
		if(this.tipoDeEquipamento == null) {
			this.tipoDeEquipamento = new TipoDeEquipamento();
		}
		return tipoDeEquipamento;
	}
	public void setTipoDeEquipamento(TipoDeEquipamento tipoDeEquipamento) {
		this.tipoDeEquipamento = tipoDeEquipamento;
	}
	public List<TipoDeEquipamento> getTipoDeEquipamentos() {
		return tipoDeEquipamentos;
	}
	public void setTipoDeEquipamentos(List<TipoDeEquipamento> tipoDeEquipamentos) {
		this.tipoDeEquipamentos = tipoDeEquipamentos;
	}
	
	
	public void listar() {
		try {
			TipoDeEquipamentoDAO dao = new TipoDeEquipamentoDAO();
			tipoDeEquipamentos = dao.listar();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao listar os Tipos de Equipamentos cadastrados. ERRO [ "+e.getMessage()+" ]");
		}
	}
	
	public void salvar() {
		if(this.tipoDeEquipamento.getIdTipoDeEquipamento() <= 0) {
			cadastrar();
		}else {
			atualizar();
		}
	}
	
	public void popularTipoDeEquipemnto(TipoDeEquipamento tipoDeEquipamento) {
		this.tipoDeEquipamento = tipoDeEquipamento;
	}
	
	public void novo() {
		this.tipoDeEquipamento = new TipoDeEquipamento();
	}
	
	private void cadastrar() {
		try {
			TipoDeEquipamentoDAO dao = new TipoDeEquipamentoDAO();
			dao.salvar(this.tipoDeEquipamento);
			FacesUtilBean.msgInfo("Dados cadastrais do Tipo de Equipamento salvos com sucesso.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao cadastrar os dados do Tipos de Equipamentos cadastrados. ERRO [ "+e.getMessage()+" ]");
		}
	}
	
	private void atualizar() {
		try {
			TipoDeEquipamentoDAO dao = new TipoDeEquipamentoDAO();
			dao.atualizar(this.tipoDeEquipamento);
			FacesUtilBean.msgInfo("Dados cadastrais do Tipo de Equipamento atualizados com sucesso.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao atualizar os dados do Tipos de Equipamentos cadastrados. ERRO [ "+e.getMessage()+" ]");
		}
	}
}
