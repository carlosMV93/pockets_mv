package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketWithdrawals;
import com.bbva.pzic.pockets.canonic.Withdrawal;
import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79E1;
import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79S1;
import com.bbva.pzic.pockets.dao.model.bq79.PeticionTransaccionBq79;
import com.bbva.pzic.pockets.dao.model.bq79.RespuestaTransaccionBq79;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketWithdrawalsMapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@Tx("txCreatePocketWithdrawals")
public class TxCreatePocketWithdrawals extends SingleOutputFormat<InputCreatePocketWithdrawals, FormatoBQM79E1, Withdrawal, FormatoBQM79S1> {

    @Resource(name = "txCreatePocketWithdrawalsMapper")
    private ITxCreatePocketWithdrawalsMapper mapper;

    @Autowired
    public TxCreatePocketWithdrawals(@Qualifier("transaccionBq79") InvocadorTransaccion<PeticionTransaccionBq79, RespuestaTransaccionBq79>  transaction) {
        super(transaction, PeticionTransaccionBq79::new, Withdrawal::new, FormatoBQM79S1.class);
    }

    @Override
    protected FormatoBQM79E1 mapInput(InputCreatePocketWithdrawals inputCreatePocketWithdrawals) {
        return mapper.mapIn(inputCreatePocketWithdrawals);
    }

    @Override
    protected Withdrawal mapFirstOutputFormat(FormatoBQM79S1 formatoBQM79S1, InputCreatePocketWithdrawals inputCreatePocketWithdrawals, Withdrawal withdrawal) {
        return mapper.mapOut(formatoBQM79S1);
    }
}