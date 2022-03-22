package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketRelatedContract;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.canonic.RelatedContractId;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.facade.v2.mapper.ICreatePocketRelatedContractMapper;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@Mapper
public class CreatePocketRelatedContractMapper extends ConfigurableMapper implements ICreatePocketRelatedContractMapper {

    private static final Log LOG = LogFactory.getLog(CreatePocketRelatedContractMapper.class);

    @Autowired
    private AbstractCypherTool cypherTool;

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(RelatedContract.class, InputCreatePocketRelatedContract.class)
                .field("number", "relatedContract.number")
                .field("product.id", "relatedContract.product.id")
                .field("product.productType.id", "relatedContract.product.productType.id")
                .field("product.numberType.id", "relatedContract.product.numberType.id")
                .field("relationType.id", "relatedContract.relationType.id")
                .register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputCreatePocketRelatedContract mapIn(final String pocketId, final RelatedContract relatedContract) {
        LOG.info("... called method CreatePocketRelatedContractMapper.mapIn ...");
        InputCreatePocketRelatedContract input = map(relatedContract, InputCreatePocketRelatedContract.class);
        input.setPocketId(cypherTool.decrypt(pocketId, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_RELATED_CONTRACT));

        if (input.getRelatedContract() != null && input.getRelatedContract().getProduct() != null) {
            if (input.getRelatedContract().getProduct().getProductType() != null) {
                input.getRelatedContract().getProduct().getProductType().setId(enumMapper.getBackendValue(
                        "pocket.relatedContracts.productType.id", input.getRelatedContract().getProduct().getProductType().getId()));
            }

            if (input.getRelatedContract().getProduct().getNumberType() != null) {
                input.getRelatedContract().getProduct().getNumberType().setId(enumMapper.getBackendValue(
                        "pocket.relatedContracts.numberType.id", input.getRelatedContract().getProduct().getNumberType().getId()));
            }
        }

        return input;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public ServiceResponse<RelatedContractId> mapOut(final String identifier) {
        LOG.info("... called method CreatePocketRelatedContractMapper.mapOut ...");
        if (identifier == null) {
            return null;
        }
        RelatedContractId relatedContractId = new RelatedContractId();
        relatedContractId.setId(identifier);
        return ServiceResponse.data(relatedContractId).pagination(null).build();
    }
}