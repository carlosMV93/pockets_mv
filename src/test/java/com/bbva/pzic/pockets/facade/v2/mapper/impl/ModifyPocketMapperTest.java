package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPocketV2;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.bbva.pzic.pockets.EntityMock.ENUM_OUT_MONTHLY;
import static com.bbva.pzic.pockets.EntityMock.POCKET_ID_CYPHER;
import static org.junit.Assert.*;

/**
 * Created on 19/10/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ModifyPocketMapperTest {

    @InjectMocks
    private ModifyPocketMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;
    @Mock
    private Translator translator;

    @Before
    public void init() {
        Mockito.when(translator.translateFrontendEnumValueStrictly("pocket.period.frequencyId", ENUM_OUT_MONTHLY)).thenReturn("M");
    }

    @Test
    public void mapInFull() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertTrue(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getAmount(), result.getScheduledDeposit().getDepositAmount().getAmount());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getCurrency(), result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertEquals("M", result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(input.getScheduledDeposit().getPeriod().getDayOfMonth(), result.getScheduledDeposit().getPeriod().getDayOfMonth());
    }

    @Test
    public void mapInGoalAmountOptional() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.setGoalAmount(null);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNull(result.getGoalAmount());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertTrue(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getAmount(), result.getScheduledDeposit().getDepositAmount().getAmount());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getCurrency(), result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertEquals("M", result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(input.getScheduledDeposit().getPeriod().getDayOfMonth(), result.getScheduledDeposit().getPeriod().getDayOfMonth());
    }

    @Test
    public void mapInCategoryOptionalTest() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.setCategory(null);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNull(result.getCategory());
        assertTrue(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getAmount(), result.getScheduledDeposit().getDepositAmount().getAmount());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getCurrency(), result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertEquals("M", result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(input.getScheduledDeposit().getPeriod().getDayOfMonth(), result.getScheduledDeposit().getPeriod().getDayOfMonth());
    }

    @Test
    public void mapInIsScheduledFalseTest() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.setIsScheduled(Boolean.FALSE);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertFalse(result.getIsScheduled());
        assertNull(result.getScheduledDeposit());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
    }

    @Test
    public void mapInIsScheduledNullTest() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.setIsScheduled(null);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertNull(result.getIsScheduled());
        assertNull(result.getScheduledDeposit());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
    }

    @Test
    public void mapInScheduledDepositDepositAmountOptional() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.getScheduledDeposit().setDepositAmount(null);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertTrue(result.getIsScheduled());
        assertNull(result.getScheduledDeposit().getDepositAmount());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
        assertEquals("M", result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertEquals(input.getScheduledDeposit().getPeriod().getDayOfMonth(), result.getScheduledDeposit().getPeriod().getDayOfMonth());
    }

    @Test
    public void mapInScheduledDepositPeriodFrequencyOptional() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.getScheduledDeposit().getPeriod().setFrequency(null);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertTrue(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNull(result.getScheduledDeposit().getPeriod().getFrequency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getAmount(), result.getScheduledDeposit().getDepositAmount().getAmount());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getCurrency(), result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertEquals(input.getScheduledDeposit().getPeriod().getDayOfMonth(), result.getScheduledDeposit().getPeriod().getDayOfMonth());
    }

    @Test
    public void mapInScheduledDepositPeriodDayOfMonthOptional() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(null);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertTrue(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNotNull(result.getScheduledDeposit().getPeriod().getFrequency().getId());
        assertNull(result.getScheduledDeposit().getPeriod().getDayOfMonth());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getAmount(), result.getScheduledDeposit().getDepositAmount().getAmount());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getCurrency(), result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertEquals("M", result.getScheduledDeposit().getPeriod().getFrequency().getId());
    }

    @Test
    public void mapInScheduledDepositPeriodOptional() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.getScheduledDeposit().setPeriod(null);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertTrue(result.getIsScheduled());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getAmount());
        assertNotNull(result.getScheduledDeposit().getDepositAmount().getCurrency());
        assertNull(result.getScheduledDeposit().getPeriod());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getAmount(), result.getScheduledDeposit().getDepositAmount().getAmount());
        assertEquals(input.getScheduledDeposit().getDepositAmount().getCurrency(), result.getScheduledDeposit().getDepositAmount().getCurrency());
    }

    @Test
    public void mapInScheduledDepositOptional() throws IOException {
        Mockito.when(cypherTool.decrypt(POCKET_ID_CYPHER, AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS)).thenReturn(EntityMock.POCKET_ID);

        List<Pocket> pockets = EntityMock.getInstance().getRequestModifyPocketV2();
        Pocket input = pockets.get(0);
        input.getScheduledDeposit().getPeriod().setDayOfMonth(10);
        input.setScheduledDeposit(null);

        DTOIntPocketV2 result = mapper.mapIn(pockets);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount().getAmount());
        assertNotNull(result.getGoalAmount().getCurrency());
        assertNotNull(result.getExpirationDate());
        assertNotNull(result.getPriority());
        assertNotNull(result.getCategory().getId());
        assertTrue(result.getIsScheduled());
        assertNull(result.getScheduledDeposit());

        assertEquals(EntityMock.POCKET_ID, result.getId());
        assertEquals(input.getAlias(), result.getAlias());
        assertEquals(input.getGoalAmount().getAmount(), result.getGoalAmount().getAmount());
        assertEquals(input.getGoalAmount().getCurrency(), result.getGoalAmount().getCurrency());
        assertEquals(input.getExpirationDate(), result.getExpirationDate());
        assertEquals(input.getPriority(), result.getPriority());
        assertEquals(input.getCategory().getId(), result.getCategory().getId());
    }

    @Test
    public void mapInEmptyTest() {
        DTOIntPocketV2 result = mapper.mapIn(Collections.emptyList());
        assertNull(result);
    }

    @Test
    public void mapOutFull() throws IOException {
        List<Pocket> input = EntityMock.getInstance().getResponseModifyPocketV2();
        ServiceResponse<List<Pocket>> pockets = mapper.mapOut(input);
        Pocket result = pockets.getData().get(0);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getAlias());
        assertNotNull(result.getGoalAmount());
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
        assertTrue(pockets.getMessages().isEmpty());
        assertNull(pockets.getPagination());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<List<Pocket>> result = mapper.mapOut(null);
        assertNull(result);
    }
}
