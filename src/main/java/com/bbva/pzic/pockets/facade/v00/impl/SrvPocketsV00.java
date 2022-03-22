package com.bbva.pzic.pockets.facade.v00.impl;

import com.bbva.jee.arq.spring.core.servicing.annotations.PATCH;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.bbva.pzic.pockets.business.ISrvIntPocketsV00;
import com.bbva.pzic.pockets.business.dto.DTOIntPocketsData;
import com.bbva.pzic.pockets.business.dto.DTOIntTransaction;
import com.bbva.pzic.pockets.business.dto.DTOOutPocketTransactions;
import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.*;
import com.bbva.pzic.pockets.facade.v00.ISrvPocketsV00;
import com.bbva.pzic.pockets.facade.v00.mapper.*;
import com.bbva.pzic.pockets.util.mappers.PaginationMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Path("/V00")
@SN(registryID = "SNPE1700018", logicalID = "pockets")
@VN(vnn = "V00")
@Produces(MediaType.APPLICATION_JSON)
@Service
public class SrvPocketsV00 implements ISrvPocketsV00, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

    private static final Log LOG = LogFactory.getLog(SrvPocketsV00.class);

    public HttpHeaders httpHeaders;
    public UriInfo uriInfo;

    @Resource(name = "srvIntPocketsV00")
    private ISrvIntPocketsV00 srvIntPockets;

    @Resource(name = "createPocketMapper")
    private ICreatePocketMapper createPocketMapper;

    @Resource(name = "modifyPocketMapper")
    private IModifyPocketMapper modifyPocketMapper;

    @Resource(name = "deletePocketMapper")
    private IDeletePocketMapper deletePocketMapper;

    @Resource(name = "listPocketsV00Mapper")
    private IListPocketsMapper listPocketsMapper;

    @Resource(name = "getPocketMapper")
    private IGetPocketMapper getPocketMapper;

    @Resource(name = "createPocketTransactionMapper")
    private ICreatePocketTransactionMapper createPocketTransactionMapper;

    @Resource(name = "listPocketTransactionsMapper")
    private IListPocketTransactionsMapper listPocketTransactionsMapper;

    @Autowired
    private BusinessServicesToolKit businessToolKit;

    @Override
    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @Override
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    /**
     * @see com.bbva.pzic.pockets.facade.v00.ISrvPocketsV00#createPocket(PocketV00)
     */
    @Override
    @POST
    @Path("/pockets")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMCPE1720041", logicalID = "createPocket")
    public Response createPocket(PocketV00 pocket) {
        PocketV00 response = srvIntPockets.createPocket(createPocketMapper.mapIn(pocket));
        if (response != null && response.getId() != null) {
            // pocket header response
            URI uriOfCreatedResource = UriBuilder.fromPath(uriInfo.getPath())
                    .path("/{pocket-id}")
                    .build(response.getId());

            return Response
                    .created(uriOfCreatedResource)
                    .contentLocation(uriOfCreatedResource)
                    .status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    @PATCH
    @Path("/pockets/{pocket-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMCPE1720042", logicalID = "modifyPocket")
    public Response modifyPocket(@PathParam(POCKET_ID) final String pocketId, final PocketV00 pocket) {

        LOG.info("------ SrvPocketsV01.modifyPocket ------");
        srvIntPockets.modifyPocket(modifyPocketMapper.mapIn(pocketId, pocket));
        return Response.ok().build();
    }

    @Override
    @DELETE
    @Path("/pockets/{pocket-id}")
    @SMC(registryID = "SMCPE1720043", logicalID = "deletePocket")
    public Response deletePocket(@PathParam(POCKET_ID) final String pocketId) {
        LOG.info("------ SrvPocketsV01.deletePocket ------");
        srvIntPockets.deletePocket(deletePocketMapper.mapIn(pocketId));
        return Response.ok().build();
    }

    @Override
    @GET
    @Path("/pockets")
    @SMC(registryID = "SMCPE1720044", logicalID = "listPockets")
    public Response listPockets(@QueryParam(ACCOUNT_POCKET_NUMBER) final String accountPocketNumber,
                                @QueryParam(STATUS_ID) final String statusId,
                                @QueryParam(PAGINATION_KEY) final String paginationKey,
                                @QueryParam(PAGE_SIZE) final Integer pageSize) {
        DTOIntPocketsData dto = srvIntPockets.listPockets(listPocketsMapper.mapIn(accountPocketNumber, statusId, paginationKey, pageSize));

        PocketsV00 pockets = listPocketsMapper.mapOut(dto);
        if (pockets == null) {
            return Response.noContent().build();
        }

        if (dto.getPagination() == null) {
            return Response.ok(pockets).build();
        }

        pockets.setPagination(PaginationMapper.build(
                businessToolKit.getPaginationBuider()
                        .setPagination(SrvPocketsV00.class, "listPockets", uriInfo,
                                dto.getPagination().getPaginationKey(), null,
                                dto.getPagination().getPageSize(), null,
                                null, null, null).build()
        ));
        return Response.ok(pockets).status(206).build();
    }

    @Override
    @GET
    @Path("/pockets/{pocket-id}")
    @SMC(registryID = "SMCPE1720045", logicalID = "getPocket")
    public Response getPocket(@PathParam(POCKET_ID) final String pocketId) {
        PathParamPocketId input = getPocketMapper.mapIn(pocketId);
        PocketData data = srvIntPockets.getPocket(input);
        if (data == null || data.getData() == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(data).build();
    }

    @Override
    @POST
    @Path("/pockets/{pocket-id}/transactions")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMCPE1720046", logicalID = "createPocketTransaction")
    public Response createPocketTransaction(@PathParam(POCKET_ID) final String pocketId,
                                            final Transaction payload) {
        DTOIntTransaction dto = srvIntPockets.createPocketTransaction(createPocketTransactionMapper.mapIn(pocketId, payload));
        Transaction response = createPocketTransactionMapper.mapOut(dto);

        if (response.getId() != null) {
            // transaction header response
            URI uriOfCreatedResource = UriBuilder.fromPath(uriInfo.getPath())
                    .path("/{transaction-id}")
                    .build(response.getId());

            return Response
                    .created(uriOfCreatedResource)
                    .contentLocation(uriOfCreatedResource)
                    .status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    @GET
    @Path("/pockets/{pocket-id}/transactions")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMCPE1720047", logicalID = "listPocketTransactions")
    public Response listPocketTransactions(@PathParam(POCKET_ID) final String pocketId,
                                           @QueryParam(PAGINATION_KEY) final String paginationKey,
                                           @QueryParam(PAGE_SIZE) final Long pageSize) {

        DTOOutPocketTransactions dto = srvIntPockets.listPocketTransactions(listPocketTransactionsMapper.mapIn(pocketId, paginationKey, pageSize));
        Transactions transactions = listPocketTransactionsMapper.mapOut(dto);

        if (transactions == null) {
            return Response.noContent().build();
        }

        if (dto.getPagination() == null) {
            return Response.ok(transactions).build();
        }

        transactions.setPagination(PaginationMapper.build(
                businessToolKit.getPaginationBuider()
                        .setPagination(SrvPocketsV00.class, "listPocketTransactions", uriInfo,
                                dto.getPagination().getPaginationKey(), null,
                                dto.getPagination().getPageSize(), null,
                                null, null, null).build()
        ));

        return Response.ok(transactions).status(206).build();
    }
}