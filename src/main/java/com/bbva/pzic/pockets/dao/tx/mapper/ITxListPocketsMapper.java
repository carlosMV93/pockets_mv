package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPockets;
import com.bbva.pzic.pockets.business.dto.InputListPockets;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ740;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ741;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ742;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public interface ITxListPocketsMapper {

    FormatoBGMQ740 mapIn(InputListPockets dtoIn);

    DTOIntPockets mapOut(FormatoBGMQ741 formatOutput, DTOIntPockets dtoOut);

    DTOIntPockets mapOut2(FormatoBGMQ742 formatOutput, DTOIntPockets dtoOut);
}