package com.bbva.pzic.pockets.dao;

import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.PocketData;
import com.bbva.pzic.pockets.canonic.PocketV00;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface IPocketsDAOV00 {

    PocketV00 createPocket(InputCreatePocket pocket);

    void modifyPocket(DTOIntPocket input);

    void deletePocket(DTOIntPocket input);

    DTOIntPocketsData listPockets(InputListPocket inputListPocket);

    PocketData getPocket(PathParamPocketId input);

    DTOIntTransaction createPocketTransaction(DTOIntTransaction transaction);

    DTOOutPocketTransactions listPocketTransactions(InputListPocketTransactions input);
}