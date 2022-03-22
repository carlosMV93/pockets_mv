package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntAutomaticAmount;
import com.bbva.pzic.pockets.business.dto.DTOIntPocket;
import com.bbva.pzic.pockets.dao.model.bq43.FormatoBQM43E1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxModifyPocketMapper;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.BooleanToStringConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper(value = "txModifyPocketMapper")
public class TxModifyPocketMapper extends ConfigurableMapper implements ITxModifyPocketMapper {

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.getConverterFactory().registerConverter(new BooleanToStringConverter());

        factory.classMap(FormatoBQM43E1.class, DTOIntPocket.class)
                .field("idpoc", "id")
                .field("nompoc", "name")
                .field("nomcor", "shortName")
                .field("monpoc", "goalAmount.value")
                .field("moneda", "goalAmount.currency")
                .field("fechpoc", "goalDate")
                .field("pripoc", "priority")
                .field("tippoc", "pocketType.id")
                .field("flagpoc", "isAutomaticAmount")
                .register();
    }

    @Override
    public FormatoBQM43E1 mapIn(final DTOIntPocket dtoIn) {

        FormatoBQM43E1 formatoBQM43E1 = map(dtoIn, FormatoBQM43E1.class);
        if (dtoIn.getIsAutomaticAmount() != null && dtoIn.getIsAutomaticAmount()) {
            setFormatWithDTOIntAutomaticAmount(formatoBQM43E1, dtoIn.getAutomaticAmount());
        }
        return formatoBQM43E1;
    }

    private void setFormatWithDTOIntAutomaticAmount(FormatoBQM43E1 format, DTOIntAutomaticAmount dtoIn) {
        if (dtoIn != null) {
            format.setImpaut(dtoIn.getValue());
            format.setMonimp(dtoIn.getCurrency());
            if (dtoIn.getPeriod() != null) {
                format.setPeraut(enumMapper.getBackendValue("pocket.automaticAmount.period.id", dtoIn.getPeriod().getId()));
            }
            format.setDiaauto(dtoIn.getDayMonth());
        }
    }

}