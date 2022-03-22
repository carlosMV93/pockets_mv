package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.PocketData;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40E1;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40S1;
import com.bbva.pzic.pockets.dao.model.bq40.PeticionTransaccionBq40;
import com.bbva.pzic.pockets.dao.model.bq40.RespuestaTransaccionBq40;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxGetPocketMapper;
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
@Tx("txGetPocket")
public class TxGetPocket extends SingleOutputFormat<PathParamPocketId, FormatoBQM40E1, PocketData, FormatoBQM40S1> {
    @Resource(name = "txGetPocketMapper")
    private ITxGetPocketMapper txGetPocketMapper;

    @Autowired
    public TxGetPocket(@Qualifier("transaccionBq40") InvocadorTransaccion<PeticionTransaccionBq40, RespuestaTransaccionBq40> transaction) {
        super(transaction, PeticionTransaccionBq40::new, PocketData::new, FormatoBQM40S1.class);
    }

    @Override
    protected FormatoBQM40E1 mapInput(PathParamPocketId pathParamPocketId) {
        return txGetPocketMapper.mapIn(pathParamPocketId);
    }

    @Override
    protected PocketData mapFirstOutputFormat(FormatoBQM40S1 formatoBQM40S1, PathParamPocketId pathParamPocketId, PocketData pocketData) {
        return txGetPocketMapper.mapOut(formatoBQM40S1);
    }
}