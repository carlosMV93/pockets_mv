package com.bbva.pzic.pockets.facade.v2.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.pockets.business.dto.*;
import com.bbva.pzic.pockets.canonic.Pocket;
import com.bbva.pzic.pockets.facade.RegistryIds;
import com.bbva.pzic.pockets.facade.v2.mapper.IModifyPocketMapper;
import com.bbva.pzic.pockets.util.encrypt.AbstractCypherTool;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.FromStringConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on 19/10/2018.
 *
 * @author Entelgy
 */
@Mapper("modifyPocketMapperV2")
public class ModifyPocketMapper extends ConfigurableMapper implements IModifyPocketMapper {

    private static final Log LOG = LogFactory.getLog(ModifyPocketMapper.class);

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

        factory.getConverterFactory().registerConverter(new FromStringConverter());

        factory.classMap(Pocket.class, DTOIntPocketV2.class)
                .field("id", "id")
                .field("alias", "alias")
                .field("goalAmount.amount", "goalAmount.amount")
                .field("goalAmount.currency", "goalAmount.currency")
                .field("expirationDate", "expirationDate")
                .field("priority", "priority")
                .field("isScheduled", "isScheduled")
                .register();
    }

    @Override
    public DTOIntPocketV2 mapIn(final List<Pocket> pockets) {
        LOG.info("... called method ModifyPocketMapper.mapIn ...");

        if (CollectionUtils.isEmpty(pockets)) {
            return null;
        }

        Pocket pocket = pockets.get(0);

        DTOIntPocketV2 dtoIntPocketV2 = map(pocket, DTOIntPocketV2.class);
        dtoIntPocketV2.setId(cypherTool.decrypt(pocket.getId(), AbstractCypherTool.POCKET_ID,
                RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_POCKETS));

        if (pocket.getCategory() != null) {
            DTOIntCategoryV2 category = new DTOIntCategoryV2();
            category.setId(pocket.getCategory().getId());
            dtoIntPocketV2.setCategory(category);
        }

        if (pocket.getIsScheduled() != null && pocket.getIsScheduled()) {
            if (pocket.getScheduledDeposit() != null) {
                DTOIntScheduledDepositV2 scheduledDeposit = new DTOIntScheduledDepositV2();

                if (pocket.getScheduledDeposit().getDepositAmount() != null) {
                    DTOIntImport depositAmount = new DTOIntImport();
                    depositAmount.setAmount(pocket.getScheduledDeposit().getDepositAmount().getAmount());
                    depositAmount.setCurrency(pocket.getScheduledDeposit().getDepositAmount().getCurrency());
                    scheduledDeposit.setDepositAmount(depositAmount);
                }

                if (pocket.getScheduledDeposit().getPeriod() != null) {
                    DTOIntPeriod periodo = new DTOIntPeriod();

                    if (pocket.getScheduledDeposit().getPeriod().getFrequency() != null) {
                        DTOIntFrequency frequency = new DTOIntFrequency();
                        frequency.setId(translator.translateFrontendEnumValueStrictly("pocket.period.frequencyId",
                                pocket.getScheduledDeposit().getPeriod().getFrequency().getId()));
                        periodo.setFrequency(frequency);
                    }
                    periodo.setDayOfMonth(pocket.getScheduledDeposit().getPeriod().getDayOfMonth());
                    scheduledDeposit.setPeriod(periodo);
                }
                dtoIntPocketV2.setScheduledDeposit(scheduledDeposit);
            }
        }
        return dtoIntPocketV2;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ServiceResponse<List<Pocket>> mapOut(final List<Pocket> pockets) {
        LOG.info("... called method ModifyPocketMapper.mapOut ...");
        if (CollectionUtils.isEmpty(pockets)) {
            return null;
        }
        return ServiceResponse.data(pockets).build();
    }

}
