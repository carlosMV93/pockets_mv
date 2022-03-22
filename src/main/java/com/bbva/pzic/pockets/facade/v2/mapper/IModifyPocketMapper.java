package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.DTOIntPocketV2;
import com.bbva.pzic.pockets.canonic.Pocket;

import java.util.List;

public interface IModifyPocketMapper {

    DTOIntPocketV2 mapIn(List<Pocket> pockets);

    ServiceResponse<List<Pocket>> mapOut(List<Pocket> pockets);

}
