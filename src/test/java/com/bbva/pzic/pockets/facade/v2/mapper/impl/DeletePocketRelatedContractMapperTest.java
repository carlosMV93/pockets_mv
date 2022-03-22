package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.pzic.pockets.business.dto.InputDeletePocketRelatedContract;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.bbva.pzic.pockets.EntityMock.*;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class DeletePocketRelatedContractMapperTest {

    @InjectMocks
    private DeletePocketRelatedContractMapper mapper;

    @Mock
    private AbstractCypherTool cypherTool;

    @Test
    public void mapInFullTest() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_DELETE_POCKET_RELATED_CONTRACT)).thenReturn(POCKET_ID_ORIGINAL);
        Mockito.when(cypherTool.decrypt(RELATED_CONTRACT_ID_CYPHER, AbstractCypherTool.RELATED_CONTRACT_ID, RegistryIds.SMC_REGISTRY_ID_OF_DELETE_POCKET_RELATED_CONTRACT)).thenReturn(RELATED_CONTRACT_ID_ORIGINAL);

        InputDeletePocketRelatedContract result = mapper.mapIn(POCKET_ID_CYPHER, RELATED_CONTRACT_ID_CYPHER);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPocketId());
        Assert.assertNotNull(result.getRelatedContractId());
        Assert.assertEquals(POCKET_ID_ORIGINAL, result.getPocketId());
        Assert.assertEquals(RELATED_CONTRACT_ID_ORIGINAL, result.getRelatedContractId());
    }
}