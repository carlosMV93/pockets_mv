package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.InputListPocketRelatedContracts;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.canonic.RelatedContracts;

import java.util.List;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public interface IListPocketRelatedContractsMapper {

    InputListPocketRelatedContracts mapIn(String pocketId);

    ServiceResponse<List<RelatedContracts>>  mapOut(List<RelatedContract> relatedContract);
}