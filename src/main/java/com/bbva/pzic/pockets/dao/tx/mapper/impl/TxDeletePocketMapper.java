package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.dao.model.bq42.FormatoBQM42E1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxDeletePocketMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("txDeletePocketMapper")
public class TxDeletePocketMapper implements ITxDeletePocketMapper {

    @Override
    public FormatoBQM42E1 mapIn(final DTOIntPocket dtoIn) {
        FormatoBQM42E1 format = new FormatoBQM42E1();
        format.setIdpoc(dtoIn.getId());
        return format;
    }
}