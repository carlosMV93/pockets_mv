package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.InputCreatePocketRelatedContract;
import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ710;
import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ711;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketRelatedContractMapper;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@Mapper
public class TxCreatePocketRelatedContractMapper extends ConfigurableMapper implements ITxCreatePocketRelatedContractMapper {

    @Autowired
    private AbstractCypherTool cypherTool;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(InputCreatePocketRelatedContract.class, FormatoBGMQ710.class)
                .field("pocketId", "idepock")
                .field("relatedContract.number", "numcta1")
                .field("relatedContract.product.id", "tipcta1")
                .field("relatedContract.product.productType.id", "idepre1")
                .field("relatedContract.product.numberType.id", "idetic1")
                .field("relatedContract.relationType.id", "reltid1")
                .register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoBGMQ710 mapIn(final InputCreatePocketRelatedContract dtoIn) {
        return map(dtoIn, FormatoBGMQ710.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String mapOut(final FormatoBGMQ711 formatOutput) {
        if (formatOutput.getIdnmcta() == null) {
            return null;
        }
        return cypherTool.encrypt(formatOutput.getIdnmcta(), AbstractCypherTool.RELATED_CONTRACT_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_RELATED_CONTRACT);
    }
}