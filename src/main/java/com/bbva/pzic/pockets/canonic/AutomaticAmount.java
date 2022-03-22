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
@XmlRootElement(name = "AutomaticAmount", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "AutomaticAmount", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class AutomaticAmount implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Value of the automatic amount in the pocket.
     */
    private BigDecimal value;
    /**
     * String based on ISO-4217 for specifying the currency of value of the
     * automatic amount in the pocket.
     */
    private String currency;
    /**
     * Period of an automatic amount in the pocket.
     */
    private Period period;
    /**
     * String based on ISO-8601 date format for specifying the day of the month
     * when the automatic amount is transferred in the pocket. It can be a value
     * between 01 and 31.
     */
    private String dayMonth;

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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(String dayMonth) {
        this.dayMonth = dayMonth;
    }
}