package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.*;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77E1;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxGetPocketV2Mapper;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.BooleanToStringConverter;
import com.bbva.pzic.pockets.util.orika.converter.builtin.FromStringConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.commons.utils.DateUtils;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
@Mapper("txGetPocketV2Mapper")
public class TxGetPocketV2Mapper extends ConfigurableMapper implements ITxGetPocketV2Mapper {

    private static final Log LOG = LogFactory.getLog(TxGetPocketV2Mapper.class);

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

        factory.classMap(FormatoBQM77S1.class, Pocket.class)
                .field("idpoc", "id")
                .field("nomcor", "alias")
                .field("monpoc", "goalAmount.amount")
                .field("moneda", "goalAmount.currency")
                .field("fechpoc", "expirationDate")
                .field("pripoc", "priority")
                .field("tippoc", "category.id")
                .field("destipo", "category.name")
                .field("estpoc", "status")
                .field("flapoc", "isScheduled")
                .field("impaut", "scheduledDeposit.depositAmount.amount")
                .field("monimp", "scheduledDeposit.depositAmount.currency")
                .field("peraut", "scheduledDeposit.period.frequency.id")
                .field("desperi", "scheduledDeposit.period.frequency.name")
                .field("diaauto", "scheduledDeposit.period.dayOfMonth")
                .field("numcuen", "relatedContract.number")
                .field("flaaxr", "isSavingRounding")
                .field("diasres", "remainingDays")
                .field("diastot", "totalDays")
                .register();
    }

    @Override
    public FormatoBQM77E1 mapIn(PathParamPocketId dtoIn) {
        LOG.info("----- Invoking TxGetPocketV2Mapper.mapIn -----");
        FormatoBQM77E1 formatoBQM77E1 = new FormatoBQM77E1();
        formatoBQM77E1.setIdpoc(dtoIn.getPocketId());
        return formatoBQM77E1;
    }

    @Override
    public Pocket mapOut(FormatoBQM77S1 formatOutput) {
        LOG.info("----- Invoking TxGetPocketV2Mapper.mapOut -----");
        Pocket pocket = map(formatOutput, Pocket.class);
        pocket.setId(cypherTool.encrypt(formatOutput.getIdpoc(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_GET_POCKET));

        if (formatOutput.getNompres() != null &&
                formatOutput.getIdpresp() != null &&
                (formatOutput.getAhopoc() != null && formatOutput.getAhopoc().compareTo(BigDecimal.ZERO) > 0)
                    || StringUtils.isNotEmpty(formatOutput.getMonaho()) &&

                formatOutput.getIdinter() != null &&
                (formatOutput.getImpinte() != null && formatOutput.getImpinte().compareTo(BigDecimal.ZERO) > 0)
                    || StringUtils.isNotEmpty(formatOutput.getMonaho()) &&

                formatOutput.getIdtpre() != null &&
                (formatOutput.getMtopock() != null && formatOutput.getMtopock().compareTo(BigDecimal.ZERO) > 0)
                    || StringUtils.isNotEmpty(formatOutput.getMonaho())
        ){
            List<Balance> balances = new ArrayList<>();
            ImportMode importMode = new ImportMode();
            importMode.setId(formatOutput.getIdpresp());
            importMode.setMode(formatOutput.getNompres());
            importMode.setAmount(formatOutput.getAhopoc());
            importMode.setCurrency(formatOutput.getMonaho());
            balances.add(importMode);

            ImportMode importMode2 = new ImportMode();
            importMode2.setId(formatOutput.getIdinter());
            importMode2.setMode(formatOutput.getNompres());
            importMode2.setAmount(formatOutput.getImpinte());
            importMode2.setCurrency(formatOutput.getMonaho());
            balances.add(importMode2);

            ImportMode importMode3 = new ImportMode();
            importMode3.setId(formatOutput.getIdtpre());
            importMode3.setMode(formatOutput.getNompres());
            importMode3.setAmount(formatOutput.getMtopock());
            importMode3.setCurrency(formatOutput.getMonaho());
            balances.add(importMode3);

            pocket.setBalances(balances);
        }
        pocket.setStatus(translator.translateBackendEnumValueStrictly("pocket.statusId", formatOutput.getEstpoc()));

        if (pocket.getIsScheduled() != null && pocket.getIsScheduled()) {
            if (formatOutput.getPeraut() != null) {
                pocket.getScheduledDeposit().getPeriod().getFrequency().setId(
                        translator.translateBackendEnumValueStrictly("pocket.period.frequencyId", formatOutput.getPeraut()));
            }
        } else {
            pocket.setScheduledDeposit(null);
        }

        if (formatOutput.getFechcre() != null && formatOutput.getHoraope() != null) {
            try {
                pocket.setCreationDate(DateUtils.toDateTime(formatOutput.getFechcre(), formatOutput.getHoraope()));
            } catch (ParseException e) {
                throw new BusinessServiceException("wrongDate", e);
            }
        }

        return pocket;
    }
}