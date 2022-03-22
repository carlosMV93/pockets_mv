package com.bbva.pzic.pockets.business.dto;


import javax.validation.constraints.NotNull;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DTOIntPocketType {

    @NotNull(groups = ValidationGroup.CreatePocket.class)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}