package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.InputCreatePocketWithdrawals;
import com.bbva.pzic.pockets.canonic.Withdrawal;
import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79E1;
import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79S1;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public interface ITxCreatePocketWithdrawalsMapper {

    FormatoBQM79E1 mapIn(InputCreatePocketWithdrawals dtoIn);

    Withdrawal mapOut(FormatoBQM79S1 formatOutput);
}