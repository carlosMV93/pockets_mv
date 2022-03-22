package com.bbva.pzic.pockets.business.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DTOIntGoalAmount {

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    @Digits(integer = 13, fraction = 2, groups = { ValidationGroup.ModifyPocket.class })
    private BigDecimal value;

    @Digits(integer = 13, fraction = 2, groups = { ValidationGroup.CreatePocketV2.class })
    private BigDecimal amount;

    @NotNull(groups = { ValidationGroup.CreatePocket.class })
    @Size(max = 3, groups = {
            ValidationGroup.ModifyPocket.class,
            ValidationGroup.CreatePocketV2.class})
    private String currency;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}