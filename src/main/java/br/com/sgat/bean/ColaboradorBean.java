package br.com.sgat.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgat.dao.CargoDAO;
import br.com.sgat.dao.CepsDAO;
import br.com.sgat.dao.ResidenciaDAO;
import br.com.sgat.entities.CEPS;
import br.com.sgat.entities.Cargo;
import br.com.sgat.entities.Colaborador;
import br.com.sgat.entities.Pessoa;
import br.com.sgat.entities.Residencia;
import br.com.sgat.util.FacesUtilBean;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ColaboradorBean implements Serializable {

	private Colaborador colaborador;
	private CEPS cep;
	private Residencia residencia;
	private List<CEPS> ceps;
	private List<Residencia> residencias;
	private List<Cargo> cargos;
	private Cargo cargo;

	public Colaborador getColaborador() {
		if (this.colaborador == null) {
			this.colaborador = new Colaborador();
			this.colaborador.setCargo(new Cargo());
			this.colaborador.setPessoa(new Pessoa());
		}
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public CEPS getCep() {
		if (this.cep == null) {
			this.cep = new CEPS();
		}
		return cep;
	}

	public void setCep(CEPS cep) {
		this.cep = cep;
	}

	public Residencia getResidencia() {
		if (this.residencia == null) {
			this.residencia = new Residencia();
			this.residencia.setCeps(new CEPS());
			this.residencia.setColaborador(new Colaborador());
		}
		return residencia;
	}

	public void setResidencia(Residencia residencia) {
		this.residencia = residencia;
	}
	
	public Cargo getCargo() {
		if(this.cargo == null) {
			this.cargo = new Cargo();
		}
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<CEPS> getCeps() {
		return ceps;
	}

	public void setCeps(List<CEPS> ceps) {
		this.ceps = ceps;
	}

	public List<Residencia> getResidencias() {
		return residencias;
	}

	public void setResidencias(List<Residencia> residencias) {
		this.residencias = residencias;
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	public void listar() {
		listarCargos();
		listarResidencia();
	}

	public void listarColaboradores() {
		ResidenciaDAO dao = new ResidenciaDAO();
		try {
			residencias = dao.listar();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean
					.msgErro("Ocorreu um erro ao listar os COLABORADORS cadastrados. ERRO [ " + e.getMessage() + " ]");
		}
	}
	
	public void buscarPorCep() {
		CepsDAO dao = new CepsDAO();
		try {
			this.cep = dao.buscarPorCep(this.cep.getCEP());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarPorRua() {
		CepsDAO dao = new CepsDAO();
		try {
			this.ceps = dao.buscarPorParametro(this.cep.getRUA());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void popularCep(CEPS ceps) {
		this.cep = ceps;
	}
	
	public void popularColaborador(Residencia residencia) {
		this.residencia = residencia;
		this.colaborador = residencia.getColaborador();
		this.cep = residencia.getCeps();
		this.cargo = residencia.getColaborador().getCargo();
	}

	public void salvar() {
		if(this.colaborador.getIdColaborador() <= 0) {
			try {
				ResidenciaDAO dao = new ResidenciaDAO();
				this.colaborador.setCargo(this.cargo);
				this.residencia.setCeps(cep);
				this.residencia.setColaborador(colaborador);
				dao.salvar(this.residencia);
				FacesUtilBean.msgInfo("Dados cadastrais do COLABORADOR cadastrados com sucesso.");
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				FacesUtilBean.msgErro("Ocorreu um erro ao tentar salvar os dados cadastrais. ERRO [ " + e.getMessage() + "]");
			}
		}else {
			verificaAtualizar();
		}
	}
	
	public void novoCargo() {
		CargoDAO dao = new CargoDAO();
		try {
			dao.salvar(this.cargo);
			FacesUtilBean.msgInfo("Cargo cadastrado com sucesso");
			listarCargos();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao tentar salvar os dados cadastrais. ERRO [ " + e.getMessage() + "]");
		}
	}

	private void verificaAtualizar() {
		ResidenciaDAO dao = new ResidenciaDAO();
		try {
			this.residencia.setCeps(this.cep);
			this.residencia.setColaborador(this.colaborador);
			dao.atualizar(residencia);
			FacesUtilBean.msgInfo("Dados cadastrais do COLABORADOR atualizados com sucesso.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao atualizar os dados cadastrais. ERRO [ " + e.getMessage() + "]");
		}
	}
	
	private void listarCargos() {
		try {
			CargoDAO dao = new CargoDAO();
			cargos = dao.listar();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao listar os CARGOS cadastrados. ERRO [ "+e.getMessage()+" ]");
		}
	}
	
	private void listarResidencia() {
		try {
			ResidenciaDAO dao = new ResidenciaDAO();
			residencias = dao.listar();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao listar os COLABORADORES cadastrados. ERRO [ "+e.getMessage()+" ]");
		}
	}

}
