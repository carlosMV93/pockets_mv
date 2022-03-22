package com.bbva.pzic.pockets.facade.v00.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPocketsData;
import com.bbva.pzic.pockets.business.dto.InputListPocket;
import com.bbva.pzic.pockets.canonic.PocketsV00;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface IListPocketsMapper {
    InputListPocket mapIn(String accountPocketNumber, String statusId, String paginationKey, Integer pageSize);

    PocketsV00 mapOut(DTOIntPocketsData dtoIntTransactionData);
}