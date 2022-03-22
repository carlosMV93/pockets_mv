package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.InputCreatePocket;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38E1;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38S1;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ITxCreatePocketMapper {
    /**
     * Metodo que mapeo los datos ya validados a {@link FormatoBQM38E1}
     * el cual es el formato de entrada para el createPocket
     *
     * @param dtoIn Objeto con los datos que seran pasados al FormatoBQM38E1
     * @return {@link com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38E1}
     */
    FormatoBQM38E1 mapIn(InputCreatePocket dtoIn);

    /**
     * Metodo que mapeo el formato de respuesta por parte de HOST a un objeto
     * {@link PocketV00}
     *
     * @param formatOutput Formato de salida (Respuesta de Host)
     * @return {@link PocketV00}
     */
    PocketV00 mapOut(FormatoBQM38S1 formatOutput);
}