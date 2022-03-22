package com.bbva.pzic.pockets.business.dto;


import com.bbva.pzic.pockets.canonic.Transaction;

import java.util.List;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DTOOutPocketTransactions {

    private List<Transaction> data;
    private DTOIntPagination pagination;

    public List<Transaction> getData() {
        return data;
    }

    public void setData(List<Transaction> data) {
        this.data = data;
    }

    public DTOIntPagination getPagination() {
        return pagination;
    }

    public void setPagination(DTOIntPagination pagination) {
        this.pagination = pagination;
    }
}