package com.bbva.pzic.pockets.business.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public class DTOIntRelationType {

    @NotNull(groups = ValidationGroup.CreatePocketRelatedContract.class)
    @Size(max = 20, groups = ValidationGroup.CreatePocketRelatedContract.class)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}