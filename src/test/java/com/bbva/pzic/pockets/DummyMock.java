package com.bbva.pzic.pockets;

import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.canonic.Transaction;
import com.bbva.pzic.pockets.util.mappers.ObjectMapperHelper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Component
public class DummyMock {

    public static final String POCKET_ID = "00110241029996285000001";
    public static final String POCKET_ID_WRONG_SIZE = "001102410299962850000017";
    public static final String POCKET_NAME_WRONG_SIZE = "VIAJE PARIS 0123456789012345678901234567890123456789012345678";
    public static final String POCKET_SHORT_NAME_WRONG_SIZE = "VP 012345678901234567";
    public static final BigDecimal POCKET_GOAL_AMOUNT_VALUE_WRONG_SIZE = new BigDecimal("1234567890123.000");
    public static final String POCKET_GOAL_AMOUNT_CURRENCY_WRONG_SIZE = "USD1";
    public static final Integer POCKET_PRIORITY_WRONG_SIZE = 1234;
    public static final BigDecimal POCKET_AUTOMATIC_AMOUNT_VALUE_WRONG_SIZE = new BigDecimal("1234567890123.000");
    public static final String POCKET_AUTOMATIC_AMOUNT_CURRENCY_WRONG_SIZE = "USD2";
    public static final String POCKET_AUTOMATIC_AMOUNT_DAYMONTH_WRONG_SIZE = "100";
    public static final String STATUS_ID = "CREATED";
    public static final String PERIOD_ID = "MONTHLY";
    public static final String ACCOUNT_POCKET_NUMBER = "001102410299962850";
    public static final String PAGINATION_KEY = "abcdef1234";
    public static final Integer PAGE_SIZE = 123;
    public static final String PROPERTY_POCKET_STATUS_ID_CREATED_VALUE_TESTED = "CREATED";
    public static final String PROPERTY_POCKET_STATUS_ID_CREATED_KEY_TESTED = "A";
    public static final String PROPERTY_POCKET_STATUS_ID_DELETED_VALUE_TESTED = "DELETED";
    public static final String PROPERTY_POCKET_STATUS_ID_DELETED_KEY_TESTED = "B";

    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    public DummyMock() {
    }

    public PocketV00 getPocket() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/request_post_createPocket.json"), PocketV00.class);
    }

    public PathParamPocketId getPathParamPocketId() {
        PathParamPocketId input = new PathParamPocketId();
        input.setPocketId(POCKET_ID);
        return input;
    }

    public InputCreatePocket getInputCreatePocket() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/InputCreatePocket.json"), InputCreatePocket.class);
    }

    public InputListPocket getDTOIntListPocket() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/dtoIntListPocket.json"), InputListPocket.class);
    }

    public DTOIntPocketsData getDTOIntPocketsData() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/dtoIntPocketsData.json"), DTOIntPocketsData.class);
    }

    public PocketV00 getModifyPocketPayload() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/request_patch_modifyPocket.json"), PocketV00.class);
    }

    public DTOIntPocket getModifyPocketDtoInt() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/modify_pocket_dto_int.json"), DTOIntPocket.class);
    }

    public Transaction getCreatedPocketTransaction() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/request_post_createPocketTransaction.json"), Transaction.class);
    }

    public DTOIntTransaction getDTOIntPocketTransaction() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/request_post_createPocketTransaction.json"), DTOIntTransaction.class);
    }

    public DTOIntTransaction getDTOOutPocketTransaction() {
        DTOIntTransaction dto = new DTOIntTransaction();
        dto.setId(1234567);
        return dto;
    }

    public InputListPocketTransactions getDTOInputListPocketTransactions() {
        InputListPocketTransactions dtoIn = new InputListPocketTransactions();
        dtoIn.setPocketId(POCKET_ID);

        DTOIntPagination pagination = new DTOIntPagination();
        pagination.setPageSize(PAGE_SIZE.longValue());
        pagination.setPaginationKey(PAGINATION_KEY);

        dtoIn.setPagination(pagination);
        return dtoIn;
    }

    public DTOOutPocketTransactions getDTOOutListPocketTransactions() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/listPocketTransactions.json"), DTOOutPocketTransactions.class);
    }

    public DTOIntPocket getCreatePocketV2DtoInt() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/request_post_createPocketV2.json"), DTOIntPocket.class);
    }
}
