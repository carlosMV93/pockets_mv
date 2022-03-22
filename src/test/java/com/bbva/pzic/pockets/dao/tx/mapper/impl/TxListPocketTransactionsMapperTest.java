package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPagination;
import com.bbva.pzic.pockets.business.dto.DTOOutPocketTransactions;
import com.bbva.pzic.pockets.business.dto.InputListPocketTransactions;
import com.bbva.pzic.pockets.canonic.Transaction;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44E1;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44P1;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44S1;
import com.bbva.pzic.pockets.dao.model.bq44.mock.FormatsBq44Mock;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class TxListPocketTransactionsMapperTest {

    private DummyMock dummyMock;
    private FormatsBq44Mock formatsBq44Mock;
    private TxListPocketTransactionsMapper txListPocketTransactionsMapper;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
        formatsBq44Mock = new FormatsBq44Mock();
        txListPocketTransactionsMapper = new TxListPocketTransactionsMapper();
    }

    @Test
    public void mapInTestFull() {
        InputListPocketTransactions dtoIn = dummyMock.getDTOInputListPocketTransactions();
        FormatoBQM44E1 formatoBQM44E1 = txListPocketTransactionsMapper.mapIn(dtoIn);

        assertNotNull(formatoBQM44E1);
        assertNotNull(formatoBQM44E1.getIdpoc());
        assertNotNull(formatoBQM44E1.getIdpagin());
        assertNotNull(formatoBQM44E1.getTampagi());

        assertEquals(dtoIn.getPocketId(), formatoBQM44E1.getIdpoc());
        assertEquals(dtoIn.getPagination().getPaginationKey(), formatoBQM44E1.getIdpagin());
        assertEquals(Integer.valueOf(dtoIn.getPagination().getPageSize().toString()), formatoBQM44E1.getTampagi());
    }

    @Test
    public void mapInTestNoData() {
        InputListPocketTransactions dtoIn = new InputListPocketTransactions();
        FormatoBQM44E1 formatoBQM44E1 = txListPocketTransactionsMapper.mapIn(dtoIn);

        assertNotNull(formatoBQM44E1);
        assertNull(formatoBQM44E1.getIdpoc());
        assertNull(formatoBQM44E1.getIdpagin());
        assertNull(formatoBQM44E1.getTampagi());
    }

    @Test
    public void mapInWithoutPocketId() {
        InputListPocketTransactions dtoIn = dummyMock.getDTOInputListPocketTransactions();
        dtoIn.setPocketId(null);
        FormatoBQM44E1 formatoBQM44E1 = txListPocketTransactionsMapper.mapIn(dtoIn);

        assertNotNull(formatoBQM44E1);
        assertNull(formatoBQM44E1.getIdpoc());
        assertNotNull(formatoBQM44E1.getIdpagin());
        assertNotNull(formatoBQM44E1.getTampagi());

        assertEquals(dtoIn.getPagination().getPaginationKey(), formatoBQM44E1.getIdpagin());
        assertEquals(Integer.valueOf(dtoIn.getPagination().getPageSize().toString()), formatoBQM44E1.getTampagi());
    }

    @Test
    public void mapInWithoutPaginationKey() {
        InputListPocketTransactions dtoIn = dummyMock.getDTOInputListPocketTransactions();
        dtoIn.getPagination().setPaginationKey(null);
        FormatoBQM44E1 formatoBQM44E1 = txListPocketTransactionsMapper.mapIn(dtoIn);

        assertNotNull(formatoBQM44E1);
        assertNotNull(formatoBQM44E1.getIdpoc());
        assertNull(formatoBQM44E1.getIdpagin());
        assertNotNull(formatoBQM44E1.getTampagi());

        assertEquals(dtoIn.getPocketId(), formatoBQM44E1.getIdpoc());
        assertEquals(Integer.valueOf(dtoIn.getPagination().getPageSize().toString()), formatoBQM44E1.getTampagi());
    }

    @Test
    public void mapInWithoutPageSize() {
        InputListPocketTransactions dtoIn = dummyMock.getDTOInputListPocketTransactions();
        dtoIn.getPagination().setPageSize(null);
        FormatoBQM44E1 formatoBQM44E1 = txListPocketTransactionsMapper.mapIn(dtoIn);

        assertNotNull(formatoBQM44E1);
        assertNotNull(formatoBQM44E1.getIdpoc());
        assertNotNull(formatoBQM44E1.getIdpagin());
        assertNull(formatoBQM44E1.getTampagi());

        assertEquals(dtoIn.getPocketId(), formatoBQM44E1.getIdpoc());
        assertEquals(dtoIn.getPagination().getPaginationKey(), formatoBQM44E1.getIdpagin());
    }

    @Test
    public void mapOutFormatoBQM44S1() throws IOException {
        List<FormatoBQM44S1> formatosBQM44S1 = formatsBq44Mock.getFormatoBQM44S1();
        FormatoBQM44S1 formatoBQM44S1 = formatosBQM44S1.get(0);
        DTOOutPocketTransactions dtoOut = new DTOOutPocketTransactions();
        dtoOut = txListPocketTransactionsMapper.mapOut(formatoBQM44S1, dtoOut);
        Transaction transaction = dtoOut.getData().get(0);

        /*
        Primera posicion
         */
        assertEquals(1, dtoOut.getData().size());
        assertNotNull(dtoOut);

        assertNotNull(transaction.getId());
        assertNotNull(transaction.getAdditionalInformation());
        assertNotNull(transaction.getCreationDate());
        assertNotNull(transaction.getOperationType().getId());
        assertNotNull(transaction.getOperationType().getName());
        assertNotNull(transaction.getAmount().getCurrency());
        assertNotNull(transaction.getAmount().getValue());

        assertEquals(formatoBQM44S1.getNumope(), transaction.getId());
        assertEquals(formatoBQM44S1.getDetmov(), transaction.getAdditionalInformation());
        assertEquals(formatoBQM44S1.getFechmov(), transaction.getCreationDate());
        assertEquals(formatoBQM44S1.getTipope(), transaction.getOperationType().getId());
        assertEquals(formatoBQM44S1.getDestipo(), transaction.getOperationType().getName());
        assertEquals(formatoBQM44S1.getMonmov(), transaction.getAmount().getValue());
        assertEquals(formatoBQM44S1.getMoneda(), transaction.getAmount().getCurrency());

        /*
        Segunda posicion
         */
        formatoBQM44S1 = formatosBQM44S1.get(1);
        dtoOut = txListPocketTransactionsMapper.mapOut(formatoBQM44S1, dtoOut);
        transaction = dtoOut.getData().get(1);

        assertEquals(2, dtoOut.getData().size());
        assertNotNull(dtoOut);

        assertNotNull(transaction.getId());
        assertNotNull(transaction.getAdditionalInformation());
        assertNotNull(transaction.getCreationDate());
        assertNotNull(transaction.getOperationType().getId());
        assertNotNull(transaction.getOperationType().getName());
        assertNotNull(transaction.getAmount().getCurrency());
        assertNotNull(transaction.getAmount().getValue());

        assertEquals(formatoBQM44S1.getNumope(), transaction.getId());
        assertEquals(formatoBQM44S1.getDetmov(), transaction.getAdditionalInformation());
        assertEquals(formatoBQM44S1.getFechmov(), transaction.getCreationDate());
        assertEquals(formatoBQM44S1.getTipope(), transaction.getOperationType().getId());
        assertEquals(formatoBQM44S1.getDestipo(), transaction.getOperationType().getName());
        assertEquals(formatoBQM44S1.getMonmov(), transaction.getAmount().getValue());
        assertEquals(formatoBQM44S1.getMoneda(), transaction.getAmount().getCurrency());
    }

    @Test
    public void mapOutFormatoBQM44S1EmptyTest() throws IOException {
        FormatoBQM44S1 formatoBQM44S1 = formatsBq44Mock.getFormatoBQM44S1().get(2);
        DTOOutPocketTransactions dtoOut = new DTOOutPocketTransactions();
        dtoOut = txListPocketTransactionsMapper.mapOut(formatoBQM44S1, dtoOut);
        Transaction transaction = dtoOut.getData().get(0);

        assertEquals(1, dtoOut.getData().size());
        assertNotNull(transaction);
        assertNull(transaction.getId());
        assertNull(transaction.getAdditionalInformation());
        assertNull(transaction.getCreationDate());
        assertNull(transaction.getOperationType().getId());
        assertNull(transaction.getOperationType().getName());
        assertNull(transaction.getAmount().getCurrency());
        assertNull(transaction.getAmount().getValue());
    }

    @Test
    public void mapOutFormatoBQM44P1() throws IOException {
        FormatoBQM44P1 formatoBQM44P1 = formatsBq44Mock.getFormatoBQM44P1();
        DTOOutPocketTransactions dtoOut = new DTOOutPocketTransactions();
        dtoOut = txListPocketTransactionsMapper.mapOut2(formatoBQM44P1, dtoOut);
        DTOIntPagination dtoIntPagination = dtoOut.getPagination();

        assertNotNull(dtoIntPagination);
        assertNotNull(dtoIntPagination.getPaginationKey());
        assertNotNull(dtoIntPagination.getPageSize());

        assertEquals(formatoBQM44P1.getIdpagin(), dtoIntPagination.getPaginationKey());
        assertEquals(formatoBQM44P1.getTampagi(), Integer.valueOf(dtoIntPagination.getPageSize().toString()));
    }
}