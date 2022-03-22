package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputListPocketRelatedContracts;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ720;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ721;
import com.bbva.pzic.pockets.dao.model.bq72.mock.FormatsBq72Mock;
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
import java.util.List;

import static com.bbva.pzic.pockets.EntityMock.*;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxListPocketRelatedContractsMapperTest {

    @InjectMocks
    private TxListPocketRelatedContractsMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;
    @Mock
    private EnumMapper enumMapper;

    @Before
    public void setUp() {
        Mockito.when(enumMapper.getEnumValue("pocket.relatedContracts.productType.id", ENUM_OUT_PRODUCT_TYPE_ID)).thenReturn(ENUM_IN_PRODUCT_TYPE_ID);
        Mockito.when(enumMapper.getEnumValue("pocket.relatedContracts.numberType.id", ENUM_OUT_NUMBER_TYPE_ID)).thenReturn(ENUM_IN_NUMBER_TYPE_ID);
    }

    @Test
    public void mapInFullTest() {
        InputListPocketRelatedContracts input = EntityMock.getInstance().getInputListPocketRelatedContracts();
        FormatoBGMQ720 result = mapper.mapIn(input);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdepock());
        Assert.assertEquals(input.getPocketId(), result.getIdepock());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoBGMQ720 result = mapper.mapIn(new InputListPocketRelatedContracts());

        Assert.assertNotNull(result);
        Assert.assertNull(result.getIdepock());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        FormatoBGMQ721 format = FormatsBq72Mock.getInstance().getFormatoBGMQ721().get(0);

        Mockito.when(cypherTool.encrypt(format.getIdafili(), AbstractCypherTool.RELATED_CONTRACT_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKET_RELATED_CONTRACTS)).thenReturn(RELATED_CONTRACT_ID_CYPHER);
        List<RelatedContract> listresult = mapper.mapOut(format);
        RelatedContract result = listresult.get(0);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getId());
        Assert.assertNotNull(result.getContractId());
        Assert.assertNotNull(result.getNumber());
        Assert.assertNotNull(result.getProduct().getId());
        Assert.assertNotNull(result.getProduct().getProductType().getId());
        Assert.assertNotNull(result.getProduct().getNumberType().getId());
        Assert.assertNotNull(result.getRelationType().getId());
        Assert.assertNotNull(result.getRelationType().getName());
        Assert.assertNotNull(result.getRelationDate());
        Assert.assertEquals(RELATED_CONTRACT_ID_CYPHER, result.getId());
        Assert.assertEquals(format.getNumecta(), result.getContractId());
        Assert.assertEquals(format.getNumecta(), result.getNumber());
        Assert.assertEquals(format.getTiprodt(), result.getProduct().getId());
        Assert.assertEquals(ENUM_IN_PRODUCT_TYPE_ID, result.getProduct().getProductType().getId());
        Assert.assertEquals(ENUM_IN_NUMBER_TYPE_ID, result.getProduct().getNumberType().getId());
        Assert.assertEquals(format.getReltyid(), result.getRelationType().getId());
        Assert.assertEquals(format.getRelname(), result.getRelationType().getName());
        Assert.assertEquals(format.getFechafi(), result.getRelationDate());
    }

    @Test
    public void mapOutEmptyTest() {
        List<RelatedContract> listresult = mapper.mapOut(new FormatoBGMQ721());
        RelatedContract result = listresult.get(0);
        Assert.assertNotNull(result);
        Assert.assertNull(result.getId());
        Assert.assertNull(result.getContractId());
        Assert.assertNull(result.getNumber());
        Assert.assertNull(result.getProduct());
        Assert.assertNull(result.getRelationType());
        Assert.assertNull(result.getRelationDate());
    }
}