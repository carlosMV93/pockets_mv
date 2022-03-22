package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketContributions;
import com.bbva.pzic.pockets.canonic.Contribution;
import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78E1;
import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78S1;
import com.bbva.pzic.pockets.dao.model.bq78.mock.FormatsBq78Mock;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketContributionsMapper;
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
public class TxCreatePocketContributionsMapperTest {

    private ITxCreatePocketContributionsMapper mapper;

    @Before
    public void setUp() {
        mapper = new TxCreatePocketContributionsMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputCreatePocketContributions input = EntityMock.getInstance().getInputCreatePocketContributions();
        FormatoBQM78E1 result = mapper.mapIn(input);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdpoc());
        Assert.assertNotNull(result.getImporte());
        Assert.assertNotNull(result.getMoneda());

        Assert.assertEquals(input.getPocketId(), result.getIdpoc());
        Assert.assertEquals(input.getContribution().getContributionAmount().getAmount(), result.getImporte());
        Assert.assertEquals(input.getContribution().getContributionAmount().getCurrency(), result.getMoneda());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoBQM78E1 result = mapper.mapIn(new InputCreatePocketContributions());

        Assert.assertNotNull(result);
        Assert.assertNull(result.getIdpoc());
        Assert.assertNull(result.getImporte());
        Assert.assertNull(result.getMoneda());
    }

    @Test
    public void mapOutFullTest() throws IOException, ParseException {
        FormatoBQM78S1 format = FormatsBq78Mock.getInstance().getFormatoBQM78S1();
        int year = 2018;
        int month = Calendar.MARCH;
        int day = 28;
        GregorianCalendar dateOperation = new GregorianCalendar(year, month, day);
        format.setFechope(dateOperation.getTime());

        Contribution result = mapper.mapOut(format);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getContributionAmount().getAmount());
        Assert.assertNotNull(result.getContributionAmount().getCurrency());
        Assert.assertNotNull(result.getOperationNumber());
        Assert.assertNotNull(result.getOperationDate());

        Assert.assertEquals(format.getImporte(), result.getContributionAmount().getAmount());
        Assert.assertEquals(format.getMoneda(), result.getContributionAmount().getCurrency());
        Assert.assertEquals(format.getNumope().toString(), result.getOperationNumber());
        Assert.assertEquals(DateUtils.toDateTime(format.getFechope(), format.getHoraope()), result.getOperationDate());
    }

    @Test
    public void mapOutEmptyTest() throws IOException {
        FormatoBQM78S1 format = FormatsBq78Mock.getInstance().getFormatoBQM78S1Empty();
        Contribution result = mapper.mapOut(format);

        Assert.assertNotNull(result);
        Assert.assertNull(result.getContributionAmount().getCurrency());
        Assert.assertNull(result.getOperationDate());
        Assert.assertNotNull(result.getContributionAmount().getAmount());
        Assert.assertNotNull(result.getOperationNumber());

        Assert.assertEquals(format.getImporte(), result.getContributionAmount().getAmount());
        Assert.assertEquals(format.getNumope().toString(), result.getOperationNumber());
    }
}