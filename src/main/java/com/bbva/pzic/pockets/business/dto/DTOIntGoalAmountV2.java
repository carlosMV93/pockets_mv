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
public class DTOIntGoalAmountV2 {

    @NotNull(groups = ValidationGroup.ModifyPocketV2.class)
    @Digits(integer = 13, fraction = 2, groups = { ValidationGroup.ModifyPocketV2.class })
    private BigDecimal amount;

    @NotNull(groups = { ValidationGroup.ModifyPocketV2.class})
    @Size(max = 3, groups = { ValidationGroup.ModifyPocketV2.class})
    private String currency;

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