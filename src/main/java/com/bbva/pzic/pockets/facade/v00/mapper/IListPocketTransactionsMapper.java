package com.bbva.pzic.pockets.facade.v00.mapper;

import com.bbva.pzic.pockets.business.dto.DTOOutPocketTransactions;
import com.bbva.pzic.pockets.business.dto.InputListPocketTransactions;
import com.bbva.pzic.pockets.canonic.Transactions;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface IListPocketTransactionsMapper {

    InputListPocketTransactions mapIn(String pocketId, String paginationKey, Long pageSize);

    Transactions mapOut(DTOOutPocketTransactions dtoOutPocketTransactions);
}