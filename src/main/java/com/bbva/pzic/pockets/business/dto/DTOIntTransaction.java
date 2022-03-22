package com.bbva.pzic.pockets.business.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DTOIntTransaction {

    private Integer id;
    @Size(max = 23, groups = ValidationGroup.CreatePocketTransaction.class)
    @NotNull(groups = ValidationGroup.CreatePocketTransaction.class)
    private String pocketId;
    @NotNull(groups = ValidationGroup.CreatePocketTransaction.class)
    @Valid
    private DTOIntOperationType operationType;
    @NotNull(groups = ValidationGroup.CreatePocketTransaction.class)
    @Valid
    private DTOIntAmount amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DTOIntOperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(DTOIntOperationType operationType) {
        this.operationType = operationType;
    }

    public DTOIntAmount getAmount() {
        return amount;
    }

    public void setAmount(DTOIntAmount amount) {
        this.amount = amount;
    }

    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }
}