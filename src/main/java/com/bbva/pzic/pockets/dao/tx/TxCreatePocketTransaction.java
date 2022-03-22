package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.DTOIntTransaction;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41E1;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41S1;
import com.bbva.pzic.pockets.dao.model.bq41.PeticionTransaccionBq41;
import com.bbva.pzic.pockets.dao.model.bq41.RespuestaTransaccionBq41;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketTransactionMapper;
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
@Tx("txCreatePocketTransaction")
public class TxCreatePocketTransaction extends SingleOutputFormat<DTOIntTransaction, FormatoBQM41E1, DTOIntTransaction, FormatoBQM41S1> {

    @Resource(name = "txCreatePocketTransactionMapper")
    private ITxCreatePocketTransactionMapper pocketTransactionMapper;

    @Autowired
    public TxCreatePocketTransaction(@Qualifier("transaccionBq41") InvocadorTransaccion<PeticionTransaccionBq41, RespuestaTransaccionBq41> transaction) {
        super(transaction, PeticionTransaccionBq41::new, DTOIntTransaction::new , FormatoBQM41S1.class);
    }

    @Override
    protected FormatoBQM41E1 mapInput(DTOIntTransaction dtoIntTransaction) {
        return pocketTransactionMapper.mapIn(dtoIntTransaction);
    }

    @Override
    protected DTOIntTransaction mapFirstOutputFormat(FormatoBQM41S1 formatoBQM41S1, DTOIntTransaction dtoIntTransaction, DTOIntTransaction dtoIntTransaction2) {
        return pocketTransactionMapper.mapOut(formatoBQM41S1);
    }
}