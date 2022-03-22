package com.bbva.pzic.pockets.dao.model.bq76;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ76</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq76 {

    private static final Log LOG = LogFactory.getLog(TestTransaccionBq76.class);

    @InjectMocks
    private TransaccionBq76 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() throws ExcepcionTransaccion {

        PeticionTransaccionBq76 peticion = new PeticionTransaccionBq76();

        RespuestaTransaccionBq76 respuesta = transaccion.invocar(peticion);


        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq76.class, RespuestaTransaccionBq76.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq76 result = transaccion.invocar(peticion);
        Assert.assertEquals(result, respuesta);
    }
}