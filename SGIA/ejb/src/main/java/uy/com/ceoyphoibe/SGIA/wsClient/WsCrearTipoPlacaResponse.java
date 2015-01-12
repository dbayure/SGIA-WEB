package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for wsCrearTipoPlacaResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsCrearTipoPlacaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsCrearTipoPlacaResult" type="{Comunicacion.Comunicacion}ResultadoCreacionWS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsCrearTipoPlacaResponse", propOrder = { "wsCrearTipoPlacaResult" })
public class WsCrearTipoPlacaResponse {

	@XmlElement(required = true)
	protected ResultadoCreacionWS wsCrearTipoPlacaResult;

	/**
	 * Gets the value of the wsCrearTipoPlacaResult property.
	 * 
	 * @return possible object is {@link ResultadoCreacionWS }
	 * 
	 */
	public ResultadoCreacionWS getWsCrearTipoPlacaResult() {
		return wsCrearTipoPlacaResult;
	}

	/**
	 * Sets the value of the wsCrearTipoPlacaResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ResultadoCreacionWS }
	 * 
	 */
	public void setWsCrearTipoPlacaResult(ResultadoCreacionWS value) {
		this.wsCrearTipoPlacaResult = value;
	}

}
