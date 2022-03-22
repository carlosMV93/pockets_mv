package com.bbva.pzic.pockets.canonic;

import com.bbva.jee.arq.spring.core.servicing.utils.DateAdapter;
import com.bbva.pzic.routine.commons.utils.CustomCalendarAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "operation", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "operation", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Unique identifier of the operation.
     */
    private String id;
    /**
     * Additional information about the operation.
     */
    private String additionalInformation;
    /**
     * Amount of the operation related to the transaction of a pocket.
     */
    private Import operationAmount;
    /**
     * Number of the operation related to the operation of a pocket.
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
     * Operation type identifier associated with the pocket.
     */
    private OperationType operationType;
    /**
     * Customer's contract that is being queried. When customer is performing an
     * account's transactions query in this attribute must be setted the
     * information about that account. It occurs the same for other products
     * which transaction can be queried (i.e. cards, loans, etc…)
     */
    private Origin origin;
    /**
     * Establishment where the transaction was made with savings by rounding.
     */
    private String establishmentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Import getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(Import operationAmount) {
        this.operationAmount = operationAmount;
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

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }
}