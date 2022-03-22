package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.dao.model.bq42.FormatoBQM42E1;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ITxDeletePocketMapper {

    FormatoBQM42E1 mapIn(DTOIntPocket dtoIn);
}