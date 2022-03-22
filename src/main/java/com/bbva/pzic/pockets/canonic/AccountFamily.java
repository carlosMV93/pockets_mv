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
@XmlRootElement(name = "AccountFamily", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "AccountFamily", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountFamily implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier of the account family. Each name groups accounts of the same
     * category based on their financial characteristics.
     */
    private String id;
    /**
     * Name of the account family.
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