package uy.com.ceoyphoibe.sgia.converter;

import java.net.URL;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpServletRequest;
import org.codehaus.jackson.map.ObjectMapper;
import uy.com.ceoyphoibe.SGIA.model.ActuadorAvance;
/**
 * Clase utilizada para convertir un objeto ActuadorAvance para ser utilizado en la vista
 */
@FacesConverter(forClass = ActuadorAvance.class, value = "actuadorAvanceConverter")
public class ActuadorAvanceConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.trim().equals("")) {
			value = ((HttpServletRequest) context.getExternalContext()
					.getRequest()).getParameter(component.getClientId()
					+ "_input");
			// return null;
		}
		ActuadorAvance actuador = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			actuador = mapper.readValue(new URL(context.getExternalContext()
					.getRequestScheme()
					+ "://"
					+ context.getExternalContext().getRequestServerName()
					+ ":"
					+ context.getExternalContext().getRequestServerPort()
					+ context.getExternalContext().getRequestContextPath()
					+ "/rest/actuadoresAvance/" + value), ActuadorAvance.class);
		} catch (Exception e) {
			throw new ConverterException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error de Conversion",
					"Actuador Avance no válido"));
		}
		return actuador;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {
			return String.valueOf(((ActuadorAvance) value).getId());
		}
	}
}
