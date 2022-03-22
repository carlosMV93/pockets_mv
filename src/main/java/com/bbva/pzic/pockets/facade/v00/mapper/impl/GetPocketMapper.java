package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.facade.v00.mapper.IGetPocketMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper
public class GetPocketMapper implements IGetPocketMapper {
    @Override
    public PathParamPocketId mapIn(final String pocketId) {
        PathParamPocketId pathParamPocketId = new PathParamPocketId();
        pathParamPocketId.setPocketId(pocketId);
        return pathParamPocketId;
    }
}