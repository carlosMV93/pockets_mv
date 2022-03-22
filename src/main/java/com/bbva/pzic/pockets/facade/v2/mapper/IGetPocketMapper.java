package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.Pocket;

public interface IGetPocketMapper {

    PathParamPocketId mapIn(String pocketId);

    ServiceResponse<Pocket> mapOut(Pocket pocket);

}
