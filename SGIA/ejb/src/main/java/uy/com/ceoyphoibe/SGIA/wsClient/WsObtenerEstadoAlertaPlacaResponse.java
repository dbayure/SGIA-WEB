
package uy.com.ceoyphoibe.SGIA.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsObtenerEstadoAlertaPlacaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsObtenerEstadoAlertaPlacaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wsObtenerEstadoAlertaPlacaResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsObtenerEstadoAlertaPlacaResponse", propOrder = {
    "wsObtenerEstadoAlertaPlacaResult"
})
public class WsObtenerEstadoAlertaPlacaResponse {

    @XmlElement(required = true)
    protected String wsObtenerEstadoAlertaPlacaResult;

    /**
     * Gets the value of the wsObtenerEstadoAlertaPlacaResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsObtenerEstadoAlertaPlacaResult() {
        return wsObtenerEstadoAlertaPlacaResult;
    }

    /**
     * Sets the value of the wsObtenerEstadoAlertaPlacaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsObtenerEstadoAlertaPlacaResult(String value) {
        this.wsObtenerEstadoAlertaPlacaResult = value;
    }

}
