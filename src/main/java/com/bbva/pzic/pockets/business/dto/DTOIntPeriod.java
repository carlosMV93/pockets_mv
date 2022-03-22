package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DTOIntPeriod {

    private String id;

    @Valid
    @NotNull(groups = ValidationGroup.CreatePocketV2.class)
    private DTOIntFrequency frequency;

    @NotNull(groups = ValidationGroup.CreatePocketV2.class)
    @Digits(integer = 2, fraction = 0, groups = {
            ValidationGroup.CreatePocketV2.class,
            ValidationGroup.ModifyPocketV2.class})
    private Integer dayOfMonth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DTOIntFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(DTOIntFrequency frequency) {
        this.frequency = frequency;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
}
