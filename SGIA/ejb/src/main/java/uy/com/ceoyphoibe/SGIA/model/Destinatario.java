package uy.com.ceoyphoibe.SGIA.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "destinatarios")
public class Destinatario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idDestinatario;
	private String nombre;
	private String celular;
	private String mail;
	private int horaMin;
	private int horaMax;
	private char activoSistema;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "placa_id", referencedColumnName = "id")
	private Placa placa;

	/**
	 * @return the idDestinatario
	 */
	public Long getIdDestinatario() {
		return idDestinatario;
	}

	/**
	 * @param idDestinatario
	 *            the idDestinatario to set
	 */
	public void setIdDestinatario(Long idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular
	 *            the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the horaMin
	 */
	public int getHoraMin() {
		return horaMin;
	}

	/**
	 * @param horaMin
	 *            the horaMin to set
	 */
	public void setHoraMin(int horaMin) {
		this.horaMin = horaMin;
	}

	/**
	 * @return the horaMax
	 */
	public int getHoraMax() {
		return horaMax;
	}

	/**
	 * @param horaMax
	 *            the horaMax to set
	 */
	public void setHoraMax(int horaMax) {
		this.horaMax = horaMax;
	}

	/**
	 * @return the activoSistema
	 */
	public char getActivoSistema() {
		return activoSistema;
	}

	/**
	 * @param activoSistema
	 *            the activoSistema to set
	 */
	public void setActivoSistema(char activoSistema) {
		this.activoSistema = activoSistema;
	}

	/**
	 * @return the placa
	 */
	public Placa getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activoSistema;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + horaMax;
		result = prime * result + horaMin;
		result = prime * result
				+ ((idDestinatario == null) ? 0 : idDestinatario.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destinatario other = (Destinatario) obj;
		if (activoSistema != other.activoSistema)
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (horaMax != other.horaMax)
			return false;
		if (horaMin != other.horaMin)
			return false;
		if (idDestinatario == null) {
			if (other.idDestinatario != null)
				return false;
		} else if (!idDestinatario.equals(other.idDestinatario))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Destinatario [idDestinatario=" + idDestinatario + ", nombre="
				+ nombre + ", celular=" + celular + ", mail=" + mail
				+ ", horaMin=" + horaMin + ", horaMax=" + horaMax
				+ ", activoSistema=" + activoSistema + "]";
	}

}
