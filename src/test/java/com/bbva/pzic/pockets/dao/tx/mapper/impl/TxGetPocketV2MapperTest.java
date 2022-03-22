package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77E1;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77S1;
import com.bbva.pzic.pockets.dao.model.bq77.mock.FormatsBq77Mock;
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
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.bbva.pzic.pockets.EntityMock.*;
import static org.junit.Assert.*;

/**
 * Created on 18/10/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxGetPocketV2MapperTest {

    @InjectMocks
    private TxGetPocketV2Mapper mapper;

    @Mock
    private AbstractCypherTool cypherTool;

    @Mock
    private Translator translator;

    private DummyMock dummyMock = new DummyMock();

    @Before
    public void init() {
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.statusId", "A")).thenReturn(ENUM_STATUS_ID);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.period.frequencyId", "Q")).thenReturn(ENUM_PERIOD_FREQUENCY_ID_FORTNIGHTLY);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.period.frequencyId", "M")).thenReturn(ENUM_PERIOD_FREQUENCY_ID_MONTHLY);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.period.frequencyId", "B")).thenReturn(ENUM_PERIOD_FREQUENCY_ID_BIMONTHLY);
    }

    @Test
    public void mapInFullTest() {
        FormatoBQM77E1 result = mapper.mapIn(dummyMock.getPathParamPocketId());
        assertNotNull(result);
        assertNotNull(result.getIdpoc());
    }

    @Test
    public void mapOutFullTest() throws IOException, ParseException {
        FormatoBQM77S1 input = FormatsBq77Mock.getInstance().getFormatoBQM77S1();

        int year = 2016;
        int month = Calendar.OCTOBER;
        int day = 30;
        input.setFechcre(new GregorianCalendar(year, month, day).getTime());

        Mockito.when(cypherTool.encrypt(input.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_GET_POCKET))
                .thenReturn(POCKET_ID_CYPHER);

        Integer dayOfMonth = Integer.valueOf(input.getDiaauto());
        Pocket result = mapper.mapOut(input);

        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getBalances());

        assertEquals(3, result.getBalances().size());

        assertNotNull(result.getBalances().get(0).getId());
        assertNotNull(result.getBalances().get(0).getMode());
        assertNotNull(result.getBalances().get(0).getCurrency());
        assertNotNull(result.getBalances().get(0).getAmount());

        assertNotNull(result.getBalances().get(1).getId());
        assertNotNull(result.getBalances().get(1).getMode());
        assertNotNull(result.getBalances().get(1).getMode());
        assertNotNull(result.getBalances().get(1).getCurrency());

        assertNotNull(result.getBalances().get(2).getId());
        assertNotNull(result.getBalances().get(2).getMode());
        assertNotNull(result.getBalances().get(2).getMode());
        assertNotNull(result.getBalances().get(2).getCurrency());

        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getCategory().getName());
        assertNotNull(result.getStatus());
        assertNotNull(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit());
        assertNotNull(result.getScheduledDeposit().getDepositAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getName());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());
        assertNotNull(result.getRelatedContract().getNumber());
        assertNotNull(result.getCreationDate());
        assertNotNull(result.getIsSavingRounding());
        assertNotNull(result.getTotalDays());
        assertNotNull(result.getRemainingDays());

        assertEquals(POCKET_ID_CYPHER, result.getId());
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertEquals(result.getPriority(), input.getPripoc());

        assertEquals(result.getBalances().get(0).getId(), input.getIdpresp());
        assertEquals(result.getBalances().get(0).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(0).getAmount(), input.getAhopoc());
        assertEquals(result.getBalances().get(0).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(1).getId(), input.getIdinter());
        assertEquals(result.getBalances().get(1).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(1).getAmount(), input.getImpinte());
        assertEquals(result.getBalances().get(1).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(2).getId(), input.getIdtpre());
        assertEquals(result.getBalances().get(2).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(2).getAmount(), input.getMtopock());
        assertEquals(result.getBalances().get(2).getCurrency(), input.getMonaho());

        assertEquals(result.getCategory().getId(), input.getTippoc());
        assertEquals(result.getCategory().getName(), input.getDestipo());
        assertEquals(ENUM_STATUS_ID, result.getStatus());
        assertTrue(result.getIsScheduled());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getAmount(), input.getImpaut());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getCurrency(), input.getMonimp());
        assertEquals(ENUM_PERIOD_FREQUENCY_ID_FORTNIGHTLY, result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(result.getScheduledDeposit().getPeriod().getFrequency().getName(), input.getDesperi());
        assertEquals(result.getScheduledDeposit().getPeriod().getDayOfMonth(), dayOfMonth);
        assertEquals(result.getRelatedContract().getNumber(), input.getNumcuen());
        assertEquals(DateUtils.toDateTime(input.getFechcre(), input.getHoraope()), result.getCreationDate());
        assertTrue(result.getIsSavingRounding());
        assertEquals(result.getTotalDays(), input.getDiastot());
        assertEquals(result.getRemainingDays(), input.getDiasres());
    }

    @Test
    public void mapOutFlapocNFlaaxrNTest() throws IOException, ParseException {
        FormatoBQM77S1 input = FormatsBq77Mock.getInstance().getFormatoBQM77S1();
        Mockito.when(cypherTool.encrypt(input.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_GET_POCKET))
                .thenReturn(POCKET_ID_CYPHER);
        input.setFlapoc("N");
        input.setFlaaxr("N");

        int year = 2016;
        int month = Calendar.OCTOBER;
        int day = 30;
        input.setFechcre(new GregorianCalendar(year, month, day).getTime());

        Pocket result = mapper.mapOut(input);

        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());

        assertNotNull(result.getBalances());
        assertNull(result.getScheduledDeposit());

        assertEquals(3, result.getBalances().size());

        assertEquals(result.getBalances().get(0).getId(), input.getIdpresp());
        assertEquals(result.getBalances().get(0).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(0).getAmount(), input.getAhopoc());
        assertEquals(result.getBalances().get(0).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(1).getId(), input.getIdinter());
        assertEquals(result.getBalances().get(1).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(1).getAmount(), input.getImpinte());
        assertEquals(result.getBalances().get(1).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(2).getId(), input.getIdtpre());
        assertEquals(result.getBalances().get(2).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(2).getAmount(), input.getMtopock());
        assertEquals(result.getBalances().get(2).getCurrency(), input.getMonaho());

        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getCategory().getName());
        assertNotNull(result.getStatus());
        assertNotNull(result.getIsScheduled());
        assertNull(result.getScheduledDeposit());
        assertNotNull(result.getRelatedContract().getNumber());
        assertNotNull(result.getCreationDate());
        assertNotNull(result.getIsSavingRounding());

        assertNotNull(result.getTotalDays());
        assertNotNull(result.getRemainingDays());

        assertEquals(POCKET_ID_CYPHER, result.getId());
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertEquals(result.getPriority(), input.getPripoc());

        assertEquals(result.getBalances().get(0).getId(), input.getIdpresp());
        assertEquals(result.getBalances().get(0).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(0).getAmount(), input.getAhopoc());
        assertEquals(result.getBalances().get(0).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(1).getId(), input.getIdinter());
        assertEquals(result.getBalances().get(1).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(1).getAmount(), input.getImpinte());
        assertEquals(result.getBalances().get(1).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(2).getId(), input.getIdtpre());
        assertEquals(result.getBalances().get(2).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(2).getAmount(), input.getMtopock());
        assertEquals(result.getBalances().get(2).getCurrency(), input.getMonaho());

        assertEquals(result.getCategory().getId(), input.getTippoc());
        assertEquals(result.getCategory().getName(), input.getDestipo());
        assertEquals(ENUM_STATUS_ID, result.getStatus());
        assertFalse(result.getIsScheduled());
        assertEquals(result.getRelatedContract().getNumber(), input.getNumcuen());
        assertEquals(DateUtils.toDateTime(input.getFechcre(), input.getHoraope()), result.getCreationDate());
        assertFalse(result.getIsSavingRounding());

        assertEquals(result.getTotalDays(), input.getDiastot());
        assertEquals(result.getRemainingDays(), input.getDiasres());
    }

    @Test
    public void mapOutTotalDaysOptionalTest() throws IOException, ParseException {
        FormatoBQM77S1 input = FormatsBq77Mock.getInstance().getFormatoBQM77S1();
        Mockito.when(cypherTool.encrypt(input.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_GET_POCKET))
                .thenReturn(POCKET_ID_CYPHER);

        Integer dayOfMonth = Integer.valueOf(input.getDiaauto());
        input.setDiastot(null);
        input.setPeraut("M");

        int year = 2016;
        int month = Calendar.OCTOBER;
        int day = 30;
        GregorianCalendar dateCreation = new GregorianCalendar(year, month, day);
        input.setFechcre(dateCreation.getTime());

        Pocket result = mapper.mapOut(input);

        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getBalances());

        assertEquals(3, result.getBalances().size());

        assertEquals(result.getBalances().get(0).getId(), input.getIdpresp());
        assertEquals(result.getBalances().get(0).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(0).getAmount(), input.getAhopoc());
        assertEquals(result.getBalances().get(0).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(1).getId(), input.getIdinter());
        assertEquals(result.getBalances().get(1).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(1).getAmount(), input.getImpinte());
        assertEquals(result.getBalances().get(1).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(2).getId(), input.getIdtpre());
        assertEquals(result.getBalances().get(2).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(2).getAmount(), input.getMtopock());
        assertEquals(result.getBalances().get(2).getCurrency(), input.getMonaho());

        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getCategory().getName());
        assertNotNull(result.getStatus());
        assertNotNull(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit());
        assertNotNull(result.getScheduledDeposit().getDepositAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getName());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());
        assertNotNull(result.getRelatedContract().getNumber());
        assertNotNull(result.getCreationDate());
        assertNotNull(result.getIsSavingRounding());
        assertNull(result.getTotalDays());
        assertNotNull(result.getRemainingDays());

        assertEquals(POCKET_ID_CYPHER, result.getId());
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertEquals(result.getPriority(), input.getPripoc());

        assertEquals(result.getBalances().get(0).getId(), input.getIdpresp());
        assertEquals(result.getBalances().get(0).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(0).getAmount(), input.getAhopoc());
        assertEquals(result.getBalances().get(0).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(1).getId(), input.getIdinter());
        assertEquals(result.getBalances().get(1).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(1).getAmount(), input.getImpinte());
        assertEquals(result.getBalances().get(1).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(2).getId(), input.getIdtpre());
        assertEquals(result.getBalances().get(2).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(2).getAmount(), input.getMtopock());
        assertEquals(result.getBalances().get(2).getCurrency(), input.getMonaho());

        assertEquals(result.getCategory().getId(), input.getTippoc());
        assertEquals(result.getCategory().getName(), input.getDestipo());
        assertEquals(ENUM_STATUS_ID, result.getStatus());
        assertTrue(result.getIsScheduled());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getAmount(), input.getImpaut());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getCurrency(), input.getMonimp());
        assertEquals(ENUM_PERIOD_FREQUENCY_ID_MONTHLY, result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(result.getScheduledDeposit().getPeriod().getFrequency().getName(), input.getDesperi());
        assertEquals(result.getScheduledDeposit().getPeriod().getDayOfMonth(), dayOfMonth);
        assertEquals(result.getRelatedContract().getNumber(), input.getNumcuen());
        assertEquals(DateUtils.toDateTime(input.getFechcre(), input.getHoraope()), result.getCreationDate());
        assertTrue(result.getIsSavingRounding());
        assertEquals(result.getRemainingDays(), input.getDiasres());
    }

    @Test
    public void mapOutRemainingDaysOptionalTest() throws IOException, ParseException {
        FormatoBQM77S1 input = FormatsBq77Mock.getInstance().getFormatoBQM77S1();
        Mockito.when(cypherTool.encrypt(input.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_GET_POCKET)).thenReturn(POCKET_ID_CYPHER);
        Integer dayOfMonth = Integer.valueOf(input.getDiaauto());
        input.setDiasres(null);
        input.setPeraut("B");

        int year = 2016;
        int month = Calendar.OCTOBER;
        int day = 30;
        GregorianCalendar dateCreation = new GregorianCalendar(year, month, day);
        input.setFechcre(dateCreation.getTime());

        Pocket result = mapper.mapOut(input);

        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getBalances());

        assertEquals(3, result.getBalances().size());

        assertEquals(result.getBalances().get(0).getId(), input.getIdpresp());
        assertEquals(result.getBalances().get(0).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(0).getAmount(), input.getAhopoc());
        assertEquals(result.getBalances().get(0).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(1).getId(), input.getIdinter());
        assertEquals(result.getBalances().get(1).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(1).getAmount(), input.getImpinte());
        assertEquals(result.getBalances().get(1).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(2).getId(), input.getIdtpre());
        assertEquals(result.getBalances().get(2).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(2).getAmount(), input.getMtopock());
        assertEquals(result.getBalances().get(2).getCurrency(), input.getMonaho());

        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getCategory().getName());
        assertNotNull(result.getStatus());
        assertNotNull(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit());
        assertNotNull(result.getScheduledDeposit().getDepositAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getName());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());
        assertNotNull(result.getRelatedContract().getNumber());
        assertNotNull(result.getCreationDate());
        assertNotNull(result.getIsSavingRounding());
        assertNotNull(result.getTotalDays());
        assertNull(result.getRemainingDays());

        assertEquals(result.getId(), POCKET_ID_CYPHER);
        assertEquals(result.getAlias(), input.getNomcor());
        assertEquals(result.getGoalAmount().getAmount(), input.getMonpoc());
        assertEquals(result.getGoalAmount().getCurrency(), input.getMoneda());
        assertEquals(result.getExpirationDate(), input.getFechpoc());
        assertEquals(result.getPriority(), input.getPripoc());

        assertEquals(result.getBalances().get(0).getId(), input.getIdpresp());
        assertEquals(result.getBalances().get(0).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(0).getAmount(), input.getAhopoc());
        assertEquals(result.getBalances().get(0).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(1).getId(), input.getIdinter());
        assertEquals(result.getBalances().get(1).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(1).getAmount(), input.getImpinte());
        assertEquals(result.getBalances().get(1).getCurrency(), input.getMonaho());

        assertEquals(result.getBalances().get(2).getId(), input.getIdtpre());
        assertEquals(result.getBalances().get(2).getMode(), input.getNompres());
        assertEquals(result.getBalances().get(2).getAmount(), input.getMtopock());
        assertEquals(result.getBalances().get(2).getCurrency(), input.getMonaho());

        assertEquals(result.getCategory().getId(), input.getTippoc());
        assertEquals(result.getCategory().getName(), input.getDestipo());
        assertEquals(ENUM_STATUS_ID, result.getStatus());
        assertTrue(result.getIsScheduled());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getAmount(), input.getImpaut());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getCurrency(), input.getMonimp());
        assertEquals(ENUM_PERIOD_FREQUENCY_ID_BIMONTHLY, result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(result.getScheduledDeposit().getPeriod().getFrequency().getName(), input.getDesperi());
        assertEquals(result.getScheduledDeposit().getPeriod().getDayOfMonth(), dayOfMonth);
        assertEquals(result.getRelatedContract().getNumber(), input.getNumcuen());
        assertEquals(DateUtils.toDateTime(input.getFechcre(), input.getHoraope()), result.getCreationDate());
        assertTrue(result.getIsSavingRounding());
        assertEquals(result.getTotalDays(), input.getDiastot());
    }

    @Test
    public void mapOutIsScheduledNullTest() throws IOException {
        FormatoBQM77S1 input = FormatsBq77Mock.getInstance().getFormatoBQM77S1();
        Mockito.when(cypherTool.encrypt(input.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_GET_POCKET))
                .thenReturn(POCKET_ID_CYPHER);
        input.setFlapoc(null);
        Pocket result = mapper.mapOut(input);

        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getBalances());

        assertEquals(3, result.getBalances().size());

        assertNotNull(result.getBalances().get(0).getId());
        assertNotNull(result.getBalances().get(0).getMode());
        assertNotNull(result.getBalances().get(0).getCurrency());
        assertNotNull(result.getBalances().get(0).getAmount());

        assertNotNull(result.getBalances().get(1).getId());
        assertNotNull(result.getBalances().get(1).getMode());
        assertNotNull(result.getBalances().get(1).getMode());
        assertNotNull(result.getBalances().get(1).getCurrency());

        assertNotNull(result.getBalances().get(2).getId());
        assertNotNull(result.getBalances().get(2).getMode());
        assertNotNull(result.getBalances().get(2).getMode());
        assertNotNull(result.getBalances().get(2).getCurrency());

        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getCategory().getName());
        assertNotNull(result.getStatus());
        assertNull(result.getIsScheduled());
        assertNull(result.getScheduledDeposit());
        assertNotNull(result.getRelatedContract().getNumber());
        assertNotNull(result.getCreationDate());
        assertNotNull(result.getIsSavingRounding());
        assertNotNull(result.getTotalDays());
        assertNotNull(result.getRemainingDays());
    }

    @Test
    public void mapOutScheduledDepositPeriodFrequencyIdNullTest() throws IOException {
        FormatoBQM77S1 input = FormatsBq77Mock.getInstance().getFormatoBQM77S1();
        Mockito.when(cypherTool.encrypt(input.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_GET_POCKET))
                .thenReturn(POCKET_ID_CYPHER);
        input.setPeraut(null);
        Integer dayOfMonth = Integer.valueOf(input.getDiaauto());
        Pocket result = mapper.mapOut(input);

        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getBalances());

        assertEquals(3, result.getBalances().size());

        assertNotNull(result.getBalances().get(0).getId());
        assertNotNull(result.getBalances().get(0).getMode());
        assertNotNull(result.getBalances().get(0).getCurrency());
        assertNotNull(result.getBalances().get(0).getAmount());

        assertNotNull(result.getBalances().get(1).getId());
        assertNotNull(result.getBalances().get(1).getMode());
        assertNotNull(result.getBalances().get(1).getMode());
        assertNotNull(result.getBalances().get(1).getCurrency());

        assertNotNull(result.getBalances().get(2).getId());
        assertNotNull(result.getBalances().get(2).getMode());
        assertNotNull(result.getBalances().get(2).getMode());
        assertNotNull(result.getBalances().get(2).getCurrency());

        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getCategory().getName());
        assertNotNull(result.getStatus());
        assertNotNull(result.getIsScheduled());

        assertNotNull(result.getScheduledDeposit());
        assertNotNull(result.getScheduledDeposit().getDepositAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency());
        assertNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getName());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());

        assertNotNull(result.getRelatedContract().getNumber());
        assertNotNull(result.getCreationDate());
        assertNotNull(result.getIsSavingRounding());
        assertNotNull(result.getTotalDays());
        assertNotNull(result.getRemainingDays());

        assertTrue(result.getIsScheduled());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getAmount(), input.getImpaut());
        assertEquals(result.getScheduledDeposit().getDepositAmount().getCurrency(), input.getMonimp());
        assertEquals(result.getScheduledDeposit().getPeriod().getFrequency().getName(), input.getDesperi());
        assertEquals(result.getScheduledDeposit().getPeriod().getDayOfMonth(), dayOfMonth);
    }
}
