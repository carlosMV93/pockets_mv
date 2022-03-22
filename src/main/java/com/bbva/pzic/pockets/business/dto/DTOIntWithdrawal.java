package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public class DTOIntWithdrawal {

    @Valid
    private DTOIntImport withdrawalAmount;

    public DTOIntImport getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(DTOIntImport withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }
}
