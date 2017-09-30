package br.com.sgat.main;

import java.util.ArrayList;
import java.util.List;

import br.com.sgat.dao.CepsDAO;
import br.com.sgat.dao.ClienteDAO;
import br.com.sgat.entities.CEPS;
import br.com.sgat.entities.Cliente;

public class Principal {

	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		List<String> cpf = new ArrayList<>();
		try {
			cpf = dao.listarCPF();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		for (String string : cpf) {
			System.out.println(string);
		}
	}

}
