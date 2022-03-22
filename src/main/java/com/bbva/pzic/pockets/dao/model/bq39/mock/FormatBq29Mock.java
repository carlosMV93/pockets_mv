package com.bbva.pzic.pockets.dao.model.bq39.mock;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39P1;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39S1;
import com.bbva.pzic.pockets.util.Errors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created on 2017-03-11.
 *
 * @author Entelgy
 */
@Component
public class FormatBq29Mock {

    private ObjectMapper objectMapper;

    public FormatBq29Mock() {
        objectMapper = new ObjectMapper();
    }

    public FormatoBQM39P1 getFormatoBQM39P1() {
        try {
            return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq39/mock/formatoBQM39P1.json"),
                    FormatoBQM39P1.class);
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    public List<FormatoBQM39S1> getFormatoBQM39S1() {
        try {
            return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream("com/bbva/pzic/pockets/dao/model/bq39/mock/formatoBQM39S1.json"),
                    new TypeReference<List<FormatoBQM39S1>>() {
                    });
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }
}
