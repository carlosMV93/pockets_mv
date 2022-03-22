package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketLiquidate;
import com.bbva.pzic.pockets.canonic.Liquidate;
import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80E1;
import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80S1;
import com.bbva.pzic.pockets.dao.model.bq80.PeticionTransaccionBq80;
import com.bbva.pzic.pockets.dao.model.bq80.RespuestaTransaccionBq80;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketLiquidateMapper;
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
@Tx("txCreatePocketLiquidate")
public class TxCreatePocketLiquidate extends SingleOutputFormat<InputCreatePocketLiquidate, FormatoBQM80E1, Liquidate, FormatoBQM80S1> {

    @Resource(name = "txCreatePocketLiquidateMapper")
    private ITxCreatePocketLiquidateMapper mapper;

    @Autowired
    public TxCreatePocketLiquidate(@Qualifier("transaccionBq80") InvocadorTransaccion<PeticionTransaccionBq80, RespuestaTransaccionBq80> transaction) {
        super(transaction, PeticionTransaccionBq80::new, Liquidate::new, FormatoBQM80S1.class);
    }

    @Override
    protected FormatoBQM80E1 mapInput(InputCreatePocketLiquidate inputCreatePocketLiquidate) {
        return mapper.mapIn(inputCreatePocketLiquidate);
    }

    @Override
    protected Liquidate mapFirstOutputFormat(FormatoBQM80S1 formatoBQM80S1, InputCreatePocketLiquidate inputCreatePocketLiquidate, Liquidate liquidate) {
        return mapper.mapOut(formatoBQM80S1);
    }
}