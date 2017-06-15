package converter;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import controller.BaseEntity;

@ManagedBean(name = "simpleEntityConverterBean") 
@FacesConverter(value = "simpleEntityConverter")
public class SimpleEntityConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (value != null) {
			System.out.println("passou aqui!");
			Object values = this.getAttributesFrom(component).get(value);
			System.out.println("valor: "+ values.toString());
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object value) {

		if (value != null
				&& !"".equals(value)) {

			BaseEntity entity = (BaseEntity) value;

			// adiciona item como atributo do componente
			this.addAttribute(component, entity);

			Long codigo = entity.getChaveUnica();
			if (codigo != null) {
				return String.valueOf(codigo);
			}
		}

		return (String) value;
	}

	protected void addAttribute(UIComponent component, BaseEntity o) {
		String key = o.getChaveUnica().toString(); // codigo da empresa como chave neste caso
		this.getAttributesFrom(component).put(key, o);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}