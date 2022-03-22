package com.bbva.pzic.pockets.business.dto;


import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DTOIntAutomaticAmount {

    @Digits(integer = 13, fraction = 2, groups = ValidationGroup.ModifyPocket.class)
    private BigDecimal value;
    @Size(max = 3, groups = ValidationGroup.ModifyPocket.class)
    private String currency;
    @Valid
    private DTOIntPeriod period;
    @Size(max = 2, groups = ValidationGroup.ModifyPocket.class)
    private String dayMonth;

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

    public DTOIntPeriod getPeriod() {
        return period;
    }

    public void setPeriod(DTOIntPeriod period) {
        this.period = period;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(String dayMonth) {
        this.dayMonth = dayMonth;
    }
}