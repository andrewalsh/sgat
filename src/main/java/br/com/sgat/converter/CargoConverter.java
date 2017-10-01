package br.com.sgat.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgat.dao.CargoDAO;
import br.com.sgat.entities.Cargo;

@FacesConverter("cargoConverter")
public class CargoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			Long codigo = Long.parseLong(value);
			CargoDAO dao = new CargoDAO();
			Cargo cargo = dao.buscarPorCodigo(codigo);
			return cargo;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			Cargo cargo = (Cargo) value;
			Long codigo = cargo.getIdCargo();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}

}
