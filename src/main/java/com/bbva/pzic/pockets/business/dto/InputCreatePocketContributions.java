package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public class InputCreatePocketContributions {

    @Size(max = 23, groups = {ValidationGroup.CreatePocketContributions.class})
    private String pocketId;

    @Valid
    private DTOIntContribution contribution;

    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }

    public DTOIntContribution getContribution() {
        return contribution;
    }

    public void setContribution(DTOIntContribution contribution) {
        this.contribution = contribution;
    }
}