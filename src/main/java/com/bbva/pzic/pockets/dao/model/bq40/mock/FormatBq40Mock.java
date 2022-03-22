package com.bbva.pzic.pockets.dao.model.bq40.mock;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40S1;
import com.bbva.pzic.pockets.util.Errors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created on 10/05/2017.
 *
 * @author Entelgy
 */
@Component
public class FormatBq40Mock {
    private ObjectMapper objectMapper;

    public FormatBq40Mock() {
        objectMapper = new ObjectMapper();
    }

    public FormatoBQM40S1 getFormatoBQM40S1() {
        try {
            return objectMapper.readValue(
                    Thread.currentThread().getContextClassLoader().getResourceAsStream(
                            "com/bbva/pzic/pockets/dao/model/bq40/mock/formatoBQM40S1.json"),
                    new TypeReference<FormatoBQM40S1>() {
                    });
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }
}
