package com.bbva.pzic.pockets.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 10/05/2017.
 *
 * @author Entelgy
 */
public class InputListPocketTransactions {

    @NotNull(groups = ValidationGroup.ListPocketTransactions.class)
    @Size(max = 23, groups = ValidationGroup.ListPocketTransactions.class)
    private String pocketId;

    @Valid
    private DTOIntPagination pagination;

    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }

    public DTOIntPagination getPagination() {
        return pagination;
    }

    public void setPagination(DTOIntPagination pagination) {
        this.pagination = pagination;
    }
}
