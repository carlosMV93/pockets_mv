package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntPagination;
import com.bbva.pzic.pockets.business.dto.DTOOutPocketTransactions;
import com.bbva.pzic.pockets.business.dto.InputListPocketTransactions;
import com.bbva.pzic.pockets.canonic.Amount;
import com.bbva.pzic.pockets.canonic.OperationType;
import com.bbva.pzic.pockets.canonic.Transaction;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44E1;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44P1;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketTransactionsMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;

import java.util.ArrayList;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("txListPocketTransactionsMapper")
public class TxListPocketTransactionsMapper implements ITxListPocketTransactionsMapper {

    @Override
    public FormatoBQM44E1 mapIn(InputListPocketTransactions dtoIn) {
        FormatoBQM44E1 formatoBQM44E1 = new FormatoBQM44E1();
        formatoBQM44E1.setIdpoc(dtoIn.getPocketId());

        if (dtoIn.getPagination() != null) {
            formatoBQM44E1.setIdpagin(dtoIn.getPagination().getPaginationKey());
            formatoBQM44E1.setTampagi(dtoIn.getPagination().getPageSize() == null ? null : dtoIn.getPagination().getPageSize().intValue());
        }
        return formatoBQM44E1;
    }

    @Override
    public DTOOutPocketTransactions mapOut(final FormatoBQM44S1 formatOutput, final DTOOutPocketTransactions dtoOut) {
        DTOOutPocketTransactions dto = dtoOut;
        if (dto == null) {
            dto = new DTOOutPocketTransactions();
        }
        if (dto.getData() == null) {
            dto.setData(new ArrayList<Transaction>());
        }

        Transaction transaction = new Transaction();
        transaction.setId(formatOutput.getNumope());
        transaction.setAdditionalInformation(formatOutput.getDetmov());
        transaction.setCreationDate(formatOutput.getFechmov());

        OperationType operationType = new OperationType();
        operationType.setId(formatOutput.getTipope());
        operationType.setName(formatOutput.getDestipo());
        transaction.setOperationType(operationType);

        Amount amount = new Amount();
        amount.setValue(formatOutput.getMonmov());
        amount.setCurrency(formatOutput.getMoneda());
        transaction.setAmount(amount);

        dto.getData().add(transaction);
        return dto;
    }

    @Override
    public DTOOutPocketTransactions mapOut2(final FormatoBQM44P1 formatOutput, final DTOOutPocketTransactions dtoOut) {
        DTOOutPocketTransactions dto = dtoOut;
        if (dto == null) {
            dto = new DTOOutPocketTransactions();
        }

        DTOIntPagination pagination = new DTOIntPagination();
        pagination.setPaginationKey(formatOutput.getIdpagin());
        if (formatOutput.getTampagi() != null) {
            pagination.setPageSize(formatOutput.getTampagi().longValue());
        }
        dto.setPagination(pagination);

        return dto;
    }
}