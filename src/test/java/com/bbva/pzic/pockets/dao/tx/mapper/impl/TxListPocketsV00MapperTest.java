package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.DummyMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPocketsData;
import com.bbva.pzic.pockets.business.dto.InputListPocket;
import com.bbva.pzic.pockets.canonic.*;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39E1;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39P1;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39S1;
import com.bbva.pzic.pockets.dao.model.bq39.mock.FormatBq29Mock;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static com.bbva.pzic.pockets.DummyMock.*;
import static com.bbva.pzic.pockets.dao.tx.mapper.impl.TxListPocketsV00Mapper.CONSTANT_SAVINGS;
import static com.bbva.pzic.pockets.dao.tx.mapper.impl.TxListPocketsV00Mapper.ENUM_FIELD_POCKET_STATUS_ID;
import static org.junit.Assert.*;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxListPocketsV00MapperTest {

    @InjectMocks
    private TxListPocketsV00Mapper mapper;

    @Mock
    private EnumMapper enumMapper;

    private DummyMock dummyMock = new DummyMock();
    private FormatBq29Mock formatBq29Mock = new FormatBq29Mock();

    @Before
    public void setUp() {
        Mockito.when(enumMapper.getBackendValue(ENUM_FIELD_POCKET_STATUS_ID,
                PROPERTY_POCKET_STATUS_ID_CREATED_VALUE_TESTED)).thenReturn(PROPERTY_POCKET_STATUS_ID_CREATED_KEY_TESTED);

        Mockito.when(enumMapper.getEnumValue(ENUM_FIELD_POCKET_STATUS_ID,
                PROPERTY_POCKET_STATUS_ID_CREATED_KEY_TESTED)).thenReturn(PROPERTY_POCKET_STATUS_ID_CREATED_VALUE_TESTED);
        Mockito.when(enumMapper.getEnumValue(ENUM_FIELD_POCKET_STATUS_ID,
                PROPERTY_POCKET_STATUS_ID_DELETED_KEY_TESTED)).thenReturn(PROPERTY_POCKET_STATUS_ID_DELETED_VALUE_TESTED);
    }

    @Test
    public void mapInFull() throws IOException {

        InputListPocket dto = dummyMock.getDTOIntListPocket();
        FormatoBQM39E1 result = mapper.mapIn(dto);

        assertNotNull(result);
        assertEquals(dto.getAccountPocketNumber(), result.getNumcuen());
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_KEY_TESTED, result.getOpcion());
        assertEquals(dto.getPaginationKey(), result.getIdpagin());
        assertEquals(dto.getPageSize(), result.getTampagi());
    }

    @Test
    public void mapInWithoutAccountNumber() throws IOException {

        InputListPocket dto = dummyMock.getDTOIntListPocket();
        dto.setAccountPocketNumber(null);
        FormatoBQM39E1 result = mapper.mapIn(dto);

        assertNotNull(result);
        assertNull(result.getNumcuen());
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_KEY_TESTED, result.getOpcion());
        assertEquals(dto.getPaginationKey(), result.getIdpagin());
        assertEquals(dto.getPageSize(), result.getTampagi());
    }

    @Test
    public void mapInWithoutStatusId() throws IOException {

        InputListPocket dto = dummyMock.getDTOIntListPocket();
        dto.setStatusId(null);
        FormatoBQM39E1 result = mapper.mapIn(dto);

        assertNotNull(result);
        assertEquals(dto.getAccountPocketNumber(), result.getNumcuen());
        assertNull(result.getOpcion());
        assertEquals(dto.getPaginationKey(), result.getIdpagin());
        assertEquals(dto.getPageSize(), result.getTampagi());
    }

    @Test
    public void mapInEmpty() {
        InputListPocket dto = new InputListPocket();
        FormatoBQM39E1 result = mapper.mapIn(dto);

        assertNotNull(result);
        assertNull(result.getNumcuen());
        assertNull(result.getOpcion());
        assertNull(result.getIdpagin());
        assertNull(result.getTampagi());
    }

    @Test
    public void mapInWithoutPaginationKey() throws IOException {
        InputListPocket dto = dummyMock.getDTOIntListPocket();
        dto.setPaginationKey(null);

        FormatoBQM39E1 result = mapper.mapIn(dto);

        assertNotNull(result);
        assertEquals(dto.getAccountPocketNumber(), result.getNumcuen());
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_KEY_TESTED, result.getOpcion());
        assertNull(result.getIdpagin());
        assertEquals(dto.getPageSize(), result.getTampagi());
    }

    @Test
    public void mapInWithoutPageSize() throws IOException {

        InputListPocket dto = dummyMock.getDTOIntListPocket();
        dto.setPageSize(null);
        FormatoBQM39E1 result = mapper.mapIn(dto);

        assertNotNull(result);
        assertEquals(dto.getAccountPocketNumber(), result.getNumcuen());
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_KEY_TESTED, result.getOpcion());
        assertEquals(dto.getPaginationKey(), result.getIdpagin());
        assertNull(result.getTampagi());
    }

    @Test
    public void mapOutDataFull() {
        List<FormatoBQM39S1> formats = formatBq29Mock.getFormatoBQM39S1();
        DTOIntPocketsData dto = new DTOIntPocketsData();

        // ####Datos Completos con Mapeo Created
        FormatoBQM39S1 format = formats.get(0);

        dto = mapper.mapOutData(format, dto);

        assertNotNull(dto.getData());
        assertEquals(1, dto.getData().size());

        PocketV00 result = dto.getData().get(0);
        assertNotNull(result);

        assertEquals(format.getIdpoc(), result.getId());

        AccountPocket accountPocket = result.getAccountPocket();
        assertNotNull(accountPocket);
        assertEquals(format.getNumcuen(), accountPocket.getNumber());
        assertEquals(CONSTANT_SAVINGS, accountPocket.getAccountFamily().getId());

        assertEquals(format.getNomcor(), result.getShortName());

        GoalAmount goalAmount = result.getGoalAmount();
        assertNotNull(goalAmount);
        assertEquals(format.getMonpoc(), goalAmount.getValue());
        assertEquals(format.getMoneda(), goalAmount.getCurrency());

        assertEquals(format.getPripoc(), result.getPriority());

        assertNotNull(result.getGoalDate());

        CurrentAmount currentAmount = result.getCurrentAmount();
        assertNotNull(currentAmount);
        assertEquals(format.getAhopoc(), currentAmount.getValue());
        assertEquals(format.getMonaho(), currentAmount.getCurrency());

        Status status = result.getStatus();
        assertNotNull(status);
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_VALUE_TESTED, status.getId());
        assertEquals(format.getDesest(), status.getName());

        // ####Datos Completos con Mapeo Deleted
        format = formats.get(1);

        dto = mapper.mapOutData(format, dto);

        assertNotNull(dto.getData());
        assertEquals(2, dto.getData().size());

        result = dto.getData().get(1);
        assertNotNull(result);

        assertEquals(format.getIdpoc(), result.getId());

        accountPocket = result.getAccountPocket();
        assertNotNull(accountPocket);
        assertEquals(format.getNumcuen(), accountPocket.getNumber());
        assertEquals(CONSTANT_SAVINGS, accountPocket.getAccountFamily().getId());

        assertEquals(format.getNomcor(), result.getShortName());

        goalAmount = result.getGoalAmount();
        assertNotNull(goalAmount);
        assertEquals(format.getMonpoc(), goalAmount.getValue());
        assertEquals(format.getMoneda(), goalAmount.getCurrency());

        assertEquals(format.getPripoc(), result.getPriority());

        assertNotNull(result.getGoalDate());

        currentAmount = result.getCurrentAmount();
        assertNotNull(currentAmount);
        assertEquals(format.getAhopoc(), currentAmount.getValue());
        assertEquals(format.getMonaho(), currentAmount.getCurrency());

        status = result.getStatus();
        assertNotNull(status);
        assertEquals(PROPERTY_POCKET_STATUS_ID_DELETED_VALUE_TESTED, status.getId());
        assertEquals(format.getDesest(), status.getName());


        // ####Datos Nulos
        format = formats.get(2);

        dto = mapper.mapOutData(format, dto);

        assertNotNull(dto.getData());
        assertEquals(3, dto.getData().size());

        result = dto.getData().get(2);
        assertNotNull(result);

        assertNull(result.getId());

        accountPocket = result.getAccountPocket();
        assertNotNull(accountPocket);
        assertNull(accountPocket.getNumber());
        assertEquals(CONSTANT_SAVINGS, accountPocket.getAccountFamily().getId());

        assertNull(result.getShortName());

        goalAmount = result.getGoalAmount();
        assertNull(goalAmount);

        assertNull(result.getPriority());

        assertNull(result.getGoalDate());

        currentAmount = result.getCurrentAmount();
        assertNull(currentAmount);

        status = result.getStatus();
        assertNull(status);
    }

    @Test
    public void mapOutWithoutMonpoc() {
        List<FormatoBQM39S1> formats = formatBq29Mock.getFormatoBQM39S1();
        DTOIntPocketsData dto = new DTOIntPocketsData();

        // ####Datos Completos con Mapeo Created
        FormatoBQM39S1 format = formats.get(0);
        format.setMonpoc(null);

        dto = mapper.mapOutData(format, dto);

        assertNotNull(dto.getData());
        assertEquals(1, dto.getData().size());

        PocketV00 result = dto.getData().get(0);
        assertNotNull(result);

        assertEquals(format.getIdpoc(), result.getId());

        AccountPocket accountPocket = result.getAccountPocket();
        assertNotNull(accountPocket);
        assertEquals(format.getNumcuen(), accountPocket.getNumber());
        assertEquals(CONSTANT_SAVINGS, accountPocket.getAccountFamily().getId());

        assertEquals(format.getNomcor(), result.getShortName());

        GoalAmount goalAmount = result.getGoalAmount();
        assertNotNull(goalAmount);
        assertNull(goalAmount.getValue());
        assertEquals(format.getMoneda(), goalAmount.getCurrency());

        assertEquals(format.getPripoc(), result.getPriority());

        assertNotNull(result.getGoalDate());

        CurrentAmount currentAmount = result.getCurrentAmount();
        assertNotNull(currentAmount);
        assertEquals(format.getAhopoc(), currentAmount.getValue());
        assertEquals(format.getMonaho(), currentAmount.getCurrency());

        Status status = result.getStatus();
        assertNotNull(status);
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_VALUE_TESTED, status.getId());
        assertEquals(format.getDesest(), status.getName());

    }

    @Test
    public void mapOutWithoutMoneda() {
        List<FormatoBQM39S1> formats = formatBq29Mock.getFormatoBQM39S1();
        DTOIntPocketsData dto = new DTOIntPocketsData();

        // ####Datos Completos con Mapeo Created
        FormatoBQM39S1 format = formats.get(0);
        format.setMoneda(null);

        dto = mapper.mapOutData(format, dto);

        assertNotNull(dto.getData());
        assertEquals(1, dto.getData().size());

        PocketV00 result = dto.getData().get(0);
        assertNotNull(result);

        assertEquals(format.getIdpoc(), result.getId());

        AccountPocket accountPocket = result.getAccountPocket();
        assertNotNull(accountPocket);
        assertEquals(format.getNumcuen(), accountPocket.getNumber());
        assertEquals(CONSTANT_SAVINGS, accountPocket.getAccountFamily().getId());

        assertEquals(format.getNomcor(), result.getShortName());

        GoalAmount goalAmount = result.getGoalAmount();
        assertNotNull(goalAmount);
        assertEquals(format.getMonpoc(), goalAmount.getValue());
        assertNull(goalAmount.getCurrency());

        assertEquals(format.getPripoc(), result.getPriority());

        assertNotNull(result.getGoalDate());

        CurrentAmount currentAmount = result.getCurrentAmount();
        assertNotNull(currentAmount);
        assertEquals(format.getAhopoc(), currentAmount.getValue());
        assertEquals(format.getMonaho(), currentAmount.getCurrency());

        Status status = result.getStatus();
        assertNotNull(status);
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_VALUE_TESTED, status.getId());
        assertEquals(format.getDesest(), status.getName());

    }

    @Test
    public void mapOutWithoutAhopoc() {
        List<FormatoBQM39S1> formats = formatBq29Mock.getFormatoBQM39S1();
        DTOIntPocketsData dto = new DTOIntPocketsData();

        // ####Datos Completos con Mapeo Created
        FormatoBQM39S1 format = formats.get(0);
        format.setAhopoc(null);

        dto = mapper.mapOutData(format, dto);

        assertNotNull(dto.getData());
        assertEquals(1, dto.getData().size());

        PocketV00 result = dto.getData().get(0);
        assertNotNull(result);

        assertEquals(format.getIdpoc(), result.getId());

        AccountPocket accountPocket = result.getAccountPocket();
        assertNotNull(accountPocket);
        assertEquals(format.getNumcuen(), accountPocket.getNumber());
        assertEquals(CONSTANT_SAVINGS, accountPocket.getAccountFamily().getId());

        assertEquals(format.getNomcor(), result.getShortName());

        GoalAmount goalAmount = result.getGoalAmount();
        assertNotNull(goalAmount);
        assertEquals(format.getMonpoc(), goalAmount.getValue());
        assertEquals(format.getMoneda(), goalAmount.getCurrency());

        assertEquals(format.getPripoc(), result.getPriority());

        assertNotNull(result.getGoalDate());

        CurrentAmount currentAmount = result.getCurrentAmount();
        assertNotNull(currentAmount);
        assertNull(currentAmount.getValue());
        assertEquals(format.getMonaho(), currentAmount.getCurrency());

        Status status = result.getStatus();
        assertNotNull(status);
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_VALUE_TESTED, status.getId());
        assertEquals(format.getDesest(), status.getName());
    }

    @Test
    public void mapOutWithoutMonaho() {
        List<FormatoBQM39S1> formats = formatBq29Mock.getFormatoBQM39S1();
        DTOIntPocketsData dto = new DTOIntPocketsData();

        // ####Datos Completos con Mapeo Created
        FormatoBQM39S1 format = formats.get(0);
        format.setMonaho(null);

        dto = mapper.mapOutData(format, dto);

        assertNotNull(dto.getData());
        assertEquals(1, dto.getData().size());

        PocketV00 result = dto.getData().get(0);
        assertNotNull(result);

        assertEquals(format.getIdpoc(), result.getId());

        AccountPocket accountPocket = result.getAccountPocket();
        assertNotNull(accountPocket);
        assertEquals(format.getNumcuen(), accountPocket.getNumber());
        assertEquals(CONSTANT_SAVINGS, accountPocket.getAccountFamily().getId());

        assertEquals(format.getNomcor(), result.getShortName());

        GoalAmount goalAmount = result.getGoalAmount();
        assertNotNull(goalAmount);
        assertEquals(format.getMonpoc(), goalAmount.getValue());
        assertEquals(format.getMoneda(), goalAmount.getCurrency());

        assertEquals(format.getPripoc(), result.getPriority());

        assertNotNull(result.getGoalDate());

        CurrentAmount currentAmount = result.getCurrentAmount();
        assertNotNull(currentAmount);
        assertEquals(format.getAhopoc(), currentAmount.getValue());
        assertNull(currentAmount.getCurrency());

        Status status = result.getStatus();
        assertNotNull(status);
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_VALUE_TESTED, status.getId());
        assertEquals(format.getDesest(), status.getName());
    }

    @Test
    public void mapOutWithoutEstpoc() {
        List<FormatoBQM39S1> formats = formatBq29Mock.getFormatoBQM39S1();
        DTOIntPocketsData dto = new DTOIntPocketsData();

        // ####Datos Completos con Mapeo Created
        FormatoBQM39S1 format = formats.get(0);
        format.setEstpoc(null);

        dto = mapper.mapOutData(format, dto);

        assertNotNull(dto.getData());
        assertEquals(1, dto.getData().size());

        PocketV00 result = dto.getData().get(0);
        assertNotNull(result);

        assertEquals(format.getIdpoc(), result.getId());

        AccountPocket accountPocket = result.getAccountPocket();
        assertNotNull(accountPocket);
        assertEquals(format.getNumcuen(), accountPocket.getNumber());
        assertEquals(CONSTANT_SAVINGS, accountPocket.getAccountFamily().getId());

        assertEquals(format.getNomcor(), result.getShortName());

        GoalAmount goalAmount = result.getGoalAmount();
        assertNotNull(goalAmount);
        assertEquals(format.getMonpoc(), goalAmount.getValue());
        assertEquals(format.getMoneda(), goalAmount.getCurrency());

        assertEquals(format.getPripoc(), result.getPriority());

        assertNotNull(result.getGoalDate());

        CurrentAmount currentAmount = result.getCurrentAmount();
        assertNotNull(currentAmount);
        assertEquals(format.getAhopoc(), currentAmount.getValue());
        assertEquals(format.getMonaho(), currentAmount.getCurrency());

        Status status = result.getStatus();
        assertNotNull(status);
        assertNull(status.getId());
        assertEquals(format.getDesest(), status.getName());
    }

    @Test
    public void mapOutWithoutDesest() {
        List<FormatoBQM39S1> formats = formatBq29Mock.getFormatoBQM39S1();
        DTOIntPocketsData dto = new DTOIntPocketsData();

        // ####Datos Completos con Mapeo Created
        FormatoBQM39S1 format = formats.get(0);
        format.setDesest(null);

        dto = mapper.mapOutData(format, dto);

        assertNotNull(dto.getData());
        assertEquals(1, dto.getData().size());

        PocketV00 result = dto.getData().get(0);
        assertNotNull(result);

        assertEquals(format.getIdpoc(), result.getId());

        AccountPocket accountPocket = result.getAccountPocket();
        assertNotNull(accountPocket);
        assertEquals(format.getNumcuen(), accountPocket.getNumber());
        assertEquals(CONSTANT_SAVINGS, accountPocket.getAccountFamily().getId());

        assertEquals(format.getNomcor(), result.getShortName());

        GoalAmount goalAmount = result.getGoalAmount();
        assertNotNull(goalAmount);
        assertEquals(format.getMonpoc(), goalAmount.getValue());
        assertEquals(format.getMoneda(), goalAmount.getCurrency());

        assertEquals(format.getPripoc(), result.getPriority());

        assertNotNull(result.getGoalDate());

        CurrentAmount currentAmount = result.getCurrentAmount();
        assertNotNull(currentAmount);
        assertEquals(format.getAhopoc(), currentAmount.getValue());
        assertEquals(format.getMonaho(), currentAmount.getCurrency());

        Status status = result.getStatus();
        assertNotNull(status);
        assertEquals(PROPERTY_POCKET_STATUS_ID_CREATED_VALUE_TESTED, status.getId());
        assertNull(status.getName());
    }

    @Test
    public void mapOutPaginationFull() {
        FormatoBQM39P1 format = formatBq29Mock.getFormatoBQM39P1();

        DTOIntPocketsData result = new DTOIntPocketsData();
        result = mapper.mapOutPagination(format, result);

        assertNotNull(result.getPagination().getPaginationKey());
        assertNotNull(result.getPagination().getPageSize());

        assertEquals(format.getIdpagin(), result.getPagination().getPaginationKey());
        assertEquals(format.getTampagi().toString(), result.getPagination().getPageSize().toString());
    }

    @Test
    public void mapOutPaginationEmpty() {
        FormatoBQM39P1 format = new FormatoBQM39P1();

        DTOIntPocketsData result = new DTOIntPocketsData();
        result = mapper.mapOutPagination(format, result);

        assertNull(result.getPagination());
    }
}