package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPocketV2;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81E1;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81S1;

import java.util.List;

public interface ITxModifyPocketV2Mapper {

    FormatoBQM81E1 mapIn(DTOIntPocketV2 dtoIn);

    List<Pocket> mapOut(FormatoBQM81S1 formatOutput);

}
