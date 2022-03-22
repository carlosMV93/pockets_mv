package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.DTOIntWithdrawal;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketWithdrawals;
import com.bbva.pzic.pockets.canonic.Withdrawal;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.facade.v2.mapper.ICreatePocketWithdrawalsMapper;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@Mapper
public class CreatePocketWithdrawalsMapper extends ConfigurableMapper implements ICreatePocketWithdrawalsMapper {

    private static final Log LOG = LogFactory.getLog(CreatePocketWithdrawalsMapper.class);

    @Autowired
    private AbstractCypherTool cypherTool;

    /**
     * {@inheritDoc}
     */
    @Override
    public InputCreatePocketWithdrawals mapIn(final String pocketId, final Withdrawal withdrawal) {
        LOG.info("... called method CreatePocketWithdrawalsMapper.mapIn ...");
        InputCreatePocketWithdrawals input = map(withdrawal, InputCreatePocketWithdrawals.class);
        if (input.getWithdrawal() == null)
            input.setWithdrawal(new DTOIntWithdrawal());
        input.setPocketId(cypherTool.decrypt(pocketId, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_WITHDRAWALS));
        return input;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public ServiceResponse<Withdrawal> mapOut(final Withdrawal withdrawal) {
        LOG.info("... called method CreatePocketWithdrawalsMapper.mapOut ...");
        if (withdrawal == null) {
            return null;
        }

        return ServiceResponse.data(withdrawal).build();
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(Withdrawal.class, InputCreatePocketWithdrawals.class)
                .field("withdrawalAmount.amount", "withdrawal.withdrawalAmount.amount")
                .field("withdrawalAmount.currency", "withdrawal.withdrawalAmount.currency")
                .register();
    }
}