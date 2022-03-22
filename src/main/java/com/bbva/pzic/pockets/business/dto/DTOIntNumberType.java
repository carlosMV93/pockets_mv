package com.bbva.pzic.pockets.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public class DTOIntNumberType {

    @NotNull(groups = ValidationGroup.CreatePocketRelatedContract.class)
    @Size(max = 1, groups = ValidationGroup.CreatePocketRelatedContract.class)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
