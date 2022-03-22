package com.bbva.pzic.pockets.facade.v2;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.canonic.*;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public interface ISrvPocketsV2 {

    String POCKET_ID ="pocket-id";
    String RELATED_CONTRACT_ID="related-contract-id";
    String PAGINATION_KEY="paginationKey";
    String PAGE_SIZE="pageSize";

    /**
     * Service for retrieving the list of pockets.
     *
     * @param relatedContractNumber number of the contract associated with the pocket.
     * @param statusId              identifier of the status of the pocket.
     * @param paginationKey         key to obtain a single page
     * @param pageSize              number of elements per page
     * @return {@link Pockets}
     */
    Pockets listPockets(String relatedContractNumber, String statusId,
                        String paginationKey, Long pageSize);

    /**
     * List of related contracts with the pocket
     *
     * @param pocketId unique pocket identifier
     * @return {@link RelatedContracts}
     */
    ServiceResponse<List<RelatedContracts>> listPocketRelatedContracts(String pocketId);

    /**
     * Adding a new related contract to a pocket
     *
     * @param pocketId        unique pocket identifier
     * @param relatedContract payload
     * @return {@link ServiceResponse}
     */
    ServiceResponse<RelatedContractId> createPocketRelatedContract(String pocketId, RelatedContract relatedContract);

    /**
     * Delete an existing relationship between a contract and the pocket
     *
     * @param pocketId          unique pocket identifier
     * @param relatedContractId unique related contract identifier
     * @return {@link Response}
     */
    Response deletePocketRelatedContract(String pocketId, String relatedContractId);

    /**
     * Service to retrieving the list of operations related to a specific
     * pocket.
     *
     * @param pocketId      unique pocket identifier
     * @param paginationKey key to obtain a single page
     * @param pageSize      number of elements per page
     * @return {@link Operations}
     */
    Operations listPocketOperations(String pocketId, String paginationKey, Long pageSize);

    /**
     * Service to making a withdrawal to a specific pocket.
     *
     * @param pocketId   unique pocket identifier
     * @param withdrawal payload
     * @return {@link ServiceResponse}
     */
    ServiceResponse<Withdrawal> createPocketWithdrawals(String pocketId, Withdrawal withdrawal);

    /**
     * Service to making a contribution to a specific pocket.
     *
     * @param pocketId     unique pocket identifier
     * @param contribution payload
     * @return {@link ServiceResponse}
     */
    ServiceResponse<Contribution> createPocketContributions(String pocketId, Contribution contribution);

    /**
     * Service to removing a specific pocket.
     *
     * @param pocketId unique pocket identifier
     * @return {@link ServiceResponse}
     */
    ServiceResponse<Liquidate> createPocketLiquidate(String pocketId);

    /**
     * Create a savings goal associated with a customer account
     *
     * @param pocket payload
     * @return {@link ServiceResponse}
     */
    ServiceResponse<Pocket> createPocket(Pocket pocket);

    /**
     * It allows to visualize the detail of the saving goal.
     *
     * @param pocketId payload
     * @return {@link ServiceResponse}
     */
    ServiceResponse<Pocket> getPocket(String pocketId);

    /**
     * It allows the customer to modify their savings goal associated with their account.
     *
     * @param pockets payload
     * @return {@link ServiceResponse}
     */
    ServiceResponse<List<Pocket>> modifyPocket(List<Pocket> pockets);

}
