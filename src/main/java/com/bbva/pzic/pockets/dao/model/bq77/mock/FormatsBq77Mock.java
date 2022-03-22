package com.bbva.pzic.pockets.dao.model.bq77.mock;

import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77S1;
import com.bbva.pzic.pockets.util.mappers.ObjectMapperHelper;

import java.io.IOException;

public class FormatsBq77Mock {

    private static final FormatsBq77Mock INSTANCE = new FormatsBq77Mock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private FormatsBq77Mock() {
    }

    public static FormatsBq77Mock getInstance() {
        return INSTANCE;
    }

    public FormatoBQM77S1 getFormatoBQM77S1() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(
                                "com/bbva/pzic/pockets/dao/model/bq77/mock/formatoBQM77S1.json"),
                FormatoBQM77S1.class);
    }

}
