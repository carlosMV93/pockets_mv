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
public class DTOIntAmount {

    @NotNull(groups = ValidationGroup.CreatePocketTransaction.class)
    @Digits(integer = 13, fraction = 2, groups = ValidationGroup.CreatePocketTransaction.class)
    private BigDecimal value;
    @NotNull(groups = ValidationGroup.CreatePocketTransaction.class)
    @Size(max = 3, groups = ValidationGroup.CreatePocketTransaction.class)
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
}