package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76E1;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76S1;
import com.bbva.pzic.pockets.dao.model.bq76.PeticionTransaccionBq76;
import com.bbva.pzic.pockets.dao.model.bq76.RespuestaTransaccionBq76;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketV2Mapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Tx("txCreatePocketV2")
public class TxCreatePocketV2 extends SingleOutputFormat<DTOIntPocket, FormatoBQM76E1, Pocket, FormatoBQM76S1> {

    @Autowired
    private ITxCreatePocketV2Mapper txCreatePocketV2Mapper;

    @Autowired
    public TxCreatePocketV2(@Qualifier("transaccionBq76") InvocadorTransaccion<PeticionTransaccionBq76, RespuestaTransaccionBq76>  transaction) {
        super(transaction, PeticionTransaccionBq76::new, Pocket::new, FormatoBQM76S1.class);
    }

    @Override
    protected FormatoBQM76E1 mapInput(DTOIntPocket dtoIntPocket) {
        return txCreatePocketV2Mapper.mapIn(dtoIntPocket);
    }

    @Override
    protected Pocket mapFirstOutputFormat(FormatoBQM76S1 formatoBQM76S1, DTOIntPocket dtoIntPocket, Pocket pocket) {
        return txCreatePocketV2Mapper.mapOut(formatoBQM76S1);
    }
}
