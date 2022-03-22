package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntOperations;
import com.bbva.pzic.pockets.business.dto.InputListPocketOperations;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ750;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ751;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ752;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public interface ITxListPocketOperationsMapper {

    FormatoBGMQ750 mapIn(InputListPocketOperations dtoIn);

    DTOIntOperations mapOut(FormatoBGMQ751 formatOutput, DTOIntOperations dtoOut);

    DTOIntOperations mapOut2(FormatoBGMQ752 formatOutput,
                             DTOIntOperations dtoOut);
}