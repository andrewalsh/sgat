package br.com.sgat.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgat.dao.FabricanteDAO;
import br.com.sgat.entities.Fabricante;

@FacesConverter("fabricanteConverter")
public class FabricanteConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			Long codigo = Long.parseLong(value);
			FabricanteDAO dao = new FabricanteDAO();
			Fabricante fabricante = dao.buscarPorCodigo(codigo);
			return fabricante;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			Fabricante fabricante = (Fabricante) value;
			Long codigo = fabricante.getIdFabricante();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}

}
