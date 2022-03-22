package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.business.dto.InputCreatePocket;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.facade.v00.mapper.ICreatePocketMapper;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("createPocketMapper")
public class CreatePocketMapper extends ConfigurableMapper implements ICreatePocketMapper {
    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {

        super.configure(factory);
        //simulate
        factory.classMap(PocketV00.class, InputCreatePocket.class)
                .field("accountPocket.number", "accountPocketNumber")
                .field("accountPocket.accountFamily.id", "accountPocketAccountFamilyId")
                .field("pocketType.id", "pocketTypeId")
                .field("name", "name")
                .field("shortName", "shortName")
                .field("goalAmount.value", "goalAmountValue")
                .field("goalAmount.currency", "goalAmountCurrency")
                .field("goalDate", "goalDate")
                .field("isAutomaticAmount", "isAutomaticAmount")
                .field("automaticAmount.value", "automaticAmountValue")
                .field("automaticAmount.currency", "automaticAmountCurrency")
                .field("automaticAmount.period.id", "automaticAmountPeriodId")
                .field("automaticAmount.dayMonth", "automaticAmountDayMonth")
                .register();
    }

    /**
     * @see com.bbva.pzic.pockets.facade.v00.mapper.ICreatePocketMapper#mapIn(PocketV00)
     */
    @Override
    public InputCreatePocket mapIn(PocketV00 pocket) {
        final InputCreatePocket input = map(pocket, InputCreatePocket.class);
        input.setAutomaticAmountPeriodId(enumMapper.getBackendValue("pocket.automaticAmount.period.id", input.getAutomaticAmountPeriodId()));
        return input;
    }
}