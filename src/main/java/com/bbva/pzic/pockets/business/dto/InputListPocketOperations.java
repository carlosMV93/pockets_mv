package com.bbva.pzic.pockets.business.dto;


import javax.validation.constraints.Size;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public class InputListPocketOperations {

    @Size(max = 23, groups = ValidationGroup.ListPocketsOperations.class)
    private String pocketId;
    private String paginationKey;
    private Long pageSize;

    public String getPocketId() {
        return pocketId;
    }

    public void setPocketId(String pocketId) {
        this.pocketId = pocketId;
    }

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