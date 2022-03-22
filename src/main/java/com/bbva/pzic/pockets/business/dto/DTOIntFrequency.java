package com.bbva.pzic.pockets.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 19/10/2018.
 *
 * @author Entelgy
 */
public class DTOIntFrequency {

    @NotNull(groups = { ValidationGroup.CreatePocketV2.class,
                        ValidationGroup.ModifyPocketV2.class})
    @Size(max = 1, groups = {
            ValidationGroup.CreatePocketV2.class,
            ValidationGroup.ModifyPocketV2.class})
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
