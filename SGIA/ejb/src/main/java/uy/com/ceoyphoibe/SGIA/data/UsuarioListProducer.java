
package uy.com.ceoyphoibe.SGIA.data;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import uy.com.ceoyphoibe.SGIA.model.Usuario;
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto Usuario
 */
@RequestScoped
public class UsuarioListProducer {

	@Inject
	private EntityManager em;

	private List<Usuario> usuarios;

	@Produces
	@Named
	public List<Usuario> getUsuario() {
		return usuarios;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Usuario usuario) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = cb.createQuery(Usuario.class);
		Root<Usuario> usuario = criteria.from(Usuario.class);
		criteria.select(usuario).orderBy(cb.asc(usuario.get("id")));
		usuarios = em.createQuery(criteria).getResultList();
	}
}
