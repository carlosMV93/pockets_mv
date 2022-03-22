package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.DTOIntPockets;
import com.bbva.pzic.pockets.business.dto.InputListPockets;
import com.bbva.pzic.pockets.dao.model.bq74.*;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketsMapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.DoubleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@Tx("txListPockets")
public class TxListPockets extends DoubleOutputFormat<InputListPockets, FormatoBGMQ740, DTOIntPockets, FormatoBGMQ741, FormatoBGMQ742> {

    @Resource(name = "txListPocketsMapper")
    private ITxListPocketsMapper mapper;

    @Autowired
    public TxListPockets(@Qualifier("transaccionBq74") InvocadorTransaccion<PeticionTransaccionBq74, RespuestaTransaccionBq74> transaction) {
        super(transaction, PeticionTransaccionBq74::new, DTOIntPockets::new, FormatoBGMQ741.class, FormatoBGMQ742.class);
    }

    @Override
    protected FormatoBGMQ740 mapInput(InputListPockets inputListPockets) {
        return mapper.mapIn(inputListPockets);
    }

    @Override
    protected DTOIntPockets mapFirstOutputFormat(FormatoBGMQ741 formatoBGMQ741, InputListPockets inputListPockets, DTOIntPockets dtoIntPockets) {
        return mapper.mapOut(formatoBGMQ741, dtoIntPockets);
    }

    @Override
    protected DTOIntPockets mapSecondOutputFormat(FormatoBGMQ742 formatoBGMQ742, InputListPockets inputListPockets, DTOIntPockets dtoIntPockets) {
        return mapper.mapOut2(formatoBGMQ742, dtoIntPockets);
    }
}