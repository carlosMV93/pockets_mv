package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntPockets;
import com.bbva.pzic.pockets.business.dto.InputListPockets;
import com.bbva.pzic.pockets.canonic.Balance;
import com.bbva.pzic.pockets.canonic.Import;
import com.bbva.pzic.pockets.canonic.Percentage;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ740;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ741;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ742;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketsMapper;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.BooleanToStringConverter;
import com.bbva.pzic.pockets.util.orika.converter.builtin.DateToStringConverter;
import com.bbva.pzic.pockets.util.orika.converter.builtin.LongToIntegerConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@Mapper
public class TxListPocketsMapper extends ConfigurableMapper implements ITxListPocketsMapper {

    private static final String NUMCUEN = "numcuen";

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

        factory.getConverterFactory().registerConverter(new LongToIntegerConverter());
        factory.getConverterFactory().registerConverter(new BooleanToStringConverter());
        factory.getConverterFactory().registerConverter(new DateToStringConverter(DateToStringConverter.DateFormatsBBVA.SHORT_FORMAT));

        factory.classMap(InputListPockets.class, FormatoBGMQ740.class)
                .field("relatedContractNumber", NUMCUEN)
                .field("statusId", "opcion")
                .field("pagination.pageSize", "tampagi")
                .field("pagination.paginationKey", "idpagin")
                .register();

        factory.classMap(FormatoBGMQ741.class, Pocket.class)
                .field("idepock", "id")
                .field("mtopock", "goalAmount.amount")
                .field("divpock", "goalAmount.currency")
                .field("nompock", "alias")
                .field("fefpock", "expirationDate")
                .field("codcate", "category.id")
                .field("nomcate", "category.name")
                .field("indepoc", "isScheduled")
                .field("montdep", "scheduledDeposit.depositAmount.amount")
                .field("divdepo", "scheduledDeposit.depositAmount.currency")
                .field("perdepo", "scheduledDeposit.period.dayOfMonth")
                .field("frecdep", "scheduledDeposit.period.frequency.id")
                .field("nomfrec", "scheduledDeposit.period.frequency.name")
                .field("stapock", "status")
                .field(NUMCUEN, "relatedContract.id")
                .field(NUMCUEN, "relatedContract.contractId")
                .field(NUMCUEN, "relatedContract.number")
                .field("idtipoc", "relatedContract.product.id")
                .field("nomcuen", "relatedContract.product.name")
                .field("ideprre", "relatedContract.product.productType.id")
                .field("desprre", "relatedContract.product.productType.name")
                .field("fecpock", "relatedContract.relationDate")
                .field("pripock", "priority")
                .field("codafil", "isSavingRounding")
                .field("diastot", "totalDays")
                .field("diasres", "remainingDays")
                .register();

        factory.classMap(FormatoBGMQ742.class, DTOIntPockets.class)
                .field("idpagin", "pagination.paginationKey")
                .field("tampagi", "pagination.pageSize")
                .register();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoBGMQ740 mapIn(final InputListPockets dtoIn) {
        return map(dtoIn, FormatoBGMQ740.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntPockets mapOut(final FormatoBGMQ741 formatOutput, final DTOIntPockets dtoOut) {
        if (dtoOut.getData() == null) {
            dtoOut.setData(new ArrayList<>());
        }

        Pocket pocket = map(formatOutput, Pocket.class);
        pocket.setId(cypherTool.encrypt(formatOutput.getIdepock(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKETS));

        if (formatOutput.getFrecdep() != null) {
            pocket.getScheduledDeposit().getPeriod().getFrequency().setId(
                    translator.translateBackendEnumValueStrictly("pocket.period.frequency.id", formatOutput.getFrecdep()));
        }
        if (formatOutput.getStapock() != null) {
            pocket.setStatus(
                    translator.translateBackendEnumValueStrictly("pocket.statusId", formatOutput.getStapock()));
        }
        if (formatOutput.getIdeprre() != null) {
            pocket.getRelatedContract().getProduct().getProductType().setId(
                    translator.translateBackendEnumValueStrictly("pocket.product.productType.id", formatOutput.getIdeprre()));
        }
        pocket.setBalances(mapOutBalances(formatOutput));
        dtoOut.getData().add(pocket);
        return dtoOut;
    }

    private List<Balance> mapOutBalances(final FormatoBGMQ741 formatOutput) {
        List<Balance> balances = new ArrayList<>();
        Balance balance;
        // Index 0
        if (formatOutput.getIdpresp() != null || formatOutput.getNompres() != null) {
            balance = new Balance();
            balance.setId(translator.translateBackendEnumValueStrictly("pocket.balances.id", formatOutput.getIdpresp()));
            balance.setMode(translator.translateBackendEnumValueStrictly("pocket.balances.mode", formatOutput.getNompres()));

            if ("AMOUNT".equals(formatOutput.getNompres())) {
                Import importUnit = new Import();
                importUnit.setAmount(formatOutput.getAhopock());
                importUnit.setCurrency(formatOutput.getDivisad());
                balance.setUnit(importUnit);

            } else if ("PERCENTAGE".equals(formatOutput.getNompres())) {
                Percentage percentageUnit = new Percentage();
                percentageUnit.setPercentage(formatOutput.getAhopock());
                balance.setUnit(percentageUnit);
            }
            balances.add(balance);
        }

        // Index 1
        if (formatOutput.getIdinter() != null || formatOutput.getNominte() != null) {
            balance = new Balance();
            balance.setId(translator.translateBackendEnumValueStrictly("pocket.balances.id", formatOutput.getIdinter()));
            balance.setMode(translator.translateBackendEnumValueStrictly("pocket.balances.mode", formatOutput.getNominte()));

            if ("AMOUNT".equals(formatOutput.getNominte())) {
                Import importUnit = new Import();
                importUnit.setAmount(formatOutput.getImpinte());
                importUnit.setCurrency(formatOutput.getDivisad());
                balance.setUnit(importUnit);

            } else if ("PERCENTAGE".equals(formatOutput.getNominte())) {
                Percentage percentageUnit = new Percentage();
                percentageUnit.setPercentage(formatOutput.getImpinte());
                balance.setUnit(percentageUnit);
            }
            balances.add(balance);
        }

        // Index 2
        if (formatOutput.getIdpercn() != null || formatOutput.getNomperc() != null) {
            balance = new Balance();
            balance.setId(translator.translateBackendEnumValueStrictly("pocket.balances.id", formatOutput.getIdpercn()));
            balance.setMode(translator.translateBackendEnumValueStrictly("pocket.balances.mode", formatOutput.getNomperc()));

            if ("AMOUNT".equals(formatOutput.getNomperc())) {
                Import importUnit = new Import();
                importUnit.setAmount(new BigDecimal(formatOutput.getPercent()));
                importUnit.setCurrency(formatOutput.getDivisad());
                balance.setUnit(importUnit);

            } else if ("PERCENTAGE".equals(formatOutput.getNomperc())) {
                Percentage percentageUnit = new Percentage();
                percentageUnit.setPercentage(new BigDecimal(formatOutput.getPercent()));
                balance.setUnit(percentageUnit);
            }
            balances.add(balance);
        }

        return balances.isEmpty() ? null : balances;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntPockets mapOut2(final FormatoBGMQ742 formatOutput, final DTOIntPockets dtoOut) {
        map(formatOutput, dtoOut);
        return dtoOut;
    }
}
