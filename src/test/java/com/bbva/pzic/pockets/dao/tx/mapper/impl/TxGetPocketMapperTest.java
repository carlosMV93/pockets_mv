package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.PocketData;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40E1;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40S1;
import com.bbva.pzic.pockets.dao.model.bq40.mock.FormatBq40Mock;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxGetPocketMapperTest {

    @InjectMocks
    private TxGetPocketMapper mapper;
    @Mock
    private EnumMapper enumMapper;

    private DummyMock dummyMock = new DummyMock();
    private FormatBq40Mock formatBq40Mock = new FormatBq40Mock();

    private void enumMapOut() {
        Mockito.when(enumMapper.getEnumValue("pocket.automaticAmount.period.id", "M")).thenReturn(DummyMock.PERIOD_ID);
        Mockito.when(enumMapper.getEnumValue("pocket.status.id", "A")).thenReturn(DummyMock.STATUS_ID);
    }

    @Test
    public void mapInFull() {
        PathParamPocketId input = dummyMock.getPathParamPocketId();
        FormatoBQM40E1 result = mapper.mapIn(input);

        assertNotNull(result.getIdpoc());
        assertEquals(input.getPocketId(), result.getIdpoc());
    }

    @Test
    public void mapOutFullTest() {
        FormatoBQM40S1 formatoBQM40S1 = formatBq40Mock.getFormatoBQM40S1();
        enumMapOut();
        PocketData pocketData = mapper.mapOut(formatoBQM40S1);
        Assert.assertNotNull(pocketData);
        PocketV00 data = pocketData.getData();
        Assert.assertNotNull(data);

        Assert.assertNotNull(data.getId());
        Assert.assertEquals(data.getId(), formatoBQM40S1.getPocket());

        Assert.assertNotNull(data.getAccountPocket());
        Assert.assertNotNull(data.getAccountPocket().getNumber());
        Assert.assertNotNull(data.getAccountPocket().getAccountFamily());
        Assert.assertNotNull(data.getAccountPocket().getAccountFamily().getId());
        Assert.assertEquals(data.getAccountPocket().getNumber(), formatoBQM40S1.getNumcuen());
        Assert.assertEquals(data.getAccountPocket().getAccountFamily().getId(), "SAVINGS");

        Assert.assertNotNull(data.getName());
        Assert.assertEquals(data.getName(), formatoBQM40S1.getNompoc());

        Assert.assertNotNull(data.getShortName());
        Assert.assertEquals(data.getShortName(), formatoBQM40S1.getNomcor());

        Assert.assertNotNull(data.getGoalAmount());
        Assert.assertNotNull(data.getGoalAmount().getValue());
        Assert.assertNotNull(data.getGoalAmount().getCurrency());
        Assert.assertEquals(data.getGoalAmount().getValue(), formatoBQM40S1.getMonpoc());
        Assert.assertEquals(data.getGoalAmount().getCurrency(), formatoBQM40S1.getMoneda());

        Assert.assertNotNull(data.getIsAutomaticAmount());
        Assert.assertTrue(data.getIsAutomaticAmount());

        Assert.assertNotNull(data.getGoalDate());
        Assert.assertEquals(data.getGoalDate(), formatoBQM40S1.getFechpoc());

        Assert.assertNotNull(data.getPriority());
        Assert.assertEquals(data.getPriority(), formatoBQM40S1.getPripoc());

        Assert.assertNotNull(data.getCurrentAmount());
        Assert.assertNotNull(data.getCurrentAmount().getValue());
        Assert.assertNotNull(data.getCurrentAmount().getCurrency());
        Assert.assertEquals(data.getCurrentAmount().getValue(), formatoBQM40S1.getAhopoc());
        Assert.assertEquals(data.getCurrentAmount().getCurrency(), formatoBQM40S1.getMonaho());

        Assert.assertNotNull(data.getPocketType());
        Assert.assertNotNull(data.getPocketType().getId());
        Assert.assertNotNull(data.getPocketType().getName());
        Assert.assertEquals(data.getPocketType().getId(), formatoBQM40S1.getTippoc());
        Assert.assertEquals(data.getPocketType().getName(), formatoBQM40S1.getDestipo());

        Assert.assertNotNull(data.getStatus());
        Assert.assertNotNull(data.getStatus().getId());
        Assert.assertNotNull(data.getStatus().getName());
        Assert.assertEquals(data.getStatus().getId(), DummyMock.STATUS_ID);
        Assert.assertEquals(data.getStatus().getName(), formatoBQM40S1.getDesest());

        Assert.assertNotNull(data.getAutomaticAmount());
        Assert.assertNotNull(data.getAutomaticAmount().getValue());
        Assert.assertNotNull(data.getAutomaticAmount().getCurrency());
        Assert.assertNotNull(data.getAutomaticAmount().getPeriod());
        Assert.assertNotNull(data.getAutomaticAmount().getPeriod().getId());
        Assert.assertNotNull(data.getAutomaticAmount().getPeriod().getName());
        Assert.assertNotNull(data.getAutomaticAmount().getDayMonth());
        Assert.assertEquals(data.getAutomaticAmount().getValue(), formatoBQM40S1.getImpaut());
        Assert.assertEquals(data.getAutomaticAmount().getCurrency(), formatoBQM40S1.getMonimp());
        Assert.assertEquals(data.getAutomaticAmount().getPeriod().getId(), DummyMock.PERIOD_ID);
        Assert.assertEquals(data.getAutomaticAmount().getPeriod().getName(), formatoBQM40S1.getDesperi());
        Assert.assertEquals(data.getAutomaticAmount().getDayMonth(), formatoBQM40S1.getDiaauto());
    }

    @Test
    public void mapOutNullTest() {
        enumMapOut();
        PocketData pocketData = mapper.mapOut(null);
        Assert.assertNull(pocketData);
    }
}