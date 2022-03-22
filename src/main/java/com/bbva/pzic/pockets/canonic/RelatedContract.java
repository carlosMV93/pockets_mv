package com.bbva.pzic.pockets.canonic;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;
import com.bbva.jee.arq.spring.core.servicing.utils.ShortDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "relatedContract", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "relatedContract", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedContract implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Contract number.
     */
    private String number;
    /**
     * Financial product associated to the contract.
     */
    private Product product;
    /**
     * Type of relation between the related contract and the account.
     */
    private RelationType relationType;
    /**
     * Identifier associated to the relationship between the pocket and the
     * account.
     */
    @DatoAuditable(omitir = true)
    private String id;
    /**
     * Identifier associated to the contract.
     */
    private String contractId;
    /**
     * String based on the ISO-8601 date format for the date the savings
     * affiliation was created by rounding.
     */
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    private Date relationDate;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Date getRelationDate() {
        return relationDate;
    }

    public void setRelationDate(Date relationDate) {
        this.relationDate = relationDate;
    }
}