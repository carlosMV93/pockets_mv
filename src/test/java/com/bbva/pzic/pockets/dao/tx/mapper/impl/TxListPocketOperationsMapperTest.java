package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.EntityMock;
import com.bbva.pzic.pockets.business.dto.DTOIntOperations;
import com.bbva.pzic.pockets.business.dto.InputListPocketOperations;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ750;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ751;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ752;
import com.bbva.pzic.pockets.dao.model.bq75.mock.FormatsBq75Mock;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
@RunWith(MockitoJUnitRunner.class)
public class TxListPocketOperationsMapperTest {

    @InjectMocks
    private TxListPocketOperationsMapper mapper;

    @Mock
    private Translator translator;

    @Before
    public void setUp() {
        Mockito.when(translator.translateBackendEnumValueStrictly("operation.operationType.id", "CONTRIBUTION")).thenReturn("CONTRIBUTION");
        Mockito.when(translator.translateBackendEnumValueStrictly("operation.origin.numberType.id", "L")).thenReturn("LIC");
        Mockito.when(translator.translateBackendEnumValueStrictly("operation.origin.product.id", "P")).thenReturn("POCKETS");
    }

    @Test
    public void mapInFullTest() {
        InputListPocketOperations input = EntityMock.getInstance().getInputListPocketOperations();
        FormatoBGMQ750 result = mapper.mapIn(input);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdepock());
        Assert.assertNotNull(result.getIdpagin());
        Assert.assertNotNull(result.getTampagi());

        Assert.assertEquals(input.getPocketId(), result.getIdepock());
        Assert.assertEquals(input.getPaginationKey(), result.getIdpagin());
        Assert.assertEquals(input.getPageSize().toString(), result.getTampagi().toString());
    }

    @Test
    public void mapInEmptyTest() {
        FormatoBGMQ750 result = mapper.mapIn(new InputListPocketOperations());
        Assert.assertNotNull(result);
        Assert.assertNull(result.getIdepock());
        Assert.assertNull(result.getIdpagin());
        Assert.assertNull(result.getTampagi());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        List<FormatoBGMQ751> formats = FormatsBq75Mock.getInstance().getFormatoBGMQ751();
        DTOIntOperations result = new DTOIntOperations();

        FormatoBGMQ751 format = formats.get(0);
        result = mapper.mapOut(format, result);

        Assert.assertEquals(3, formats.size());
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
        Assert.assertNotNull(result.getData().get(0));
        Assert.assertNotNull(result.getData().get(0).getId());
        Assert.assertNotNull(result.getData().get(0).getAdditionalInformation());
        Assert.assertNotNull(result.getData().get(0).getOperationAmount());
        Assert.assertNotNull(result.getData().get(0).getOperationAmount().getAmount());
        Assert.assertNotNull(result.getData().get(0).getOperationAmount().getCurrency());
        Assert.assertNotNull(result.getData().get(0).getOperationNumber());
        Assert.assertNotNull(result.getData().get(0).getOperationDate());
        Assert.assertNotNull(result.getData().get(0).getOperationType());
        Assert.assertNotNull(result.getData().get(0).getOperationType().getId());
        Assert.assertNotNull(result.getData().get(0).getOrigin());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getId());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getNumber());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getNumberType());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getNumberType().getId());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getNumberType().getName());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getProduct());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getProduct().getId());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getProduct().getName());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getRelationType());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getRelationType().getId());
        Assert.assertNotNull(result.getData().get(0).getOrigin().getRelationType().getName());
        Assert.assertNotNull(result.getData().get(0).getEstablishmentName());

        Assert.assertEquals(format.getNumeope().toString(), result.getData().get(0).getId());
        Assert.assertEquals(format.getDetmovi(), result.getData().get(0).getAdditionalInformation());
        Assert.assertEquals(format.getMtomovi(), result.getData().get(0).getOperationAmount().getAmount());
        Assert.assertEquals(format.getDivmovi(), result.getData().get(0).getOperationAmount().getCurrency());
        Assert.assertEquals(format.getNumeope().toString(), result.getData().get(0).getOperationNumber());
        Assert.assertEquals(format.getTipoper(), result.getData().get(0).getOperationType().getId());
        Assert.assertEquals(format.getIdepock(), result.getData().get(0).getOrigin().getId());
        Assert.assertEquals(format.getNumecta(), result.getData().get(0).getOrigin().getNumber());
        Assert.assertEquals("LIC", result.getData().get(0).getOrigin().getNumberType().getId());
        Assert.assertEquals(format.getDestico(), result.getData().get(0).getOrigin().getNumberType().getName());
        Assert.assertEquals("POCKETS", result.getData().get(0).getOrigin().getProduct().getId());
        Assert.assertEquals(format.getDesprre(), result.getData().get(0).getOrigin().getProduct().getName());
        Assert.assertEquals(format.getReltyid(), result.getData().get(0).getOrigin().getRelationType().getId());
        Assert.assertEquals(format.getRelname(), result.getData().get(0).getOrigin().getRelationType().getName());
        Assert.assertEquals(format.getNomesta(), result.getData().get(0).getEstablishmentName());

        FormatoBGMQ751 format2 = formats.get(1);
        result = mapper.mapOut(format2, result);

        Assert.assertNotNull(result.getData().get(1));
        Assert.assertNotNull(result.getData().get(1).getId());
        Assert.assertNotNull(result.getData().get(1).getAdditionalInformation());
        Assert.assertNotNull(result.getData().get(1).getOperationAmount());
        Assert.assertNotNull(result.getData().get(1).getOperationAmount().getAmount());
        Assert.assertNotNull(result.getData().get(1).getOperationAmount().getCurrency());
        Assert.assertNotNull(result.getData().get(1).getOperationNumber());
        Assert.assertNotNull(result.getData().get(1).getOperationDate());
        Assert.assertNotNull(result.getData().get(1).getOperationType());
        Assert.assertNotNull(result.getData().get(1).getOperationType().getId());
        Assert.assertNotNull(result.getData().get(1).getOrigin());
        Assert.assertNotNull(result.getData().get(1).getOrigin().getId());
        Assert.assertNotNull(result.getData().get(1).getOrigin().getNumber());
        Assert.assertNotNull(result.getData().get(1).getOrigin().getNumberType());
        Assert.assertNotNull(result.getData().get(1).getOrigin().getNumberType().getId());
        Assert.assertNull(result.getData().get(1).getOrigin().getNumberType().getName());
        Assert.assertNotNull(result.getData().get(1).getOrigin().getProduct());
        Assert.assertNotNull(result.getData().get(1).getOrigin().getProduct().getId());
        Assert.assertNull(result.getData().get(1).getOrigin().getProduct().getName());
        Assert.assertNotNull(result.getData().get(1).getOrigin().getRelationType());
        Assert.assertNotNull(result.getData().get(1).getOrigin().getRelationType().getId());
        Assert.assertNull(result.getData().get(1).getOrigin().getRelationType().getName());
        Assert.assertNotNull(result.getData().get(1).getEstablishmentName());

        Assert.assertEquals(format2.getNumeope().toString(), result.getData().get(1).getId());
        Assert.assertEquals(format2.getDetmovi(), result.getData().get(1).getAdditionalInformation());
        Assert.assertEquals(format2.getMtomovi(), result.getData().get(1).getOperationAmount().getAmount());
        Assert.assertEquals(format2.getDivmovi(), result.getData().get(1).getOperationAmount().getCurrency());
        Assert.assertEquals(format2.getNumeope().toString(), result.getData().get(1).getOperationNumber());
        Assert.assertEquals(format2.getTipoper(), result.getData().get(1).getOperationType().getId());
        Assert.assertEquals(format2.getIdepock(), result.getData().get(1).getOrigin().getId());
        Assert.assertEquals(format2.getNumecta(), result.getData().get(1).getOrigin().getNumber());
        Assert.assertEquals("LIC", result.getData().get(1).getOrigin().getNumberType().getId());
        Assert.assertEquals("POCKETS", result.getData().get(1).getOrigin().getProduct().getId());
        Assert.assertEquals(format2.getReltyid(), result.getData().get(1).getOrigin().getRelationType().getId());
        Assert.assertEquals(format2.getNomesta(), result.getData().get(1).getEstablishmentName());

        FormatoBGMQ751 format3 = formats.get(2);
        result = mapper.mapOut(format3, result);

        Assert.assertNotNull(result.getData().get(2));
        Assert.assertNotNull(result.getData().get(2).getId());
        Assert.assertNull(result.getData().get(2).getAdditionalInformation());
        Assert.assertNotNull(result.getData().get(2).getOperationAmount());
        Assert.assertNotNull(result.getData().get(2).getOperationAmount().getAmount());
        Assert.assertNotNull(result.getData().get(2).getOperationNumber());
        Assert.assertNull(result.getData().get(2).getOperationDate());
        Assert.assertNull(result.getData().get(2).getOperationType());
        Assert.assertNull(result.getData().get(2).getOrigin());
        Assert.assertNull(result.getData().get(2).getEstablishmentName());

        Assert.assertEquals(format3.getNumeope().toString(), result.getData().get(2).getId());
        Assert.assertEquals(format3.getMtomovi(), result.getData().get(2).getOperationAmount().getAmount());
        Assert.assertEquals(format3.getNumeope().toString(), result.getData().get(2).getOperationNumber());
    }

    @Test
    public void mapOutEmptyTest() throws IOException {
        DTOIntOperations result = new DTOIntOperations();
        FormatoBGMQ751 format = FormatsBq75Mock.getInstance().getFormatoBGMQ751Empty();
        result = mapper.mapOut(format, result);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
        Assert.assertEquals(1, result.getData().size());
        Assert.assertNotNull(result.getData().get(0));
        Assert.assertNotNull(result.getData().get(0).getId());
        Assert.assertNull(result.getData().get(0).getAdditionalInformation());
        Assert.assertNotNull(result.getData().get(0).getOperationAmount());
        Assert.assertNotNull(result.getData().get(0).getOperationNumber());
        Assert.assertNull(result.getData().get(0).getOperationDate());
        Assert.assertNull(result.getData().get(0).getOperationType());
        Assert.assertNull(result.getData().get(0).getOrigin());
        Assert.assertNull(result.getData().get(0).getEstablishmentName());
    }

    @Test
    public void mapOut2FullTest() throws IOException {
        FormatoBGMQ752 format = FormatsBq75Mock.getInstance().getFormatoBGMQ752();
        DTOIntOperations result = new DTOIntOperations();
        result = mapper.mapOut2(format, result);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPagination());
        Assert.assertNotNull(result.getPagination().getPaginationKey());
        Assert.assertNotNull(result.getPagination().getPageSize());
        Assert.assertEquals(format.getIdpagin(), result.getPagination().getPaginationKey());
        Assert.assertEquals(format.getTampagi().toString(), result.getPagination().getPageSize().toString());
    }

    @Test
    public void mapOut2EmptyTest() throws IOException {
        DTOIntOperations result = new DTOIntOperations();
        result = mapper.mapOut2(FormatsBq75Mock.getInstance().getFormatoBGMQ752Empty(), result);

        Assert.assertNotNull(result);
        Assert.assertNull(result.getPagination().getPaginationKey());
        Assert.assertNotNull(result.getPagination().getPageSize());
    }
}