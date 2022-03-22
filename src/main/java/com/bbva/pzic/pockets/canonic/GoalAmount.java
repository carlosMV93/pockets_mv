package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "GoalAmount", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "GoalAmount", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class GoalAmount implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Value of amount goal in the pocket.
     */
    private BigDecimal value;
    /**
     * String based on ISO-4217 for specifying the currency of value of goal
     * amount in the pocket.
     */
    private String currency;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}