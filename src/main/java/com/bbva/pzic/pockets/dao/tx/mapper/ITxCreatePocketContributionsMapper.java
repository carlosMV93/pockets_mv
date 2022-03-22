package com.bbva.pzic.pockets.dao.tx.mapper;

import com.bbva.pzic.pockets.business.dto.InputCreatePocketContributions;
import com.bbva.pzic.pockets.canonic.Contribution;
import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78E1;
import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78S1;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public interface ITxCreatePocketContributionsMapper {

    FormatoBQM78E1 mapIn(InputCreatePocketContributions dtoIn);

    Contribution mapOut(FormatoBQM78S1 formatOutput);
}