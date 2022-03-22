package com.bbva.pzic.pockets.business;

import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.PocketData;
import com.bbva.pzic.pockets.canonic.PocketV00;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ISrvIntPocketsV00 {

    /**
     * Metodo que valida los datos de entrada, las validaciones corresponde a datos no informados
     * y tamaños incorrectos
     *
     * @param input Objeto con los datos de entrada la cual contiene las anotaciones a validar.
     * @return {@link PocketV00}
     */
    PocketV00 createPocket(InputCreatePocket input);

    void modifyPocket(DTOIntPocket dtoIntPocket);

    void deletePocket(DTOIntPocket dtoIntPocket);

    DTOIntPocketsData listPockets(InputListPocket inputListPocket);

    PocketData getPocket(PathParamPocketId input);

    DTOIntTransaction createPocketTransaction(DTOIntTransaction transaction);

    DTOOutPocketTransactions listPocketTransactions(InputListPocketTransactions input);

}