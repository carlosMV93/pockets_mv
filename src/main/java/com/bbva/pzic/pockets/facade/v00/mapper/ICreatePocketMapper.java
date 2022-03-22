package com.bbva.pzic.pockets.facade.v00.mapper;

import com.bbva.pzic.pockets.business.dto.InputCreatePocket;
import com.bbva.pzic.pockets.canonic.PocketV00;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ICreatePocketMapper {
    /**
     * Metodo que realiza el mapeo de entrada del payLoad a un DTO la cual contiene
     * anotaciones de validacion
     *
     * @param pocket Objeto de entrada (payLoad)
     * @return {@link com.bbva.pzic.pockets.business.dto.InputCreatePocket}
     */
    InputCreatePocket mapIn(PocketV00 pocket);
}