package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketContributions;
import com.bbva.pzic.pockets.canonic.Contribution;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.bbva.pzic.pockets.EntityMock.POCKET_ID_CYPHER;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class CreatePocketContributionsMapperTest {

    @InjectMocks
    private CreatePocketContributionsMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;

    @Test
    public void mapInFullTest() throws IOException {
        Contribution input = EntityMock.getInstance().getContribution();
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_CONTRIBUTIONS)).thenReturn(EntityMock.POCKET_ID);
        InputCreatePocketContributions result = mapper.mapIn(POCKET_ID_CYPHER, input);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPocketId());
        Assert.assertNotNull(result.getContribution().getContributionAmount().getAmount());
        Assert.assertNotNull(result.getContribution().getContributionAmount().getCurrency());

        Assert.assertEquals(EntityMock.POCKET_ID, result.getPocketId());
        Assert.assertEquals(input.getContributionAmount().getAmount(), result.getContribution().getContributionAmount().getAmount());
        Assert.assertEquals(input.getContributionAmount().getCurrency(), result.getContribution().getContributionAmount().getCurrency());
    }

    @Test
    public void mapInEmptyTest() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_CONTRIBUTIONS)).thenReturn(EntityMock.POCKET_ID);
        InputCreatePocketContributions result = mapper.mapIn(POCKET_ID_CYPHER, new Contribution());

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getContribution());
        Assert.assertNotNull(result.getPocketId());
        Assert.assertNull(result.getContribution().getContributionAmount());
    }

    @Test
    public void mapOutFullTest() {
        ServiceResponse<Contribution> result = mapper.mapOut(new Contribution());
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<Contribution> result = mapper.mapOut(null);
        Assert.assertNull(result);
    }
}