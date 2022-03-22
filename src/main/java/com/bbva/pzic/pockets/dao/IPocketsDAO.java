package com.bbva.pzic.pockets.dao;

import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.*;

import java.util.List;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public interface IPocketsDAO {

    DTOIntPockets listPockets(InputListPockets input);

    List<RelatedContract> listPocketRelatedContracts(InputListPocketRelatedContracts input);

    String createPocketRelatedContract(InputCreatePocketRelatedContract input);

    void deletePocketRelatedContract(InputDeletePocketRelatedContract input);

    DTOIntOperations listPocketOperations(InputListPocketOperations input);

    Withdrawal createPocketWithdrawals(InputCreatePocketWithdrawals input);

    Contribution createPocketContributions(InputCreatePocketContributions input);

    Liquidate createPocketLiquidate(InputCreatePocketLiquidate input);

    Pocket createPocket(DTOIntPocket input);

    Pocket getPocket(PathParamPocketId input);

    List<Pocket> modifyPocket(DTOIntPocketV2 input);
}
