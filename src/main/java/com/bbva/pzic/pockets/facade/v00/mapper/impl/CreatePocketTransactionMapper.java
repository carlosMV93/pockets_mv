package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntOperationType;
import com.bbva.pzic.pockets.business.dto.DTOIntTransaction;
import com.bbva.pzic.pockets.canonic.Transaction;
import com.bbva.pzic.pockets.facade.v00.mapper.ICreatePocketTransactionMapper;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("createPocketTransactionMapper")
public class CreatePocketTransactionMapper extends ConfigurableMapper implements ICreatePocketTransactionMapper {

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(Transaction.class, DTOIntTransaction.class)
                .field("amount.value", "amount.value")
                .field("amount.currency", "amount.currency")
                .register();
    }

    @Override
    public DTOIntTransaction mapIn(final String pocketId, final Transaction transaction) {
        final DTOIntTransaction input = map(transaction, DTOIntTransaction.class);
        input.setPocketId(pocketId);
        if (transaction.getOperationType() != null) {
            input.setOperationType(new DTOIntOperationType());
            input.getOperationType().setId(enumMapper.getBackendValue(
                    "transaction.operationType.id", transaction.getOperationType().getId()));
        }

        return input;
    }

    @Override
    public Transaction mapOut(final DTOIntTransaction dto) {
        final Transaction transaction = new Transaction();
        if (dto != null) {
            transaction.setId(dto.getId());
        }
        return transaction;
    }
}