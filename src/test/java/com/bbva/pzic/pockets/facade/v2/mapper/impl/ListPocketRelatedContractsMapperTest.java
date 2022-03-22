package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputListPocketRelatedContracts;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.canonic.RelatedContracts;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static com.bbva.pzic.pockets.EntityMock.POCKET_ID_CYPHER;
import static com.bbva.pzic.pockets.EntityMock.POCKET_ID_ORIGINAL;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ListPocketRelatedContractsMapperTest {

    @InjectMocks
    private ListPocketRelatedContractsMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;

    @Test
    public void mapInFullTest() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKET_RELATED_CONTRACTS)).thenReturn(POCKET_ID_ORIGINAL);
        InputListPocketRelatedContracts result = mapper.mapIn(EntityMock.POCKET_ID_CYPHER);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPocketId());
        Assert.assertEquals(EntityMock.POCKET_ID_ORIGINAL, result.getPocketId());
    }

    @Test
    public void mapOutFullTest() {
        ServiceResponse<List<RelatedContracts>> result = mapper.mapOut(Collections.singletonList(new RelatedContract()));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<List<RelatedContracts>> result = mapper.mapOut(Collections.<RelatedContract>emptyList());
        Assert.assertNull(result);
    }
}