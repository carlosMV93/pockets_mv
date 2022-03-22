package com.bbva.pzic.pockets;

import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.Contribution;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.canonic.Withdrawal;
import com.bbva.pzic.pockets.util.mappers.ObjectMapperHelper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author Entelgy
 */
public final class EntityMock {

    public static final String TSEC_MNET = "TDQxODg4ODc3OjEzMDAwMDEx";

    public static final String POCKET_ID_CYPHER = "NDg2MjMxMjY4ODc0MzQ2NT";
    public static final String POCKET_ID_ORIGINAL = "12512345678901234567843";
    public static final String RELATED_CONTRACT_ID_CYPHER = "NjYwMzE3NzE2MzM5Mjk3MTE2";
    public static final String RELATED_CONTRACT_ID_ORIGINAL = "123456789012345678";

    public final static String RELATED_CONTRACT_NUMBER = "q";

    public static final String ENUM_IN_PERIOD_FREQUENCY_ID = "FORTNIGHTLY";
    public static final String ENUM_IN_STATUS_ID = "CREATED";
    public static final String ENUM_IN_BALANCES_ID_AMOUNT = "CURRENT_AMOUNT";
    public static final String ENUM_IN_BALANCES_ID_PERCENTAGE = "CURRENT_PERCENTAGE";
    public static final String ENUM_IN_BALANCES_MODE_AMOUNT = "AMOUNT";
    public static final String ENUM_IN_BALANCES_MODE_PERCENTAGE = "PERCENTAGE";
    public static final String ENUM_IN_PRODUCT_TYPE_ID = "ACCOUNTS";
    public static final String ENUM_IN_NUMBER_TYPE_ID = "LIC";

    public static final String ENUM_OUT_PERIOD_FREQUENCY_ID = "FORTNIGHTLY";
    public static final String ENUM_OUT_STATUS_ID = "A";
    public static final String ENUM_OUT_BALANCES_ID_AMOUNT = "CURRENT_AMOUNT";
    public static final String ENUM_OUT_BALANCES_ID_PERCENTAGE = "CURRENT_PERCENTAGE";
    public static final String ENUM_OUT_BALANCES_MODE_AMOUNT = "AMOUNT";
    public static final String ENUM_OUT_BALANCES_MODE_PERCENTAGE = "PERCENTAGE";
    public static final String ENUM_OUT_PRODUCT_TYPE_ID = "A";
    public static final String ENUM_OUT_NUMBER_TYPE_ID = "L";
    public static final String ENUM_OUT_MONTHLY = "MONTHLY";
    public static final String ENUM_STATUS_ACTIVE = "ACTIVE";
    public static final String ENUM_STATUS_INACTIVE = "INACTIVE";
    public static final String ENUM_STATUS_ID = "CREATED";
    public static final String ENUM_STATUS_ID_CLOSED = "CLOSED";
    public static final String ENUM_PERIOD_FREQUENCY_ID_FORTNIGHTLY = "FORTNIGHTLY";
    public static final String ENUM_PERIOD_FREQUENCY_ID_MONTHLY = "MONTHLY";
    public static final String ENUM_PERIOD_FREQUENCY_ID_BIMONTHLY = "BIMONTHLY";

    public static final String PAGINATION_KEY = "vvvvvvvvvvvvvvvvvvvv";
    public static final Long PAGE_SIZE = 20L;

    public final static String POCKET_ID = "00110241029996285000001";

    private static final EntityMock INSTANCE = new EntityMock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private EntityMock() {
    }

    public static EntityMock getInstance() {
        return INSTANCE;
    }

    public InputListPockets getInputListPockets() {
        InputListPockets input = new InputListPockets();
        input.setRelatedContractNumber(RELATED_CONTRACT_NUMBER);
        input.setStatusId(ENUM_IN_STATUS_ID);

        DTOIntPagination pagination = new DTOIntPagination();
        pagination.setPageSize(PAGE_SIZE);
        pagination.setPaginationKey(PAGINATION_KEY);
        input.setPagination(pagination);
        return input;
    }

    public DTOIntOperations getDTOIntOperations() {
        DTOIntOperations dtoIntOperations = new DTOIntOperations();
        dtoIntOperations.setData(Collections.emptyList());
        return dtoIntOperations;
    }

    public InputListPocketRelatedContracts getInputListPocketRelatedContracts() {
        InputListPocketRelatedContracts input = new InputListPocketRelatedContracts();
        input.setPocketId(POCKET_ID_ORIGINAL);
        return input;
    }

    public InputCreatePocketRelatedContract getInputCreatePocketRelatedContract() throws IOException {
        InputCreatePocketRelatedContract input = new InputCreatePocketRelatedContract();
        input.setPocketId(POCKET_ID_ORIGINAL);
        input.setRelatedContract(objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "mock/relatedContract.json"), DTOIntRelatedContract.class));
        return input;
    }

    public InputDeletePocketRelatedContract getInputDeletePocketRelatedContract() {
        InputDeletePocketRelatedContract input = new InputDeletePocketRelatedContract();
        input.setPocketId(POCKET_ID_CYPHER);
        input.setRelatedContractId(RELATED_CONTRACT_ID_CYPHER);
        return input;
    }

    public InputListPocketOperations getInputListPocketOperations() {
        InputListPocketOperations input = new InputListPocketOperations();
        input.setPocketId(POCKET_ID_CYPHER);
        input.setPaginationKey(PAGINATION_KEY);
        input.setPageSize(PAGE_SIZE);
        return input;
    }

    public DTOIntPockets getDTOIntPockets() {
        DTOIntPockets dtoIntPockets = new DTOIntPockets();
        dtoIntPockets.setData(Collections.singletonList(new Pocket()));
        return dtoIntPockets;
    }

    public RelatedContract getRelatedContract() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "mock/relatedContract.json"), RelatedContract.class);
    }

    public InputCreatePocketWithdrawals getInputCreatePocketWithdrawals() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(
                        "mock/createPocketWithdrawals.json"), InputCreatePocketWithdrawals.class);
    }

    public InputCreatePocketContributions getInputCreatePocketContributions() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(
                        "mock/createPocketContributions.json"), InputCreatePocketContributions.class);
    }

    public InputCreatePocketLiquidate getInputCreatePocketLiquidate() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(
                        "mock/createPocketLiquidate.json"), InputCreatePocketLiquidate.class);
    }

    public Withdrawal getWithdrawal() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(
                        "mock/withdrawal.json"), Withdrawal.class);
    }

    public Contribution getContribution() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(
                        "mock/contribution.json"), Contribution.class);
    }


    public Pocket getRequestCreatePocketV2() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "mock/request_post_createPocketV2.json"), Pocket.class);
    }

    public Pocket getResponseCreatePocketV2() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "mock/response_post_createPocketV2.json"), Pocket.class);
    }

    public Pocket getResponseGetPocketV2() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "mock/response_get_getPocketV2.json"), Pocket.class);
    }

    public List<Pocket> getRequestModifyPocketV2() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "mock/request_patch_modifyPocketV2.json"), new TypeReference<List<Pocket>>() {
        });
    }

    public List<Pocket> getResponseModifyPocketV2() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "mock/response_patch_modifyPocketV2.json"), new TypeReference<List<Pocket>>() {
        });
    }

    public DTOIntPocketV2 getModifyPocketV2DtoInt() throws IOException {
        List<DTOIntPocketV2> dtoInt = objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/request_patch_modifyPocketV2.json"), new TypeReference<List<DTOIntPocketV2>>() {
        });
        return dtoInt.get(0);
    }
}
