package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext;
import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketLiquidate;
import com.bbva.pzic.pockets.canonic.Liquidate;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext.ASTA_MX_CLIENT_ID;
import static com.bbva.pzic.pockets.EntityMock.ASTA_MX_CLIENT_ID_MOCK;
import static org.mockito.Mockito.when;
import static com.bbva.pzic.pockets.EntityMock.*;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class CreatePocketLiquidateMapperTest {

    @InjectMocks
    private CreatePocketLiquidateMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;
    @Mock
    private ServiceInvocationContext serviceInvocationContext;

    //modificaciones en test
    @Before
    public void setUp() {
        when(serviceInvocationContext.getProperty(ASTA_MX_CLIENT_ID)).thenReturn(ASTA_MX_CLIENT_ID_MOCK);
    }

    @Test
    public void mapInFullTest() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_LIQUIDATE)).thenReturn(EntityMock.POCKET_ID);
        InputCreatePocketLiquidate result = mapper.mapIn(POCKET_ID_CYPHER);
        Assert.assertNotNull(result);
        //modificaciones en test campo cifrado
        Assert.assertEquals(ASTA_MX_CLIENT_ID_MOCK, result.getCustomerId());
        //
        Assert.assertNotNull(result.getPocketId());
        Assert.assertEquals(EntityMock.POCKET_ID, result.getPocketId());
    }

    @Test
    public void mapInEmptyTest() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_LIQUIDATE)).thenReturn(EntityMock.POCKET_ID);
        InputCreatePocketLiquidate result = mapper.mapIn(POCKET_ID_CYPHER);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPocketId());
    }

    @Test
    public void mapOutFullTest() {
        ServiceResponse<Liquidate> result = mapper.mapOut(new Liquidate());
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<Liquidate> result = mapper.mapOut(null);

        Assert.assertNull(result);
    }
}