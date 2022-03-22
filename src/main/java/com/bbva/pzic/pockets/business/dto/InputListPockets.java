package com.bbva.pzic.pockets.business.dto;


import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public class InputListPockets {

    @Size(max = 20, groups = ValidationGroup.ListPockets.class)
    private String relatedContractNumber;

    @Size(max = 1, groups = ValidationGroup.ListPockets.class)
    private String statusId;

    @Valid
    private DTOIntPagination pagination;

    public String getRelatedContractNumber() {
        return relatedContractNumber;
    }

    public void setRelatedContractNumber(String relatedContractNumber) {
        this.relatedContractNumber = relatedContractNumber;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public DTOIntPagination getPagination() {
        return pagination;
    }

    public void setPagination(DTOIntPagination pagination) {
        this.pagination = pagination;
    }
}