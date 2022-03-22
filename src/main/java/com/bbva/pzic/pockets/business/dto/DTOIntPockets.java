package com.bbva.pzic.pockets.business.dto;

import com.bbva.pzic.pockets.canonic.Pocket;

import java.util.List;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public class DTOIntPockets {

    private List<Pocket> data;
    private DTOIntPagination pagination;

    public List<Pocket> getData() {
        return data;
    }

    public void setData(List<Pocket> data) {
        this.data = data;
    }

    public DTOIntPagination getPagination() {
        return pagination;
    }

    public void setPagination(DTOIntPagination pagination) {
        this.pagination = pagination;
    }
}