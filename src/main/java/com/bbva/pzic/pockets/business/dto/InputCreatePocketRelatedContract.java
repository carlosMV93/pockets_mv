package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public class InputCreatePocketRelatedContract {

    @Size(max = 23, groups = ValidationGroup.CreatePocketRelatedContract.class)
    private String pocketId;
    @Valid
    private DTOIntRelatedContract relatedContract;

    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }

    public DTOIntRelatedContract getRelatedContract() {
        return relatedContract;
    }

    public void setRelatedContract(DTOIntRelatedContract relatedContract) {
        this.relatedContract = relatedContract;
    }
}