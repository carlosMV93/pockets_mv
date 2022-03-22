package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputListPockets;
import com.bbva.pzic.pockets.canonic.Pockets;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.bbva.pzic.pockets.EntityMock.ENUM_IN_STATUS_ID;
import static com.bbva.pzic.pockets.EntityMock.ENUM_OUT_STATUS_ID;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ListPocketsMapperTest {

    @InjectMocks
    private ListPocketsMapper mapper;
    @Mock
    private Translator translator;

    @Before
    public void setUp() {
        Mockito.when(translator.translateFrontendEnumValueStrictly("pocket.statusId", ENUM_IN_STATUS_ID)).thenReturn(ENUM_OUT_STATUS_ID);
    }

    @Test
    public void mapInFullTest() {
        InputListPockets result = mapper.mapIn(
                EntityMock.RELATED_CONTRACT_NUMBER, ENUM_IN_STATUS_ID, EntityMock.PAGINATION_KEY, EntityMock.PAGE_SIZE);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getRelatedContractNumber());
        Assert.assertNotNull(result.getStatusId());
        Assert.assertNotNull(result.getPagination().getPageSize());
        Assert.assertNotNull(result.getPagination().getPaginationKey());
        Assert.assertEquals(EntityMock.RELATED_CONTRACT_NUMBER, result.getRelatedContractNumber());
        Assert.assertEquals(ENUM_OUT_STATUS_ID, result.getStatusId());
        Assert.assertEquals(EntityMock.PAGINATION_KEY, result.getPagination().getPaginationKey());
        Assert.assertEquals(EntityMock.PAGE_SIZE, result.getPagination().getPageSize());
    }

    @Test
    public void mapInEmptyTest() {
        InputListPockets result = mapper.mapIn(null, null, null, null);

        Assert.assertNotNull(result);
        Assert.assertNull(result.getRelatedContractNumber());
        Assert.assertNull(result.getStatusId());
        Assert.assertNull(result.getPagination().getPageSize());
        Assert.assertNull(result.getPagination().getPaginationKey());
    }

    @Test
    public void mapOutFullTest() {
        Pockets result = mapper.mapOut(EntityMock.getInstance().getDTOIntPockets());
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        Pockets result = mapper.mapOut(null);
        Assert.assertNull(result);
    }
}