package com.bbva.pzic.pockets.facade.v00;

import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.canonic.Transaction;

import javax.ws.rs.core.Response;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ISrvPocketsV00 {

    String POCKET_ID = "pocket-id";
    String ACCOUNT_POCKET_NUMBER = "accountPocket.number";
    String STATUS_ID = "status.id";
    String PAGINATION_KEY = "paginationKey";
    String PAGE_SIZE = "pageSize";

    /**
     * Method for performing the pocket of a service.
     *
     * @param pocket Payload input
     * @return {@link javax.ws.rs.core.Response}
     */
    Response createPocket(PocketV00 pocket);

    /**
     * Method for modifying the details of a pocket.
     *
     * @param pocketId Unique identifier of the pocket.
     * @param pocket   Payload input
     * @return {@link javax.ws.rs.core.Response}
     */
    Response modifyPocket(String pocketId, PocketV00 pocket);

    /**
     * Method for removing a pocket.
     *
     * @param pocketId Unique identifier of the pocket.
     * @return {@link javax.ws.rs.core.Response}
     */
    Response deletePocket(String pocketId);

    /**
     * Method for retrieving the list of pockets related to a specific saving account.
     *
     * @param accountPocketNumber Contract unique identifier. This attribute refers to the identifier associated to the contract related to the account in which the amounts will be deposited or withdrawn in the pocket.
     * @param statusId            Identifier of a status pocket.
     * @param paginationKey       Key to obtain a single page
     * @param pageSize            Number of elements per page
     * @return {@link javax.ws.rs.core.Response}
     */
    Response listPockets(String accountPocketNumber, String statusId, String paginationKey, Integer pageSize);

    /**
     * Method for retrieving the details of a pocket.
     *
     * @param pocketId Unique identifier of the pocket.
     * @return {@link javax.ws.rs.core.Response}
     */
    Response getPocket(String pocketId);

    /**
     * Method for performing the transaction related to a specific client's pocket.
     *
     * @param pocketId Unique identifier of the pocket.
     * @param payload  Payload input
     * @return {@link javax.ws.rs.core.Response}
     */
    Response createPocketTransaction(String pocketId, Transaction payload);

    /**
     * Method for retrieving the list of transactions related to a specific client's pocket.
     *
     * @param pocketId      Unique identifier of the pocket.
     * @param paginationKey Key to obtain a single page
     * @param pageSize      Number of elements per page
     * @return {@link javax.ws.rs.core.Response}
     */
    Response listPocketTransactions(String pocketId, String paginationKey, Long pageSize);
}