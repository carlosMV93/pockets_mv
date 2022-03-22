package com.bbva.pzic.pockets.facade.v2.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketContributions;
import com.bbva.pzic.pockets.canonic.Contribution;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public interface ICreatePocketContributionsMapper {

    InputCreatePocketContributions mapIn(String pocketId, Contribution contribution);

    ServiceResponse<Contribution> mapOut(Contribution contribution);
}