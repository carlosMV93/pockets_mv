package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "relatedContracts", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "relatedContracts", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedContracts implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * RelatedContract Data List
     */
    private List<RelatedContract> data;

    public List<RelatedContract> getData() {
        return data;
    }

    public void setData(List<RelatedContract> data) {
        this.data = data;
    }
}