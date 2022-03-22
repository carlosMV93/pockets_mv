package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DTOIntPocket {

    @NotNull(groups = { ValidationGroup.ModifyPocket.class })
    @Size(max = 23, groups = { ValidationGroup.ModifyPocket.class })
    private String id;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    @Size(max = 60, groups = ValidationGroup.ModifyPocket.class)
    private String name;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    @Size(max = 20, groups = ValidationGroup.ModifyPocket.class)
    private String shortName;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    private Date goalDate;

    @Digits(integer = 3, fraction = 0, groups = { ValidationGroup.ModifyPocket.class })
    private Integer priority;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    private Boolean isAutomaticAmount;

    @Valid
    private DTOIntAutomaticAmount automaticAmount;

    @Valid
    @NotNull(groups = ValidationGroup.CreatePocket.class)
    private DTOIntGoalAmount goalAmount;

    @Valid
    @NotNull(groups = ValidationGroup.CreatePocket.class)
    private DTOIntPocketType pocketType;

    @Valid
    @NotNull(groups = ValidationGroup.CreatePocketV2.class)
    private DTOIntRelatedContract relatedContract;

    @Valid
    @NotNull(groups = ValidationGroup.CreatePocketV2.class)
    private DTOIntCategory category;

    @NotNull(groups = ValidationGroup.CreatePocketV2.class)
    @Size(max = 60, groups = { ValidationGroup.CreatePocketV2.class })
    private String alias;

    private Date expirationDate;

    @NotNull(groups = ValidationGroup.CreatePocketV2.class)
    private Boolean isScheduled;

    @Valid
    private DTOIntScheduledDeposit scheduledDeposit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Date getGoalDate() {
        if (goalDate == null) {
            return null;
        }
        return new Date(goalDate.getTime());
    }

    public void setGoalDate(Date goalDate) {
        if (goalDate == null) {
            this.goalDate = null;
        } else {
            this.goalDate = new Date(goalDate.getTime());
        }
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getIsAutomaticAmount() {
        return isAutomaticAmount;
    }

    public void setIsAutomaticAmount(Boolean isAutomaticAmount) {
        this.isAutomaticAmount = isAutomaticAmount;
    }

    public DTOIntAutomaticAmount getAutomaticAmount() {
        return automaticAmount;
    }

    public void setAutomaticAmount(DTOIntAutomaticAmount automaticAmount) {
        this.automaticAmount = automaticAmount;
    }

    public DTOIntGoalAmount getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(DTOIntGoalAmount goalAmount) {
        this.goalAmount = goalAmount;
    }

    public DTOIntPocketType getPocketType() {
        return pocketType;
    }

    public void setPocketType(DTOIntPocketType pocketType) {
        this.pocketType = pocketType;
    }

    public DTOIntRelatedContract getRelatedContract() {
        return relatedContract;
    }

    public void setRelatedContract(DTOIntRelatedContract relatedContract) {
        this.relatedContract = relatedContract;
    }

    public DTOIntCategory getCategory() {
        return category;
    }

    public void setCategory(DTOIntCategory category) {
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

    public DTOIntScheduledDeposit getScheduledDeposit() {
        return scheduledDeposit;
    }

    public void setScheduledDeposit(DTOIntScheduledDeposit scheduledDeposit) {
        this.scheduledDeposit = scheduledDeposit;
    }

}
