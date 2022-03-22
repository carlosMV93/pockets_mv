package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketLiquidate;
import com.bbva.pzic.pockets.canonic.Liquidate;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public interface ICreatePocketLiquidateMapper {

    InputCreatePocketLiquidate mapIn(String pocketId);

    ServiceResponse<Liquidate> mapOut(Liquidate liquidate);
}