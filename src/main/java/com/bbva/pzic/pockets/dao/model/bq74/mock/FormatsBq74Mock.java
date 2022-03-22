package com.bbva.pzic.pockets.dao.model.bq74.mock;

import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ741;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ742;
import com.bbva.pzic.pockets.util.mappers.ObjectMapperHelper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public final class FormatsBq74Mock {

    private static final FormatsBq74Mock INSTANCE = new FormatsBq74Mock();

    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private FormatsBq74Mock() {
    }

    public static FormatsBq74Mock getInstance() {
        return INSTANCE;
    }

    public List<FormatoBGMQ741> getFormatoBGMQ741() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/pockets/dao/model/bq74/mock/formatosBGMQ741.json"), new TypeReference<List<FormatoBGMQ741>>() {
        });
    }

    public FormatoBGMQ742 getFormatoBGMQ742() {
        FormatoBGMQ742 formatoBGMQ742 = new FormatoBGMQ742();
        formatoBGMQ742.setIdpagin("xxasa310192");
        formatoBGMQ742.setTampagi(20);
        return formatoBGMQ742;
    }
}
