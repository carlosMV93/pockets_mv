package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77E1;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77S1;

public interface ITxGetPocketV2Mapper {

    FormatoBQM77E1 mapIn(PathParamPocketId dtoIn);

    Pocket mapOut(FormatoBQM77S1 formatOutput);

}