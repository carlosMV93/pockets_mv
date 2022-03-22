package com.bbva.pzic.pockets.business.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class InputCreatePocket {
    @NotNull(groups = ValidationGroup.CreatePocket.class)
    @Size(max = 60, groups = ValidationGroup.CreatePocket.class)
    private String name;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    @Size(max = 20, groups = ValidationGroup.CreatePocket.class)
    private String shortName;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    private Date goalDate;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    private Boolean isAutomaticAmount;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    @Digits(integer = 13, fraction = 2, groups = ValidationGroup.CreatePocket.class)
    private BigDecimal goalAmountValue;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    @Size(max = 3, groups = ValidationGroup.CreatePocket.class)
    private String goalAmountCurrency;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    @Digits(integer = 3, fraction = 0, groups = ValidationGroup.CreatePocket.class)
    private Integer pocketTypeId;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    @Size(max = 18, groups = ValidationGroup.CreatePocket.class)
    private String accountPocketNumber;

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    private String accountPocketAccountFamilyId;

    @Digits(integer = 13, fraction = 2, groups = ValidationGroup.CreatePocket.class)
    private BigDecimal automaticAmountValue;

    @Size(max = 3, groups = ValidationGroup.CreatePocket.class)
    private String automaticAmountCurrency;

    private String automaticAmountPeriodId;

    @Size(max = 2, groups = ValidationGroup.CreatePocket.class)
    private String automaticAmountDayMonth;

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

    public Boolean getIsAutomaticAmount() {
        return isAutomaticAmount;
    }

    public void setIsAutomaticAmount(Boolean isAutomaticAmount) {
        this.isAutomaticAmount = isAutomaticAmount;
    }

    public BigDecimal getGoalAmountValue() {
        return goalAmountValue;
    }

    public void setGoalAmountValue(BigDecimal goalAmountValue) {
        this.goalAmountValue = goalAmountValue;
    }

    public String getGoalAmountCurrency() {
        return goalAmountCurrency;
    }

    public void setGoalAmountCurrency(String goalAmountCurrency) {
        this.goalAmountCurrency = goalAmountCurrency;
    }

    public Integer getPocketTypeId() {
        return pocketTypeId;
    }

    public void setPocketTypeId(Integer pocketTypeId) {
        this.pocketTypeId = pocketTypeId;
    }

    public String getAccountPocketNumber() {
        return accountPocketNumber;
    }

    public void setAccountPocketNumber(String accountPocketNumber) {
        this.accountPocketNumber = accountPocketNumber;
    }

    public String getAccountPocketAccountFamilyId() {
        return accountPocketAccountFamilyId;
    }

    public void setAccountPocketAccountFamilyId(String accountPocketAccountFamilyId) {
        this.accountPocketAccountFamilyId = accountPocketAccountFamilyId;
    }

    public BigDecimal getAutomaticAmountValue() {
        return automaticAmountValue;
    }

    public void setAutomaticAmountValue(BigDecimal automaticAmountValue) {
        this.automaticAmountValue = automaticAmountValue;
    }

    public String getAutomaticAmountCurrency() {
        return automaticAmountCurrency;
    }

    public void setAutomaticAmountCurrency(String automaticAmountCurrency) {
        this.automaticAmountCurrency = automaticAmountCurrency;
    }

    public String getAutomaticAmountPeriodId() {
        return automaticAmountPeriodId;
    }

    public void setAutomaticAmountPeriodId(String automaticAmountPeriodId) {
        this.automaticAmountPeriodId = automaticAmountPeriodId;
    }

    public String getAutomaticAmountDayMonth() {
        return automaticAmountDayMonth;
    }

    public void setAutomaticAmountDayMonth(String automaticAmountDayMonth) {
        this.automaticAmountDayMonth = automaticAmountDayMonth;
    }
}
