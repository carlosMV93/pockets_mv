package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.PocketData;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40E1;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40S1;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ITxGetPocketMapper {

    FormatoBQM40E1 mapIn(PathParamPocketId dtoIn);

    PocketData mapOut(FormatoBQM40S1 formatOutput);
}