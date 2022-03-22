package com.bbva.pzic.pockets.facade.v00.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.PocketV00;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface IModifyPocketMapper {

    DTOIntPocket mapIn(final String pocketId, final PocketV00 pocket);

}