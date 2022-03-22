package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntPagination;
import com.bbva.pzic.pockets.business.dto.DTOOutPocketTransactions;
import com.bbva.pzic.pockets.business.dto.InputListPocketTransactions;
import com.bbva.pzic.pockets.canonic.Transactions;
import com.bbva.pzic.pockets.facade.v00.mapper.IListPocketTransactionsMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("listPocketTransactionsMapper")
public class ListPocketTransactionsMapper implements IListPocketTransactionsMapper {

    @Override
    public InputListPocketTransactions mapIn(String pocketId, String paginationKey, Long pageSize) {
        InputListPocketTransactions inputListPocketTransactions = new InputListPocketTransactions();
        inputListPocketTransactions.setPocketId(pocketId);

        DTOIntPagination pagination = new DTOIntPagination();
        pagination.setPaginationKey(paginationKey);
        pagination.setPageSize(pageSize);
        inputListPocketTransactions.setPagination(pagination);

        return inputListPocketTransactions;
    }

    @Override
    public Transactions mapOut(DTOOutPocketTransactions dtoOutPocketTransactions) {
        if (dtoOutPocketTransactions == null || dtoOutPocketTransactions.getData() == null || dtoOutPocketTransactions.getData().isEmpty()) {
            return null;
        }
        Transactions transactions = new Transactions();
        transactions.setData(dtoOutPocketTransactions.getData());

        return transactions;
    }
}