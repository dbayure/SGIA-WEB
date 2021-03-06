
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
import uy.com.ceoyphoibe.SGIA.model.Sensor;
/**
 * Clase de apoyo que permite la interacción con el entity manager para obtener desde base de datos listas del objeto Sensor
 */
@RequestScoped
public class SensorListProducer {

	@Inject
	private EntityManager em;

	private List<Sensor> sensores;

	@Produces
	@Named
	public List<Sensor> getSensores() {
		return sensores;
	}

	public void onListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Sensor sensor) {
		retrieveAllOrderedByName();
	}

	@PostConstruct
	public void retrieveAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Sensor> criteria = cb.createQuery(Sensor.class);
		Root<Sensor> sensor = criteria.from(Sensor.class);
		criteria.select(sensor).orderBy(cb.asc(sensor.get("nombre")));
		criteria.where(cb.equal(sensor.get("activoSistema"), 'S'));
		sensores = em.createQuery(criteria).getResultList();
	}
}
