package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketRelatedContract;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.canonic.RelatedContractId;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.bbva.pzic.pockets.EntityMock.*;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class CreatePocketRelatedContractMapperTest {

    @InjectMocks
    private CreatePocketRelatedContractMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;
    @Mock
    private EnumMapper enumMapper;

    @Before
    public void setUp() {
        Mockito.when(enumMapper.getBackendValue("pocket.relatedContracts.productType.id", ENUM_IN_PRODUCT_TYPE_ID)).thenReturn(ENUM_OUT_PRODUCT_TYPE_ID);
        Mockito.when(enumMapper.getBackendValue("pocket.relatedContracts.numberType.id", ENUM_IN_NUMBER_TYPE_ID)).thenReturn(ENUM_OUT_NUMBER_TYPE_ID);
    }

    @Test
    public void mapInFullTest() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_RELATED_CONTRACT)).thenReturn(POCKET_ID_ORIGINAL);

        RelatedContract input = EntityMock.getInstance().getRelatedContract();
        InputCreatePocketRelatedContract result = mapper.mapIn(POCKET_ID_CYPHER, input);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPocketId());
        Assert.assertNotNull(result.getRelatedContract().getNumber());
        Assert.assertNotNull(result.getRelatedContract().getProduct().getId());
        Assert.assertNotNull(result.getRelatedContract().getProduct().getProductType().getId());
        Assert.assertNotNull(result.getRelatedContract().getProduct().getNumberType().getId());
        Assert.assertNotNull(result.getRelatedContract().getRelationType().getId());
        Assert.assertEquals(POCKET_ID_ORIGINAL, result.getPocketId());
        Assert.assertEquals(input.getNumber(), result.getRelatedContract().getNumber());
        Assert.assertEquals(input.getProduct().getId(), result.getRelatedContract().getProduct().getId());
        Assert.assertEquals(ENUM_OUT_PRODUCT_TYPE_ID, result.getRelatedContract().getProduct().getProductType().getId());
        Assert.assertEquals(ENUM_OUT_NUMBER_TYPE_ID, result.getRelatedContract().getProduct().getNumberType().getId());
        Assert.assertEquals(input.getRelationType().getId(), result.getRelatedContract().getRelationType().getId());
    }

    @Test
    public void mapInEmptyTest() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_RELATED_CONTRACT)).thenReturn(POCKET_ID_ORIGINAL);

        InputCreatePocketRelatedContract result = mapper.mapIn(POCKET_ID_CYPHER, new RelatedContract());

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPocketId());
        Assert.assertNull(result.getRelatedContract());
    }

    @Test
    public void mapOutFullTest() {
        ServiceResponse<RelatedContractId> result = mapper.mapOut(POCKET_ID_ORIGINAL);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<RelatedContractId> result = mapper.mapOut(null);
        Assert.assertNull(result);
    }
}