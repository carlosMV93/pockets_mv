package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.dao.model.bq43.FormatoBQM43E1;
import com.bbva.pzic.pockets.dao.model.bq43.PeticionTransaccionBq43;
import com.bbva.pzic.pockets.dao.model.bq43.RespuestaTransaccionBq43;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxModifyPocketMapper;
import com.bbva.pzic.pockets.util.tx.IFormatNotApply;
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
@Tx
public class TxModifyPocket extends SingleOutputFormat<DTOIntPocket, FormatoBQM43E1, DTOIntPocket, IFormatNotApply> {

    @Resource(name = "txModifyPocketMapper")
    private ITxModifyPocketMapper mapper;

    @Resource(name = "transaccionBq43")
    private InvocadorTransaccion<PeticionTransaccionBq43, RespuestaTransaccionBq43> transaction;

    @Autowired
    public TxModifyPocket(@Qualifier("transaccionBq43") InvocadorTransaccion<PeticionTransaccionBq43, RespuestaTransaccionBq43> transaction) {
        super(transaction, PeticionTransaccionBq43::new, DTOIntPocket::new, IFormatNotApply.class);
    }

    @Override
    protected FormatoBQM43E1 mapInput(DTOIntPocket dtoIntPocket) {
        return mapper.mapIn(dtoIntPocket);
    }

    @Override
    protected DTOIntPocket mapFirstOutputFormat(IFormatNotApply iFormatNotApply, DTOIntPocket dtoIntPocket, DTOIntPocket dtoIntPocket2) {
        return dtoIntPocket;
    }
}