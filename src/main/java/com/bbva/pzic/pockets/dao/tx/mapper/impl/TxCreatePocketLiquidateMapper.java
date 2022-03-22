package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketLiquidate;
import com.bbva.pzic.pockets.canonic.Liquidate;
import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80E1;
import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketLiquidateMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.DateToStringConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.commons.utils.DateUtils;

import java.text.ParseException;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@Mapper
public class TxCreatePocketLiquidateMapper extends ConfigurableMapper implements ITxCreatePocketLiquidateMapper {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoBQM80E1 mapIn(final InputCreatePocketLiquidate dtoIn) {
        return map(dtoIn, FormatoBQM80E1.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Liquidate mapOut(final FormatoBQM80S1 formatOutput) {
        Liquidate liquidate = map(formatOutput, Liquidate.class);
        if (formatOutput.getFechope() != null && formatOutput.getHoraope() != null) {
            try {
                liquidate.setOperationDate(DateUtils.toDateTime(formatOutput.getFechope(), formatOutput.getHoraope()));
            } catch (ParseException e) {
                throw new BusinessServiceException("wrongDate", e);
            }
        }
        return liquidate;
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.getConverterFactory().registerConverter(new DateToStringConverter(DateToStringConverter.DateFormatsBBVA.SHORT_FORMAT));
        factory.classMap(InputCreatePocketLiquidate.class, FormatoBQM80E1.class)
                .field("pocketId", "idpoc")
                .register();

        factory.classMap(FormatoBQM80S1.class, Liquidate.class)
                .field("numope", "operationNumber")
                .field("importe", "currentAmount.amount")
                .field("moneda", "currentAmount.currency")
                .register();
    }
}