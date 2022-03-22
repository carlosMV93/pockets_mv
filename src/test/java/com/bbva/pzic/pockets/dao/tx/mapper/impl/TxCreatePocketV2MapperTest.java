package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76E1;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76S1;
import com.bbva.pzic.pockets.dao.model.bq76.mock.FormatsBq76Mock;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.routine.commons.utils.DateUtils;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.bbva.pzic.pockets.EntityMock.*;
import static org.junit.Assert.*;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxCreatePocketV2MapperTest {

    @InjectMocks
    private TxCreatePocketV2Mapper mapper;

    @Mock
    private AbstractCypherTool cypherTool;

    @Mock
    private Translator translator;

    private DummyMock dummyMock;

    @Before
    public void init() {
        dummyMock = new DummyMock();
    }

    @Test
    public void mapInFullIsScheduledTest() throws IOException {

        DTOIntPocket input = dummyMock.getCreatePocketV2DtoInt();
        input.setIsScheduled(Boolean.TRUE);

        FormatoBQM76E1 result = mapper.mapIn(input);
        assertNotNull(result.getNumcuen());
        assertNotNull(result.getTippock());
        assertNotNull(result.getNomcor());
        assertNotNull(result.getMoneda());
        assertNotNull(result.getFechpoc());
        assertNotNull(result.getFlagpoc());
        assertNotNull(result.getImpaut());
        assertNotNull(result.getMonimp());
        assertNotNull(result.getPeraut());
        assertNotNull(result.getDiaauto());

        assertEquals(result.getNumcuen(), input.getRelatedContract().getNumber());
        assertEquals(result.getTippock(), input.getCategory().getId());
        assertEquals(result.getNomcor(), input.getAlias());
        assertEquals(result.getMonpoc(), input.getGoalAmount().getAmount());
        assertEquals(result.getMoneda(), input.getGoalAmount().getCurrency());
        assertEquals(result.getFechpoc(), input.getExpirationDate());
        assertEquals(result.getFlagpoc(), "S");
        assertEquals(result.getImpaut(), input.getScheduledDeposit().getDepositAmount().getAmount());
        assertEquals(result.getMonimp(), input.getScheduledDeposit().getDepositAmount().getCurrency());
        assertEquals(result.getPeraut(), input.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(result.getDiaauto(), input.getScheduledDeposit().getPeriod().getDayOfMonth());

    }

    @Test
    public void mapInFullNotIsScheduledTest() throws IOException {
        DTOIntPocket input = dummyMock.getCreatePocketV2DtoInt();
        input.setIsScheduled(Boolean.FALSE);

        FormatoBQM76E1 result = mapper.mapIn(input);
        assertNotNull(result.getNumcuen());
        assertNotNull(result.getTippock());
        assertNotNull(result.getNomcor());
        assertNotNull(result.getMoneda());
        assertNotNull(result.getFechpoc());
        assertNotNull(result.getFlagpoc());
        assertNull(result.getImpaut());
        assertNull(result.getMonimp());
        assertNull(result.getPeraut());
        assertNull(result.getDiaauto());

        assertEquals(result.getNumcuen(), input.getRelatedContract().getNumber());
        assertEquals(result.getTippock(), input.getCategory().getId());
        assertEquals(result.getNomcor(), input.getAlias());
        assertEquals(result.getMonpoc(), input.getGoalAmount().getAmount());
        assertEquals(result.getMoneda(), input.getGoalAmount().getCurrency());
        assertEquals(result.getFechpoc(), input.getExpirationDate());
        assertEquals(result.getFlagpoc(), "N");

    }


    @Test
    public void mapOutFlagpocSFullTest() throws Exception {
        FormatoBQM76S1 input = FormatsBq76Mock.getInstance().getFormatoBQM76S1();
        Mockito.when(cypherTool.encrypt(input.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET))
                .thenReturn(POCKET_ID_CYPHER);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.period.frequencyId", "M")).thenReturn(ENUM_OUT_MONTHLY);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.status.id", "A")).thenReturn(ENUM_STATUS_ID);

        input.setFlagpoc("S");
        int year = 2018;
        int month = Calendar.MARCH;
        int day = 28;
        GregorianCalendar dateCreation = new GregorianCalendar(year, month, day);
        input.setFechcre(dateCreation.getTime());

        Integer dayOfMonth = Integer.valueOf(input.getDiaauto());

        Pocket result = mapper.mapOut(input);
        assertNotNull(result.getId());
        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());
        assertNotNull(result.getCreationDate());
        assertNotNull(result.getStatus());
        assertNotNull(result.getRelatedContract());
        assertNotNull(result.getRelatedContract().getId());

        assertEquals(result.getId(), POCKET_ID_CYPHER);
        assertEquals(result.getCategory().getId(), input.getTippock());
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertTrue(result.getIsScheduled());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getAmount(), input.getImpaut());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getCurrency(), input.getMonimp());
        assertEquals(result.getScheduledDeposit().getPeriod().getFrequency().getId(), ENUM_OUT_MONTHLY);
        assertEquals(result.getScheduledDeposit().getPeriod().getDayOfMonth(), dayOfMonth);
        assertEquals(DateUtils.toDateTime(input.getFechcre(), input.getHoraope()), result.getCreationDate());
        assertEquals(result.getStatus(), ENUM_STATUS_ID);
        assertEquals(result.getRelatedContract().getId(), input.getNumcuen());
    }


    @Test
    public void mapOutFlagpocNFullTest() throws Exception {
        FormatoBQM76S1 input = FormatsBq76Mock.getInstance().getFormatoBQM76S1();
        Mockito.when(cypherTool.encrypt(input.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET)).thenReturn(POCKET_ID_CYPHER);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.status.id", "C")).thenReturn(ENUM_STATUS_ID_CLOSED);

        input.setFlagpoc("N");
        input.setEstado("C");

        int year = 2018;
        int month = Calendar.MARCH;
        int day = 28;
        GregorianCalendar dateCreation = new GregorianCalendar(year, month, day);
        input.setFechcre(dateCreation.getTime());

        Pocket result = mapper.mapOut(input);
        assertNotNull(result.getId());
        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getIsScheduled());
        assertNull(result.getScheduledDeposit());
        assertNotNull(result.getCreationDate());
        assertNotNull(result.getStatus());
        assertNotNull(result.getRelatedContract());
        assertNotNull(result.getRelatedContract().getId());

        assertEquals(result.getId(), POCKET_ID_CYPHER);
        assertEquals(result.getCategory().getId(), input.getTippock());
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertFalse(result.getIsScheduled());
        assertEquals(DateUtils.toDateTime(input.getFechcre(), input.getHoraope()), result.getCreationDate());
        assertEquals(result.getStatus(), ENUM_STATUS_ID_CLOSED);
        assertEquals(result.getRelatedContract().getId(), input.getNumcuen());
    }

}
