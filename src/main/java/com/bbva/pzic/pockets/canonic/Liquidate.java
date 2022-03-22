package com.bbva.pzic.pockets.canonic;

import com.bbva.pzic.routine.commons.utils.CustomCalendarAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "liquidate", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "liquidate", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Liquidate implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Number of the operation, when the pocket is eliminated.
     */
    private String operationNumber;
    /**
     * String based on ISO-8601 date format to specify the date on which the
     * operation was registered.
     */
    @XmlJavaTypeAdapter(CustomCalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    private Calendar operationDate;
    /**
     * Amount of the current balance of the pocket.
     */
    private Import currentAmount;

    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }

    public Calendar getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Calendar operationDate) {
        this.operationDate = operationDate;
    }

    public Import getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Import currentAmount) {
        this.currentAmount = currentAmount;
    }
}