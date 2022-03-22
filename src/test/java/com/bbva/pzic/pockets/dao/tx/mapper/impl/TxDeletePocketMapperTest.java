package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.dao.model.bq42.FormatoBQM42E1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxDeletePocketMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class TxDeletePocketMapperTest {

    private ITxDeletePocketMapper mapper;
    private DummyMock mock;

    @Before
    public void setUp() {
        mapper = new TxDeletePocketMapper();
        mock = new DummyMock();
    }

    @Test
    public void mapInTest() throws IOException {
        DTOIntPocket dto = mock.getModifyPocketDtoInt();
        FormatoBQM42E1 result = mapper.mapIn(dto);

        assertNotNull(result.getIdpoc());
        assertEquals(dto.getId(), result.getIdpoc());
    }
}