package com.bbva.pzic.pockets.canonic;

import com.bbva.pzic.routine.commons.utils.CustomCalendarAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "contribution", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "contribution", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contribution implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Amount you wish to establish to make the contribution to the selected
     * pocket.
     */
    private Import contributionAmount;
    /**
     * Number of the operation, when the contribution was made to the pocket.
     */
    private String operationNumber;
    /**
     * String based on ISO-8601 date of operation associated with the
     * contribution of the selected pocket.
     */
    @XmlJavaTypeAdapter(CustomCalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    private Calendar operationDate;

    public Import getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(Import contributionAmount) {
        this.contributionAmount = contributionAmount;
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