package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntPocketV2;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81E1;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxModifyPocketV2Mapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.BooleanToStringConverter;
import com.bbva.pzic.pockets.util.orika.converter.builtin.FromStringConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@Mapper("txModifyPocketV2Mapper")
public class TxModifyPocketV2Mapper extends ConfigurableMapper implements ITxModifyPocketV2Mapper {

    private static final Log LOG = LogFactory.getLog(TxModifyPocketV2Mapper.class);

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

        factory.classMap(DTOIntPocketV2.class, FormatoBQM81E1.class)
                .field("id", "idpoc")
                .field("alias", "nomcor")
                .field("goalAmount.amount", "monpoc")
                .field("goalAmount.currency", "moneda")
                .field("expirationDate", "fechpoc")
                .field("priority", "pripoc")
                .field("category.id", "tippoc")
                .field("isScheduled", "flagpoc")
                .field("scheduledDeposit.depositAmount.amount", "impaut")
                .field("scheduledDeposit.depositAmount.currency", "monimp")
                .field("scheduledDeposit.period.frequency.id", "peraut")
                .field("scheduledDeposit.period.dayOfMonth", "diaauto")
                .register();

        factory.classMap(FormatoBQM81S1.class, Pocket.class)
                .field("idpoc", "id")
                .field("nomcor", "alias")
                .field("monpoc", "goalAmount.amount")
                .field("moneda", "goalAmount.currency")
                .field("fechpoc", "expirationDate")
                .field("pripoc", "priority")
                .field("tippoc", "category.id")
                .field("flagpoc", "isScheduled")
                .field("impaut", "scheduledDeposit.depositAmount.amount")
                .field("monimp", "scheduledDeposit.depositAmount.currency")
                .field("peraut", "scheduledDeposit.period.frequency.id")
                .field("diaauto", "scheduledDeposit.period.dayOfMonth")
                .field("estado", "status")
                .register();

    }

    @Override
    public FormatoBQM81E1 mapIn(final DTOIntPocketV2 dtoIn) {
        LOG.info("----- Invoking TxModifyPocketV2Mapper.mapIn -----");
        FormatoBQM81E1 formatoBQM81E1 = map(dtoIn, FormatoBQM81E1.class);
        if (dtoIn.getIsScheduled() == null || !dtoIn.getIsScheduled()) {
            formatoBQM81E1.setImpaut(null);
            formatoBQM81E1.setMonimp(null);
            formatoBQM81E1.setDiaauto(null);
            formatoBQM81E1.setPeraut(null);
        }
        return formatoBQM81E1;
    }

    @Override
    public List<Pocket> mapOut(final FormatoBQM81S1 formatOutput) {
        LOG.info("----- Invoking TxModifyPocketV2Mapper.mapOut -----");
        if (formatOutput == null) {
            return null;
        }
        Pocket pocket = map(formatOutput, Pocket.class);
        List<Pocket> lstPockes= new ArrayList<>();
        if (pocket.getScheduledDeposit() != null &&
                pocket.getScheduledDeposit().getPeriod() != null &&
                pocket.getScheduledDeposit().getPeriod().getFrequency() != null &&
                formatOutput.getPeraut() != null) {
            pocket.getScheduledDeposit().getPeriod().getFrequency().setId(
                    translator.translateBackendEnumValueStrictly("pocket.period.frequencyId", formatOutput.getPeraut()));
        }
        if (pocket.getIsScheduled() == null || !pocket.getIsScheduled()) {
            pocket.setScheduledDeposit(null);
        }
        if (formatOutput.getEstado() != null) {
            pocket.setStatus(translator.translateBackendEnumValueStrictly("pocket.status.id", formatOutput.getEstado()));
        }
        lstPockes.add(pocket);
        return lstPockes;
    }
}
