package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.pzic.pockets.business.dto.InputDeletePocketRelatedContract;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.facade.v2.mapper.IDeletePocketRelatedContractMapper;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@Mapper
public class DeletePocketRelatedContractMapper implements IDeletePocketRelatedContractMapper {

    private static final Log LOG = LogFactory.getLog(DeletePocketRelatedContractMapper.class);

    @Autowired
    private AbstractCypherTool cypherTool;

    /**
     * {@inheritDoc}
     */
    @Override
    public InputDeletePocketRelatedContract mapIn(final String pocketId, final String relatedContractId) {
        LOG.info("... called method DeletePocketRelatedContractMapper.mapIn ...");
        InputDeletePocketRelatedContract input = new InputDeletePocketRelatedContract();
        input.setPocketId(cypherTool.decrypt(pocketId, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_DELETE_POCKET_RELATED_CONTRACT));
        input.setRelatedContractId(cypherTool.decrypt(relatedContractId, AbstractCypherTool.RELATED_CONTRACT_ID, RegistryIds.SMC_REGISTRY_ID_OF_DELETE_POCKET_RELATED_CONTRACT));
        return input;
    }
}