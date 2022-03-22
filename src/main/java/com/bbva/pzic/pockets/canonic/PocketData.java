package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 9/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "PocketData", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "PocketData", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class PocketData implements Serializable {

    private static final long serialVersionUID = 1L;

    private PocketV00 data;

    public PocketV00 getData() {
        return data;
    }

    public void setData(PocketV00 data) {
        this.data = data;
    }
}
