package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.DTOIntPocketV2;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81E1;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81S1;
import com.bbva.pzic.pockets.dao.model.bq81.PeticionTransaccionBq81;
import com.bbva.pzic.pockets.dao.model.bq81.RespuestaTransaccionBq81;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxModifyPocketV2Mapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 22/10/2018.
 *
 * @author Entelgy
 */
@Tx("txModifyPocketV2")
public class TxModifyPocketV2 extends SingleOutputFormat<DTOIntPocketV2, FormatoBQM81E1, List<Pocket>, FormatoBQM81S1> {

    @Resource(name = "txModifyPocketV2Mapper")
    private ITxModifyPocketV2Mapper txModifyPocketV2Mapper;

    @Autowired
    public TxModifyPocketV2(@Qualifier("transaccionBq81") InvocadorTransaccion<PeticionTransaccionBq81, RespuestaTransaccionBq81> transaction) {
        super(transaction, PeticionTransaccionBq81::new, ArrayList::new, FormatoBQM81S1.class);
    }

    @Override
    protected FormatoBQM81E1 mapInput(DTOIntPocketV2 dtoIntPocketV2) {
        return txModifyPocketV2Mapper.mapIn(dtoIntPocketV2);
    }

    @Override
    protected List<Pocket> mapFirstOutputFormat(FormatoBQM81S1 formatoBQM81S1, DTOIntPocketV2 dtoIntPocketV2, List<Pocket> pocket) {
        return txModifyPocketV2Mapper.mapOut(formatoBQM81S1);
    }
}
