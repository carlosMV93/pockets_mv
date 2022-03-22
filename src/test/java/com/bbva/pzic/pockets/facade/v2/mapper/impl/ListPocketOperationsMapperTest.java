package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputListPocketOperations;
import com.bbva.pzic.pockets.canonic.Operations;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.bbva.pzic.pockets.EntityMock.POCKET_ID_CYPHER;
import static com.bbva.pzic.pockets.EntityMock.POCKET_ID_ORIGINAL;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ListPocketOperationsMapperTest {

    @InjectMocks
    private ListPocketOperationsMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;

    @Test
    public void mapInFullTest() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKETS_OPERATIONS)).thenReturn(POCKET_ID_ORIGINAL);
        InputListPocketOperations result = mapper.mapIn(EntityMock.POCKET_ID_CYPHER, EntityMock.PAGINATION_KEY, EntityMock.PAGE_SIZE);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPocketId());
        Assert.assertNotNull(result.getPaginationKey());
        Assert.assertNotNull(result.getPageSize());
        Assert.assertEquals(EntityMock.POCKET_ID_ORIGINAL, result.getPocketId());
        Assert.assertEquals(EntityMock.PAGINATION_KEY, result.getPaginationKey());
        Assert.assertEquals(EntityMock.PAGE_SIZE, result.getPageSize());
    }

    @Test
    public void mapInEmptyTest() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKETS_OPERATIONS)).thenReturn(POCKET_ID_ORIGINAL);
        InputListPocketOperations result = mapper.mapIn(EntityMock.POCKET_ID_CYPHER, null, null);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPocketId());
        Assert.assertNull(result.getPaginationKey());
        Assert.assertNull(result.getPageSize());
    }

    @Test
    public void mapOutFullTest() {
        Operations result = mapper.mapOut(EntityMock.getInstance().getDTOIntOperations());
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        Operations result = mapper.mapOut(null);
        Assert.assertNull(result);
    }
}