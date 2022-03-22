package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntOperations;
import com.bbva.pzic.pockets.business.dto.InputListPocketOperations;
import com.bbva.pzic.pockets.canonic.Operations;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public interface IListPocketOperationsMapper {

    InputListPocketOperations mapIn(String pocketId, String paginationKey, Long pageSize);

    Operations mapOut(DTOIntOperations dtoIntOperations);
}