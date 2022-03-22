package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.InputDeletePocketRelatedContract;
import com.bbva.pzic.pockets.dao.model.bq73.FormatoBGMQ730;
import com.bbva.pzic.pockets.dao.model.bq73.PeticionTransaccionBq73;
import com.bbva.pzic.pockets.dao.model.bq73.RespuestaTransaccionBq73;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxDeletePocketRelatedContractMapper;
import com.bbva.pzic.pockets.util.tx.IFormatNotApply;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@Tx("txDeletePocketRelatedContract")
public class TxDeletePocketRelatedContract extends SingleOutputFormat<InputDeletePocketRelatedContract, FormatoBGMQ730, InputDeletePocketRelatedContract, IFormatNotApply> {

    @Resource(name = "txDeletePocketRelatedContractMapper")
    private ITxDeletePocketRelatedContractMapper mapper;

    @Autowired
    public TxDeletePocketRelatedContract(@Qualifier("transaccionBq73") InvocadorTransaccion<PeticionTransaccionBq73, RespuestaTransaccionBq73> transaction) {
        super(transaction, PeticionTransaccionBq73::new, InputDeletePocketRelatedContract::new, IFormatNotApply.class);
    }

    @Override
    protected FormatoBGMQ730 mapInput(InputDeletePocketRelatedContract inputDeletePocketRelatedContract) {
        return mapper.mapIn(inputDeletePocketRelatedContract);
    }

    @Override
    protected InputDeletePocketRelatedContract mapFirstOutputFormat(IFormatNotApply iFormatNotApply, InputDeletePocketRelatedContract inputDeletePocketRelatedContract, InputDeletePocketRelatedContract inputDeletePocketRelatedContract2) {
        return null;
    }
}
