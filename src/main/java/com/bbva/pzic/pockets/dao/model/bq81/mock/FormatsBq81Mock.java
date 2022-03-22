package com.bbva.pzic.pockets.dao.model.bq81.mock;

import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81S1;
import com.bbva.pzic.pockets.util.mappers.ObjectMapperHelper;

import java.io.IOException;

public class FormatsBq81Mock {

    private static final FormatsBq81Mock INSTANCE = new FormatsBq81Mock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private FormatsBq81Mock() {
    }

    public static FormatsBq81Mock getInstance() {
        return INSTANCE;
    }

    public FormatoBQM81S1 getFormatoBQM81S1() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/pockets/dao/model/bq81/mock/FormatoBQM81S1.json"), FormatoBQM81S1.class);
    }

}
