package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketLiquidate;
import com.bbva.pzic.pockets.canonic.Liquidate;
import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80E1;
import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80S1;
import com.bbva.pzic.pockets.dao.model.bq80.mock.FormatsBq80Mock;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketLiquidateMapper;
import com.bbva.pzic.routine.commons.utils.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public class TxCreatePocketLiquidateMapperTest {

    private ITxCreatePocketLiquidateMapper mapper;

    @Before
    public void setUp() {
        mapper = new TxCreatePocketLiquidateMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputCreatePocketLiquidate input = EntityMock.getInstance().getInputCreatePocketLiquidate();
        FormatoBQM80E1 result = mapper.mapIn(input);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdpoc());
        Assert.assertEquals(input.getPocketId(), result.getIdpoc());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoBQM80E1 result = mapper.mapIn(new InputCreatePocketLiquidate());
        Assert.assertNotNull(result);
        Assert.assertNull(result.getIdpoc());
    }

    @Test
    public void mapOutFullTest() throws IOException, ParseException {
        FormatoBQM80S1 format = FormatsBq80Mock.getInstance().getFormatoBQM80S1();

        int year = 2010;
        int month = Calendar.NOVEMBER;
        int day = 15;
        GregorianCalendar dateOperation = new GregorianCalendar(year, month, day);
        format.setFechope(dateOperation.getTime());

        Liquidate result = mapper.mapOut(format);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getOperationNumber());
        Assert.assertNotNull(result.getOperationDate());
        Assert.assertNotNull(result.getCurrentAmount().getAmount());
        Assert.assertNotNull(result.getCurrentAmount().getCurrency());

        Assert.assertEquals(format.getNumope().toString(), result.getOperationNumber());
        Assert.assertEquals(DateUtils.toDateTime(format.getFechope(), format.getHoraope()), result.getOperationDate());
        Assert.assertEquals(format.getImporte(), result.getCurrentAmount().getAmount());
        Assert.assertEquals(format.getMoneda(), result.getCurrentAmount().getCurrency());
    }

    @Test
    public void mapOutEmptyTest() throws IOException {
        FormatoBQM80S1 format = FormatsBq80Mock.getInstance().getFormatoBQM80S1Empty();
        Liquidate result = mapper.mapOut(format);

        Assert.assertNotNull(result);
        Assert.assertNull(result.getOperationDate());
        Assert.assertNull(result.getCurrentAmount().getCurrency());
        Assert.assertNotNull(result.getOperationNumber());
        Assert.assertNotNull(result.getCurrentAmount().getAmount());

        Assert.assertEquals(format.getNumope().toString(), result.getOperationNumber());
        Assert.assertEquals(format.getImporte(), result.getCurrentAmount().getAmount());
    }
}