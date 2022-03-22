package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPockets;
import com.bbva.pzic.pockets.business.dto.InputListPockets;
import com.bbva.pzic.pockets.canonic.Pockets;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public interface IListPocketsMapper {

    InputListPockets mapIn(String relatedContractNumber, String statusId,
                           String paginationKey, Long pageSize);

    Pockets mapOut(DTOIntPockets dtoIntPockets);
}