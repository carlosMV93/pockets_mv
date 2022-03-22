package com.bbva.pzic.pockets.facade.v2.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.managers.OutputHeaderManager;
import com.bbva.jee.arq.spring.core.servicing.annotations.*;
import com.bbva.jee.arq.spring.core.servicing.annotations.PATCH;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.bbva.pzic.pockets.business.ISrvIntPockets;
import com.bbva.pzic.pockets.business.dto.DTOIntOperations;
import com.bbva.pzic.pockets.business.dto.DTOIntPockets;
import com.bbva.pzic.pockets.canonic.*;
import com.bbva.pzic.pockets.facade.v2.ISrvPocketsV2;
import com.bbva.pzic.pockets.facade.v2.mapper.*;
import com.bbva.pzic.pockets.util.BusinessServiceUtil;
import com.bbva.pzic.pockets.util.mappers.PaginationMapper;
import com.bbva.pzic.routine.processing.data.DataProcessingExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bbva.pzic.pockets.facade.RegistryIds.*;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@Path("/v2")
@Produces(MediaType.APPLICATION_JSON)
@SN(registryID = "SNPE1800086", logicalID = "pockets")
@VN(vnn = "v2")
@Service
public class SrvPocketsV2 implements ISrvPocketsV2, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

    private static final Log LOG = LogFactory.getLog(SrvPocketsV2.class);

    public HttpHeaders httpHeaders;
    public UriInfo uriInfo;
    private OutputHeaderManager outputHeaderManager;

    @Autowired
    private BusinessServicesToolKit businessServicesToolKit;
    @Autowired
    private ISrvIntPockets srvIntPockets;
    @Autowired
    private IListPocketsMapper listPocketsMapper;
    @Autowired
    private IListPocketRelatedContractsMapper listPocketRelatedContractsMapper;
    @Autowired
    private ICreatePocketRelatedContractMapper createPocketRelatedContractMapper;
    @Autowired
    private IDeletePocketRelatedContractMapper deletePocketRelatedContractMapper;
    @Autowired
    private IListPocketOperationsMapper listPocketOperationsMapper;
    @Autowired
    private ICreatePocketWithdrawalsMapper createPocketWithdrawalsMapper;
    @Autowired
    private ICreatePocketContributionsMapper createPocketContributionsMapper;
    @Autowired
    private ICreatePocketLiquidateMapper createPocketLiquidateMapper;
    @Resource(name = "createPocketMapperV2")
    private ICreatePocketMapper createPocketMapper;
    @Autowired
    private IGetPocketMapper getPocketMapper;
    @Autowired
    private IModifyPocketMapper modifyPocketMapper;

    @Autowired
    private DataProcessingExecutor inputDataProcessingExecutor;
    @Autowired
    private DataProcessingExecutor outputDataProcessingExecutor;

    @Override
    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @Override
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    @Autowired
    public void setOutputHeaderManager(OutputHeaderManager outputHeaderManager) {
        this.outputHeaderManager = outputHeaderManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @GET
    @Path("/pockets")
    @SMC(registryID = SMC_REGISTRY_ID_OF_LIST_POCKETS, logicalID = "listPockets", forcedCatalog = "asoCatalog")
    public Pockets listPockets(
            @QueryParam("relatedContract.number") @CasContract final String relatedContractNumber,
            @QueryParam("status.id") final String statusId,
            @QueryParam("paginationKey") final String paginationKey,
            @QueryParam("pageSize") final Long pageSize) {
        LOG.info("----- Invoking service listPockets -----");

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("relatedContract.number", relatedContractNumber);
        queryParams.put("status.id", statusId);
        queryParams.put("paginationKey", paginationKey);
        queryParams.put("pageSize", pageSize);

        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_LIST_POCKETS, null, null, queryParams);

        DTOIntPockets dtoInt = srvIntPockets.listPockets(
                listPocketsMapper.mapIn(
                        BusinessServiceUtil.toString(queryParams.get("relatedContract.number")),
                        BusinessServiceUtil.toString(queryParams.get("status.id")),
                        BusinessServiceUtil.toString(queryParams.get("paginationKey")),
                        BusinessServiceUtil.toLong(queryParams.get("pageSize"))));

        Pockets pockets = listPocketsMapper.mapOut(dtoInt);

        if (pockets == null) {
            return null;
        }

        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_LIST_POCKETS, pockets, null, queryParams);

        if (dtoInt.getPagination() == null) {
            return pockets;
        }
        pockets.setPagination(PaginationMapper.build(businessServicesToolKit.getPaginationBuider()
                .setPagination(SrvPocketsV2.class, "listPockets", uriInfo,
                        dtoInt.getPagination().getPaginationKey(), null,
                        dtoInt.getPagination().getPageSize(), null, null,
                        null, null).build()));
        return pockets;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @GET
    @Path("/pockets/{pocket-id}/related-contracts")
    @SMC(registryID = SMC_REGISTRY_ID_OF_LIST_POCKET_RELATED_CONTRACTS, logicalID = "listPocketRelatedContracts")
    public ServiceResponse<List<RelatedContracts>> listPocketRelatedContracts(
            @PathParam(POCKET_ID) final String pocketId) {
        LOG.info("----- Invoking service listPocketRelatedContracts -----");
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put(POCKET_ID, pocketId);
        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_LIST_POCKET_RELATED_CONTRACTS, null, pathParams, null);
        ServiceResponse<List<RelatedContracts>> response = listPocketRelatedContractsMapper.mapOut(
                srvIntPockets.listPocketRelatedContracts(
                        listPocketRelatedContractsMapper.mapIn((String) pathParams.get(POCKET_ID))));
        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_LIST_POCKET_RELATED_CONTRACTS, response, pathParams, null);
        return response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @POST
    @Path("/pockets/{pocket-id}/related-contracts")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = SMC_REGISTRY_ID_OF_CREATE_POCKET_RELATED_CONTRACT, logicalID = "createPocketRelatedContract", forcedCatalog = "gabiCatalog")
    public ServiceResponse<RelatedContractId> createPocketRelatedContract(
            @PathParam(POCKET_ID) final String pocketId,
            final RelatedContract relatedContract) {
        LOG.info("----- Invoking service createPocketRelatedContract -----");
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put(POCKET_ID, pocketId);
        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET_RELATED_CONTRACT, relatedContract, pathParams, null);
        ServiceResponse<RelatedContractId> response = createPocketRelatedContractMapper.mapOut(
                srvIntPockets.createPocketRelatedContract(
                        createPocketRelatedContractMapper.mapIn((String) pathParams.get(POCKET_ID), relatedContract)));
        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET_RELATED_CONTRACT, response, pathParams, null);
        return response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DELETE
    @Path("/pockets/{pocket-id}/related-contracts/{related-contract-id}")
    @SMC(registryID = SMC_REGISTRY_ID_OF_DELETE_POCKET_RELATED_CONTRACT, logicalID = "deletePocketRelatedContract")
    public Response deletePocketRelatedContract(
            @PathParam(POCKET_ID) final String pocketId,
            @PathParam(RELATED_CONTRACT_ID) final String relatedContractId) {
        LOG.info("----- Invoking service deletePocketRelatedContract -----");
        srvIntPockets.deletePocketRelatedContract(
                deletePocketRelatedContractMapper.mapIn(pocketId, relatedContractId));
        return Response.ok().build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @GET
    @Path("/pockets/{pocket-id}/operations")
    @SMC(registryID = SMC_REGISTRY_ID_OF_LIST_POCKETS_OPERATIONS, logicalID = "listPocketOperations", forcedCatalog = "asoCatalog")
    public Operations listPocketOperations(
            @PathParam(POCKET_ID) final String pocketId,
            @QueryParam(PAGINATION_KEY) final String paginationKey,
            @QueryParam(PAGE_SIZE) final Long pageSize) {
        LOG.info("----- Invoking service listPocketOperations -----");

        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put(POCKET_ID, pocketId);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put(PAGINATION_KEY, paginationKey);
        queryParams.put(PAGE_SIZE, pageSize);

        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_LIST_POCKETS_OPERATIONS, null, pathParams, queryParams);

        DTOIntOperations dtoInt = srvIntPockets.listPocketOperations(
                listPocketOperationsMapper.mapIn(
                        pathParams.get(POCKET_ID).toString(),
                        BusinessServiceUtil.toString(queryParams.get(PAGINATION_KEY)),
                        BusinessServiceUtil.toLong(queryParams.get(PAGE_SIZE))));

        Operations operations = listPocketOperationsMapper.mapOut(dtoInt);
        if (operations == null) {
            return null;
        }

        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_LIST_POCKETS_OPERATIONS, operations, pathParams, queryParams);

        if (dtoInt.getPagination() == null) {
            return operations;
        }
        operations.setPagination(PaginationMapper.build(businessServicesToolKit
                .getPaginationBuider()
                .setPagination(SrvPocketsV2.class, "listPocketOperations",
                        uriInfo,
                        dtoInt.getPagination().getPaginationKey(),
                        null, dtoInt.getPagination().getPageSize(),
                        null, null, null, null).build()));
        return operations;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @POST
    @Path("/pockets/{pocket-id}/withdrawals")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = SMC_REGISTRY_ID_OF_CREATE_POCKET_WITHDRAWALS, logicalID = "createPocketWithdrawals", forcedCatalog = "asoCatalog")
    public ServiceResponse<Withdrawal> createPocketWithdrawals(@PathParam(POCKET_ID) final String pocketId,
                                                               final Withdrawal withdrawal) {
        LOG.info("----- Invoking service createPocketWithdrawals -----");

        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put(POCKET_ID, pocketId);

        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET_WITHDRAWALS, withdrawal, pathParams, null);

        ServiceResponse<Withdrawal> withdrawalData = createPocketWithdrawalsMapper.mapOut(
                srvIntPockets.createPocketWithdrawals(
                        createPocketWithdrawalsMapper.mapIn(
                                pathParams.get(POCKET_ID).toString(), withdrawal)));

        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET_WITHDRAWALS, withdrawalData, pathParams, null);

        return withdrawalData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @POST
    @Path("/pockets/{pocket-id}/contributions")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = SMC_REGISTRY_ID_OF_CREATE_POCKET_CONTRIBUTIONS, logicalID = "createPocketContributions", forcedCatalog = "asoCatalog")
    public ServiceResponse<Contribution> createPocketContributions(@PathParam(POCKET_ID) final String pocketId,
                                                                   final Contribution contribution) {
        LOG.info("----- Invoking service createPocketContributions -----");

        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put(POCKET_ID, pocketId);

        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET_CONTRIBUTIONS, contribution, pathParams, null);

        ServiceResponse<Contribution> contributionData = createPocketContributionsMapper.mapOut(
                srvIntPockets.createPocketContributions(
                        createPocketContributionsMapper.mapIn(
                                pathParams.get(POCKET_ID).toString(), contribution)));

        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET_CONTRIBUTIONS, contributionData, pathParams, null);

        return contributionData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @POST
    @Path("/pockets/{pocket-id}/liquidate")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMCPE1810348", logicalID = "createPocketLiquidate", forcedCatalog = "asoCatalog")
    public ServiceResponse<Liquidate> createPocketLiquidate(@PathParam(POCKET_ID) final String pocketId) {
        LOG.info("----- Invoking service createPocketLiquidate -----");

        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put(POCKET_ID, pocketId);

       // inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET_LIQUIDATE, null, pathParams, null);

        ServiceResponse<Liquidate> liquidateData = createPocketLiquidateMapper.mapOut(
                srvIntPockets.createPocketLiquidate(
                        createPocketLiquidateMapper.mapIn((String) pathParams.get(POCKET_ID))));

        // outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET_LIQUIDATE, liquidateData, pathParams, null);

        return liquidateData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @POST
    @Path("/pockets")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = SMC_REGISTRY_ID_OF_CREATE_POCKET, logicalID = "createPocket", forcedCatalog = "asoCatalog")
    public ServiceResponse<Pocket> createPocket(final Pocket pocket) {
        LOG.info("----- Invoking service createPocket -----");

        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET, pocket, null, null);

        ServiceResponse<Pocket> pocketData = createPocketMapper.mapOut(
                srvIntPockets.createPocket(
                        createPocketMapper.mapIn(pocket)));

        if (pocketData != null && pocketData.getData() != null && pocketData.getData().getId() != null) {
            outputHeaderManager.setLocationHeader(pocketData.getData().getId());
        }

        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_POCKET, pocketData, null, null);

        return pocketData;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @GET
    @Path("/pockets/{pocket-id}")
    @SMC(registryID = SMC_REGISTRY_ID_OF_GET_POCKET, logicalID = "getPocket", forcedCatalog = "asoCatalog")
    public ServiceResponse<Pocket> getPocket(
            @PathParam(POCKET_ID) final String pocketId) {
        LOG.info("----- Invoking service getPocket -----");

        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put(POCKET_ID, pocketId);

        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_GET_POCKET, null, pathParams, null);

        ServiceResponse<Pocket> pocketData = getPocketMapper.mapOut(
                srvIntPockets.getPocket(
                        getPocketMapper.mapIn(pathParams.get(POCKET_ID).toString())));

        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_GET_POCKET, pocketData, pathParams, null);

        return pocketData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PATCH
    @Path("pockets")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = SMC_REGISTRY_ID_OF_MODIFY_POCKETS, logicalID = "modifyPocket", forcedCatalog = "asoCatalog")
    public ServiceResponse<List<Pocket>> modifyPocket(final List<Pocket> pockets) {
        LOG.info("----- Invoking service modifyPocket -----");

        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_MODIFY_POCKETS, pockets, null, null);

        ServiceResponse<List<Pocket>> pocketsData = modifyPocketMapper.mapOut(
                srvIntPockets.modifyPocket(
                        modifyPocketMapper.mapIn(pockets)));

        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_MODIFY_POCKETS, pocketsData, null, null);

        return pocketsData;
    }

}
