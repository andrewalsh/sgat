package br.com.sgat.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgat.dao.FabricanteDAO;
import br.com.sgat.entities.Fabricante;
import br.com.sgat.util.FacesUtilBean;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable{

	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	
	
	public Fabricante getFabricante() {
		if(this.fabricante == null) {
			this.fabricante = new Fabricante();
		}
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		try {
			fabricantes = dao.listarFabricantes();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao listar os FABRICANTES. ERRO [ "+e.getMessage()+" ]");
		}
	}
	
	public void salvar() {
		if(this.fabricante.getIdFabricante() <= 0) {
			cadastrar();
		}else {
			atualizar();
		}
	}
	
	public void popularFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void novo() {
		this.fabricante = new Fabricante();
	}
	
	private void cadastrar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(this.fabricante);
			FacesUtilBean.msgInfo("Fabricnate adicionado com sucesso.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao tentar cadastrar o Fabricante. ERRO [ "+e.getMessage()+" ]");
		}
	}
	
	private void atualizar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.atualizar(this.fabricante);
			FacesUtilBean.msgInfo("Dados do Fabricante atualizados com sucesso.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao tentar atualizar os dados do Fabricante. ERRO [ "+e.getMessage()+" ]");
		}
	}
}
