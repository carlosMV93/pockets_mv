package com.bbva.pzic.pockets.dao.model.bq79.mock;

import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79S1;
import com.bbva.pzic.pockets.util.mappers.ObjectMapperHelper;

import java.io.IOException;

/**
 * Created on 16/10/2018.
 *
 * @author Entelgy
 */
public final class FormatsBq79Mock {

    private static final FormatsBq79Mock INSTANCE = new FormatsBq79Mock();
    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private FormatsBq79Mock() {
    }

    public static FormatsBq79Mock getInstance() {
        return INSTANCE;
    }

    public FormatoBQM79S1 getFormatoBQM79S1() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq79/mock/formatoBQM79S1.json"), FormatoBQM79S1.class);
    }

    public FormatoBQM79S1 getFormatoBQM79S1Empty() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq79/mock/formatoBQM79S1-EMPTY.json"), FormatoBQM79S1.class);
    }

}