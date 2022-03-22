package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntTransaction;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41E1;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41S1;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ITxCreatePocketTransactionMapper {

    DTOIntTransaction mapOut(FormatoBQM41S1 formatOutput);

    FormatoBQM41E1 mapIn(DTOIntTransaction dtoIn);
}