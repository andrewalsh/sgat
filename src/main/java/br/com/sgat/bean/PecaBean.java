package br.com.sgat.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgat.dao.FabricanteDAO;
import br.com.sgat.dao.PecaDAO;
import br.com.sgat.dao.TipoDeEquipamentoDAO;
import br.com.sgat.entities.Fabricante;
import br.com.sgat.entities.Peca;
import br.com.sgat.entities.TipoDeEquipamento;
import br.com.sgat.util.FacesUtilBean;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PecaBean implements Serializable{

	private Peca peca;
	private List<Peca> pecas;
	private List<Fabricante> fabricantes;
	private List<TipoDeEquipamento> tiposDeEquipamento;
	
	
	public Peca getPeca() {
		if(this.peca == null) {
			this.peca = new Peca();
			this.peca.setFabricante(new Fabricante());
			this.peca.setTipo(new TipoDeEquipamento());
		}
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	public List<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	public List<TipoDeEquipamento> getTiposDeEquipamento() {
		return tiposDeEquipamento;
	}
	public void setTiposDeEquipamento(List<TipoDeEquipamento> tiposDeEquipamento) {
		this.tiposDeEquipamento = tiposDeEquipamento;
	}
	
	
	public void listar() {
		listarPecas();
		listarFabricantes();
		listarTiposDeEquipamentos();
	}
	
	public void salvar() {
		if(this.peca.getIdPeca() <= 0) {
			cadastrar();
		}else {
			atualizar();
		}
	}
	
	public void popularPeca(Peca peca) {
		this.peca = peca;
	}
	
	public void novo() {
		this.peca = new Peca();
		this.peca.setFabricante(new Fabricante());
		this.peca.setTipo(new TipoDeEquipamento());
	}
	
	private void cadastrar() {
		try {
			PecaDAO dao = new PecaDAO();
			dao.salvar(peca);
			FacesUtilBean.msgInfo("Dados cadastrais da peça inseridos com sucesso.");
		} catch (RuntimeException e) {
			FacesUtilBean.msgErro("Ocorreu um erro ao salvar os dados cadastrais da peça. ERRO [ "+e.getMessage()+" ]");
			System.out.println(e.getMessage());
		}
	}
	
	private void atualizar() {
		try {
			PecaDAO dao = new PecaDAO();
			dao.atualizar(peca);
			FacesUtilBean.msgInfo("Dados cadastrais da peça atualizados com sucesso.");
		} catch (RuntimeException e) {
			FacesUtilBean.msgErro("Ocorreu um erro ao atualizar os dados cadastrais da peça. ERRO [ "+e.getMessage()+" ]");
			System.out.println(e.getMessage());
		}
	}
	
	private void listarPecas() {
		try {
			PecaDAO dao = new PecaDAO();
			pecas = dao.listar();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao listar as peças cadastradas. ERRO [ "+e.getMessage()+ " ]");
		}
	}
	
	private void listarFabricantes() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listarFabricantes();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao listar os Fabricantes cadastradas. ERRO [ "+e.getMessage()+ " ]");
		}
	}
	
	private void listarTiposDeEquipamentos() {
		try {
			TipoDeEquipamentoDAO dao = new TipoDeEquipamentoDAO();
			tiposDeEquipamento = dao.listar();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao listar os Tipos de Equipamentos cadastradas. ERRO [ "+e.getMessage()+ " ]");
		}
	}
	
}
