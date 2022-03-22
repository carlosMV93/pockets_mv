package com.bbva.pzic.pockets.canonic;

import com.bbva.pzic.routine.commons.utils.CustomCalendarAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "withdrawal", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "withdrawal", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Withdrawal implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Amount to the withdrawal made to the selected pocket.
     */
    private Import withdrawalAmount;
    /**
     * Number of the operation, when the contribution is withdrawn into the
     * pocket.
     */
    private String operationNumber;
    /**
     * String based on ISO-8601 date of operation associated with the withdrawal
     * of the selected pocket.
     */
    @XmlJavaTypeAdapter(CustomCalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    private Calendar operationDate;

    public Import getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(Import withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

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
}