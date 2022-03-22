package com.bbva.pzic.pockets.canonic;

import com.bbva.jee.arq.spring.core.servicing.utils.ShortDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "Transaction", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "Transaction", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Unique identifier of the transaction.
     */
    private Integer id;
    /**
     * Type of transaction operation. This type identifies to certain type of
     * transaction operation in the pocket.
     */
    private OperationType operationType;
    /**
     * Amount that is the deposited or withdrawn in the pocket.
     */
    private Amount amount;
    /**
     * Additional information about the transaction.
     */
    private String additionalInformation;
    /**
     * String based on ISO-8601 date format for specifying the date when the
     * transaction has been performed.
     */
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    private Date creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}