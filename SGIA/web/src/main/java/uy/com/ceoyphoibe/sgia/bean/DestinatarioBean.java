package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import uy.com.ceoyphoibe.SGIA.controller.RegistroDestinatario;
import uy.com.ceoyphoibe.SGIA.model.Destinatario;
import uy.com.ceoyphoibe.SGIA.model.Mensaje;
import uy.com.ceoyphoibe.SGIA.model.Placa;

@ManagedBean
@RequestScoped
public class DestinatarioBean {

	@ManagedProperty("#{placaBean.placa}")
	private Placa placa;

	@Inject
	private RegistroDestinatario registroDestinatario;

	private Destinatario destinatarioSeleccionado = new Destinatario();

	/**
	 * 
	 */
	public DestinatarioBean() {
		destinatarioSeleccionado.setHoraMin(0);
		destinatarioSeleccionado.setHoraMax(23);
	}

	/**
	 * @return the destinatarioSeleccionado
	 */
	public Destinatario getDestinatarioSeleccionado() {
		return destinatarioSeleccionado;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	/**
	 * @param destinatarioSeleccionado
	 *            the destinatarioSeleccionado to set
	 */
	public void setDestinatarioSeleccionado(
			Destinatario destinatarioSeleccionado) {
		this.destinatarioSeleccionado = destinatarioSeleccionado;
	}

	public void registrar() {
		try {
			destinatarioSeleccionado.setPlaca(placa);
			destinatarioSeleccionado.setActivoSistema('S');
			registroDestinatario.registro(destinatarioSeleccionado);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se registró ", "con éxito!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			destinatarioSeleccionado = new Destinatario();
			destinatarioSeleccionado.setHoraMin(0);
			destinatarioSeleccionado.setHoraMax(23);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onEdit(RowEditEvent event) {
		Destinatario destinatario = ((Destinatario) event.getObject());

		try {
			Mensaje resultado = registroDestinatario.modificar(destinatario);
			if (resultado.getTipo().equals("Informativo")) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						resultado.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else {
				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, resultado.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}

		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error al modificar ", destinatario.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((Destinatario) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			Mensaje mensaje = registroDestinatario.eliminar(id);
			if (mensaje.getTipo().equals("Informativo")) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						mensaje.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else {
				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, mensaje.getTexto(), "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
}
