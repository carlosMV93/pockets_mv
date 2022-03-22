package com.bbva.pzic.pockets.business.dto;


import javax.validation.constraints.Size;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public class InputDeletePocketRelatedContract {

    @Size(max = 23, groups = ValidationGroup.DeletePocketRelatedContract.class)
    private String pocketId;
    @Size(max = 18, groups = ValidationGroup.DeletePocketRelatedContract.class)
    private String relatedContractId;

    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }

    public String getRelatedContractId() {
        return relatedContractId;
    }

    public void setRelatedContractId(String relatedContractId) {
        this.relatedContractId = relatedContractId;
    }
}