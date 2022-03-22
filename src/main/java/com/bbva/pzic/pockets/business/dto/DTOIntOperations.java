package com.bbva.pzic.pockets.business.dto;

import com.bbva.pzic.pockets.canonic.Operation;

import java.util.List;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public class DTOIntOperations {

    private List<Operation> data;
    private DTOIntPagination pagination;

    public List<Operation> getData() {
        return data;
    }

    public void setData(List<Operation> data) {
        this.data = data;
    }

    public DTOIntPagination getPagination() {
        return pagination;
    }

    public void setPagination(DTOIntPagination pagination) {
        this.pagination = pagination;
    }
}