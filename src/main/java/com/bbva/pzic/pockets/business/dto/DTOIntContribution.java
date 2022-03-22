package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public class DTOIntContribution {

    @Valid
    private DTOIntImport contributionAmount;

    public DTOIntImport getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(DTOIntImport contributionAmount) {
        this.contributionAmount = contributionAmount;
    }
}
