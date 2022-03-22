package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.InputListPocketRelatedContracts;
import com.bbva.pzic.pockets.canonic.RelatedContract;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ720;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ721;
import com.bbva.pzic.pockets.dao.model.bq72.PeticionTransaccionBq72;
import com.bbva.pzic.pockets.dao.model.bq72.RespuestaTransaccionBq72;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketRelatedContractsMapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.SingleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@Tx("txListPocketRelatedContracts")
public class TxListPocketRelatedContracts extends SingleOutputFormat<InputListPocketRelatedContracts, FormatoBGMQ720, List<RelatedContract>, FormatoBGMQ721> {

    @Resource(name = "txListPocketRelatedContractsMapper")
    private ITxListPocketRelatedContractsMapper mapper;
    @Resource(name = "transaccionBq72")
    private InvocadorTransaccion<PeticionTransaccionBq72, RespuestaTransaccionBq72> transaccionBq72;
    @Autowired
    public TxListPocketRelatedContracts(@Qualifier("transaccionBq72") InvocadorTransaccion<PeticionTransaccionBq72, RespuestaTransaccionBq72> transaction) {
        super(transaction, PeticionTransaccionBq72::new, ArrayList::new, FormatoBGMQ721.class);
    }

    @Override
    protected FormatoBGMQ720 mapInput(InputListPocketRelatedContracts inputListPocketRelatedContracts) {
        return mapper.mapIn(inputListPocketRelatedContracts);
    }

    @Override
    protected List<RelatedContract> mapFirstOutputFormat(FormatoBGMQ721 formatoBGMQ721, InputListPocketRelatedContracts inputListPocketRelatedContracts, List<RelatedContract> relatedContracts) {
        return mapper.mapOut(formatoBGMQ721);
    }
}