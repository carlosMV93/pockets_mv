package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.facade.v00.mapper.IGetPocketMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class GetPocketMapperTest {

    private IGetPocketMapper getPocketMapper;

    @Before
    public void setUp() {
        getPocketMapper = new GetPocketMapper();
    }

    @Test
    public void mapIn() {
        PathParamPocketId result = getPocketMapper.mapIn(DummyMock.POCKET_ID);

        assertNotNull(result.getPocketId());
        assertEquals(DummyMock.POCKET_ID, result.getPocketId());
    }
}