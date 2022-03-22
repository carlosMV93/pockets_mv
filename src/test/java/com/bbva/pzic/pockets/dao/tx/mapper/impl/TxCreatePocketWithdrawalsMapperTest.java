package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketWithdrawals;
import com.bbva.pzic.pockets.canonic.Withdrawal;
import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79E1;
import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79S1;
import com.bbva.pzic.pockets.dao.model.bq79.mock.FormatsBq79Mock;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketWithdrawalsMapper;
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
public class TxCreatePocketWithdrawalsMapperTest {

    private ITxCreatePocketWithdrawalsMapper mapper;

    @Before
    public void setUp() {
        mapper = new TxCreatePocketWithdrawalsMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputCreatePocketWithdrawals input = EntityMock.getInstance().getInputCreatePocketWithdrawals();
        FormatoBQM79E1 result = mapper.mapIn(input);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdpoc());
        Assert.assertNotNull(result.getImporte());
        Assert.assertNotNull(result.getMoneda());

        Assert.assertEquals(input.getPocketId(), result.getIdpoc());
        Assert.assertEquals(input.getWithdrawal().getWithdrawalAmount().getAmount(), result.getImporte());
        Assert.assertEquals(input.getWithdrawal().getWithdrawalAmount().getCurrency(), result.getMoneda());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoBQM79E1 result = mapper.mapIn(new InputCreatePocketWithdrawals());

        Assert.assertNotNull(result);
        Assert.assertNull(result.getIdpoc());
        Assert.assertNull(result.getImporte());
        Assert.assertNull(result.getMoneda());
    }

    @Test
    public void mapOutFullTest() throws IOException, ParseException {
        FormatoBQM79S1 format = FormatsBq79Mock.getInstance().getFormatoBQM79S1();

        int year = 2004;
        int month = Calendar.JANUARY;
        int day = 7;
        GregorianCalendar dateOperation = new GregorianCalendar(year, month, day);
        format.setFechope(dateOperation.getTime());

        Withdrawal result = mapper.mapOut(format);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getWithdrawalAmount().getAmount());
        Assert.assertNotNull(result.getWithdrawalAmount().getCurrency());
        Assert.assertNotNull(result.getOperationNumber());
        Assert.assertNotNull(result.getOperationDate());

        Assert.assertEquals(format.getImporte(), result.getWithdrawalAmount().getAmount());
        Assert.assertEquals(format.getMoneda(), result.getWithdrawalAmount().getCurrency());
        Assert.assertEquals(format.getNumope().toString(), result.getOperationNumber());
        Assert.assertEquals(DateUtils.toDateTime(format.getFechope(), format.getHoraope()), result.getOperationDate());
    }

    @Test
    public void mapOutEmptyTest() throws IOException {
        FormatoBQM79S1 format = FormatsBq79Mock.getInstance().getFormatoBQM79S1Empty();
        Withdrawal result = mapper.mapOut(format);

        Assert.assertNotNull(result);
        Assert.assertNull(result.getWithdrawalAmount().getCurrency());
        Assert.assertNull(result.getOperationDate());
        Assert.assertNotNull(result.getWithdrawalAmount().getAmount());
        Assert.assertNotNull(result.getOperationNumber());

        Assert.assertEquals(format.getImporte(), result.getWithdrawalAmount().getAmount());
        Assert.assertEquals(format.getNumope().toString(), result.getOperationNumber());
    }
}