package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.InputCreatePocketLiquidate;
import com.bbva.pzic.pockets.canonic.Liquidate;
import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80E1;
import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80S1;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public interface ITxCreatePocketLiquidateMapper {

    FormatoBQM80E1 mapIn(InputCreatePocketLiquidate dtoIn);

    Liquidate mapOut(FormatoBQM80S1 formatOutput);
}