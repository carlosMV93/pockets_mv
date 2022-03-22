package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketWithdrawals;
import com.bbva.pzic.pockets.canonic.Withdrawal;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public interface ICreatePocketWithdrawalsMapper {

    InputCreatePocketWithdrawals mapIn(String pocketId, Withdrawal withdrawal);

    ServiceResponse<Withdrawal> mapOut(Withdrawal withdrawal);
}