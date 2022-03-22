package com.bbva.pzic.pockets.dao.model.bq80.mock;

import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80S1;
import com.bbva.pzic.pockets.util.mappers.ObjectMapperHelper;

import java.io.IOException;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public final class FormatsBq80Mock {

    private static final FormatsBq80Mock INSTANCE = new FormatsBq80Mock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private FormatsBq80Mock() {
    }

    public static FormatsBq80Mock getInstance() {
        return INSTANCE;
    }

    public FormatoBQM80S1 getFormatoBQM80S1() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq80/mock/formatoBQM80S1.json"), FormatoBQM80S1.class);
    }

    public FormatoBQM80S1 getFormatoBQM80S1Empty() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq80/mock/formatoBQM80S1-EMPTY.json"), FormatoBQM80S1.class);
    }
}
