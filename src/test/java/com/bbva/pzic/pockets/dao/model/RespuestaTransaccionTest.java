package com.bbva.pzic.pockets.dao.model;

import com.bbva.jee.arq.spring.core.host.RespuestaTransaccion;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterClassName;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.affirm.Affirm;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author Entelgy
 */
public class RespuestaTransaccionTest {

    @Test
    public void annotationRespuestaTransaccionTest() {
        final PojoClassFilter filter = new FilterClassName("RespuestaTransaccion(?!Test)\\w{4}(?!_)");
        final StringBuilder result = new StringBuilder();

        List<PojoClass> responses = PojoClassFactory.getPojoClassesRecursively(this.getClass().getPackage().getName(), filter);

        boolean discriminator;
        for (PojoClass response : responses) {
            discriminator = false;
            for (Annotation annotation : response.getClazz().getAnnotations()) {
                if (annotation.annotationType().equals(RespuestaTransaccion.class)) {
                    discriminator = true;
                    break;
                }
            }

            if (!discriminator) {
                result.append(String.format("\n%s not contain annotation @RespuestaTransaccion", response.getClazz().getName()));
            }
        }

        Affirm.affirmTrue(result.toString(), result.toString().isEmpty());
    }
}
