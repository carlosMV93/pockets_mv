package com.bbva.pzic.pockets.util;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.routine.commons.utils.DateUtils;

import java.text.ParseException;
import java.util.Calendar;

public class FunctionUtils {

    private FunctionUtils() {
    }

    public static Calendar buildDatetime(String date, String time) {
        if (date == null || time == null) {
            return null;
        }
        try {
            return DateUtils.toDateTime(date, time);
        } catch (ParseException e) {
            throw new BusinessServiceException(Errors.WRONG_DATE, e);
        }
    }
}