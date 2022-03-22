package com.bbva.pzic.pockets.dao.impl;

import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.*;
import com.bbva.pzic.pockets.dao.IPocketsDAO;
import com.bbva.pzic.pockets.dao.tx.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@Repository
public class PocketsDAO implements IPocketsDAO {

    private static final Log LOG = LogFactory.getLog(PocketsDAO.class);

    @Autowired
    private TxListPockets txListPockets;
    @Autowired
    private TxListPocketRelatedContracts txListPocketRelatedContracts;
    @Autowired
    private TxCreatePocketRelatedContract txCreatePocketRelatedContract;
    @Autowired
    private TxDeletePocketRelatedContract txDeletePocketRelatedContract;
    @Autowired
    private TxListPocketOperations txListPocketOperations;
    @Autowired
    private TxCreatePocketWithdrawals txCreatePocketWithdrawals;
    @Autowired
    private TxCreatePocketContributions txCreatePocketContributions;
    @Autowired
    private TxCreatePocketLiquidate txCreatePocketLiquidate;
    @Autowired
    private TxCreatePocketV2 txCreatePocketV2;
    @Autowired
    private TxGetPocketV2 txGetPocketV2;
    @Autowired
    private TxModifyPocketV2 txModifyPocketV2;

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntPockets listPockets(final InputListPockets input) {
        LOG.info("... Invoking method PocketsDAO.listPockets ...");
        return txListPockets.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RelatedContract> listPocketRelatedContracts(final InputListPocketRelatedContracts input) {
        LOG.info("... Invoking method PocketsDAO.listPocketRelatedContracts ...");
        return txListPocketRelatedContracts.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String createPocketRelatedContract(final InputCreatePocketRelatedContract input) {
        LOG.info("... Invoking method PocketsDAO.createPocketRelatedContract ...");
        return txCreatePocketRelatedContract.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePocketRelatedContract(final InputDeletePocketRelatedContract input) {
        LOG.info("... Invoking method PocketsDAO.deletePocketRelatedContract ...");
        txDeletePocketRelatedContract.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntOperations listPocketOperations(final InputListPocketOperations input) {
        LOG.info("... Invoking method PocketsDAO.listPocketOperations ...");
        return txListPocketOperations.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Withdrawal createPocketWithdrawals(final InputCreatePocketWithdrawals input) {
        LOG.info("... Invoking method PocketsDAO.createPocketWithdrawals ...");
        return txCreatePocketWithdrawals.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contribution createPocketContributions(final InputCreatePocketContributions input) {
        LOG.info("... Invoking method PocketsDAO.createPocketContributions ...");
        return txCreatePocketContributions.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Liquidate createPocketLiquidate(final InputCreatePocketLiquidate input) {
        LOG.info("... Invoking method PocketsDAO.createPocketLiquidate ...");
        return txCreatePocketLiquidate.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pocket createPocket(final DTOIntPocket input) {
        LOG.info("... Invoking method PocketsDAO.createPocket ...");
        return txCreatePocketV2.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pocket getPocket(final PathParamPocketId input) {
        LOG.info("... Invoking method PocketsDAO.getPocket ...");
        return txGetPocketV2.perform(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pocket> modifyPocket(final DTOIntPocketV2 input) {
        LOG.info("... Invoking method PocketsDAO.modifyPocket ...");
        return txModifyPocketV2.perform(input);
    }
}
