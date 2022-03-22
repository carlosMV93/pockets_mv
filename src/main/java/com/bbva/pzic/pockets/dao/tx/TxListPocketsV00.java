package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.DTOIntPocketsData;
import com.bbva.pzic.pockets.business.dto.InputListPocket;
import com.bbva.pzic.pockets.dao.model.bq39.*;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketsV00Mapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.DoubleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Tx("txListPocketsV00")
public class TxListPocketsV00 extends DoubleOutputFormat<InputListPocket, FormatoBQM39E1, DTOIntPocketsData, FormatoBQM39S1, FormatoBQM39P1> {

    @Resource(name = "txListPocketsV00Mapper")
    private ITxListPocketsV00Mapper mapper;

    @Autowired
    public TxListPocketsV00(@Qualifier("transaccionBq39") InvocadorTransaccion<PeticionTransaccionBq39, RespuestaTransaccionBq39> transaction) {
        super(transaction, PeticionTransaccionBq39::new, DTOIntPocketsData::new, FormatoBQM39S1.class, FormatoBQM39P1.class);
    }

    @Override
    protected FormatoBQM39E1 mapInput(InputListPocket inputListPocket) {
        return mapper.mapIn(inputListPocket);
    }

    @Override
    protected DTOIntPocketsData mapFirstOutputFormat(FormatoBQM39S1 formatoBQM39S1, InputListPocket inputListPocket, DTOIntPocketsData dtoIntPocketsData) {
        return mapper.mapOutData(formatoBQM39S1, dtoIntPocketsData);
    }

    @Override
    protected DTOIntPocketsData mapSecondOutputFormat(FormatoBQM39P1 formatoBQM39P1, InputListPocket inputListPocket, DTOIntPocketsData dtoIntPocketsData) {
        return mapper.mapOutPagination(formatoBQM39P1, dtoIntPocketsData);
    }
}