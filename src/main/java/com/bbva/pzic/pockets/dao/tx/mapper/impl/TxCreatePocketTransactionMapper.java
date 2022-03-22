package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntTransaction;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41E1;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketTransactionMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("txCreatePocketTransactionMapper")
public class TxCreatePocketTransactionMapper
        implements
        ITxCreatePocketTransactionMapper {

    @Override
    public FormatoBQM41E1 mapIn(DTOIntTransaction dtoIn) {
        final FormatoBQM41E1 input = new FormatoBQM41E1();
        input.setIdpoc(dtoIn.getPocketId());
        input.setTipope(dtoIn.getOperationType().getId());
        input.setImporte(dtoIn.getAmount().getValue());
        input.setMoneda(dtoIn.getAmount().getCurrency());

        return input;
    }

    /**
     * @see com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketTransactionMapper#mapOut(com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41S1)
     */
    @Override
    public DTOIntTransaction mapOut(FormatoBQM41S1 formatOutput) {
        if (formatOutput == null) {
            return null;
        }
        DTOIntTransaction transaction = new DTOIntTransaction();
        transaction.setId(formatOutput.getNumope());
        return transaction;
    }
}