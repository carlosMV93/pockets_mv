package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public class DTOIntRelatedContract {

    @NotNull(groups = ValidationGroup.CreatePocketV2.class)
    @Size(max = 18, groups = {
            ValidationGroup.CreatePocketRelatedContract.class
    })
    @Size(max = 20, groups = {
            ValidationGroup.CreatePocketV2.class
    })
    private String number;

    @Valid
    @NotNull(groups = ValidationGroup.CreatePocketRelatedContract.class)
    private DTOIntProduct product;

    @Valid
    @NotNull(groups = ValidationGroup.CreatePocketRelatedContract.class)
    private DTOIntRelationType relationType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public DTOIntProduct getProduct() {
        return product;
    }

    public void setProduct(DTOIntProduct product) {
        this.product = product;
    }

    public DTOIntRelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(DTOIntRelationType relationType) {
        this.relationType = relationType;
    }
}