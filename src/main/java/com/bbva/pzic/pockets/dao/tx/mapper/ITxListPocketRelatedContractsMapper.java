package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.InputListPocketRelatedContracts;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ720;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ721;

import java.util.List;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public interface ITxListPocketRelatedContractsMapper {

    FormatoBGMQ720 mapIn(InputListPocketRelatedContracts dtoIn);

    List<RelatedContract> mapOut(FormatoBGMQ721 formatOutput);
}