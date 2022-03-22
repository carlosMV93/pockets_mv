package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.PathParamPocketId;
import com.bbva.pzic.pockets.canonic.AccountFamily;
import com.bbva.pzic.pockets.canonic.PocketData;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40E1;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxGetPocketMapper;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.BooleanToStringConverter;
import com.bbva.pzic.pockets.util.orika.converter.builtin.DateToStringConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("txGetPocketMapper")
public class TxGetPocketMapper extends ConfigurableMapper implements ITxGetPocketMapper {

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.getConverterFactory().registerConverter(new BooleanToStringConverter());
        factory.getConverterFactory().registerConverter(new DateToStringConverter(DateToStringConverter.DateFormatsBBVA.SHORT_FORMAT));
        factory.classMap(FormatoBQM40S1.class, PocketV00.class)
                .field("pocket", "id")
                .field("numcuen", "accountPocket.number")
                .field("nompoc", "name")
                .field("nomcor", "shortName")
                .field("monpoc", "goalAmount.value")
                .field("moneda", "goalAmount.currency")
                .field("flapoc", "isAutomaticAmount")
                .field("fechpoc", "goalDate")
                .field("pripoc", "priority")
                .field("ahopoc", "currentAmount.value")
                .field("monaho", "currentAmount.currency")
                .field("tippoc", "pocketType.id")
                .field("destipo", "pocketType.name")
                .field("estpoc", "status.id")
                .field("desest", "status.name")
                .field("impaut", "automaticAmount.value")
                .field("monimp", "automaticAmount.currency")
                .field("peraut", "automaticAmount.period.id")
                .field("desperi", "automaticAmount.period.name")
                .field("diaauto", "automaticAmount.dayMonth")
                .register();
    }

    @Override
    public FormatoBQM40E1 mapIn(PathParamPocketId dtoIn) {
        FormatoBQM40E1 format = new FormatoBQM40E1();
        format.setIdpoc(dtoIn.getPocketId());
        return format;
    }

    @Override
    public PocketData mapOut(FormatoBQM40S1 formatOutput) {

        if (formatOutput == null) {
            return null;
        }

        PocketV00 pocketMap = map(formatOutput, PocketV00.class);
        if (formatOutput.getEstpoc() != null) {
            pocketMap.getStatus().setId(enumMapper.getEnumValue("pocket.status.id", formatOutput.getEstpoc()));
        }
        if (formatOutput.getPeraut() != null) {
            pocketMap.getAutomaticAmount().getPeriod().setId(enumMapper.getEnumValue("pocket.automaticAmount.period.id", formatOutput.getPeraut()));
        }

        AccountFamily accountFamily = new AccountFamily();
        accountFamily.setId("SAVINGS");
        pocketMap.getAccountPocket().setAccountFamily(accountFamily);
        PocketData pocketData = new PocketData();
        pocketData.setData(pocketMap);

        return pocketData;
    }
}