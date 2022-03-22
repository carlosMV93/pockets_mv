package com.bbva.pzic.pockets.business;

import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.*;

import java.util.List;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public interface ISrvIntPockets {

    /**
     * Service for retrieving the list of pockets.
     *
     * @param input dto with input fields to validate
     * @return {@link DTOIntPockets}
     */
    DTOIntPockets listPockets(InputListPockets input);

    /**
     * List of related contracts with the pocket
     *
     * @param input dto with input fields to validate
     * @return {@link List}
     */
    List<RelatedContract> listPocketRelatedContracts(
            InputListPocketRelatedContracts input);

    /**
     * Adding a new related contract to a pocket
     *
     * @param input dto with input fields to validate
     * @return {@link String}
     */
    String createPocketRelatedContract(InputCreatePocketRelatedContract input);

    /**
     * Delete an existing relationship between a contract and the pocket
     *
     * @param input dto with input fields to validate
     */
    void deletePocketRelatedContract(InputDeletePocketRelatedContract input);

    /**
     * Service to retrieving the list of operations related to a specific
     * pocket.
     *
     * @param input dto with input fields to validate
     * @return {@link DTOIntOperations}
     */
    DTOIntOperations listPocketOperations(InputListPocketOperations input);

    /**
     * Service to making a withdrawal to a specific pocket.
     *
     * @param input dto with input fields to validate
     * @return {@link Withdrawal}
     */
    Withdrawal createPocketWithdrawals(InputCreatePocketWithdrawals input);

    /**
     * Service to making a contribution to a specific pocket.
     *
     * @param input dto with input fields to validate
     * @return {@link Contribution}
     */
    Contribution createPocketContributions(InputCreatePocketContributions input);

    /**
     * Service to removing a specific pocket.
     *
     * @param input dto with input fields to validate
     * @return {@link Liquidate}
     */
    Liquidate createPocketLiquidate(InputCreatePocketLiquidate input);

    /**
     * @param input dto with input fields to validate
     * @return {@link DTOIntPocket}
     */
    Pocket createPocket(DTOIntPocket input);


    /**
     * It allows to visualize the detail of the saving goal.
     *
     * @param input dto with input fields to validate
     * @return {@link PathParamPocketId}
     */
    Pocket getPocket(PathParamPocketId input);

    /**
     * @param input dto with input fields to validate
     * @return {@link List<DTOIntPocketV2>}
     */
    List<Pocket> modifyPocket(DTOIntPocketV2 input);
}
