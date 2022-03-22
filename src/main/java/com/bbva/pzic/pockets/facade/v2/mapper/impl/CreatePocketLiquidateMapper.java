package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketLiquidate;
import com.bbva.pzic.pockets.canonic.Liquidate;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.facade.v2.mapper.ICreatePocketLiquidateMapper;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@Mapper
public class CreatePocketLiquidateMapper implements ICreatePocketLiquidateMapper {

    private static final Log LOG = LogFactory.getLog(CreatePocketLiquidateMapper.class);

    @Autowired
    private AbstractCypherTool cypherTool;

    //obtener de contexto
    private ServiceInvocationContext serviceInvocationContext;

    @Autowired
    public void setServiceInvocationContext(ServiceInvocationContext serviceInvocationContext) {
        this.serviceInvocationContext = serviceInvocationContext;
    }

    /**
	 * {@inheritDoc}
	 */
	@Override
	public InputCreatePocketLiquidate mapIn(final String pocketId) {
		LOG.info("... called method CreatePocketLiquidateMapper.mapIn ...");
		LOG.debug(String.format("Pocket id recibido = %s", pocketId));
		InputCreatePocketLiquidate input = new InputCreatePocketLiquidate();
        //campo sesionado
        input.setCustomerId(serviceInvocationContext.getProperty("ASTAMxClientId"));
        //
		input.setPocketId(cypherTool.decrypt(pocketId, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_LIQUIDATE));
		return input;
	}

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public ServiceResponse<Liquidate> mapOut(final Liquidate liquidate) {
        LOG.info("... called method CreatePocketLiquidateMapper.mapOut ...");
        if (liquidate == null) {
            return null;
        }
        return ServiceResponse.data(liquidate).build();
    }
}