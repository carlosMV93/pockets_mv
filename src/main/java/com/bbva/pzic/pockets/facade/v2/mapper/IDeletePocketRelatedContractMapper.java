package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.pzic.pockets.business.dto.InputDeletePocketRelatedContract;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public interface IDeletePocketRelatedContractMapper {

    InputDeletePocketRelatedContract mapIn(String pocketId, String relatedContractId);
}