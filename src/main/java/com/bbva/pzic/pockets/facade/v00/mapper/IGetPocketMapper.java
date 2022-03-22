package com.bbva.pzic.pockets.facade.v00.mapper;

import com.bbva.pzic.pockets.business.dto.PathParamPocketId;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface IGetPocketMapper {
    PathParamPocketId mapIn(String pocketId);
}