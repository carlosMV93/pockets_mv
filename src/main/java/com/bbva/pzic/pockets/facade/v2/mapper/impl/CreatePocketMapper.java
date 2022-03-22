package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.facade.v2.mapper.ICreatePocketMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.FromStringConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper("createPocketMapperV2")
public class CreatePocketMapper extends ConfigurableMapper implements ICreatePocketMapper {

    private static final Log LOG = LogFactory.getLog(CreatePocketMapper.class);

    private Translator translator;

    @Autowired
    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    @Override
    protected void configure(MapperFactory factory) {

        super.configure(factory);
        factory.getConverterFactory().registerConverter(new FromStringConverter());
        factory.classMap(Pocket.class, DTOIntPocket.class)
                .field("relatedContract.number", "relatedContract.number")
                .field("category.id", "category.id")
                .field("alias", "alias")
                .field("goalAmount.amount", "goalAmount.amount")
                .field("goalAmount.currency", "goalAmount.currency")
                .field("expirationDate", "expirationDate")
                .field("isScheduled", "isScheduled")
                .field("scheduledDeposit.depositAmount.amount", "scheduledDeposit.depositAmount.amount")
                .field("scheduledDeposit.depositAmount.currency", "scheduledDeposit.depositAmount.currency")
                .field("scheduledDeposit.period.frequency.id", "scheduledDeposit.period.frequency.id")
                .field("scheduledDeposit.period.dayOfMonth", "scheduledDeposit.period.dayOfMonth")
                .register();
    }

    @Override
    public DTOIntPocket mapIn(Pocket pocket) {
        LOG.info("... called method CreatePocketMapper.mapIn ...");
        DTOIntPocket dtoIntPocket = map(pocket, DTOIntPocket.class);
        if (dtoIntPocket.getScheduledDeposit() != null &&
                dtoIntPocket.getScheduledDeposit().getPeriod() != null &&
                dtoIntPocket.getScheduledDeposit().getPeriod().getFrequency() != null) {

            dtoIntPocket.getScheduledDeposit().getPeriod().getFrequency().setId(
                    translator.translateFrontendEnumValueStrictly("pocket.period.frequencyId", pocket.getScheduledDeposit().getPeriod().getFrequency().getId()));
        }
        return dtoIntPocket;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ServiceResponse<Pocket> mapOut(Pocket pocket) {
        LOG.info("... called method CreatePocketMapper.mapOut ...");
        if (pocket == null) {
            return null;
        }
        return ServiceResponse.data(pocket).build();
    }
}
