package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPocketsData;
import com.bbva.pzic.pockets.business.dto.InputListPocket;
import com.bbva.pzic.pockets.canonic.PocketsV00;
import com.bbva.pzic.pockets.facade.v00.mapper.IListPocketsMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.bbva.pzic.pockets.DummyMock.*;
import static org.junit.Assert.*;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class ListPocketsMapperTest {

    private IListPocketsMapper mapper;
    private DummyMock dummyMock;

    @Before
    public void setUp() {
        mapper = new ListPocketsMapper();
        dummyMock = new DummyMock();
    }

    @Test
    public void mapInFull() {
        InputListPocket result = mapper.mapIn(ACCOUNT_POCKET_NUMBER, STATUS_ID, PAGINATION_KEY, PAGE_SIZE);

        assertNotNull(result);
        assertEquals(ACCOUNT_POCKET_NUMBER, result.getAccountPocketNumber());
        assertEquals(STATUS_ID, result.getStatusId());


        assertEquals(PAGINATION_KEY, result.getPaginationKey());
        assertEquals(PAGE_SIZE, result.getPageSize());
    }

    @Test
    public void mapInWithoutAccountPocketNumber() {
        InputListPocket result = mapper.mapIn(null, STATUS_ID, PAGINATION_KEY, PAGE_SIZE);

        assertNotNull(result);
        assertNull(result.getAccountPocketNumber());
        assertEquals(STATUS_ID, result.getStatusId());


        assertEquals(PAGINATION_KEY, result.getPaginationKey());
        assertEquals(PAGE_SIZE, result.getPageSize());
    }

    @Test
    public void mapInWithoutStatusId() {
        InputListPocket result = mapper.mapIn(ACCOUNT_POCKET_NUMBER, null, PAGINATION_KEY, PAGE_SIZE);

        assertNotNull(result);
        assertEquals(ACCOUNT_POCKET_NUMBER, result.getAccountPocketNumber());
        assertNull(result.getStatusId());


        assertEquals(PAGINATION_KEY, result.getPaginationKey());
        assertEquals(PAGE_SIZE, result.getPageSize());
    }

    @Test
    public void mapInWithoutPaginationKey() {
        InputListPocket result = mapper.mapIn(ACCOUNT_POCKET_NUMBER, STATUS_ID, null, PAGE_SIZE);

        assertNotNull(result);
        assertEquals(ACCOUNT_POCKET_NUMBER, result.getAccountPocketNumber());
        assertEquals(STATUS_ID, result.getStatusId());


        assertNull(result.getPaginationKey());
        assertEquals(PAGE_SIZE, result.getPageSize());
    }

    @Test
    public void mapInWithoutPaginationSize() {
        InputListPocket result = mapper.mapIn(ACCOUNT_POCKET_NUMBER, STATUS_ID, PAGINATION_KEY, null);

        assertNotNull(result);
        assertEquals(ACCOUNT_POCKET_NUMBER, result.getAccountPocketNumber());
        assertEquals(STATUS_ID, result.getStatusId());


        assertEquals(PAGINATION_KEY, result.getPaginationKey());
        assertNull(result.getPageSize());
    }

    @Test
    public void mapInWithoutPaginationKeyAndSize() {
        InputListPocket result = mapper.mapIn(ACCOUNT_POCKET_NUMBER, STATUS_ID, null, null);

        assertNotNull(result);
        assertEquals(ACCOUNT_POCKET_NUMBER, result.getAccountPocketNumber());
        assertEquals(STATUS_ID, result.getStatusId());


        assertNull(result.getPaginationKey());
        assertNull(result.getPageSize());
    }

    @Test
    public void mapInWithoutParameters() {
        InputListPocket result = mapper.mapIn(null, null, null, null);

        assertNotNull(result);
        assertNull(result.getAccountPocketNumber());
        assertNull(result.getStatusId());


        assertNull(result.getPaginationKey());
        assertNull(result.getPageSize());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        DTOIntPocketsData dtoIntTransactionData = dummyMock.getDTOIntPocketsData();
        PocketsV00 result = mapper.mapOut(dtoIntTransactionData);

        assertNotNull(result);
        assertNotNull(result.getData());
        assertEquals(3, result.getData().size());
        assertNull(result.getPagination());
    }

    @Test
    public void mapOutDtoEmptyTest() {
        DTOIntPocketsData dtoIntTransactionData = new DTOIntPocketsData();
        PocketsV00 result = mapper.mapOut(dtoIntTransactionData);

        assertNull(result);
    }
}