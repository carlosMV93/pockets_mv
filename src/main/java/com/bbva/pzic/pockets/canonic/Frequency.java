package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "frequency", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "frequency", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Frequency implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Frequency identifier of an automatic amount in the pocket.
     */
    private String id;
    /**
     * Name of the Frequency of an automatic pocket amount.
     */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}