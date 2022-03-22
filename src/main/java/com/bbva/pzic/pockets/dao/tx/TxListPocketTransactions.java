package com.bbva.pzic.pockets.dao.tx;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.business.dto.DTOOutPocketTransactions;
import com.bbva.pzic.pockets.business.dto.InputListPocketTransactions;
import com.bbva.pzic.pockets.dao.model.bq44.*;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketTransactionsMapper;
import com.bbva.pzic.routine.commons.utils.host.templates.Tx;
import com.bbva.pzic.routine.commons.utils.host.templates.impl.DoubleOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Tx("txListPocketTransactions")
public class TxListPocketTransactions extends DoubleOutputFormat<InputListPocketTransactions, FormatoBQM44E1, DTOOutPocketTransactions, FormatoBQM44S1, FormatoBQM44P1> {

    @Resource(name = "txListPocketTransactionsMapper")
    private ITxListPocketTransactionsMapper txListPocketTransactionsMapper;

    @Resource(name = "transaccionBq44")
    private InvocadorTransaccion<PeticionTransaccionBq44, RespuestaTransaccionBq44> transaccionBq44;
    @Autowired
    public TxListPocketTransactions(@Qualifier("transaccionBq44") InvocadorTransaccion<PeticionTransaccionBq44, RespuestaTransaccionBq44> transaction) {
        super(transaction, PeticionTransaccionBq44::new, DTOOutPocketTransactions::new, FormatoBQM44S1.class, FormatoBQM44P1.class);
    }

    @Override
    protected FormatoBQM44E1 mapInput(InputListPocketTransactions inputListPocketTransactions) {
        return txListPocketTransactionsMapper.mapIn(inputListPocketTransactions);
    }

    @Override
    protected DTOOutPocketTransactions mapFirstOutputFormat(FormatoBQM44S1 formatoBQM44S1, InputListPocketTransactions inputListPocketTransactions, DTOOutPocketTransactions dtoOutPocketTransactions) {
        return txListPocketTransactionsMapper.mapOut(formatoBQM44S1, dtoOutPocketTransactions);
    }

    @Override
    protected DTOOutPocketTransactions mapSecondOutputFormat(FormatoBQM44P1 formatoBQM44P1, InputListPocketTransactions inputListPocketTransactions, DTOOutPocketTransactions dtoOutPocketTransactions) {
        return txListPocketTransactionsMapper.mapOut2(formatoBQM44P1, dtoOutPocketTransactions);
    }
}