package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.InputCreatePocket;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class CreatePocketMapperTest {

    private static final String MONTHLY = "M";

    @InjectMocks
    private CreatePocketMapper pocketMapper;

    @Mock
    private EnumMapper enumMapper;
    private DummyMock dummyMock = new DummyMock();

    @Before
    public void init() {
        Mockito.when(enumMapper.getBackendValue("pocket.automaticAmount.period.id", "MONTHLY")).thenReturn(MONTHLY);
    }

    @Test
    public void mapInFullTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());
    }

    @Test
    public void mapInWithoutAccountPocketNumberTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getAccountPocket().setNumber(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNull(result.getAccountPocketNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutAccountPocketTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.setAccountPocket(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNull(result.getAccountPocketNumber());

        Assert.assertNull(result.getAccountPocketAccountFamilyId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutAccountPocketAccountFamilyIdTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getAccountPocket().getAccountFamily().setId(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNull(result.getAccountPocketAccountFamilyId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutAccountPocketAccountFamilyTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getAccountPocket().setAccountFamily(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNull(result.getAccountPocketAccountFamilyId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutPocketTypeIdTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getPocketType().setId(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNull(result.getPocketTypeId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutPocketTypeTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.setPocketType(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNull(result.getPocketTypeId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutNameTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.setName(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNull(result.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutShortNameTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.setShortName(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNull(result.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutetGoalAmountValueTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getGoalAmount().setValue(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNull(result.getGoalAmountValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutGoalAmountCurrencyTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getGoalAmount().setCurrency(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNull(result.getGoalAmountCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutGoalAmountTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.setGoalAmount(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNull(result.getGoalAmountValue());

        Assert.assertNull(result.getGoalAmountCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutGoalDateTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.setGoalDate(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutIsAutomaticAmountTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.setIsAutomaticAmount(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertNull(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutAutomaticAmountValueTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getAutomaticAmount().setValue(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNull(result.getAutomaticAmountValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutAutomaticAmountCurrencyTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getAutomaticAmount().setCurrency(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNull(result.getAutomaticAmountCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutAutomaticAmountDayMonthTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getAutomaticAmount().setDayMonth(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNotNull(result.getAutomaticAmountPeriodId());
        Assert.assertEquals(result.getAutomaticAmountPeriodId(), MONTHLY);

        Assert.assertNull(result.getAutomaticAmountDayMonth());

    }

    @Test
    public void mapInWithoutPeriodIdTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getAutomaticAmount().getPeriod().setId(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNull(result.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutPeriodTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.getAutomaticAmount().setPeriod(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNotNull(result.getAutomaticAmountValue());
        Assert.assertEquals(result.getAutomaticAmountValue(), pocket.getAutomaticAmount().getValue());

        Assert.assertNotNull(result.getAutomaticAmountCurrency());
        Assert.assertEquals(result.getAutomaticAmountCurrency(), pocket.getAutomaticAmount().getCurrency());

        Assert.assertNull(result.getAutomaticAmountPeriodId());

        Assert.assertNotNull(result.getAutomaticAmountDayMonth());
        Assert.assertEquals(result.getAutomaticAmountDayMonth(), pocket.getAutomaticAmount().getDayMonth());

    }

    @Test
    public void mapInWithoutAutomaticAmountTest() throws IOException {

        PocketV00 pocket = dummyMock.getPocket();
        pocket.setAutomaticAmount(null);
        InputCreatePocket result = pocketMapper.mapIn(pocket);
        Assert.assertNotNull(result);

        Assert.assertNotNull(result.getAccountPocketNumber());
        Assert.assertEquals(result.getAccountPocketNumber(), pocket.getAccountPocket().getNumber());

        Assert.assertNotNull(result.getAccountPocketAccountFamilyId());
        Assert.assertEquals(result.getAccountPocketAccountFamilyId(), pocket.getAccountPocket().getAccountFamily().getId());

        Assert.assertNotNull(result.getPocketTypeId());
        Assert.assertEquals(result.getPocketTypeId(), pocket.getPocketType().getId());

        Assert.assertNotNull(result.getName());
        Assert.assertEquals(result.getName(), pocket.getName());

        Assert.assertNotNull(result.getShortName());
        Assert.assertEquals(result.getShortName(), pocket.getShortName());

        Assert.assertNotNull(result.getGoalAmountValue());
        Assert.assertEquals(result.getGoalAmountValue(), pocket.getGoalAmount().getValue());

        Assert.assertNotNull(result.getGoalAmountCurrency());
        Assert.assertEquals(result.getGoalAmountCurrency(), pocket.getGoalAmount().getCurrency());

        Assert.assertNotNull(result.getGoalDate());

        Assert.assertTrue(result.getIsAutomaticAmount());

        Assert.assertNull(result.getAutomaticAmountValue());

        Assert.assertNull(result.getAutomaticAmountCurrency());

        Assert.assertNull(result.getAutomaticAmountPeriodId());

        Assert.assertNull(result.getAutomaticAmountDayMonth());

    }

}