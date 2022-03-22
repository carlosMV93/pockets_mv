package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77E1;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77S1;
import com.bbva.pzic.pockets.dao.model.bq77.PeticionTransaccionBq77;
import com.bbva.pzic.pockets.dao.model.bq77.RespuestaTransaccionBq77;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxGetPocketV2Mapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 18/10/2018.
 *
 * @author Entelgy
 */
@Tx("txGetPocketV2")
public class TxGetPocketV2 extends SingleOutputFormat<PathParamPocketId, FormatoBQM77E1, Pocket, FormatoBQM77S1> {

    @Resource(name = "txGetPocketV2Mapper")
    private ITxGetPocketV2Mapper mapper;

    @Autowired
    public TxGetPocketV2(@Qualifier("transaccionBq77") InvocadorTransaccion<PeticionTransaccionBq77, RespuestaTransaccionBq77> transaction) {
        super(transaction, PeticionTransaccionBq77::new, Pocket::new, FormatoBQM77S1.class);
    }

    @Override
    protected FormatoBQM77E1 mapInput(PathParamPocketId pathParamPocketId) {
        return mapper.mapIn(pathParamPocketId);
    }

    @Override
    protected Pocket mapFirstOutputFormat(FormatoBQM77S1 formatoBQM77S1, PathParamPocketId pathParamPocketId, Pocket pocket) {
        return mapper.mapOut(formatoBQM77S1);
    }
}
