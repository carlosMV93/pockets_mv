package com.bbva.pzic.pockets.business.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public class DTOIntImport {

    @NotNull(groups = {
            ValidationGroup.CreatePocketContributions.class,
            ValidationGroup.CreatePocketWithdrawals.class,
            ValidationGroup.ModifyPocketV2.class})
    @Digits(integer = 13, fraction = 2, groups = {
            ValidationGroup.CreatePocketContributions.class,
            ValidationGroup.CreatePocketWithdrawals.class,
            ValidationGroup.CreatePocketV2.class,
            ValidationGroup.ModifyPocketV2.class})
    private BigDecimal amount;

    @NotNull(groups = {
            ValidationGroup.CreatePocketContributions.class,
            ValidationGroup.CreatePocketWithdrawals.class,
            ValidationGroup.ModifyPocketV2.class})
    @Size(max = 3, groups = {
            ValidationGroup.CreatePocketContributions.class,
            ValidationGroup.CreatePocketWithdrawals.class,
            ValidationGroup.CreatePocketV2.class,
            ValidationGroup.ModifyPocketV2.class})
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
