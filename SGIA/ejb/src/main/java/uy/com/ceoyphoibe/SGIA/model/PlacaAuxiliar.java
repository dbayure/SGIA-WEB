
package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/**
 * La clase PlacaAuxiliar representa a todo dispositivo que puede controlar a otros dispositivos, y que se puede instanciar a nivel de placa controladora como un interface kit.
 */
@Entity
@XmlRootElement
@Table(name = "placaAuxiliar")
@JsonIgnoreProperties({ "placa", "listaDispositivos" })
public class PlacaAuxiliar extends Dispositivo implements Serializable {


	private static final long serialVersionUID = -1207751157271188774L;

	private String numeroSerie;
	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoPlacaAuxiliar_id", unique = false)
	private TipoPlacaAuxiliar tipoPlacaAuxiliar;
	private int numeroPuertoAnal;
	private int numeroPuertoEDig;
	private int numeroPuertoSdig;

	@OneToMany(mappedBy = "padre", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.EAGER)
	private List<Dispositivo> listaDispositivos;

	/**
	 * @return la lista de dispositivos hijos conectados directamente a la placa auxilair.
	 */
	public List<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}

	/**
	 * @param listaDispositivos
	 *            La lista de dispositivos hijos a asignar.
	 */
	public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}

	/**
	 * @return el número de serie de la placa auxiliar.
	 */
	public String getNumeroSerie() {
		return numeroSerie;
	}

	/**
	 * @param numeroSerie
	 * 					El número de serie a asignar.
	 */
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	/**
	 * @return el tipo de placa auxiliar al que pertenece.
	 */
	public TipoPlacaAuxiliar getTipoPlacaAuxiliar() {
		return tipoPlacaAuxiliar;
	}

	/**
	 * @param tipoPlacaAuxiliar
	 *            El tipo de placa auxiliar a asignar.
	 */
	public void setTipoPlacaAuxiliar(TipoPlacaAuxiliar tipoPlacaAuxiliar) {
		this.tipoPlacaAuxiliar = tipoPlacaAuxiliar;
	}

	/**
	 * @return el número de puertos analógicos de la placa auxiliar.
	 */
	public int getNumeroPuertoAnal() {
		return numeroPuertoAnal;
	}

	/**
	 * @param numeroPuertoAnal
	 * 						El número de puertos analógicos a asignar.
	 */
	public void setNumeroPuertoAnal(int numeroPuertoAnal) {
		this.numeroPuertoAnal = numeroPuertoAnal;
	}

	/**
	 * @return el número de puertos de entrada digital.
	 */
	public int getNumeroPuertoEDig() {
		return numeroPuertoEDig;
	}

	/**
	 * @param numeroPuertoEDig
	 * 						El número de puertos de entrada digital a asignar.
	 */
	public void setNumeroPuertoEDig(int numeroPuertoEDig) {
		this.numeroPuertoEDig = numeroPuertoEDig;
	}

	/** 
	 * @return el número de puertos de salida digital.
	 */
	public int getNumeroPuertoSdig() {
		return numeroPuertoSdig;
	}

	/**
	 * @param numeroPuertoSdig
	 * 						El número de puertos de salida digital a asignar.
	 */
	public void setNumeroPuertoSdig(int numeroPuertoSdig) {
		this.numeroPuertoSdig = numeroPuertoSdig;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numeroPuertoAnal;
		result = prime * result + numeroPuertoEDig;
		result = prime * result + numeroPuertoSdig;
		result = prime * result
				+ ((numeroSerie == null) ? 0 : numeroSerie.hashCode());
		result = prime
				* result
				+ ((tipoPlacaAuxiliar == null) ? 0 : tipoPlacaAuxiliar
						.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlacaAuxiliar other = (PlacaAuxiliar) obj;
		if (numeroPuertoAnal != other.numeroPuertoAnal)
			return false;
		if (numeroPuertoEDig != other.numeroPuertoEDig)
			return false;
		if (numeroPuertoSdig != other.numeroPuertoSdig)
			return false;
		if (numeroSerie == null) {
			if (other.numeroSerie != null)
				return false;
		} else if (!numeroSerie.equals(other.numeroSerie))
			return false;
		if (tipoPlacaAuxiliar == null) {
			if (other.tipoPlacaAuxiliar != null)
				return false;
		} else if (!tipoPlacaAuxiliar.equals(other.tipoPlacaAuxiliar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlacaAuxiliar [numeroSerie=" + numeroSerie
				+ ", tipoPlacaAuxiliar=" + tipoPlacaAuxiliar
				+ ", numeroPuertoAnal=" + numeroPuertoAnal
				+ ", numeroPuertoEDig=" + numeroPuertoEDig
				+ ", numeroPuertoSdig=" + numeroPuertoSdig + "]";
	}

}
