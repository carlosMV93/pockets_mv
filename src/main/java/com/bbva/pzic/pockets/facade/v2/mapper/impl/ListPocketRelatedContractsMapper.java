package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.InputListPocketRelatedContracts;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.canonic.RelatedContracts;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.facade.v2.mapper.IListPocketRelatedContractsMapper;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@Mapper
public class ListPocketRelatedContractsMapper implements IListPocketRelatedContractsMapper {

    private static final Log LOG = LogFactory.getLog(ListPocketRelatedContractsMapper.class);

    @Autowired
    private AbstractCypherTool cypherTool;

    /**
     * {@inheritDoc}
     */
    @Override
    public InputListPocketRelatedContracts mapIn(final String pocketId) {
        LOG.info("... called method ListPocketRelatedContractsMapper.mapIn ...");
        InputListPocketRelatedContracts input = new InputListPocketRelatedContracts();
        input.setPocketId(cypherTool.decrypt(pocketId, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKET_RELATED_CONTRACTS));
        return input;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ServiceResponse<List<RelatedContracts>> mapOut(final List<RelatedContract> relatedContract) {
        LOG.info("... called method ListPocketRelatedContractsMapper.mapOut ...");
        if (relatedContract.isEmpty()) {
            return null;
        }
        return ServiceResponse.data(relatedContract).build();
    }
}