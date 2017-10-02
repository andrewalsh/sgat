package br.com.sgat.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgat.dao.MaoDeObraDAO;
import br.com.sgat.entities.MaoDeObra;
import br.com.sgat.util.FacesUtilBean;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MaoDeObraBean implements Serializable{

	private MaoDeObra maoDeObra;
	private List<MaoDeObra> maoDeObras;
	
	
	public MaoDeObra getMaoDeObra() {
		if(this.maoDeObra == null) {
			this.maoDeObra = new MaoDeObra();
		}
		return maoDeObra;
	}
	public void setMaoDeObra(MaoDeObra maoDeObra) {
		this.maoDeObra = maoDeObra;
	}
	public List<MaoDeObra> getMaoDeObras() {
		return maoDeObras;
	}
	public void setMaoDeObras(List<MaoDeObra> maoDeObras) {
		this.maoDeObras = maoDeObras;
	}
	
	
	public void listar() {
		try {
			MaoDeObraDAO dao = new MaoDeObraDAO();
			maoDeObras = dao.listar();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao listar os tipos de mão de obra cadastrados. ERRO [ "+e.getMessage()+" ]");
		}
	}
	
	public void slavar() {
		if(this.maoDeObra.getIdMaoDeObra() <= 0) {
			cadastrar();
		}else {
			atualizar();
		}
	}
	
	public void popularMaoDeObra(MaoDeObra maoDeObra) {
		this.maoDeObra = maoDeObra;
	}
	
	public void novo() {
		this.maoDeObra = new MaoDeObra();
	}
	
	private void cadastrar() {
		try {
			MaoDeObraDAO dao = new MaoDeObraDAO();
			dao.salvar(this.maoDeObra);
			FacesUtilBean.msgInfo("Dados do tipo de mão de obra cadastrados com sucesso.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao cadastrar os dados do tipo de mão de obra. ERRO [ "+e.getMessage()+" ]");
		}
	}
	
	private void atualizar() {
		try {
			MaoDeObraDAO dao = new MaoDeObraDAO();
			dao.atualizar(this.maoDeObra);
			FacesUtilBean.msgInfo("Dados do tipo de mão de obra atualizados com sucesso.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			FacesUtilBean.msgErro("Ocorreu um erro ao atualizar os dados do tipo de mão de obra. ERRO [ "+e.getMessage()+" ]");
		}
	}
}
