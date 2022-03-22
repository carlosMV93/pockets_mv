package com.bbva.pzic.pockets.business.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DTOIntOperationType {

    @NotNull(groups = ValidationGroup.CreatePocketTransaction.class)
    @Size(max = 1, groups = ValidationGroup.CreatePocketTransaction.class)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}