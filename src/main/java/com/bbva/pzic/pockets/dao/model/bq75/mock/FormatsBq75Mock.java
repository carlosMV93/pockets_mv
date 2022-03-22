package com.bbva.pzic.pockets.dao.model.bq75.mock;

import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ751;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ752;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created on 06/08/2018.
 *
 * @author Entelgy
 */
public final class FormatsBq75Mock {

    private static final FormatsBq75Mock INSTANCE = new FormatsBq75Mock();
    private ObjectMapper objectMapper;

    private FormatsBq75Mock() {
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    public static FormatsBq75Mock getInstance() {
        return INSTANCE;
    }

    public List<FormatoBGMQ751> getFormatoBGMQ751() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq75/mock/formatosBGMQ751.json"),
                new TypeReference<List<FormatoBGMQ751>>() {
                });
    }

    public FormatoBGMQ751 getFormatoBGMQ751Empty() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(
                                "com/bbva/pzic/pockets/dao/model/bq75/mock/formatoBGMQ751-EMPTY.json"),
                FormatoBGMQ751.class);
    }

    public FormatoBGMQ752 getFormatoBGMQ752() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq75/mock/formatosBGMQ752.json"), FormatoBGMQ752.class);
    }

    public FormatoBGMQ752 getFormatoBGMQ752Empty() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq75/mock/formatoBGMQ752-EMPTY.json"),
                FormatoBGMQ752.class);
    }
}