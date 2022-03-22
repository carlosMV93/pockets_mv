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
@XmlRootElement(name = "PocketType", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "PocketType", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class PocketType implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Pocket type identifier.
     */
    private Integer id;
    /**
     * Pocket type name.
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}