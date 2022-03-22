package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created on 10/01/2020.
 *
 * @author Entelgy
 */
public class DTOIntPocketV2 {

    @NotNull(groups = { ValidationGroup.ModifyPocketV2.class })
    @Size(max = 23, groups = { ValidationGroup.ModifyPocketV2.class })
    private String id;

    @NotNull(groups = ValidationGroup.ModifyPocketV2.class)
    @Size(max = 3, groups = { ValidationGroup.ModifyPocketV2.class })
    private String priority;

    @Valid
    private DTOIntGoalAmountV2 goalAmount;

    @Valid
    private DTOIntCategoryV2 category;

    @Size(max = 60, groups = { ValidationGroup.ModifyPocketV2.class })
    private String alias;

    private Date expirationDate;

    private Boolean isScheduled;

    @Valid
    private DTOIntScheduledDepositV2 scheduledDeposit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public DTOIntGoalAmountV2 getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(DTOIntGoalAmountV2 goalAmount) {
        this.goalAmount = goalAmount;
    }

    public DTOIntCategoryV2 getCategory() {
        return category;
    }

    public void setCategory(DTOIntCategoryV2 category) {
        this.category = category;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getIsScheduled() {
        return isScheduled;
    }

    public void setIsScheduled(Boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public DTOIntScheduledDepositV2 getScheduledDeposit() {
        return scheduledDeposit;
    }

    public void setScheduledDeposit(DTOIntScheduledDepositV2 scheduledDeposit) {
        this.scheduledDeposit = scheduledDeposit;
    }

}
