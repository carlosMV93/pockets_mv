package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.Pocket;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public interface ICreatePocketMapper {

    DTOIntPocket mapIn(Pocket pocket);

    ServiceResponse<Pocket> mapOut(Pocket pocket);
}
