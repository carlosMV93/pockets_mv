package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntPagination;
import com.bbva.pzic.pockets.business.dto.DTOIntPockets;
import com.bbva.pzic.pockets.business.dto.InputListPockets;
import com.bbva.pzic.pockets.canonic.Pockets;
import com.bbva.pzic.pockets.facade.v2.mapper.IListPocketsMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@Mapper
public class ListPocketsMapper implements IListPocketsMapper {

    private static final Log LOG = LogFactory.getLog(ListPocketsMapper.class);

    @Autowired
    private Translator translator;

    /**
     * {@inheritDoc}
     */
    @Override
    public InputListPockets mapIn(final String relatedContractNumber, final String statusId,
                                  final String paginationKey, final Long pageSize) {
        LOG.info("... called method ListPocketsMapper.mapIn ...");
        InputListPockets input = new InputListPockets();
        input.setRelatedContractNumber(relatedContractNumber);
        input.setStatusId(translator.translateFrontendEnumValueStrictly("pocket.statusId", statusId));

        DTOIntPagination pagination = new DTOIntPagination();
        pagination.setPaginationKey(paginationKey);
        pagination.setPageSize(pageSize);

        input.setPagination(pagination);
        return input;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pockets mapOut(final DTOIntPockets dtoIntPockets) {
        LOG.info("... called method ListPocketsMapper.mapOut ...");
        if (dtoIntPockets == null) {
            return null;
        }
        Pockets pockets = new Pockets();
        pockets.setData(dtoIntPockets.getData());
        return pockets;
    }
}