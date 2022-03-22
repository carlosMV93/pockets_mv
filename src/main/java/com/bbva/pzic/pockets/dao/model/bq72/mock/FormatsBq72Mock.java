package com.bbva.pzic.pockets.dao.model.bq72.mock;

import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ721;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created on 15/08/2018.
 *
 * @author Entelgy
 */
public final class FormatsBq72Mock {

    private static final FormatsBq72Mock INSTANCE = new FormatsBq72Mock();
    private ObjectMapper objectMapper;

    private FormatsBq72Mock() {
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    public static FormatsBq72Mock getInstance() {
        return INSTANCE;
    }

    public List<FormatoBGMQ721> getFormatoBGMQ721() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "com/bbva/pzic/pockets/dao/model/bq72/mock/formatosBGMQ721.json"), new TypeReference<List<FormatoBGMQ721>>() {
        });
    }
}