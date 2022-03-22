package com.bbva.pzic.pockets.util;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Entelgy
 */
public final class BusinessServiceUtil {

    private static final Log LOG = LogFactory.getLog(BusinessServiceUtil.class);

    private BusinessServiceUtil() {
        // Prevent instantiation
    }

    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    public static Long toLong(Object object) {
        if (object == null) {
            return null;
        }
        return Long.valueOf(object.toString());
    }

    /**
     * Expande los atributos del objeto enviado
     *
     * @param object                  objeto
     * @param possibleJoinedExpanders nombre de todos los atributos, separados por comas, que podr&aacute;n ser expandidos.
     * @param joinedExpandersReceived nombre de los atributos, separados por comas, que se quieren expandir.
     */
    @SuppressWarnings("unchecked")
    public static <T> void expand(T object, String possibleJoinedExpanders, String joinedExpandersReceived) {
        if (object != null && possibleJoinedExpanders != null) {
            if (joinedExpandersReceived != null && joinedExpandersReceived.isEmpty()) {
                throw new BusinessServiceException(Errors.EXPAND_EMPTY);
            }

            final List<String> possibleExpanders = Arrays.asList(possibleJoinedExpanders.split(","));
            final List<String> expandersReceived = joinedExpandersReceived == null
                    ? Collections.emptyList()
                    : Arrays.asList(joinedExpandersReceived.split(","));

            for (final String expander : expandersReceived) {
                if (!possibleExpanders.contains(expander)) {
                    throw new BusinessServiceException(Errors.EXPAND_ERROR, expander);
                }
            }

            final List<String> expandersNotReceived = new ArrayList<>(possibleExpanders);
            expandersNotReceived.removeAll(expandersReceived);
            for (String expander : expandersNotReceived) {
                if (object instanceof Collection<?>) {
                    for (T element : (Collection<T>) object) {
                        setNullOnField(element, expander);
                    }
                } else {
                    setNullOnField(object, expander);
                }
            }
        }
    }

    private static <T> void setNullOnField(T object, String expander) {
        Field field = getFieldByName(object.getClass(), expander);
        if (field != null) {
            field.setAccessible(true);
            try {
                if (!field.getType().isPrimitive()) {
                    field.set(object, null);
                }
            } catch (IllegalAccessException e) {
                throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
            }
        }
    }

    private static Field getFieldByName(Class<?> clazz, String name) {
        if (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                if (!field.isSynthetic() && field.getName().equals(name)) {
                    return field;
                }
            }
            return getFieldByName(clazz.getSuperclass(), name);
        }
        return null;
    }

    /**
     * Método que construye un DateTime, esta función no valida
     * @param date Objeto de tipo Date.
     * @param datetime Hora de la fecha a construir, formato HH:mm:ss
     * @return {@link Date}
     */
    public static Date constructDateTime(Date date, String datetime){
        LOG.info("... called method BusinessServiceUtil.constructDateTime ...");
        if (datetime.length() != 8) {
            LOG.error("... datetime hasn't 8 characters (HH:MM:SS) ...");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }
        int hour = Integer.parseInt(datetime.substring(0, 2));
        int minute = Integer.parseInt(datetime.substring(3, 5));
        int second = Integer.parseInt(datetime.substring(6));
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }
}
