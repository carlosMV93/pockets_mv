package com.bbva.pzic.pockets.dao.model.bq77;

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
 * Test de la transacci&oacute;n <code>BQ77</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq77 {

    private static final Log LOG = LogFactory.getLog(TestTransaccionBq77.class);

    @InjectMocks
    private TransaccionBq77 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);


    @Test
    public void test() throws ExcepcionTransaccion {

        PeticionTransaccionBq77 peticion = new PeticionTransaccionBq77();
        RespuestaTransaccionBq77 respuesta = transaccion.invocar(peticion);

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq77.class, RespuestaTransaccionBq77.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq77 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}