package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76E1;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76S1;

public interface ITxCreatePocketV2Mapper {

    FormatoBQM76E1 mapIn(DTOIntPocket dtoIn);

    Pocket mapOut(FormatoBQM76S1 formatOutput);

}
