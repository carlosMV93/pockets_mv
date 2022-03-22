package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.DTOOutPocketTransactions;
import com.bbva.pzic.pockets.business.dto.InputListPocketTransactions;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44E1;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44P1;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44S1;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ITxListPocketTransactionsMapper {

    FormatoBQM44E1 mapIn(InputListPocketTransactions dtoIn);

    DTOOutPocketTransactions mapOut(FormatoBQM44S1 formatOutput, DTOOutPocketTransactions dtoOut);

    DTOOutPocketTransactions mapOut2(FormatoBQM44P1 formatOutput, DTOOutPocketTransactions dtoOut);
}