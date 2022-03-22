package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketWithdrawals;
import com.bbva.pzic.pockets.canonic.Withdrawal;
import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79E1;
import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketWithdrawalsMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.commons.utils.DateUtils;

import java.text.ParseException;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@Mapper
public class TxCreatePocketWithdrawalsMapper extends ConfigurableMapper implements ITxCreatePocketWithdrawalsMapper {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoBQM79E1 mapIn(final InputCreatePocketWithdrawals dtoIn) {
        return map(dtoIn, FormatoBQM79E1.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Withdrawal mapOut(final FormatoBQM79S1 formatOutput) {
        Withdrawal withdrawal = map(formatOutput, Withdrawal.class);
        if (formatOutput.getFechope() != null && formatOutput.getHoraope() != null) {
            try {
                withdrawal.setOperationDate(DateUtils.toDateTime(formatOutput.getFechope(), formatOutput.getHoraope()));
            } catch (ParseException e) {
                throw new BusinessServiceException("wrongDate", e);
            }
        }
        return withdrawal;
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(InputCreatePocketWithdrawals.class,
                FormatoBQM79E1.class).field("pocketId", "idpoc")
                .field("withdrawal.withdrawalAmount.amount", "importe")
                .field("withdrawal.withdrawalAmount.currency", "moneda")
                .register();

        factory.classMap(FormatoBQM79S1.class, Withdrawal.class)
                .field("importe", "withdrawalAmount.amount")
                .field("moneda", "withdrawalAmount.currency")
                .field("numope", "operationNumber")
                .register();
    }
}