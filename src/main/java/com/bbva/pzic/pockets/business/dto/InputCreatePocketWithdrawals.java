package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public class InputCreatePocketWithdrawals {

    @Size(max = 23, groups = {ValidationGroup.CreatePocketWithdrawals.class})
    private String pocketId;

    @Valid
    private DTOIntWithdrawal withdrawal;

    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }

    public DTOIntWithdrawal getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(DTOIntWithdrawal withdrawal) {
        this.withdrawal = withdrawal;
    }
}