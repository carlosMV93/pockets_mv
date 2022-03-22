package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntAutomaticAmount;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.dao.model.bq43.FormatoBQM43E1;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxModifyPocketMapperTest {

    @InjectMocks
    private TxModifyPocketMapper txModifyPocketMapper;

    @Mock
    private EnumMapper enumMapper;

    private DummyMock mock = new DummyMock();

    @Before
    public void init() {
        Mockito.when(enumMapper.getBackendValue(
                "pocket.automaticAmount.period.id", "MONTHLY")).thenReturn("M");
    }

    @Test
    public void testMapInFullTest() throws IOException {
        DTOIntPocket dtoInt = mock.getModifyPocketDtoInt();
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();
        FormatoBQM43E1 formatoBQM43E1 = txModifyPocketMapper.mapIn(dtoInt);

        assertNotNull(formatoBQM43E1);
        assertEquals(dtoInt.getId(), formatoBQM43E1.getIdpoc());
        assertEquals(dtoInt.getName(), formatoBQM43E1.getNompoc());
        assertEquals(dtoInt.getShortName(), formatoBQM43E1.getNomcor());
        assertEquals(dtoInt.getGoalAmount().getValue(), formatoBQM43E1.getMonpoc());
        assertEquals(dtoInt.getGoalAmount().getCurrency(), formatoBQM43E1.getMoneda());
        assertEquals(dtoInt.getGoalDate(), formatoBQM43E1.getFechpoc());
        assertEquals(dtoInt.getPriority(), formatoBQM43E1.getPripoc());
        assertEquals(dtoInt.getPocketType().getId(), formatoBQM43E1.getTippoc());
        assertEquals("S", formatoBQM43E1.getFlagpoc());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(dtoIntAutomaticAmount.getValue(), formatoBQM43E1.getImpaut());
        assertEquals(dtoIntAutomaticAmount.getCurrency(), formatoBQM43E1.getMonimp());
        assertEquals("M", formatoBQM43E1.getPeraut());
        assertEquals(dtoIntAutomaticAmount.getDayMonth(), formatoBQM43E1.getDiaauto());
    }

    @Test
    public void testMapInNullTest() {
        DTOIntPocket dtoInt = new DTOIntPocket();
        FormatoBQM43E1 formatoBQM43E1 = txModifyPocketMapper.mapIn(dtoInt);

        assertNull(formatoBQM43E1.getIdpoc());
        assertNull(formatoBQM43E1.getNompoc());
        assertNull(formatoBQM43E1.getNomcor());
        assertNull(formatoBQM43E1.getMonpoc());
        assertNull(formatoBQM43E1.getMoneda());
        assertNull(formatoBQM43E1.getFechpoc());
        assertNull(formatoBQM43E1.getPripoc());
        assertNull(formatoBQM43E1.getTippoc());
        assertNull(formatoBQM43E1.getImpaut());
        assertNull(formatoBQM43E1.getMonimp());
        assertNull(formatoBQM43E1.getPeraut());
        assertNull(formatoBQM43E1.getDiaauto());
    }

}