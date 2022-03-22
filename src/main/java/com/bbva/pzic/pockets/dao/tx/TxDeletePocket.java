package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.dao.model.bq42.FormatoBQM42E1;
import com.bbva.pzic.pockets.dao.model.bq42.PeticionTransaccionBq42;
import com.bbva.pzic.pockets.dao.model.bq42.RespuestaTransaccionBq42;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxDeletePocketMapper;
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
@Tx("txDeletePocket")
public class TxDeletePocket extends SingleOutputFormat<DTOIntPocket, FormatoBQM42E1, DTOIntPocket, IFormatNotApply> {

    @Resource(name = "txDeletePocketMapper")
    private ITxDeletePocketMapper mapper;

    @Autowired
    public TxDeletePocket(@Qualifier("transaccionBq42") InvocadorTransaccion<PeticionTransaccionBq42, RespuestaTransaccionBq42> transaction) {
        super(transaction, PeticionTransaccionBq42::new, DTOIntPocket::new, IFormatNotApply.class);
    }

    @Override
    protected FormatoBQM42E1 mapInput(DTOIntPocket dtoIntPocket) {
        return mapper.mapIn(dtoIntPocket);
    }

    @Override
    protected DTOIntPocket mapFirstOutputFormat(IFormatNotApply iFormatNotApply, DTOIntPocket dtoIntPocket, DTOIntPocket dtoIntPocket2) {
        return null;
    }
}