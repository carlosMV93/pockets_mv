package com.bbva.pzic.pockets.dao.model.bq79;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ79</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq79 {

    @InjectMocks
    private TransaccionBq79 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionBq79 peticion = new PeticionTransaccionBq79();

        RespuestaTransaccionBq79 respuesta = new RespuestaTransaccionBq79();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq79.class, RespuestaTransaccionBq79.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq79 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);

    }
}