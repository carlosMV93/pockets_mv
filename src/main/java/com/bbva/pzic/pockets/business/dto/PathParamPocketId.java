package com.bbva.pzic.pockets.business.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 9/05/2017.
 *
 * @author Entelgy
 */
public class PathParamPocketId {

    @NotNull(groups = ValidationGroup.GetPocket.class)
    @Size(max = 23, groups = {
            ValidationGroup.GetPocket.class,
            ValidationGroup.GetPocketV2.class})
    private String pocketId;

    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }

}
