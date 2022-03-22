package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "contributionData", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "contributionData", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContributionData implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Contribution Data
     */
    private Contribution data;

    public Contribution getData() {
        return data;
    }

    public void setData(Contribution data) {
        this.data = data;
    }
}