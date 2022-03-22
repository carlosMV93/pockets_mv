package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "origin", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "origin", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Origin implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier associated to the contract.
     */
    private String id;
    /**
     * Contract number.
     */
    private String number;
    /**
     * Contract number type based on the financial product type.
     */
    private NumberType numberType;
    /**
     * Financial product associated to the contract.
     */
    private Product product;
    /**
     * Type of relation between the related contract and the account.
     */
    private RelationType relationType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(NumberType numberType) {
        this.numberType = numberType;
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
}