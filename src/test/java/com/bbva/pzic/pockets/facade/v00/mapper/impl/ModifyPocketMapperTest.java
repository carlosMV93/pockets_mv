package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntAutomaticAmount;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.AutomaticAmount;
import com.bbva.pzic.pockets.canonic.PocketV00;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.bbva.pzic.pockets.DummyMock.POCKET_ID;
import static org.junit.Assert.*;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class ModifyPocketMapperTest {

    @InjectMocks
    private ModifyPocketMapper modifyPocketMapper;

    @InjectMocks
    private DummyMock mock;

    @Test
    public void mapIntTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getPocketType().getId(), dtoInt.getPocketType().getId());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());
    }

    @Test
    public void mapIntWithoutNameTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        payload.setName(null);
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getPocketType().getId(), dtoInt.getPocketType().getId());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoInt.getName());
    }

    @Test
    public void mapIntWithoutShortNameTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        payload.setShortName(null);
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getPocketType().getId(), dtoInt.getPocketType().getId());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoInt.getShortName());
    }

    @Test
    public void mapIntWithoutGoalAmountValueTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        payload.getGoalAmount().setValue(null);
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getPocketType().getId(), dtoInt.getPocketType().getId());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoInt.getGoalAmount().getValue());
    }

    @Test
    public void mapIntWithoutGoalAmountCurrencyTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        payload.getGoalAmount().setCurrency(null);
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getPocketType().getId(), dtoInt.getPocketType().getId());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoInt.getGoalAmount().getCurrency());
    }

    @Test
    public void mapIntWithoutGoalAmountTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        payload.setGoalAmount(null);
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getPocketType().getId(), dtoInt.getPocketType().getId());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoInt.getGoalAmount());
    }

    @Test
    public void mapIntWithoutGoalDateTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        payload.setGoalDate(null);
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getPocketType().getId(), dtoInt.getPocketType().getId());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoInt.getGoalDate());
    }

    @Test
    public void mapIntWithoutPriorityTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        payload.setPriority(null);
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPocketType().getId(), dtoInt.getPocketType().getId());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoInt.getPriority());
    }

    @Test
    public void mapIntWithoutPocketTypeIdTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        payload.getPocketType().setId(null);
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoInt.getPocketType());
    }

    @Test
    public void mapIntNotIsAutomaticAmountTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        payload.setIsAutomaticAmount(Boolean.FALSE);
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getPocketType().getId(), dtoInt.getPocketType().getId());

        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());
        assertNull(dtoInt.getAutomaticAmount());
    }

    @Test
    public void mapIntWithoutAutomaticAmountValueTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        automaticAmount.setValue(null);
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoIntAutomaticAmount.getValue());
    }

    @Test
    public void mapIntWithoutAutomaticAmountCurrencyTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        automaticAmount.setCurrency(null);
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoIntAutomaticAmount.getCurrency());
    }

    @Test
    public void mapIntWithoutAutomaticAmountPeriodIdTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        automaticAmount.getPeriod().setId(null);
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getDayMonth(), dtoIntAutomaticAmount.getDayMonth());

        assertNull(dtoIntAutomaticAmount.getPeriod());
    }

    @Test
    public void mapIntWithoutAutomaticAmountDayMonthTest() throws IOException {
        PocketV00 payload = mock.getModifyPocketPayload();
        AutomaticAmount automaticAmount = payload.getAutomaticAmount();
        automaticAmount.setDayMonth(null);
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);
        DTOIntAutomaticAmount dtoIntAutomaticAmount = dtoInt.getAutomaticAmount();

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());
        assertEquals(payload.getName(), dtoInt.getName());
        assertEquals(payload.getShortName(), dtoInt.getShortName());
        assertEquals(payload.getGoalAmount().getValue(), dtoInt.getGoalAmount().getValue());
        assertEquals(payload.getGoalAmount().getCurrency(), dtoInt.getGoalAmount().getCurrency());
        assertEquals(payload.getGoalDate(), dtoInt.getGoalDate());
        assertEquals(payload.getPriority(), dtoInt.getPriority());
        assertEquals(payload.getIsAutomaticAmount(), dtoInt.getIsAutomaticAmount());

        assertNotNull(dtoIntAutomaticAmount);
        assertEquals(automaticAmount.getValue(), dtoIntAutomaticAmount.getValue());
        assertEquals(automaticAmount.getCurrency(), dtoIntAutomaticAmount.getCurrency());
        assertEquals(automaticAmount.getPeriod().getId(), dtoIntAutomaticAmount.getPeriod().getId());

        assertNull(dtoIntAutomaticAmount.getDayMonth());
    }

    @Test
    public void mapIntEmptyWithIdTest() {
        PocketV00 payload = new PocketV00();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(POCKET_ID, payload);

        assertNotNull(dtoInt);
        assertEquals(POCKET_ID, dtoInt.getId());

        assertNull(dtoInt.getName());
        assertNull(dtoInt.getShortName());
        assertNull(dtoInt.getGoalAmount());
        assertNull(dtoInt.getGoalDate());
        assertNull(dtoInt.getPriority());
        assertNull(dtoInt.getPocketType());
        assertNull(dtoInt.getIsAutomaticAmount());
        assertNull(dtoInt.getAutomaticAmount());
    }

    @Test
    public void mapIntEmptyWithoutIdTest() {
        PocketV00 payload = new PocketV00();
        DTOIntPocket dtoInt = modifyPocketMapper.mapIn(null, payload);

        assertNotNull(dtoInt);
        assertNull(dtoInt.getId());
        assertNull(dtoInt.getName());
        assertNull(dtoInt.getShortName());
        assertNull(dtoInt.getGoalAmount());
        assertNull(dtoInt.getGoalDate());
        assertNull(dtoInt.getPriority());
        assertNull(dtoInt.getPocketType());
        assertNull(dtoInt.getIsAutomaticAmount());
        assertNull(dtoInt.getAutomaticAmount());
    }

}