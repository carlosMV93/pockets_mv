package com.bbva.pzic.pockets.business.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * Created on 2017-03-10.
 *
 * @author Entelgy
 */
public class DTOIntPagination {

    @Size(max = 20, groups = ValidationGroup.ListPocketTransactions.class)
    @Size(max = 23, groups = ValidationGroup.ListPockets.class)
    private String paginationKey;

    @Digits(integer = 3, fraction = 0, groups = {
            ValidationGroup.ListPockets.class,
            ValidationGroup.ListPocketTransactions.class
    })
    private Long pageSize;

    public String getPaginationKey() {
        return paginationKey;
    }

    public void setPaginationKey(String paginationKey) {
        this.paginationKey = paginationKey;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}