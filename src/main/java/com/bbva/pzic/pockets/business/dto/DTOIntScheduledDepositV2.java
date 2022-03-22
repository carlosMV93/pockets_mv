package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DTOIntScheduledDepositV2 {

    @Valid
    private DTOIntImport depositAmount;

    @Valid
    private DTOIntPeriod period;

    public DTOIntImport getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(DTOIntImport depositAmount) {
        this.depositAmount = depositAmount;
    }

    public DTOIntPeriod getPeriod() {
        return period;
    }

    public void setPeriod(DTOIntPeriod period) {
        this.period = period;
    }

}
