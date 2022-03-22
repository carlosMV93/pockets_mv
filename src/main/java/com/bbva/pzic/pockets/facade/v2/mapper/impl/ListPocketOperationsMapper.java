package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntOperations;
import com.bbva.pzic.pockets.business.dto.InputListPocketOperations;
import com.bbva.pzic.pockets.canonic.Operations;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.facade.v2.mapper.IListPocketOperationsMapper;
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
public class ListPocketOperationsMapper implements IListPocketOperationsMapper {

    private static final Log LOG = LogFactory.getLog(ListPocketOperationsMapper.class);

    @Autowired
    private AbstractCypherTool cypherTool;

    /**
     * {@inheritDoc}
     */
    @Override
    public InputListPocketOperations mapIn(final String pocketId, final String paginationKey, final Long pageSize) {
        LOG.info("... called method ListPocketOperationsMapper.mapIn ...");
        InputListPocketOperations input = new InputListPocketOperations();
        input.setPocketId(cypherTool.decrypt(pocketId, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKETS_OPERATIONS));
        input.setPaginationKey(paginationKey);
        input.setPageSize(pageSize);
        return input;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Operations mapOut(final DTOIntOperations dtoIntOperations) {
        LOG.info("... called method ListPocketOperationsMapper.mapOut ...");
        if (dtoIntOperations == null) {
            return null;
        }
        Operations operations = new Operations();
        operations.setData(dtoIntOperations.getData());
        return operations;
    }
}