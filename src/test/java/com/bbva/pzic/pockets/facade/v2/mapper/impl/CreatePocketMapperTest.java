package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.bbva.pzic.pockets.EntityMock.ENUM_OUT_MONTHLY;
import static org.junit.Assert.*;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class CreatePocketMapperTest {

    @InjectMocks
    private CreatePocketMapper mapper;

    @Mock
    private Translator translator;

    @Before
    public void init() {
        Mockito.when(translator.translateFrontendEnumValueStrictly("pocket.period.frequencyId", ENUM_OUT_MONTHLY)).thenReturn("M");
    }

    @Test
    public void mapInFull() throws IOException {
        Pocket input = EntityMock.getInstance().getRequestCreatePocketV2();
        input.setIsScheduled(Boolean.TRUE);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);

        DTOIntPocket result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getRelatedContract().getNumber());
        assertNotNull(result.getCategory().getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getIsScheduled());
        Assert.assertTrue(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());

        assertEquals(input.getRelatedContract().getNumber(), result.getRelatedContract().getNumber());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getAmount(), result.getScheduledDeposit().getDepositAmount().getAmount());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getCurrency(), result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertEquals("M", result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(input.getScheduledDeposit().getPeriod().getDayOfMonth(), result.getScheduledDeposit().getPeriod().getDayOfMonth());
    }

    @Test
    public void mapInWithOnlyGoalAmountAmount() throws IOException {
        Pocket input = EntityMock.getInstance().getRequestCreatePocketV2();
        input.setIsScheduled(Boolean.TRUE);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.getGoalAmount().setAmount(null);

        DTOIntPocket result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getGoalAmount());
        assertNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
    }

    @Test
    public void mapInWithOnlyGoalAmountCurrency() throws IOException {
        Pocket input = EntityMock.getInstance().getRequestCreatePocketV2();
        input.setIsScheduled(Boolean.TRUE);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.getGoalAmount().setCurrency(null);

        DTOIntPocket result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getGoalAmount());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNull(result.getGoalAmount().getCurrency());
    }

    @Test
    public void mapInWithoutGoalAmount() throws IOException {
        Pocket input = EntityMock.getInstance().getRequestCreatePocketV2();
        input.setIsScheduled(Boolean.TRUE);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.setGoalAmount(null);

        DTOIntPocket result = mapper.mapIn(input);

        assertNotNull(result);
        assertNull(result.getGoalAmount());
    }

    @Test
    public void mapInEmptyTest() {
        DTOIntPocket result = mapper.mapIn(new Pocket());
        assertNotNull(result);
        assertNull(result.getRelatedContract());
        assertNull(result.getCategory());
        assertNull(result.getAlias());
        assertNull(result.getGoalAmount());
        assertNull(result.getExpirationDate());
        assertNull(result.getScheduledDeposit());
    }

    @Test
    public void mapOutFull() throws IOException {
        Pocket input = EntityMock.getInstance().getResponseCreatePocketV2();
        ServiceResponse<Pocket> result = mapper.mapOut(input);
        assertNotNull(result);
        assertNotNull(result.getData());
        assertNotNull(result.getData().getId());
        assertNotNull(result.getData().getCategory().getId());
        assertNotNull(result.getData().getAlias());
        assertNotNull(result.getData().getGoalAmount());
        assertNotNull(result.getData().getGoalAmount().getAmount());
        assertNotNull(result.getData().getGoalAmount().getCurrency());
        assertNotNull(result.getData().getExpirationDate());
        assertNotNull(result.getData().getIsScheduled());
        assertNotNull(result.getData().getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getData().getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getData().getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getData().getScheduledDeposit().getPeriod().getDayOfMonth());
        assertNotNull(result.getData().getCreationDate());
        assertTrue(result.getMessages().isEmpty());
        assertNull(result.getPagination());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<Pocket> result = mapper.mapOut(null);
        assertNull(result);
    }


}
