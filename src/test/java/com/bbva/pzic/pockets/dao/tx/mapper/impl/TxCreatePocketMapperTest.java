package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocket;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38E1;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public class TxCreatePocketMapperTest {
    private ITxCreatePocketMapper pocketMapper;
    private DummyMock dummyMock;

    @Before
    public void init() {
        pocketMapper = new TxCreatePocketMapper();
        dummyMock = new DummyMock();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutAccountPocketNumberTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setAccountPocketNumber(null);

        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNull(result.getNumcuen());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutPocketTypeIdTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setPocketTypeId(null);

        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNull(result.getTippock());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutNameTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setName(null);

        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNull(result.getNompoc());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutShortNameTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setShortName(null);

        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNull(result.getNomcor());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutGoalAmountValueTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setGoalAmountValue(null);

        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNull(result.getMonpoc());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutGoalAmountCurrencyTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setGoalAmountCurrency(null);

        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNull(result.getMoneda());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutGoalDateTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setGoalDate(null);
        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNull(result.getFechpoc());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutAutomaticAmountValueTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setAutomaticAmountValue(null);
        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNull(result.getImpaut());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutAutomaticAmountCurrencyTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setAutomaticAmountCurrency(null);

        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNull(result.getMonimp());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithputautomaticAmountPeriodIdTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setAutomaticAmountPeriodId(null);

        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNull(result.getPeraut());

        Assert.assertNotNull(result.getDiaauto());
        Assert.assertEquals(result.getDiaauto(), input.getAutomaticAmountDayMonth());
    }

    @Test
    public void mapInWithoutAutomaticAmountDayAmountTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setAutomaticAmountDayMonth(null);
        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNotNull(result.getImpaut());
        Assert.assertEquals(result.getImpaut(), input.getAutomaticAmountValue());

        Assert.assertNotNull(result.getMonimp());
        Assert.assertEquals(result.getMonimp(), input.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getPeraut());
        Assert.assertEquals(result.getPeraut(), input.getAutomaticAmountPeriodId());

        Assert.assertNull(result.getDiaauto());
    }

    @Test
    public void mapInWithIsAutomaticAmountFalseTest() throws IOException {
        InputCreatePocket input = dummyMock.getInputCreatePocket();
        input.setIsAutomaticAmount(false);
        FormatoBQM38E1 result = pocketMapper.mapIn(input);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getNumcuen());
        Assert.assertEquals(result.getNumcuen(), input.getAccountPocketNumber());

        Assert.assertNotNull(result.getTippock());
        Assert.assertEquals(result.getTippock(), input.getPocketTypeId());

        Assert.assertNotNull(result.getNompoc());
        Assert.assertEquals(result.getNompoc(), input.getName());

        Assert.assertNotNull(result.getNomcor());
        Assert.assertEquals(result.getNomcor(), input.getShortName());

        Assert.assertNotNull(result.getMonpoc());
        Assert.assertEquals(result.getMonpoc(), input.getGoalAmountValue());

        Assert.assertNotNull(result.getMoneda());
        Assert.assertEquals(result.getMoneda(), input.getGoalAmountCurrency());

        Assert.assertNotNull(result.getFechpoc());
        Assert.assertEquals(result.getFechpoc(), input.getGoalDate());

        Assert.assertNotNull(result.getFlagpoc());
        Assert.assertEquals(result.getFlagpoc(), input.getIsAutomaticAmount() ? "S" : "N");

        Assert.assertNull(result.getImpaut());

        Assert.assertNull(result.getMonimp());

        Assert.assertNull(result.getPeraut());

        Assert.assertNull(result.getDiaauto());
    }

    @Test
    public void mapOutFullTest() {
        FormatoBQM38S1 format = new FormatoBQM38S1();
        format.setIdpoc("00110241029996285000001");

        PocketV00 result = pocketMapper.mapOut(format);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), format.getIdpoc());
    }

    @Test
    public void mapOutWithoutFormatIntanzedTest() {
        PocketV00 result = pocketMapper.mapOut(new FormatoBQM38S1());
        Assert.assertNotNull(result);
        Assert.assertNull(result.getId());
    }

    @Test
    public void mapOutWithFormatNullTest() {
        PocketV00 result = pocketMapper.mapOut(null);
        Assert.assertNull(result);
    }

}