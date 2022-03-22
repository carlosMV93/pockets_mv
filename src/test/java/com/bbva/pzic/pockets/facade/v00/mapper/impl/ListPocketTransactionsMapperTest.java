package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOOutPocketTransactions;
import com.bbva.pzic.pockets.business.dto.InputListPocketTransactions;
import com.bbva.pzic.pockets.canonic.Transaction;
import com.bbva.pzic.pockets.canonic.Transactions;
import com.bbva.pzic.pockets.facade.v00.mapper.IListPocketTransactionsMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static com.bbva.pzic.pockets.DummyMock.*;
import static org.junit.Assert.*;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class ListPocketTransactionsMapperTest {

    private IListPocketTransactionsMapper mapper;

    private DummyMock mock;

    @Before
    public void setUp() {
        mapper = new ListPocketTransactionsMapper();
        mock = new DummyMock();
    }

    @Test
    public void mapInListPocketTransactionsTest() {
        InputListPocketTransactions dtoIn = mapper.mapIn(POCKET_ID, PAGINATION_KEY, Long.valueOf(PAGE_SIZE.toString()));

        assertNotNull(dtoIn);
        assertNotNull(dtoIn.getPocketId());
        assertNotNull(dtoIn.getPagination().getPaginationKey());
        assertNotNull(dtoIn.getPagination().getPageSize());

        assertEquals(POCKET_ID, dtoIn.getPocketId());
        assertEquals(PAGINATION_KEY, dtoIn.getPagination().getPaginationKey());
        assertEquals(Long.valueOf(PAGE_SIZE.toString()), dtoIn.getPagination().getPageSize());
    }

    @Test
    public void mapInListPocketTransactionsWithoutPocketIdTest() {
        InputListPocketTransactions dtoIn = mapper.mapIn(null, PAGINATION_KEY, Long.valueOf(PAGE_SIZE.toString()));

        assertNotNull(dtoIn);
        assertNull(dtoIn.getPocketId());
        assertNotNull(dtoIn.getPagination().getPaginationKey());
        assertNotNull(dtoIn.getPagination().getPageSize());

        assertEquals(PAGINATION_KEY, dtoIn.getPagination().getPaginationKey());
        assertEquals(Long.valueOf(PAGE_SIZE.toString()), dtoIn.getPagination().getPageSize());
    }

    @Test
    public void mapInListPocketTransactionsWithoutPaginationKeyTest() {
        InputListPocketTransactions dtoIn = mapper.mapIn(POCKET_ID, null, Long.valueOf(PAGE_SIZE.toString()));

        assertNotNull(dtoIn);
        assertNotNull(dtoIn.getPocketId());
        assertNull(dtoIn.getPagination().getPaginationKey());
        assertNotNull(dtoIn.getPagination().getPageSize());

        assertEquals(POCKET_ID, dtoIn.getPocketId());
        assertEquals(Long.valueOf(PAGE_SIZE.toString()), dtoIn.getPagination().getPageSize());
    }

    @Test
    public void mapInListPocketTransactionsWithoutPageSizeTest() {
        InputListPocketTransactions dtoIn = mapper.mapIn(POCKET_ID, PAGINATION_KEY, null);

        assertNotNull(dtoIn);
        assertNotNull(dtoIn.getPocketId());
        assertNotNull(dtoIn.getPagination().getPaginationKey());
        assertNull(dtoIn.getPagination().getPageSize());

        assertEquals(POCKET_ID, dtoIn.getPocketId());
        assertEquals(PAGINATION_KEY, dtoIn.getPagination().getPaginationKey());
    }

    @Test
    public void mapOutListPocketTransactionsFullTest() throws IOException {
        DTOOutPocketTransactions dtoOut = mock.getDTOOutListPocketTransactions();
        Transactions transactions = mapper.mapOut(dtoOut);

        assertNotNull(transactions);
        assertNotNull(transactions.getData());

        assertEquals(dtoOut.getData(), transactions.getData());
    }

    @Test
    public void mapOutListPocketTransactionsNull() {
        Transactions transactions = mapper.mapOut(null);

        assertNull(transactions);
    }

    @Test
    public void mapOutListPocketTransactionsInitializedTest() {
        Transactions transactions = mapper.mapOut(new DTOOutPocketTransactions());

        assertNull(transactions);
    }

    @Test
    public void mapOutListPocketTransactionsEmptyTest() {
        DTOOutPocketTransactions dtoOut = new DTOOutPocketTransactions();
        dtoOut.setData(new ArrayList<Transaction>());
        Transactions transactions = mapper.mapOut(dtoOut);

        assertNull(transactions);
    }
}