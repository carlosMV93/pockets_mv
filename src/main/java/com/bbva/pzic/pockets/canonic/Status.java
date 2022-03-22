package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "Status", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "Status", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Indicator status pocket.
     */
    private String id;
    /**
     * Status name.
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