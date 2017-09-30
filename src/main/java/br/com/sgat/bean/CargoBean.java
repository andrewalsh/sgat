package br.com.sgat.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgat.dao.CargoDAO;
import br.com.sgat.entities.Cargo;
import br.com.sgat.util.FacesUtilBean;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CargoBean implements Serializable{

	private Cargo cargo;
	private List<Cargo> cargos;
	
	
	public Cargo getCargo() {
		if(this.cargo == null) {
			this.cargo = new Cargo();
		}
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
	public void listar() {
		CargoDAO dao = new CargoDAO();
		try {
			cargos = dao.listar();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao listar os CARGOS cadastrados. ERRO [ "+e.getMessage()+" ]");
		}
	}
	
	public void novo() {
		this.cargo = new Cargo();
	}
	
	public void popularCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public void salvar() {
		if(this.cargo.getIdCargo() <= 0) {
			CargoDAO dao = new CargoDAO();
			try {
				dao.salvar(this.cargo);
				FacesUtilBean.msgInfo("Dados cadastrais do CARGO salvos com sucesso.");
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				FacesUtilBean.msgErro("Ocorreu um erro ao tentar salvar os dados cadastrais. ERRO [ "+e.getMessage()+" ]");
			}
		}else {
			atualizar();
		}
	}
	
	private void atualizar() {
		CargoDAO dao = new CargoDAO();
		try {
			dao.atualizar(this.cargo);
			FacesUtilBean.msgInfo("Dados cadastrais do CARGO atualizados com sucesso.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao atualizar os dados cadastrais. ERRO [ "+e.getMessage()+" ]");
		}
	}
}
