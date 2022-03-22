package com.bbva.pzic.pockets.facade.v00.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPocket;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface IDeletePocketMapper {

    DTOIntPocket mapIn(String pocketId);
}