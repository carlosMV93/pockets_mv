package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.business.dto.InputCreatePocketContributions;
import com.bbva.pzic.pockets.canonic.Contribution;
import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78E1;
import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketContributionsMapper;
import com.bbva.pzic.pockets.util.BusinessServiceUtil;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.commons.utils.DateUtils;

import java.text.ParseException;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@Mapper
public class TxCreatePocketContributionsMapper extends ConfigurableMapper implements ITxCreatePocketContributionsMapper {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoBQM78E1 mapIn(final InputCreatePocketContributions dtoIn) {
        return map(dtoIn, FormatoBQM78E1.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contribution mapOut(final FormatoBQM78S1 formatOutput) {
        Contribution contribution = map(formatOutput, Contribution.class);

        if (formatOutput.getFechope() != null && formatOutput.getHoraope() != null) {
            try {
                contribution.setOperationDate(DateUtils.toDateTime(formatOutput.getFechope(), formatOutput.getHoraope()));
            } catch (ParseException e) {
                throw new BusinessServiceException("wrongDate", e);
            }
        }

        return contribution;
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(InputCreatePocketContributions.class, FormatoBQM78E1.class)
                .field("pocketId", "idpoc")
                .field("contribution.contributionAmount.amount", "importe")
                .field("contribution.contributionAmount.currency", "moneda")
                .register();

        factory.classMap(FormatoBQM78S1.class, Contribution.class)
                .field("importe", "contributionAmount.amount")
                .field("moneda", "contributionAmount.currency")
                .field("numope", "operationNumber")
                .register();
    }
}