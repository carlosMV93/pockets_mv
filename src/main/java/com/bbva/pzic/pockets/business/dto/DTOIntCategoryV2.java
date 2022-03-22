package com.bbva.pzic.pockets.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public class DTOIntCategoryV2 {

    @NotNull(groups = { ValidationGroup.ModifyPocketV2.class})
    @Size(max = 3, groups = { ValidationGroup.ModifyPocketV2.class })
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
