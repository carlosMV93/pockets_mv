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
@XmlRootElement(name = "importMode", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "importMode", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportMode extends Balance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Monetary amount.
     */
    private BigDecimal amount;
    /**
     * String based on ISO-4217 for specifying the currency related to the
     * amount.
     */
    private String currency;

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
