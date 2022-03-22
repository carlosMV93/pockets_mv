package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketContributions;
import com.bbva.pzic.pockets.canonic.Contribution;
import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78E1;
import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78S1;
import com.bbva.pzic.pockets.dao.model.bq78.PeticionTransaccionBq78;
import com.bbva.pzic.pockets.dao.model.bq78.RespuestaTransaccionBq78;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketContributionsMapper;
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
@Tx("txCreatePocketContributions")
public class TxCreatePocketContributions extends SingleOutputFormat<InputCreatePocketContributions, FormatoBQM78E1, Contribution, FormatoBQM78S1> {

    @Resource(name = "txCreatePocketContributionsMapper")
    private ITxCreatePocketContributionsMapper mapper;

    @Autowired
    public TxCreatePocketContributions(@Qualifier("transaccionBq78") InvocadorTransaccion<PeticionTransaccionBq78, RespuestaTransaccionBq78> transaction) {
        super(transaction, PeticionTransaccionBq78::new, Contribution::new, FormatoBQM78S1.class);
    }

    @Override
    protected FormatoBQM78E1 mapInput(InputCreatePocketContributions inputCreatePocketContributions) {
        return mapper.mapIn(inputCreatePocketContributions);
    }

    @Override
    protected Contribution mapFirstOutputFormat(FormatoBQM78S1 formatoBQM78S1, InputCreatePocketContributions inputCreatePocketContributions, Contribution contribution) {
        return mapper.mapOut(formatoBQM78S1);
    }
}