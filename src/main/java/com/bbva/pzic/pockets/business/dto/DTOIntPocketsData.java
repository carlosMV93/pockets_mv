package com.bbva.pzic.pockets.business.dto;


import com.bbva.pzic.pockets.canonic.PocketV00;

import java.util.List;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DTOIntPocketsData {

    private List<PocketV00> data;
    private DTOIntPagination pagination;

    public List<PocketV00> getData() {
        return data;
    }

    public void setData(List<PocketV00> data) {
        this.data = data;
    }

    public DTOIntPagination getPagination() {
        return pagination;
    }

    public void setPagination(DTOIntPagination pagination) {
        this.pagination = pagination;
    }
}