package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntTransaction;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41E1;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41S1;
import com.bbva.pzic.pockets.dao.model.bq41.mock.FormatBq41Mock;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketTransactionMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class TxCreatePocketTransactionMapperTest {

    private ITxCreatePocketTransactionMapper pocketTransactionMapper;
    private DummyMock dummyMock;
    private FormatBq41Mock formatBq41Mock;

    @Before
    public void init() {
        pocketTransactionMapper = new TxCreatePocketTransactionMapper();
        dummyMock = new DummyMock();
        formatBq41Mock = new FormatBq41Mock();
    }

    @Test
    public void mapInFullTest() throws IOException {
        DTOIntTransaction input = dummyMock.getDTOIntPocketTransaction();
        FormatoBQM41E1 result = pocketTransactionMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result);
        Assert.assertEquals(input.getOperationType().getId(), result.getTipope());
        Assert.assertEquals(input.getAmount().getCurrency(), result.getMoneda());
        Assert.assertEquals(input.getAmount().getValue(), result.getImporte());
    }

    @Test
    public void mapOutFullTest() {
        FormatoBQM41S1 format = formatBq41Mock.getFormatoBQM41S1();
        DTOIntTransaction result = pocketTransactionMapper.mapOut(format);
        Assert.assertNotNull(result);
        Assert.assertEquals(format.getNumope(), result.getId());
    }

    @Test
    public void mapOutEmptyTest() {
        DTOIntTransaction result = pocketTransactionMapper.mapOut(new FormatoBQM41S1());
        Assert.assertNotNull(result);
        Assert.assertNull(result.getId());
    }

    @Test
    public void mapOutNullTest() {
        DTOIntTransaction result = pocketTransactionMapper.mapOut(null);
        Assert.assertNull(result);
    }
}