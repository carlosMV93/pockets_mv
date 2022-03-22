package com.bbva.pzic.pockets.dao.model.bq44.mock;

import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44P1;
import com.bbva.pzic.pockets.dao.model.bq44.FormatoBQM44S1;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created on 11/05/2017.
 *
 * @author Entelgy
 */
@Component
public class FormatsBq44Mock {

    private static final String FORMATO_BQM44S1_FILE = "com/bbva/pzic/pockets/dao/model/bq44/mock/formatoBQM44S1.json";
    private static final String FORMATO_BQM44P1_FILE = "com/bbva/pzic/pockets/dao/model/bq44/mock/formatoBQM44P1.json";

    private ObjectMapper mapper;

    public FormatsBq44Mock() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper = new ObjectMapper();
        mapper.setDateFormat(dateFormat);
    }

    public FormatoBQM44P1 getFormatoBQM44P1() throws IOException {
        return mapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(FORMATO_BQM44P1_FILE), FormatoBQM44P1.class);
    }

    public List<FormatoBQM44S1> getFormatoBQM44S1() throws IOException {
        return mapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(FORMATO_BQM44S1_FILE), new TypeReference<List<FormatoBQM44S1>>() {
        });
    }
}
