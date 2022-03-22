package com.bbva.pzic.pockets.dao.impl;

import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.PocketData;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.dao.IPocketsDAOV00;
import com.bbva.pzic.pockets.dao.tx.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Repository
public class PocketsDAOV00 implements IPocketsDAOV00 {

    @Resource(name = "txCreatePocket")
    private TxCreatePocket txCreatePocket;

    @Resource(name = "txModifyPocket")
    private TxModifyPocket txModifyPocket;

    @Resource(name = "txDeletePocket")
    private TxDeletePocket txDeletePocket;

    @Resource(name = "txListPocketsV00")
    private TxListPocketsV00 txListPocketsV00;

    @Resource(name = "txGetPocket")
    private TxGetPocket txGetPocket;

    @Resource(name = "txCreatePocketTransaction")
    private TxCreatePocketTransaction txCreatePocketTransaction;

    @Resource(name = "txListPocketTransactions")
    private TxListPocketTransactions txListPocketTransactions;

    @Override
    public PocketV00 createPocket(InputCreatePocket pocket) {
        return txCreatePocket.perform(pocket);
    }

    @Override
    public void modifyPocket(final DTOIntPocket input) {
        txModifyPocket.perform(input);
    }

    @Override
    public void deletePocket(final DTOIntPocket input) {
        txDeletePocket.perform(input);
    }

    @Override
    public DTOIntPocketsData listPockets(InputListPocket inputListPocket) {
        return txListPocketsV00.perform(inputListPocket);
    }

    @Override
    public PocketData getPocket(PathParamPocketId input) {
        return txGetPocket.perform(input);
    }

    @Override
    public DTOIntTransaction createPocketTransaction(DTOIntTransaction transaction) {
        return txCreatePocketTransaction.perform(transaction);
    }

    @Override
    public DTOOutPocketTransactions listPocketTransactions(InputListPocketTransactions input) {
        return txListPocketTransactions.perform(input);
    }

}