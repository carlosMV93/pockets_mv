package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.InputCreatePocketRelatedContract;
import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ710;
import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ711;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public interface ITxCreatePocketRelatedContractMapper {

    FormatoBGMQ710 mapIn(InputCreatePocketRelatedContract dtoIn);

    String mapOut(FormatoBGMQ711 formatOutput);
}