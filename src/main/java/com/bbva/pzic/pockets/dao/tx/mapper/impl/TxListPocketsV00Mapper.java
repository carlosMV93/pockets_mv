package com.bbva.pzic.pockets.dao.tx.mapper.impl;

import com.bbva.pzic.pockets.business.dto.DTOIntPocketsData;
import com.bbva.pzic.pockets.business.dto.InputListPocket;
import com.bbva.pzic.pockets.canonic.AccountFamily;
import com.bbva.pzic.pockets.canonic.AccountPocket;
import com.bbva.pzic.pockets.canonic.PocketV00;
import com.bbva.pzic.pockets.canonic.Status;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39E1;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39P1;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39S1;
import com.bbva.pzic.pockets.dao.tx.mapper.ITxListPocketsV00Mapper;
import com.bbva.pzic.pockets.util.mappers.EnumMapper;
import com.bbva.pzic.pockets.util.mappers.Mapper;
import com.bbva.pzic.pockets.util.orika.MapperFactory;
import com.bbva.pzic.pockets.util.orika.converter.builtin.DateToStringConverter;
import com.bbva.pzic.pockets.util.orika.converter.builtin.LongToIntegerConverter;
import com.bbva.pzic.pockets.util.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@Mapper("txListPocketsV00Mapper")
public class TxListPocketsV00Mapper extends ConfigurableMapper implements ITxListPocketsV00Mapper {

    public static final String ENUM_FIELD_POCKET_STATUS_ID = "pocket.status.id";
    public static final String CONSTANT_SAVINGS = "SAVINGS";

    @Autowired
    private EnumMapper enumMapper;

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.getConverterFactory().registerConverter(new LongToIntegerConverter());
        factory.getConverterFactory().registerConverter(new DateToStringConverter(DateToStringConverter.DateFormatsBBVA.SHORT_FORMAT));

        factory.classMap(FormatoBQM39E1.class, InputListPocket.class)
                .field("idpagin", "paginationKey")
                .field("tampagi", "pageSize")
                .field("numcuen", "accountPocketNumber")
                .register();

        factory.classMap(FormatoBQM39S1.class, PocketV00.class)
                .field("idpoc", "id")
                .field("numcuen", "accountPocket.number")
                .field("nomcor", "shortName")
                .field("monpoc", "goalAmount.value")
                .field("moneda", "goalAmount.currency")
                .field("pripoc", "priority")
                .field("fechpoc", "goalDate")
                .field("ahopoc", "currentAmount.value")
                .field("monaho", "currentAmount.currency")
                .field("estpoc", "status.id")
                .field("desest", "status.name")
                .register();

        factory.classMap(FormatoBQM39P1.class, DTOIntPocketsData.class)
                .field("idpagin", "pagination.paginationKey")
                .field("tampagi", "pagination.pageSize")
                .register();
    }

    @Override
    public FormatoBQM39E1 mapIn(InputListPocket dto) {
        FormatoBQM39E1 formatoBQM39E1 = map(dto, FormatoBQM39E1.class);

        if (dto.getStatusId() == null) {
            return formatoBQM39E1;
        }

        formatoBQM39E1.setOpcion(enumMapper.getBackendValue(ENUM_FIELD_POCKET_STATUS_ID, dto.getStatusId()));
        return formatoBQM39E1;
    }

    @Override
    public DTOIntPocketsData mapOutData(FormatoBQM39S1 format, DTOIntPocketsData dto) {
        PocketV00 pocket = map(format, PocketV00.class);
        verifyAndAddData(dto, pocket);

        if (pocket.getAccountPocket() == null) {
            pocket.setAccountPocket(new AccountPocket());
        }
        AccountFamily accountFamily = new AccountFamily();
        accountFamily.setId(CONSTANT_SAVINGS);
        pocket.getAccountPocket().setAccountFamily(accountFamily);

        if (format.getEstpoc() == null) {
            return dto;
        }

        if (pocket.getStatus() == null) {
            pocket.setStatus(new Status());
        }
        pocket.getStatus().setId(enumMapper.getEnumValue(ENUM_FIELD_POCKET_STATUS_ID, format.getEstpoc()));

        return dto;
    }

    private void verifyAndAddData(DTOIntPocketsData pockets, PocketV00 pocket) {
        if (pockets.getData() == null) {
            pockets.setData(new ArrayList<PocketV00>());
        }
        pockets.getData().add(pocket);
    }

    @Override
    public DTOIntPocketsData mapOutPagination(FormatoBQM39P1 format, DTOIntPocketsData dtoIntTransactionData) {
        if (dtoIntTransactionData.getPagination() == null) {
            map(format, dtoIntTransactionData);
        }
        return dtoIntTransactionData;
    }
}