package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketRelatedContract;
import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ710;
import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ711;
import com.bbva.pzic.pockets.dao.model.bq71.PeticionTransaccionBq71;
import com.bbva.pzic.pockets.dao.model.bq71.RespuestaTransaccionBq71;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketRelatedContractMapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@Tx("txCreatePocketRelatedContract")
public class TxCreatePocketRelatedContract extends SingleOutputFormat<InputCreatePocketRelatedContract, FormatoBGMQ710, String, FormatoBGMQ711> {

    @Resource(name = "txCreatePocketRelatedContractMapper")
    private ITxCreatePocketRelatedContractMapper mapper;

    @Autowired
    public TxCreatePocketRelatedContract(@Qualifier("transaccionBq71") InvocadorTransaccion<PeticionTransaccionBq71, RespuestaTransaccionBq71> transaction) {
        super(transaction, PeticionTransaccionBq71::new, String::new , FormatoBGMQ711.class);
    }

    @Override
    protected FormatoBGMQ710 mapInput(InputCreatePocketRelatedContract inputCreatePocketRelatedContract) {
        return mapper.mapIn(inputCreatePocketRelatedContract);
    }

    @Override
    protected String mapFirstOutputFormat(FormatoBGMQ711 formatoBGMQ711, InputCreatePocketRelatedContract inputCreatePocketRelatedContract, String string) {
        return mapper.mapOut(formatoBGMQ711);
    }
}