package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "scheduledDeposit", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "scheduledDeposit", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScheduledDeposit implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Amount that will be contributed periodically to the pocket.
     */
    private Import depositAmount;
    /**
     * This represents the frequency with which a deposit will be made to the
     * pocket.
     */
    private Period period;

    public Import getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Import depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}