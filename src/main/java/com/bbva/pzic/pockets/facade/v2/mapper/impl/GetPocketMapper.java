package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.facade.v2.mapper.IGetPocketMapper;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper("getPocketMapperv2")
public class GetPocketMapper implements IGetPocketMapper {

    private static final Log LOG = LogFactory.getLog(GetPocketMapper.class);

    @Autowired
    private AbstractCypherTool cypherTool;

    @Override
    public PathParamPocketId mapIn(String pocketId) {
        LOG.info("... called method GetPocketMapper.mapIn ...");
        PathParamPocketId pathParamPocketId = new PathParamPocketId();
        pathParamPocketId.setPocketId(cypherTool.decrypt(pocketId, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_GET_POCKET));
        return pathParamPocketId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ServiceResponse<Pocket> mapOut(Pocket pocket) {
        LOG.info("... called method GetPocketMapper.mapOut ...");
        if (pocket == null) {
            return null;
        }
        return ServiceResponse.data(pocket).pagination(null).build();
    }
}