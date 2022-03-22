package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketRelatedContract;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.canonic.RelatedContractId;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public interface ICreatePocketRelatedContractMapper {

    InputCreatePocketRelatedContract mapIn(String pocketId, RelatedContract relatedContract);

    ServiceResponse<RelatedContractId> mapOut(String identifier);
}