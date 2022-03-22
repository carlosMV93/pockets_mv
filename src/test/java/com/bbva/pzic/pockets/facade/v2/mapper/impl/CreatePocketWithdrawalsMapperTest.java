package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketWithdrawals;
import com.bbva.pzic.pockets.canonic.Withdrawal;
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
public class CreatePocketWithdrawalsMapperTest {

    @InjectMocks
    private CreatePocketWithdrawalsMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;

    @Test
    public void mapInFullTest() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_WITHDRAWALS)).thenReturn(EntityMock.POCKET_ID);
        Withdrawal input = EntityMock.getInstance().getWithdrawal();
        InputCreatePocketWithdrawals result = mapper.mapIn(POCKET_ID_CYPHER, input);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPocketId());
        Assert.assertNotNull(result.getWithdrawal().getWithdrawalAmount().getAmount());
        Assert.assertNotNull(result.getWithdrawal().getWithdrawalAmount().getCurrency());

        Assert.assertEquals(EntityMock.POCKET_ID, result.getPocketId());
        Assert.assertEquals(input.getWithdrawalAmount().getAmount(), result.getWithdrawal().getWithdrawalAmount().getAmount());
        Assert.assertEquals(input.getWithdrawalAmount().getCurrency(), result.getWithdrawal().getWithdrawalAmount().getCurrency());
    }

    @Test
    public void mapInEmptyTest() {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_WITHDRAWALS)).thenReturn(EntityMock.POCKET_ID);
        InputCreatePocketWithdrawals result = mapper.mapIn(POCKET_ID_CYPHER, new Withdrawal());

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getWithdrawal());
        Assert.assertNotNull(result.getPocketId());
        Assert.assertNull(result.getWithdrawal().getWithdrawalAmount());
    }

    @Test
    public void mapOutFullTest() {
        ServiceResponse<Withdrawal> result = mapper.mapOut(new Withdrawal());
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<Withdrawal> result = mapper.mapOut(null);
        Assert.assertNull(result);
    }
}