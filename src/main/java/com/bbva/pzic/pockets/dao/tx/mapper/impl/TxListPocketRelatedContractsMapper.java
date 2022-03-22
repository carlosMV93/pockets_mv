package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.InputListPocketRelatedContracts;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ720;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ721;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketRelatedContractsMapper;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@Mapper
public class TxListPocketRelatedContractsMapper extends ConfigurableMapper implements ITxListPocketRelatedContractsMapper {

    @Autowired
    private AbstractCypherTool cypherTool;
    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(InputListPocketRelatedContracts.class, FormatoBGMQ720.class)
                .field("pocketId", "idepock")
                .register();

        factory.classMap(FormatoBGMQ721.class, RelatedContract.class)
                .field("idafili", "id")
                .field("numecta", "contractId")
                .field("numecta", "number")
                .field("tiprodt", "product.id")
                .field("ideprre", "product.productType.id")
                .field("idetico", "product.numberType.id")
                .field("reltyid", "relationType.id")
                .field("relname", "relationType.name")
                .field("fechafi", "relationDate")
                .register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoBGMQ720 mapIn(final InputListPocketRelatedContracts dtoIn) {
        return map(dtoIn, FormatoBGMQ720.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RelatedContract> mapOut(final FormatoBGMQ721 formatOutput) {
        RelatedContract relatedContract = map(formatOutput, RelatedContract.class);
        List<RelatedContract> lstRelatedContracts = new ArrayList<>();
        relatedContract.setId(cypherTool.encrypt(formatOutput.getIdafili(), AbstractCypherTool.RELATED_CONTRACT_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKET_RELATED_CONTRACTS));

        if (formatOutput.getIdeprre() != null) {
            relatedContract.getProduct().getProductType().setId(
                    enumMapper.getEnumValue("pocket.relatedContracts.productType.id", formatOutput.getIdeprre()));
        }
        if (formatOutput.getIdetico() != null) {
            relatedContract.getProduct().getNumberType().setId(
                    enumMapper.getEnumValue("pocket.relatedContracts.numberType.id", formatOutput.getIdetico()));
        }
        lstRelatedContracts.add(relatedContract);
        return lstRelatedContracts;
    }
}