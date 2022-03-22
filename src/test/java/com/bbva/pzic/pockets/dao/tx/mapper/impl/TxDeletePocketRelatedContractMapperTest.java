package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputDeletePocketRelatedContract;
import com.bbva.pzic.pockets.dao.model.bq73.FormatoBGMQ730;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxDeletePocketRelatedContractMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public class TxDeletePocketRelatedContractMapperTest {

    private ITxDeletePocketRelatedContractMapper mapper;

    @Before
    public void setUp() {
        mapper = new TxDeletePocketRelatedContractMapper();
    }

    @Test
    public void mapInFullTest() {
        InputDeletePocketRelatedContract input = EntityMock.getInstance().getInputDeletePocketRelatedContract();
        FormatoBGMQ730 result = mapper.mapIn(input);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdepock());
        Assert.assertNotNull(result.getNumecta());
        Assert.assertEquals(input.getPocketId(), result.getIdepock());
        Assert.assertEquals(input.getRelatedContractId(), result.getNumecta());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoBGMQ730 result = mapper.mapIn(new InputDeletePocketRelatedContract());
        Assert.assertNotNull(result);
        Assert.assertNull(result.getIdepock());
        Assert.assertNull(result.getNumecta());
    }
}