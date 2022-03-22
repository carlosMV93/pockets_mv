package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "balance", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "balance", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Balance implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Type of balance associated with the pocket.
     */
    private String id;
    /**
     * Mode that applies the pocket balance.
     */
    private String mode;
    /**
     * Monetary amount.
     */
    private BigDecimal amount;
    /**
     * String based on ISO-4217 for specifying the currency related to the amount.
     */
    private String currency;
    /**
     * Detail mode in which the pocket balance is applied.
     */
    private Object unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Object getUnit() {
        return unit;
    }

    public void setUnit(Object unit) {
        this.unit = unit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}