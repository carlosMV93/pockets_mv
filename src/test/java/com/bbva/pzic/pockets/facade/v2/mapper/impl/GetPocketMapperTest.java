package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.bbva.pzic.pockets.EntityMock.POCKET_ID_CYPHER;
import static com.bbva.pzic.pockets.EntityMock.POCKET_ID_ORIGINAL;
import static org.junit.Assert.*;

/**
 * Created on 18/10/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class GetPocketMapperTest {

    @InjectMocks
    private GetPocketMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;

    @Test
    public void mapInFull() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_GET_POCKET)).thenReturn(POCKET_ID_ORIGINAL);

        PathParamPocketId result = mapper.mapIn(POCKET_ID_CYPHER);

        assertNotNull(result.getPocketId());
        assertEquals(POCKET_ID_ORIGINAL, result.getPocketId());
    }

    @Test
    public void mapOutFull() throws IOException {
        Pocket input = EntityMock.getInstance().getResponseGetPocketV2();
        ServiceResponse<Pocket> result = mapper.mapOut(input);
        assertNotNull(result);
        assertNotNull(result.getData());
        assertNotNull(result.getData().getId());
        assertNotNull(result.getData().getAlias());
        assertNotNull(result.getData().getExpirationDate());
        assertNotNull(result.getData().getPriority());
        assertNotNull(result.getData().getCategory().getId());
        assertNotNull(result.getData().getCategory().getName());
        assertNotNull(result.getData().getStatus());
        assertNotNull(result.getData().getIsScheduled());
        assertNotNull(result.getData().getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getData().getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getData().getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getData().getScheduledDeposit().getPeriod().getFrequency().getName());
        assertNotNull(result.getData().getScheduledDeposit().getPeriod().getDayOfMonth());
        assertNotNull(result.getData().getRelatedContract().getNumber());
        assertNotNull(result.getData().getCreationDate());
        assertNotNull(result.getData().getIsSavingRounding());
        assertNotNull(result.getMessages());
        assertNull(result.getPagination());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<Pocket> result = mapper.mapOut(null);
        assertNull(result);
    }


}
