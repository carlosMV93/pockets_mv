package com.bbva.pzic.pockets.facade.v00.mapper;

import com.bbva.pzic.pockets.business.dto.DTOIntTransaction;
import com.bbva.pzic.pockets.canonic.Transaction;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
public interface ICreatePocketTransactionMapper {

    DTOIntTransaction mapIn(String pocketId, Transaction transaction);

    Transaction mapOut(final DTOIntTransaction dto);
}