package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "liquidateData", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "liquidateData", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class LiquidateData implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Liquidate Data
     */
    private Liquidate data;

    public Liquidate getData() {
        return data;
    }

    public void setData(Liquidate data) {
        this.data = data;
    }
}