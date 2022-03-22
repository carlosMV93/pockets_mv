package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.dao.model.bq43.FormatoBQM43E1;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ITxModifyPocketMapper {

    FormatoBQM43E1 mapIn(final DTOIntPocket dtoIn);

}