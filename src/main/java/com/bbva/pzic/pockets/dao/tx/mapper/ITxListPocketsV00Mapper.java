package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPocketsData;
import com.bbva.pzic.pockets.business.dto.InputListPocket;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39E1;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39P1;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39S1;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ITxListPocketsV00Mapper {
    FormatoBQM39E1 mapIn(InputListPocket dto);

    DTOIntPocketsData mapOutData(FormatoBQM39S1 format, DTOIntPocketsData dto);

    DTOIntPocketsData mapOutPagination(FormatoBQM39P1 format, DTOIntPocketsData dtoIntTransactionData);
}