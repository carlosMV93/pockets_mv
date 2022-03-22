package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketRelatedContract;
import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ710;
import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ711;
import com.bbva.pzic.pockets.dao.model.bq71.mock.FormatsBq71Mock;
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

import static com.bbva.pzic.pockets.EntityMock.RELATED_CONTRACT_ID_CYPHER;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxCreatePocketRelatedContractMapperTest {

    @InjectMocks
    private TxCreatePocketRelatedContractMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;

    @Test
    public void mapInFullTest() throws IOException {
        InputCreatePocketRelatedContract input = EntityMock.getInstance().getInputCreatePocketRelatedContract();
        FormatoBGMQ710 result = mapper.mapIn(input);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdepock());
        Assert.assertNotNull(result.getNumcta1());
        Assert.assertNotNull(result.getTipcta1());
        Assert.assertNotNull(result.getIdepre1());
        Assert.assertNotNull(result.getIdetic1());
        Assert.assertNotNull(result.getReltid1());
        Assert.assertEquals(input.getPocketId(), result.getIdepock());
        Assert.assertEquals(input.getRelatedContract().getNumber(), result.getNumcta1());
        Assert.assertEquals(input.getRelatedContract().getProduct().getId(), result.getTipcta1());
        Assert.assertEquals(input.getRelatedContract().getProduct().getProductType().getId(), result.getIdepre1());
        Assert.assertEquals(input.getRelatedContract().getProduct().getNumberType().getId(), result.getIdetic1());
        Assert.assertEquals(input.getRelatedContract().getRelationType().getId(), result.getReltid1());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoBGMQ710 result = mapper.mapIn(new InputCreatePocketRelatedContract());
        Assert.assertNotNull(result);
        Assert.assertNull(result.getIdepock());
        Assert.assertNull(result.getNumcta1());
        Assert.assertNull(result.getTipcta1());
        Assert.assertNull(result.getIdepre1());
        Assert.assertNull(result.getIdetic1());
        Assert.assertNull(result.getReltid1());
    }

    @Test
    public void mapOutFullTest() {
        FormatoBGMQ711 format = FormatsBq71Mock.getInstance().getFormatoBGMQ711();

        Mockito.when(cypherTool.encrypt(format.getIdnmcta(), AbstractCypherTool.RELATED_CONTRACT_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET_RELATED_CONTRACT)).thenReturn(RELATED_CONTRACT_ID_CYPHER);

        String result = mapper.mapOut(format);

        Assert.assertNotNull(result);
        Assert.assertEquals(RELATED_CONTRACT_ID_CYPHER, result);
    }

    @Test
    public void mapOutEmptyTest() {
        String result = mapper.mapOut(new FormatoBGMQ711());
        Assert.assertNull(result);
    }
}