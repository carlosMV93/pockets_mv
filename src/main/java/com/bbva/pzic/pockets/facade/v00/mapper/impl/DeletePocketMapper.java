package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.facade.v00.mapper.IDeletePocketMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("deletePocketMapper")
public class DeletePocketMapper implements IDeletePocketMapper {

    @Override
    public DTOIntPocket mapIn(final String pocketId) {
        DTOIntPocket dtoIntPocket = new DTOIntPocket();
        dtoIntPocket.setId(pocketId);
        return dtoIntPocket;
    }
}