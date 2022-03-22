package com.bbva.pzic.pockets.business.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * Created on 9/05/2017.
 *
 * @author Entelgy
 */
public class InputListPocket {

    @Size(max = 18, groups = ValidationGroup.ListPocketsV00.class)
    private String accountPocketNumber;
    private String statusId;
    @Size(max = 20, groups = ValidationGroup.ListPocketsV00.class)
    private String paginationKey;
    @Digits(integer = 3, fraction = 0, groups = ValidationGroup.ListPocketsV00.class)
    private Integer pageSize;

    public String getAccountPocketNumber() {
        return accountPocketNumber;
    }

    public void setAccountPocketNumber(String accountPocketNumber) {
        this.accountPocketNumber = accountPocketNumber;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getPaginationKey() {
        return paginationKey;
    }

    public void setPaginationKey(String paginationKey) {
        this.paginationKey = paginationKey;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
