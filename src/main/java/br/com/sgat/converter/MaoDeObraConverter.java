package br.com.sgat.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgat.dao.MaoDeObraDAO;
import br.com.sgat.entities.MaoDeObra;

@FacesConverter("maoDeObraConverter")
public class MaoDeObraConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			Long codigo = Long.parseLong(value);
			MaoDeObraDAO dao = new MaoDeObraDAO();
			MaoDeObra maoDeObra = dao.buscrPorCodigo(codigo);
			return maoDeObra;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			MaoDeObra maoDeObra = (MaoDeObra) value;
			Long codigo = maoDeObra.getIdMaoDeObra();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}

}
