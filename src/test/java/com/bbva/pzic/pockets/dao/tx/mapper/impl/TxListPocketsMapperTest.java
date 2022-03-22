package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.DTOIntPockets;
import com.bbva.pzic.pockets.business.dto.InputListPockets;
import com.bbva.pzic.pockets.canonic.Import;
import com.bbva.pzic.pockets.canonic.Percentage;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ740;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ741;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ742;
import com.bbva.pzic.pockets.dao.model.bq74.mock.FormatsBq74Mock;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.routine.translator.facade.Translator;
import com.bbva.pzic.utilTest.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.bbva.pzic.pockets.EntityMock.*;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxListPocketsMapperTest {

    @InjectMocks
    private TxListPocketsMapper mapper;
    @Mock
    private AbstractCypherTool cypherTool;
    @Mock
    private Translator translator;

    @Before
    public void setUp() {
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.period.frequency.id", ENUM_OUT_PERIOD_FREQUENCY_ID))
                .thenReturn(ENUM_IN_PERIOD_FREQUENCY_ID);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.statusId", ENUM_OUT_STATUS_ID)).thenReturn(ENUM_IN_STATUS_ID);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.product.productType.id", ENUM_OUT_PRODUCT_TYPE_ID))
                .thenReturn(ENUM_IN_PRODUCT_TYPE_ID);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.balances.id", ENUM_OUT_BALANCES_ID_AMOUNT))
                .thenReturn(ENUM_IN_BALANCES_ID_AMOUNT);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.balances.id", ENUM_OUT_BALANCES_ID_PERCENTAGE))
                .thenReturn(ENUM_IN_BALANCES_ID_PERCENTAGE);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.balances.mode", ENUM_OUT_BALANCES_MODE_AMOUNT))
                .thenReturn(ENUM_IN_BALANCES_MODE_AMOUNT);
        Mockito.when(translator.translateBackendEnumValueStrictly("pocket.balances.mode", ENUM_OUT_BALANCES_MODE_PERCENTAGE))
                .thenReturn(ENUM_IN_BALANCES_MODE_PERCENTAGE);
    }

    @Test
    public void mapInFullTest() {
        InputListPockets input = EntityMock.getInstance().getInputListPockets();
        FormatoBGMQ740 result = mapper.mapIn(input);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getNumcuen());
        Assert.assertNotNull(result.getOpcion());
        Assert.assertNotNull(result.getTampagi());
        Assert.assertNotNull(result.getIdpagin());
        Assert.assertEquals(input.getRelatedContractNumber(), result.getNumcuen());
        Assert.assertEquals(input.getStatusId(), result.getOpcion());
        Assert.assertEquals(input.getPagination().getPaginationKey(), result.getIdpagin());
        Assert.assertEquals(input.getPagination().getPageSize().toString(), result.getTampagi().toString());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoBGMQ740 result = mapper.mapIn(new InputListPockets());
        Assert.assertNotNull(result);
        Assert.assertNull(result.getNumcuen());
        Assert.assertNull(result.getOpcion());
        Assert.assertNull(result.getTampagi());
        Assert.assertNull(result.getIdpagin());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        DTOIntPockets result = new DTOIntPockets();

        List<FormatoBGMQ741> formatoBGMQ741s = FormatsBq74Mock.getInstance().getFormatoBGMQ741();
        // Index 0 AMOUNT
        FormatoBGMQ741 format = formatoBGMQ741s.get(0);
        Mockito.when(cypherTool.encrypt(format.getIdepock(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKETS)).thenReturn(POCKET_ID_CYPHER);
        result = mapper.mapOut(format, result);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
        Assert.assertEquals(1, result.getData().size());

        Pocket pocket = result.getData().get(0);
        Assert.assertNotNull(pocket);
        Assert.assertNotNull(pocket.getId());
        Assert.assertNotNull(pocket.getGoalAmount().getAmount());
        Assert.assertNotNull(pocket.getGoalAmount().getCurrency());
        Assert.assertNotNull(pocket.getAlias());
        Assert.assertNotNull(pocket.getExpirationDate());
        Assert.assertNotNull(pocket.getCategory().getId());
        Assert.assertNotNull(pocket.getCategory().getName());
        Assert.assertNotNull(pocket.getIsScheduled());
        Assert.assertNotNull(pocket.getScheduledDeposit().getDepositAmount().getAmount());
        Assert.assertNotNull(pocket.getScheduledDeposit().getDepositAmount().getCurrency());
        Assert.assertNotNull(pocket.getScheduledDeposit().getPeriod().getDayOfMonth());
        Assert.assertNotNull(pocket.getScheduledDeposit().getPeriod().getFrequency().getId());
        Assert.assertNotNull(pocket.getScheduledDeposit().getPeriod().getFrequency().getName());
        Assert.assertNotNull(pocket.getStatus());
        Assert.assertNotNull(pocket.getRelatedContract().getId());
        Assert.assertNotNull(pocket.getRelatedContract().getContractId());
        Assert.assertNotNull(pocket.getRelatedContract().getNumber());

        Assert.assertNotNull(pocket.getRelatedContract().getProduct().getId());
        Assert.assertNotNull(pocket.getRelatedContract().getProduct().getName());
        Assert.assertNotNull(pocket.getRelatedContract().getProduct().getProductType().getId());
        Assert.assertNotNull(pocket.getRelatedContract().getProduct().getProductType().getName());

        Assert.assertNotNull(pocket.getRelatedContract().getRelationDate());
        Assert.assertNotNull(pocket.getBalances().get(0).getId());
        Assert.assertNotNull(pocket.getBalances().get(0).getMode());
        Assert.assertNotNull(pocket.getBalances().get(1).getId());
        Assert.assertNotNull(pocket.getBalances().get(1).getMode());
        Assert.assertNotNull(pocket.getPriority());
        Assert.assertNotNull(pocket.getIsSavingRounding());
        Assert.assertNotNull(pocket.getTotalDays());
        Assert.assertNotNull(pocket.getRemainingDays());

        Assert.assertEquals(POCKET_ID_CYPHER, pocket.getId());
        Assert.assertEquals(format.getMtopock(), pocket.getGoalAmount().getAmount());
        Assert.assertEquals(format.getDivpock(), pocket.getGoalAmount().getCurrency());
        Assert.assertEquals(format.getNompock(), pocket.getAlias());
        Assert.assertEquals(format.getFefpock(), DateUtils.getFormatDefaultHost(pocket.getExpirationDate()));
        Assert.assertEquals(format.getCodcate(), pocket.getCategory().getId());
        Assert.assertEquals(format.getNomcate(), pocket.getCategory().getName());
        Assert.assertTrue(pocket.getIsScheduled());
        Assert.assertEquals(format.getMontdep(), pocket.getScheduledDeposit().getDepositAmount().getAmount());
        Assert.assertEquals(format.getDivdepo(), pocket.getScheduledDeposit().getDepositAmount().getCurrency());
        Assert.assertEquals(format.getPerdepo(), pocket.getScheduledDeposit().getPeriod().getDayOfMonth());
        Assert.assertEquals(ENUM_IN_PERIOD_FREQUENCY_ID, pocket.getScheduledDeposit().getPeriod().getFrequency().getId());
        Assert.assertEquals(format.getNomfrec(), pocket.getScheduledDeposit().getPeriod().getFrequency().getName());
        Assert.assertEquals(ENUM_IN_STATUS_ID, pocket.getStatus());
        Assert.assertEquals(format.getNumcuen(), pocket.getRelatedContract().getId());
        Assert.assertEquals(format.getNumcuen(), pocket.getRelatedContract().getContractId());
        Assert.assertEquals(format.getNumcuen(), pocket.getRelatedContract().getNumber());

        Assert.assertEquals(format.getIdtipoc(), pocket.getRelatedContract().getProduct().getId());
        Assert.assertEquals(format.getNomcuen(), pocket.getRelatedContract().getProduct().getName());
        Assert.assertEquals(ENUM_IN_PRODUCT_TYPE_ID, pocket.getRelatedContract().getProduct().getProductType().getId());
        Assert.assertEquals(format.getDesprre(), pocket.getRelatedContract().getProduct().getProductType().getName());

        Assert.assertEquals(format.getFecpock(), pocket.getRelatedContract().getRelationDate());

        Assert.assertEquals(3, pocket.getBalances().size());

        Assert.assertEquals(ENUM_IN_BALANCES_ID_AMOUNT, pocket.getBalances().get(0).getId());
        Assert.assertEquals(ENUM_IN_BALANCES_MODE_AMOUNT, pocket.getBalances().get(0).getMode());
        Import importUnit = (Import) pocket.getBalances().get(0).getUnit();
        Assert.assertEquals(format.getAhopock(), importUnit.getAmount());
        Assert.assertEquals(format.getDivisad(), importUnit.getCurrency());

        Assert.assertEquals(ENUM_IN_BALANCES_ID_PERCENTAGE, pocket.getBalances().get(1).getId());
        Assert.assertEquals(ENUM_IN_BALANCES_MODE_PERCENTAGE, pocket.getBalances().get(1).getMode());
        Percentage percentageUnit = (Percentage) pocket.getBalances().get(1).getUnit();
        Assert.assertEquals(format.getImpinte(), percentageUnit.getPercentage());

        Assert.assertEquals(ENUM_IN_BALANCES_ID_AMOUNT, pocket.getBalances().get(2).getId());
        Assert.assertEquals(ENUM_IN_BALANCES_MODE_AMOUNT, pocket.getBalances().get(2).getMode());
        importUnit = (Import) pocket.getBalances().get(2).getUnit();
        Assert.assertEquals(format.getPercent().intValue(), importUnit.getAmount().intValue());
        Assert.assertEquals(format.getDivisad(), importUnit.getCurrency());

        Assert.assertEquals(format.getPripock(), pocket.getPriority());
        Assert.assertTrue(pocket.getIsSavingRounding());
        Assert.assertEquals(format.getDiastot(), pocket.getTotalDays());
        Assert.assertEquals(format.getDiasres(), pocket.getRemainingDays());

        // Index 1
        format = formatoBGMQ741s.get(1);
        Mockito.when(cypherTool.encrypt(format.getIdepock(), AbstractCypherTool.POCKET_ID, RegistryIds.SMC_REGISTRY_ID_OF_LIST_POCKETS)).thenReturn(POCKET_ID_CYPHER);
        result = mapper.mapOut(format, result);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
        Assert.assertEquals(2, result.getData().size());

        pocket = result.getData().get(1);
        Assert.assertNotNull(pocket);
        Assert.assertNotNull(pocket);
        Assert.assertNotNull(pocket.getId());
        Assert.assertNotNull(pocket.getGoalAmount().getAmount());
        Assert.assertNotNull(pocket.getGoalAmount().getCurrency());
        Assert.assertNotNull(pocket.getAlias());
        Assert.assertNotNull(pocket.getExpirationDate());
        Assert.assertNotNull(pocket.getCategory().getId());
        Assert.assertNotNull(pocket.getCategory().getName());
        Assert.assertNotNull(pocket.getIsScheduled());
        Assert.assertNotNull(pocket.getScheduledDeposit().getDepositAmount().getAmount());
        Assert.assertNotNull(pocket.getScheduledDeposit().getDepositAmount().getCurrency());
        Assert.assertNotNull(pocket.getScheduledDeposit().getPeriod().getDayOfMonth());
        Assert.assertNotNull(pocket.getScheduledDeposit().getPeriod().getFrequency().getId());
        Assert.assertNotNull(pocket.getScheduledDeposit().getPeriod().getFrequency().getName());
        Assert.assertNotNull(pocket.getStatus());
        Assert.assertNotNull(pocket.getRelatedContract().getId());
        Assert.assertNotNull(pocket.getRelatedContract().getContractId());
        Assert.assertNotNull(pocket.getRelatedContract().getNumber());
        Assert.assertNull(pocket.getRelatedContract().getProduct());
        Assert.assertNotNull(pocket.getRelatedContract().getRelationDate());
        Assert.assertNotNull(pocket.getBalances().get(0).getId());
        Assert.assertNotNull(pocket.getBalances().get(0).getMode());
        Assert.assertNotNull(pocket.getBalances().get(1).getId());
        Assert.assertNotNull(pocket.getBalances().get(1).getMode());
        Assert.assertNotNull(pocket.getPriority());
        Assert.assertFalse(pocket.getIsSavingRounding());
        Assert.assertNotNull(pocket.getTotalDays());
        Assert.assertNotNull(pocket.getRemainingDays());

        Assert.assertEquals(POCKET_ID_CYPHER, pocket.getId());
        Assert.assertEquals(format.getMtopock(), pocket.getGoalAmount().getAmount());
        Assert.assertEquals(format.getDivpock(), pocket.getGoalAmount().getCurrency());
        Assert.assertEquals(format.getNompock(), pocket.getAlias());
        Assert.assertEquals(format.getFefpock(), DateUtils.getFormatDefaultHost(pocket.getExpirationDate()));
        Assert.assertEquals(format.getCodcate(), pocket.getCategory().getId());
        Assert.assertEquals(format.getNomcate(), pocket.getCategory().getName());
        Assert.assertFalse(pocket.getIsScheduled());
        Assert.assertEquals(format.getMontdep(), pocket.getScheduledDeposit().getDepositAmount().getAmount());
        Assert.assertEquals(format.getDivdepo(), pocket.getScheduledDeposit().getDepositAmount().getCurrency());
        Assert.assertEquals(format.getPerdepo(), pocket.getScheduledDeposit().getPeriod().getDayOfMonth());
        Assert.assertEquals(ENUM_IN_PERIOD_FREQUENCY_ID, pocket.getScheduledDeposit().getPeriod().getFrequency().getId());
        Assert.assertEquals(format.getNomfrec(), pocket.getScheduledDeposit().getPeriod().getFrequency().getName());
        Assert.assertEquals(ENUM_IN_STATUS_ID, pocket.getStatus());
        Assert.assertEquals(format.getNumcuen(), pocket.getRelatedContract().getId());
        Assert.assertEquals(format.getNumcuen(), pocket.getRelatedContract().getContractId());
        Assert.assertEquals(format.getNumcuen(), pocket.getRelatedContract().getNumber());
        Assert.assertEquals(format.getFecpock(), pocket.getRelatedContract().getRelationDate());
        Assert.assertEquals(3, pocket.getBalances().size());
        Assert.assertEquals(ENUM_IN_BALANCES_ID_PERCENTAGE, pocket.getBalances().get(0).getId());
        Assert.assertEquals(ENUM_IN_BALANCES_MODE_PERCENTAGE, pocket.getBalances().get(0).getMode());
        percentageUnit = (Percentage) pocket.getBalances().get(0).getUnit();
        Assert.assertEquals(format.getAhopock(), percentageUnit.getPercentage());

        Assert.assertEquals(ENUM_IN_BALANCES_ID_AMOUNT, pocket.getBalances().get(1).getId());
        Assert.assertEquals(ENUM_IN_BALANCES_MODE_AMOUNT, pocket.getBalances().get(1).getMode());
        importUnit = (Import) pocket.getBalances().get(1).getUnit();
        Assert.assertEquals(format.getImpinte(), importUnit.getAmount());
        Assert.assertEquals(format.getDivisad(), importUnit.getCurrency());

        Assert.assertEquals(ENUM_IN_BALANCES_ID_PERCENTAGE, pocket.getBalances().get(2).getId());
        Assert.assertEquals(ENUM_IN_BALANCES_MODE_PERCENTAGE, pocket.getBalances().get(2).getMode());
        percentageUnit = (Percentage) pocket.getBalances().get(2).getUnit();
        Assert.assertEquals(format.getPercent().intValue(), percentageUnit.getPercentage().intValue());

        Assert.assertEquals(format.getPripock(), pocket.getPriority());
        Assert.assertFalse(pocket.getIsSavingRounding());
    }

    @Test
    public void mapOutSomeBalancesTest() throws IOException {
        DTOIntPockets result = new DTOIntPockets();

        // Index 0
        FormatoBGMQ741 format = FormatsBq74Mock.getInstance().getFormatoBGMQ741().get(0);
        format.setNompres(null);
        format.setNominte(null);
        format.setNomperc(null);

        result = mapper.mapOut(format, result);
        Assert.assertEquals(1, result.getData().size());
        Assert.assertNull(result.getData().get(0).getBalances().get(0).getUnit());
        Assert.assertNull(result.getData().get(0).getBalances().get(1).getUnit());
        Assert.assertNull(result.getData().get(0).getBalances().get(2).getUnit());

        // Index 1
        format = FormatsBq74Mock.getInstance().getFormatoBGMQ741().get(0);
        format.setNompres(null);

        result = mapper.mapOut(format, result);
        Assert.assertEquals(2, result.getData().size());
        Assert.assertEquals(3, result.getData().get(1).getBalances().size());
        Assert.assertNull(result.getData().get(1).getBalances().get(0).getUnit());
        Percentage unitPercentage = (Percentage) result.getData().get(1).getBalances().get(1).getUnit();
        Assert.assertNotNull(result.getData().get(1).getBalances().get(1).getUnit());
        Assert.assertEquals(format.getImpinte(), unitPercentage.getPercentage());

        // Index 2
        format = FormatsBq74Mock.getInstance().getFormatoBGMQ741().get(0);
        format.setNominte(null);

        result = mapper.mapOut(format, result);
        Assert.assertEquals(3, result.getData().size());
        Assert.assertEquals(3, result.getData().get(2).getBalances().size());
        Import unitImport = (Import) result.getData().get(2).getBalances().get(0).getUnit();
        Assert.assertNotNull(unitImport);
        Assert.assertEquals(format.getAhopock(), unitImport.getAmount());
        Assert.assertEquals(format.getDivisad(), unitImport.getCurrency());
        Assert.assertNull(result.getData().get(2).getBalances().get(1).getUnit());

        // Index 3
        format = FormatsBq74Mock.getInstance().getFormatoBGMQ741().get(0);
        format.setIdpresp(null);
        format.setNompres(null);

        result = mapper.mapOut(format, result);
        Assert.assertEquals(4, result.getData().size());
        Assert.assertEquals(2, result.getData().get(3).getBalances().size());
        unitPercentage = (Percentage) result.getData().get(3).getBalances().get(0).getUnit();
        Assert.assertNotNull(unitPercentage);
        Assert.assertEquals(format.getImpinte(), unitPercentage.getPercentage());

        // Index 4
        format = FormatsBq74Mock.getInstance().getFormatoBGMQ741().get(0);
        format.setIdinter(null);
        format.setNominte(null);

        result = mapper.mapOut(format, result);
        Assert.assertEquals(5, result.getData().size());
        Assert.assertEquals(2, result.getData().get(4).getBalances().size());
        unitImport = (Import) result.getData().get(4).getBalances().get(0).getUnit();
        Assert.assertNotNull(unitImport);
        Assert.assertEquals(format.getAhopock(), unitImport.getAmount());
        Assert.assertEquals(format.getDivisad(), unitImport.getCurrency());

        // Index 5
        format = FormatsBq74Mock.getInstance().getFormatoBGMQ741().get(0);
        format.setIdpercn(null);
        format.setNomperc(null);

        result = mapper.mapOut(format, result);
        Assert.assertEquals(6, result.getData().size());
        Assert.assertEquals(2, result.getData().get(5).getBalances().size());
        unitImport = (Import) result.getData().get(5).getBalances().get(0).getUnit();
        Assert.assertNotNull(unitImport);
        Assert.assertEquals(format.getAhopock(), unitImport.getAmount());
        Assert.assertEquals(format.getDivisad(), unitImport.getCurrency());

        // Index 6
        format = FormatsBq74Mock.getInstance().getFormatoBGMQ741().get(0);
        format.setNomperc(null);

        result = mapper.mapOut(format, result);
        Assert.assertEquals(7, result.getData().size());
        Assert.assertEquals(3, result.getData().get(6).getBalances().size());
        unitImport = (Import) result.getData().get(6).getBalances().get(0).getUnit();
        Assert.assertNotNull(unitImport);
        Assert.assertEquals(format.getAhopock(), unitImport.getAmount());
        Assert.assertEquals(format.getDivisad(), unitImport.getCurrency());
        unitPercentage = (Percentage) result.getData().get(6).getBalances().get(1).getUnit();
        Assert.assertNotNull(unitPercentage);
        Assert.assertEquals(format.getImpinte(), unitPercentage.getPercentage());
        Assert.assertNull(result.getData().get(6).getBalances().get(2).getUnit());

        // Index 7
        format = FormatsBq74Mock.getInstance().getFormatoBGMQ741().get(0);
        format.setIdpresp(null);
        format.setIdinter(null);
        format.setIdpercn(null);

        result = mapper.mapOut(format, result);
        Assert.assertEquals(8, result.getData().size());
        Assert.assertNull(result.getData().get(7).getBalances().get(0).getId());
        Assert.assertEquals(ENUM_IN_BALANCES_MODE_AMOUNT, result.getData().get(7).getBalances().get(0).getMode());
        Assert.assertNotNull(result.getData().get(7).getBalances().get(0).getUnit());

        Assert.assertNull(result.getData().get(7).getBalances().get(1).getId());
        Assert.assertEquals(ENUM_IN_BALANCES_MODE_PERCENTAGE, result.getData().get(7).getBalances().get(1).getMode());
        Assert.assertNotNull(result.getData().get(7).getBalances().get(1).getUnit());

        Assert.assertNull(result.getData().get(7).getBalances().get(2).getId());
        Assert.assertEquals(ENUM_IN_BALANCES_MODE_AMOUNT, result.getData().get(7).getBalances().get(2).getMode());
        Assert.assertNotNull(result.getData().get(7).getBalances().get(2).getUnit());
    }

    @Test
    public void mapOutEmptyTest() throws IOException {
        DTOIntPockets result = new DTOIntPockets();
        FormatoBGMQ741 format = FormatsBq74Mock.getInstance().getFormatoBGMQ741().get(2);

        result = mapper.mapOut(format, result);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
        Assert.assertEquals(1, result.getData().size());
        Assert.assertNotNull(result.getData().get(0));
        Assert.assertNull(result.getData().get(0).getId());
        Assert.assertNotNull(result.getData().get(0).getGoalAmount());
        Assert.assertNull(result.getData().get(0).getAlias());
        Assert.assertNull(result.getData().get(0).getExpirationDate());
        Assert.assertNull(result.getData().get(0).getCategory());
        Assert.assertNull(result.getData().get(0).getIsScheduled());
        Assert.assertNotNull(result.getData().get(0).getScheduledDeposit());
        Assert.assertNull(result.getData().get(0).getStatus());
        Assert.assertNull(result.getData().get(0).getRelatedContract());
        Assert.assertNull(result.getData().get(0).getBalances());
        Assert.assertNull(result.getData().get(0).getPriority());
        Assert.assertNull(result.getData().get(0).getIsSavingRounding());

        Assert.assertEquals(BigDecimal.ZERO, format.getMtopock());
        Assert.assertEquals(format.getMtopock(), result.getData().get(0).getGoalAmount().getAmount());
        Assert.assertEquals(BigDecimal.ZERO, format.getMontdep());
        Assert.assertEquals(format.getMontdep(), result.getData().get(0).getScheduledDeposit().getDepositAmount().getAmount());
        Assert.assertEquals(Integer.valueOf(0), format.getPerdepo());
        Assert.assertEquals(format.getPerdepo(), result.getData().get(0).getScheduledDeposit().getPeriod().getDayOfMonth());
    }

    @Test
    public void mapOut2FullTest() {
        FormatoBGMQ742 format = FormatsBq74Mock.getInstance().getFormatoBGMQ742();
        DTOIntPockets result = new DTOIntPockets();
        result = mapper.mapOut2(format, result);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPagination());
    }

    @Test
    public void mapOut2EmptyTest() {
        DTOIntPockets result = new DTOIntPockets();
        result = mapper.mapOut2(new FormatoBGMQ742(), result);

        Assert.assertNotNull(result);
        Assert.assertNull(result.getPagination());
    }
}
