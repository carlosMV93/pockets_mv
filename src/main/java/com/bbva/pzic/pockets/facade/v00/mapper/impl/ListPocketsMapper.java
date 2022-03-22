package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntPocketsData;
import com.bbva.pzic.pockets.business.dto.InputListPocket;
import com.bbva.pzic.pockets.canonic.PocketsV00;
import com.bbva.pzic.pockets.facade.v00.mapper.IListPocketsMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("listPocketsV00Mapper")
public class ListPocketsMapper implements IListPocketsMapper {

    @Override
    public InputListPocket mapIn(String accountPocketNumber, String statusId, String paginationKey, Integer pageSize) {
        InputListPocket inputListPocket = new InputListPocket();
        inputListPocket.setAccountPocketNumber(accountPocketNumber);
        inputListPocket.setStatusId(statusId);
        inputListPocket.setPaginationKey(paginationKey);
        inputListPocket.setPageSize(pageSize);

        return inputListPocket;
    }

    @Override
    public PocketsV00 mapOut(DTOIntPocketsData dtoIntTransactionData) {
        if (dtoIntTransactionData == null || dtoIntTransactionData.getData() == null) {
            return null;
        }

        PocketsV00 pockets = new PocketsV00();
        pockets.setData(dtoIntTransactionData.getData());
        return pockets;
    }
}