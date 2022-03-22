package com.bbva.pzic.pockets.facade.v00.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntAutomaticAmount;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.canonic.AutomaticAmount;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.facade.v00.mapper.IModifyPocketMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper
public class ModifyPocketMapper extends ConfigurableMapper implements IModifyPocketMapper {

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(PocketV00.class, DTOIntPocket.class)
                .field("name", "name")
                .field("shortName", "shortName")
                .field("goalAmount.value", "goalAmount.value")
                .field("goalAmount.currency", "goalAmount.currency")
                .field("goalDate", "goalDate")
                .field("priority", "priority")
                .field("pocketType.id", "pocketType.id")
                .field("isAutomaticAmount", "isAutomaticAmount")
                .register();

        factory.classMap(AutomaticAmount.class, DTOIntAutomaticAmount.class)
                .field("value", "value")
                .field("currency", "currency")
                .field("period.id", "period.id")
                .field("dayMonth", "dayMonth")
                .register();
    }

    public DTOIntPocket mapIn(final String pocketId, final PocketV00 pocket) {

        DTOIntPocket dtoInt = map(pocket, DTOIntPocket.class);
        if (dtoInt.getIsAutomaticAmount() != null && dtoInt.getIsAutomaticAmount()) {
            DTOIntAutomaticAmount dtoIntAutomaticAmount
                    = map(pocket.getAutomaticAmount(), DTOIntAutomaticAmount.class);
            dtoInt.setAutomaticAmount(dtoIntAutomaticAmount);
        }
        dtoInt.setId(pocketId);
        return dtoInt;
    }

}