package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.InputDeletePocketRelatedContract;
import com.bbva.pzic.pockets.dao.model.bq73.FormatoBGMQ730;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxDeletePocketRelatedContractMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@Mapper
public class TxDeletePocketRelatedContractMapper extends ConfigurableMapper implements ITxDeletePocketRelatedContractMapper {

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(InputDeletePocketRelatedContract.class, FormatoBGMQ730.class)
                .field("pocketId", "idepock")
                .field("relatedContractId", "numecta")
                .register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoBGMQ730 mapIn(final InputDeletePocketRelatedContract dtoIn) {
        return map(dtoIn, FormatoBGMQ730.class);
    }
}