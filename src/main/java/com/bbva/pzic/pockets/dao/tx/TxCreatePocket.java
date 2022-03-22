package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.InputCreatePocket;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38E1;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38S1;
import com.bbva.pzic.pockets.dao.model.bq38.PeticionTransaccionBq38;
import com.bbva.pzic.pockets.dao.model.bq38.RespuestaTransaccionBq38;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketMapper;
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
@Tx("txCreatePocket")
public class TxCreatePocket extends SingleOutputFormat<InputCreatePocket, FormatoBQM38E1, PocketV00, FormatoBQM38S1> {

    @Resource(name = "txCreatePocketMapper")
    private ITxCreatePocketMapper pocketMapper;

    @Autowired
    public TxCreatePocket(@Qualifier("transaccionBq38") InvocadorTransaccion<PeticionTransaccionBq38, RespuestaTransaccionBq38> transaction) {
        super(transaction, PeticionTransaccionBq38::new, PocketV00::new, FormatoBQM38S1.class);
    }

    @Override
    protected FormatoBQM38E1 mapInput(InputCreatePocket inputCreatePocket) {
        return pocketMapper.mapIn(inputCreatePocket);
    }

    @Override
    protected PocketV00 mapFirstOutputFormat(FormatoBQM38S1 formatoBQM38S1, InputCreatePocket inputCreatePocket, PocketV00 pocketV00) {
        return pocketMapper.mapOut(formatoBQM38S1);
    }
}