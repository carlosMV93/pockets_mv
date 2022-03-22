package com.bbva.pzic.pockets.canonic;

import com.bbva.jee.arq.spring.core.servicing.annotations.IdEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "relatedContractId", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "relatedContractId", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedContractId implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * RelatedContract identifier
     */
    @IdEntity
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}