package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.facade.v00.mapper.IDeletePocketMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class DeletePocketMapperTest {

    private IDeletePocketMapper mapper;

    @Before
    public void setUp() {
        mapper = new DeletePocketMapper();
    }

    @Test
    public void mapInTest() {
        DTOIntPocket result = mapper.mapIn(DummyMock.POCKET_ID);

        assertNotNull(result.getId());
        assertEquals(DummyMock.POCKET_ID, result.getId());
    }
}