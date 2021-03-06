package uy.com.ceoyphoibe.sgia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import uy.com.ceoyphoibe.SGIA.controller.RegistroRol;
import uy.com.ceoyphoibe.SGIA.model.Rol;
/**
 * La clase RolBean controla a las páginas de la vista relacionadas a los roles y establece las comunicaciones necesarias con el EJB para ejecutar las tareas solicitadas.
 */
@ManagedBean
@RequestScoped
public class RolBean {

	@Inject
	private RegistroRol registroRol;

	private Rol rolTemp = new Rol();

	public void registrar() {
		try {
			registroRol.registro(rolTemp);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se registró ", "con éxito!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			rolTemp = new Rol();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al registrar ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	/**
	 * @return the rolTemp
	 */
	public Rol getRolTemp() {
		return rolTemp;
	}

	/**
	 * @param rolTemp
	 *            the rolTemp to set
	 */
	public void setRolTemp(Rol rolTemp) {
		this.rolTemp = rolTemp;
	}

	public void onEdit(RowEditEvent event) {
		Rol rol = ((Rol) event.getObject());

		try {
			registroRol.modificar(rol);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se modificó ", rol.getRol());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Error al modificar ", rol.getRol());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló modificar ",
				((Rol) event.getObject()).getRol());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminar(Long id) {
		try {
			registroRol.eliminar(id);
			FacesMessage msg = new FacesMessage("Se eliminó ", id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Error al eliminar",
					id.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
}
