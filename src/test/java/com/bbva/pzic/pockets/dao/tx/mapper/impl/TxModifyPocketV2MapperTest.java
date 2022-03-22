package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPocketV2;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81E1;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81S1;
import com.bbva.pzic.pockets.dao.model.bq81.mock.FormatsBq81Mock;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static com.bbva.pzic.pockets.EntityMock.*;
import static org.junit.Assert.*;

/**
 * Created on 22/10/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxModifyPocketV2MapperTest {

    @InjectMocks
    private TxModifyPocketV2Mapper mapper;

    @Mock
    private Translator translator;

    private EntityMock entityMock = EntityMock.getInstance();

    @Test
    public void mapInFullIsScheduledTest() throws IOException {
        DTOIntPocketV2 input = entityMock.getModifyPocketV2DtoInt();
        input.setIsScheduled(Boolean.TRUE);

        FormatoBQM81E1 result = mapper.mapIn(input);
        assertNotNull(result.getIdpoc());
        assertNotNull(result.getNomcor());
        assertNotNull(result.getMonpoc());
        assertNotNull(result.getMoneda());
        assertNotNull(result.getFechpoc());
        assertNotNull(result.getPripoc());
        assertNotNull(result.getTippoc());
        assertNotNull(result.getFlagpoc());
        assertNotNull(result.getImpaut());
        assertNotNull(result.getMonimp());
        assertNotNull(result.getPeraut());
        assertNotNull(result.getDiaauto());

        assertEquals(result.getIdpoc(), input.getId());
        assertEquals(result.getNomcor(), input.getAlias());
        assertEquals(result.getMonpoc(), input.getGoalAmount().getAmount());
        assertEquals(result.getMoneda(), input.getGoalAmount().getCurrency());
        assertEquals(result.getFechpoc(), input.getExpirationDate());
        assertEquals(result.getPripoc(), String.valueOf(input.getPriority()));
        assertEquals(result.getTippoc(), input.getCategory().getId());
        assertEquals(result.getFlagpoc(), "S");
        assertEquals(result.getImpaut(), input.getScheduledDeposit().getDepositAmount().getAmount());
        assertEquals(result.getMonimp(), input.getScheduledDeposit().getDepositAmount().getCurrency());
        assertEquals(result.getPeraut(), input.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(result.getDiaauto(), input.getScheduledDeposit().getPeriod().getDayOfMonth());
    }

    @Test
    public void mapInFullNotIsScheduledTest() throws IOException {
        DTOIntPocketV2 input = entityMock.getModifyPocketV2DtoInt();
        input.setIsScheduled(Boolean.FALSE);

        FormatoBQM81E1 result = mapper.mapIn(input);
        assertNotNull(result.getIdpoc());
        assertNotNull(result.getNomcor());
        assertNotNull(result.getMonpoc());
        assertNotNull(result.getMoneda());
        assertNotNull(result.getFechpoc());
        assertNotNull(result.getPripoc());
        assertNotNull(result.getTippoc());
        assertNotNull(result.getFlagpoc());
        assertNull(result.getImpaut());
        assertNull(result.getMonimp());
        assertNull(result.getPeraut());
        assertNull(result.getDiaauto());

        assertEquals(result.getIdpoc(), input.getId());
        assertEquals(result.getNomcor(), input.getAlias());
        assertEquals(result.getMonpoc(), input.getGoalAmount().getAmount());
        assertEquals(result.getMoneda(), input.getGoalAmount().getCurrency());
        assertEquals(result.getFechpoc(), input.getExpirationDate());
        assertEquals(result.getPripoc(), String.valueOf(input.getPriority()));
        assertEquals(result.getTippoc(), input.getCategory().getId());
        assertEquals(result.getFlagpoc(), "N");
    }

    @Test
    public void mapInFullIsScheduledNullTest() throws IOException {

        DTOIntPocketV2 input = entityMock.getModifyPocketV2DtoInt();
        input.setIsScheduled(null);

        FormatoBQM81E1 result = mapper.mapIn(input);
        assertNotNull(result.getIdpoc());
        assertNotNull(result.getNomcor());
        assertNotNull(result.getMonpoc());
        assertNotNull(result.getMoneda());
        assertNotNull(result.getFechpoc());
        assertNotNull(result.getPripoc());
        assertNotNull(result.getTippoc());
        assertNull(result.getFlagpoc());
        assertNull(result.getImpaut());
        assertNull(result.getMonimp());
        assertNull(result.getPeraut());
        assertNull(result.getDiaauto());

        assertEquals(result.getIdpoc(), input.getId());
        assertEquals(result.getNomcor(), input.getAlias());
        assertEquals(result.getMonpoc(), input.getGoalAmount().getAmount());
        assertEquals(result.getMoneda(), input.getGoalAmount().getCurrency());
        assertEquals(result.getFechpoc(), input.getExpirationDate());
        assertEquals(result.getPripoc(), String.valueOf(input.getPriority()));
        assertEquals(result.getTippoc(), input.getCategory().getId());
    }

    @Test
    public void mapOutFlagpocSFullTest() throws IOException {
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.period.frequencyId", "M")).thenReturn(ENUM_OUT_MONTHLY);
        FormatoBQM81S1 input = FormatsBq81Mock.getInstance().getFormatoBQM81S1();
        Integer dayOfMonth = input.getDiaauto();

        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.status.id", "P")).thenReturn(ENUM_STATUS_ACTIVE);

        List<Pocket> listresult = mapper.mapOut(input);
        Pocket result = listresult.get(0);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());
        assertNotNull(result.getStatus());

        assertEquals(result.getId(), input.getIdpoc());
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertEquals(result.getPriority(), input.getPripoc());
        assertEquals(result.getCategory().getId(), input.getTippoc());
        assertTrue(result.getIsScheduled());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getAmount(), input.getImpaut());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getCurrency(), input.getMonimp());
        assertEquals(result.getScheduledDeposit().getPeriod().getFrequency().getId(), ENUM_OUT_MONTHLY);
        assertEquals(result.getScheduledDeposit().getPeriod().getDayOfMonth(), dayOfMonth);
        assertEquals(ENUM_STATUS_ACTIVE, result.getStatus());
    }

    @Test
    public void mapOutFlagpocNFullTest() throws IOException {
        FormatoBQM81S1 input = FormatsBq81Mock.getInstance().getFormatoBQM81S1();
        input.setFlagpoc("N");
        input.setEstado("Q");
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.status.id", "Q")).thenReturn(ENUM_STATUS_INACTIVE);

        List<Pocket> listresult = mapper.mapOut(input);
        Pocket result = listresult.get(0);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getIsScheduled());
        assertNull(result.getScheduledDeposit());
        assertNotNull(result.getStatus());

        assertEquals(result.getId(), input.getIdpoc());
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertEquals(result.getPriority(), input.getPripoc());
        assertEquals(result.getCategory().getId(), input.getTippoc());
        assertFalse(result.getIsScheduled());
        assertEquals(ENUM_STATUS_INACTIVE, result.getStatus());
    }

    @Test
    public void mapOutEstadoNullTest() throws IOException {
        FormatoBQM81S1 input = FormatsBq81Mock.getInstance().getFormatoBQM81S1();
        input.setFlagpoc("N");
        input.setEstado(null);
        List<Pocket> listresult = mapper.mapOut(input);
        Pocket result = listresult.get(0);

        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getIsScheduled());
        assertNull(result.getScheduledDeposit());
        assertNull(result.getStatus());

        assertEquals(result.getId(), input.getIdpoc());
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertEquals(result.getPriority(), input.getPripoc());
        assertEquals(result.getCategory().getId(), input.getTippoc());
        assertFalse(result.getIsScheduled());
    }

    @Test
    public void mapOutFlagpocNullTest() throws IOException {
        FormatoBQM81S1 input = FormatsBq81Mock.getInstance().getFormatoBQM81S1();
        input.setFlagpoc(null);
        List<Pocket> listresult = mapper.mapOut(input);
        Pocket result = listresult.get(0);

        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertNull(result.getIsScheduled());
        assertNull(result.getScheduledDeposit());

        assertEquals(result.getId(), input.getIdpoc());
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertEquals(result.getPriority(), input.getPripoc());
        assertEquals(result.getCategory().getId(), input.getTippoc());
    }

}
