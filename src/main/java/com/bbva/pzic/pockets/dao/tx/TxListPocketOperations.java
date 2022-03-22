package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.DTOIntOperations;
import com.bbva.pzic.pockets.business.dto.InputListPocketOperations;
import com.bbva.pzic.pockets.dao.model.bq75.*;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketOperationsMapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.DoubleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@Tx("txListPocketOperations")
public class TxListPocketOperations extends DoubleOutputFormat<InputListPocketOperations, FormatoBGMQ750, DTOIntOperations, FormatoBGMQ751, FormatoBGMQ752> {

    @Resource(name = "txListPocketOperationsMapper")
    private ITxListPocketOperationsMapper mapper;

    @Autowired
    public TxListPocketOperations(@Qualifier("transaccionBq75") InvocadorTransaccion<PeticionTransaccionBq75, RespuestaTransaccionBq75> transaction) {
        super(transaction, PeticionTransaccionBq75::new, DTOIntOperations::new, FormatoBGMQ751.class,FormatoBGMQ752.class);
    }

    @Override
    protected FormatoBGMQ750 mapInput(InputListPocketOperations inputListPocketOperations) {
        return mapper.mapIn(inputListPocketOperations);
    }

    @Override
    protected DTOIntOperations mapFirstOutputFormat(FormatoBGMQ751 formatoBGMQ751, InputListPocketOperations inputListPocketOperations, DTOIntOperations dtoIntOperations) {
        return mapper.mapOut(formatoBGMQ751, dtoIntOperations);
    }

    @Override
    protected DTOIntOperations mapSecondOutputFormat(FormatoBGMQ752 formatoBGMQ752, InputListPocketOperations inputListPocketOperations, DTOIntOperations dtoIntOperations) {
        return mapper.mapOut2(formatoBGMQ752, dtoIntOperations);
    }
}