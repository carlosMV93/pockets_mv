package com.bbva.pzic.pockets.business.dto;


import javax.validation.constraints.Size;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public class InputCreatePocketLiquidate {

    @Size(max = 23, groups = {ValidationGroup.CreatePocketLiquidate.class})
    private String pocketId;
    //campo sesionado
    private String customerId;


    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}