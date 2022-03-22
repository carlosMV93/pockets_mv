package com.bbva.pzic.pockets.business.impl;

import com.bbva.pzic.pockets.business.ISrvIntPockets;
import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.*;
import com.bbva.pzic.pockets.dao.IPocketsDAO;
import com.bbva.pzic.routine.validator.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@Service
public class SrvIntPockets implements ISrvIntPockets {

    private static final Log LOG = LogFactory.getLog(SrvIntPockets.class);
    @Autowired
    private IPocketsDAO pocketsDAO;
    @Autowired
    private Validator validator;

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntPockets listPockets(final InputListPockets input) {
        LOG.info("... Invoking method SrvIntPockets.listPockets ...");
        LOG.info("... Validating listPockets input parameter ...");
        validator.validate(input, ValidationGroup.ListPockets.class);
        return pocketsDAO.listPockets(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RelatedContract> listPocketRelatedContracts(final InputListPocketRelatedContracts input) {
        LOG.info("... Invoking method SrvIntPockets.listPocketRelatedContracts ...");
        LOG.info("... Validating listPocketRelatedContracts input parameter ...");
        validator.validate(input, ValidationGroup.ListPocketRelatedContracts.class);
        return pocketsDAO.listPocketRelatedContracts(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String createPocketRelatedContract(final InputCreatePocketRelatedContract input) {
        LOG.info("... Invoking method SrvIntPockets.createPocketRelatedContract ...");
        LOG.info("... Validating createPocketRelatedContract input parameter ...");
        validator.validate(input, ValidationGroup.CreatePocketRelatedContract.class);
        return pocketsDAO.createPocketRelatedContract(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePocketRelatedContract(final InputDeletePocketRelatedContract input) {
        LOG.info("... Invoking method SrvIntPockets.deletePocketRelatedContract ...");
        validator.validate(input, ValidationGroup.DeletePocketRelatedContract.class);
        pocketsDAO.deletePocketRelatedContract(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntOperations listPocketOperations(final InputListPocketOperations input) {
        LOG.info("... Invoking method SrvIntPockets.listPocketOperations ...");
        validator.validate(input, ValidationGroup.ListPocketsOperations.class);
        return pocketsDAO.listPocketOperations(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Withdrawal createPocketWithdrawals(final InputCreatePocketWithdrawals input) {
        LOG.info("... Invoking method SrvIntPockets.createPocketWithdrawals ...");
        LOG.info("... Validating createPocketWithdrawals input parameter ...");
        validator.validate(input, ValidationGroup.CreatePocketWithdrawals.class);
        return pocketsDAO.createPocketWithdrawals(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contribution createPocketContributions(final InputCreatePocketContributions input) {
        LOG.info("... Invoking method SrvIntPockets.createPocketContributions ...");
        LOG.info("... Validating createPocketContributions input parameter ...");
        validator.validate(input, ValidationGroup.CreatePocketContributions.class);
        return pocketsDAO.createPocketContributions(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Liquidate createPocketLiquidate(final InputCreatePocketLiquidate input) {
        LOG.info("... Invoking method SrvIntPockets.createPocketLiquidate ...");
        validator.validate(input, ValidationGroup.CreatePocketLiquidate.class);
        return pocketsDAO.createPocketLiquidate(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pocket createPocket(final DTOIntPocket input) {
        LOG.info("... Invoking method SrvIntPockets.createPocket ...");
        validator.validate(input, ValidationGroup.CreatePocketV2.class);
        return pocketsDAO.createPocket(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pocket getPocket(final PathParamPocketId input) {
        LOG.info("... Invoking method SrvIntPockets.getPocket ...");
        validator.validate(input, ValidationGroup.GetPocketV2.class);
        return pocketsDAO.getPocket(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pocket> modifyPocket(final DTOIntPocketV2 input) {
        LOG.info("... Invoking method SrvIntPockets.modifyPocket ...");
        validator.validate(input, ValidationGroup.ModifyPocketV2.class);
        return pocketsDAO.modifyPocket(input);
    }
}
