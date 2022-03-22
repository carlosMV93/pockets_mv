package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.DTOIntContribution;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketContributions;
import com.bbva.pzic.pockets.canonic.Contribution;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.facade.v2.mapper.ICreatePocketContributionsMapper;
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
public class CreatePocketContributionsMapper extends ConfigurableMapper implements ICreatePocketContributionsMapper {

    private static final Log LOG = LogFactory.getLog(CreatePocketContributionsMapper.class);

    @Autowired
    private AbstractCypherTool cypherTool;

    /**
     * {@inheritDoc}
     */
    @Override
    public InputCreatePocketContributions mapIn(final String pocketId, final Contribution contribution) {
        LOG.info("... called method CreatePocketContributionsMapper.mapIn ...");
        InputCreatePocketContributions input = map(contribution, InputCreatePocketContributions.class);
        if (input.getContribution() == null)
            input.setContribution(new DTOIntContribution());
        input.setPocketId(cypherTool.decrypt(pocketId, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_CONTRIBUTIONS));
        return input;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public ServiceResponse<Contribution> mapOut(final Contribution contribution) {
        LOG.info("... called method CreatePocketContributionsMapper.mapOut ...");
        if (contribution == null) {
            return null;
        }

        return ServiceResponse.data(contribution).build();
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(Contribution.class, InputCreatePocketContributions.class)
                .field("contributionAmount.amount", "contribution.contributionAmount.amount")
                .field("contributionAmount.currency", "contribution.contributionAmount.currency")
                .register();
    }
}