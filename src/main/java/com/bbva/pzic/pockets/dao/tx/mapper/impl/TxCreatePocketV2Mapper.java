package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76E1;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxCreatePocketV2Mapper;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.BooleanToStringConverter;
import com.bbva.pzic.pockets.util.orika.converter.builtin.FromStringConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.commons.utils.DateUtils;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@Mapper("txCreatePocketV2Mapper")
public class TxCreatePocketV2Mapper extends ConfigurableMapper implements ITxCreatePocketV2Mapper {

    private static final Log LOG = LogFactory.getLog(TxCreatePocketV2Mapper.class);

    @Autowired
    private AbstractCypherTool cypherTool;

    private Translator translator;

    @Autowired
    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.getConverterFactory().registerConverter(new BooleanToStringConverter());
        factory.getConverterFactory().registerConverter(new FromStringConverter());

        factory.classMap(DTOIntPocket.class, FormatoBQM76E1.class)
                .field("relatedContract.number", "numcuen")
                .field("category.id", "tippock")
                .field("alias", "nomcor")
                .field("goalAmount.amount", "monpoc")
                .field("goalAmount.currency", "moneda")
                .field("expirationDate", "fechpoc")
                .field("isScheduled", "flagpoc")
                .field("scheduledDeposit.depositAmount.amount", "impaut")
                .field("scheduledDeposit.depositAmount.currency", "monimp")
                .field("scheduledDeposit.period.frequency.id", "peraut")
                .field("scheduledDeposit.period.dayOfMonth", "diaauto")

                .register();

        factory.classMap(FormatoBQM76S1.class, Pocket.class)
                .field("idpoc", "id")
                .field("tippock", "category.id")
                .field("nomcor", "alias")
                .field("monpoc", "goalAmount.amount")
                .field("moneda", "goalAmount.currency")
                .field("fechpoc", "expirationDate")
                .field("flagpoc", "isScheduled")
                .field("impaut", "scheduledDeposit.depositAmount.amount")
                .field("monimp", "scheduledDeposit.depositAmount.currency")
                .field("peraut", "scheduledDeposit.period.frequency.id")
                .field("diaauto", "scheduledDeposit.period.dayOfMonth")
                .field("estado", "status")
                .field("numcuen", "relatedContract.id")
                .register();

    }

    @Override
    public FormatoBQM76E1 mapIn(DTOIntPocket dtoIn) {
        LOG.info("----- Invoking TxCreatePocketV2Mapper.mapIn -----");
        FormatoBQM76E1 formatoBQM76E1 = map(dtoIn, FormatoBQM76E1.class);
        if (!dtoIn.getIsScheduled()) {
            formatoBQM76E1.setImpaut(null);
            formatoBQM76E1.setMonimp(null);
            formatoBQM76E1.setDiaauto(null);
            formatoBQM76E1.setPeraut(null);
        }

        return formatoBQM76E1;
    }

    @Override
    public Pocket mapOut(FormatoBQM76S1 formatOutput) {
        LOG.info("----- Invoking TxCreatePocketV2Mapper.mapOut -----");
        Pocket pocket = map(formatOutput, Pocket.class);
        pocket.setId(cypherTool.encrypt(formatOutput.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_CREATE_POCKET));

        if (formatOutput.getFechcre() != null && formatOutput.getHoraope() != null) {
            try {
                pocket.setCreationDate(DateUtils.toDateTime(formatOutput.getFechcre(), formatOutput.getHoraope()));
            } catch (ParseException e) {
                throw new BusinessServiceException("wrongDate", e);
            }
        }

        pocket.getScheduledDeposit().getPeriod().getFrequency().setId(
                translator.translateBackendEnumValueStrictly("pocket.period.frequencyId", formatOutput.getPeraut()));
        if (!pocket.getIsScheduled()) {
            pocket.setScheduledDeposit(null);
        }
        pocket.setStatus(translator.translateBackendEnumValueStrictly("pocket.status.id", formatOutput.getEstado()));
        return pocket;
    }

}
