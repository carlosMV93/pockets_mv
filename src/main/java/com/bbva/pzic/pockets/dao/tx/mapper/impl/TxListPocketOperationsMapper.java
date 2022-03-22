package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntOperations;
import com.bbva.pzic.pockets.business.dto.InputListPocketOperations;
import com.bbva.pzic.pockets.canonic.Operation;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ750;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ751;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ752;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketOperationsMapper;
import com.bbva.pzic.pockets.util.FunctionUtils;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.LongToIntegerConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static com.bbva.pzic.pockets.util.Constants.DEFAULT_TIME;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@Mapper
public class TxListPocketOperationsMapper extends ConfigurableMapper implements ITxListPocketOperationsMapper {

    private Translator translator;

    @Autowired
    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.getConverterFactory().registerConverter(new LongToIntegerConverter());

        factory.classMap(InputListPocketOperations.class, FormatoBGMQ750.class)
                .field("pocketId", "idepock")
                .field("paginationKey", "idpagin")
                .field("pageSize", "tampagi")
                .register();

        factory.classMap(FormatoBGMQ751.class, Operation.class)
                .field("numeope", "id")
                .field("detmovi", "additionalInformation")
                .field("mtomovi", "operationAmount.amount")
                .field("divmovi", "operationAmount.currency")
                .field("numeope", "operationNumber")
                .field("tipoper", "operationType.id")
                .field("idepock", "origin.id")
                .field("numecta", "origin.number")
                .field("idetico", "origin.numberType.id")
                .field("destico", "origin.numberType.name")
                .field("ideprre", "origin.product.id")
                .field("desprre", "origin.product.name")
                .field("reltyid", "origin.relationType.id")
                .field("relname", "origin.relationType.name")
                .field("nomesta", "establishmentName")
                .register();

        factory.classMap(FormatoBGMQ752.class, DTOIntOperations.class)
                .field("idpagin", "pagination.paginationKey")
                .field("tampagi", "pagination.pageSize")
                .register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoBGMQ750 mapIn(final InputListPocketOperations dtoIn) {
        return map(dtoIn, FormatoBGMQ750.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntOperations mapOut(final FormatoBGMQ751 formatOutput, final DTOIntOperations dtoOut) {
        if (dtoOut.getData() == null) {
            dtoOut.setData(new ArrayList<>());
        }
        Operation operation = map(formatOutput, Operation.class);

        if (formatOutput.getTipoper() != null)
            operation.getOperationType().setId(translator.translateBackendEnumValueStrictly("operation.operationType.id", formatOutput.getTipoper()));

        if (formatOutput.getIdetico() != null)
            operation.getOrigin().getNumberType().setId(translator.translateBackendEnumValueStrictly("operation.origin.numberType.id", formatOutput.getIdetico()));

        if (formatOutput.getIdeprre() != null)
            operation.getOrigin().getProduct().setId(translator.translateBackendEnumValueStrictly("operation.origin.product.id", formatOutput.getIdeprre()));

        operation.setOperationDate(FunctionUtils.buildDatetime(formatOutput.getFchmovi(), DEFAULT_TIME));
        dtoOut.getData().add(operation);
        return dtoOut;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntOperations mapOut2(final FormatoBGMQ752 formatOutput, final DTOIntOperations dtoOut) {
        if (dtoOut.getPagination() == null) {
            map(formatOutput, dtoOut);
        }
        return dtoOut;
    }
}
