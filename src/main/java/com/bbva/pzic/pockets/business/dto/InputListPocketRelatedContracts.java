package com.bbva.pzic.pockets.business.dto;


import javax.validation.constraints.Size;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public class InputListPocketRelatedContracts {

    @Size(max = 23, groups = ValidationGroup.ListPocketRelatedContracts.class)
    private String pocketId;

    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }
}