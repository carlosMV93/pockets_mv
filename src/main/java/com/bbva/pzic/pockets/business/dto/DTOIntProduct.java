package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public class DTOIntProduct {

    @NotNull(groups = ValidationGroup.CreatePocketRelatedContract.class)
    @Size(max = 2, groups = ValidationGroup.CreatePocketRelatedContract.class)
    private String id;

    @Valid
    @NotNull(groups = ValidationGroup.CreatePocketRelatedContract.class)
    private DTOIntProductType productType;

    @Valid
    @NotNull(groups = ValidationGroup.CreatePocketRelatedContract.class)
    private DTOIntNumberType numberType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DTOIntProductType getProductType() {
        return productType;
    }

    public void setProductType(DTOIntProductType productType) {
        this.productType = productType;
    }

    public DTOIntNumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(DTOIntNumberType numberType) {
        this.numberType = numberType;
    }
}
