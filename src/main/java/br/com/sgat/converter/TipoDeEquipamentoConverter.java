package br.com.sgat.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgat.dao.TipoDeEquipamentoDAO;
import br.com.sgat.entities.TipoDeEquipamento;

@FacesConverter("tipoDeEqipamentoConverter")
public class TipoDeEquipamentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			Long codigo = Long.parseLong(value);
			TipoDeEquipamentoDAO dao = new TipoDeEquipamentoDAO();
			TipoDeEquipamento tipoDeEquipamento = dao.buscarPorCodigo(codigo);
			return tipoDeEquipamento;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			TipoDeEquipamento tipoDeEquipamento = (TipoDeEquipamento) value;
			Long codigo = tipoDeEquipamento.getIdTipoDeEquipamento();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}

}
