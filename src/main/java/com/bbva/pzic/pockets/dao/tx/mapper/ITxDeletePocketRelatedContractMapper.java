package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.InputDeletePocketRelatedContract;
import com.bbva.pzic.pockets.dao.model.bq73.FormatoBGMQ730;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public interface ITxDeletePocketRelatedContractMapper {

    FormatoBGMQ730 mapIn(InputDeletePocketRelatedContract dtoIn);
}