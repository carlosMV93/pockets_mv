package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntTransaction;
import com.bbva.pzic.pockets.canonic.Transaction;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class CreatePocketTransactionMapperTest {
    private static final String CREDIT = "-";
    @InjectMocks
    private CreatePocketTransactionMapper pocketTransactionMapper;
    @Mock
    private EnumMapper enumMapper;
    private DummyMock dummyMock = new DummyMock();

    @Test
    public void mapInFullTest() throws IOException {
        Mockito.when(enumMapper.getBackendValue("transaction.operationType.id", "CREDIT")).thenReturn(CREDIT);
        Transaction transaction = dummyMock.getCreatedPocketTransaction();
        DTOIntTransaction result = pocketTransactionMapper.mapIn(DummyMock.POCKET_ID, transaction);

        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getOperationType());
        Assert.assertEquals(CREDIT, result.getOperationType().getId());

        Assert.assertNotNull(result.getAmount());

        Assert.assertNotNull(result.getAmount().getCurrency());
        Assert.assertEquals(transaction.getAmount().getCurrency(), result.getAmount().getCurrency());

        Assert.assertNotNull(result.getAmount().getValue());
        Assert.assertEquals(transaction.getAmount().getValue(), result.getAmount().getValue());
    }

    @Test
    public void mapInEmptyTest() throws IOException {
        DTOIntTransaction result = pocketTransactionMapper.mapIn(null, new Transaction());

        Assert.assertNotNull(result);
        Assert.assertNull(result.getPocketId());
        Assert.assertNull(result.getOperationType());
        Assert.assertNull(result.getAmount());
    }


    @Test
    public void mapOutFullTest() throws IOException {
        DTOIntTransaction dto = dummyMock.getDTOOutPocketTransaction();
        Transaction result = pocketTransactionMapper.mapOut(dto);

        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getId());
        Assert.assertEquals(dto.getId(), result.getId());

    }

    @Test
    public void mapOutEmptyTest() throws IOException {
        DTOIntTransaction dto = new DTOIntTransaction();
        Transaction result = pocketTransactionMapper.mapOut(dto);

        Assert.assertNotNull(result);
        Assert.assertNull(result.getId());

    }

}