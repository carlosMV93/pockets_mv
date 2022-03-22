package com.bbva.pzic.pockets.dao.model.bq76.mock;

import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76S1;
import com.bbva.pzic.pockets.util.mappers.ObjectMapperHelper;

import java.io.IOException;

public class FormatsBq76Mock {

    private static final FormatsBq76Mock INSTANCE = new FormatsBq76Mock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private FormatsBq76Mock() {
    }

    public static FormatsBq76Mock getInstance() {
        return INSTANCE;
    }

    public FormatoBQM76S1 getFormatoBQM76S1() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(
                                "com/bbva/pzic/pockets/dao/model/bq76/mock/FormatoBQM76S1.json"),
                FormatoBQM76S1.class);
    }
}
