package converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dao.implementation.TipoQuartoDAOImplementation;
import model.TipoQuarto;

@ManagedBean(name = "tipoQuartoConverterBean") 
@FacesConverter(value = "tipoQuartoConverter")
public class TipoQuartoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		return new TipoQuartoDAOImplementation().find(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		return String.valueOf(((TipoQuarto)o).getId());
	}
	
}
