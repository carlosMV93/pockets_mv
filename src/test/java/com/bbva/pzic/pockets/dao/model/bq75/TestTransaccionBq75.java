package com.bbva.pzic.pockets.dao.model.bq75;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ75</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq75 {

    @InjectMocks
    private TransaccionBq75 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionBq75 peticion = new PeticionTransaccionBq75();

        RespuestaTransaccionBq75 respuesta = new RespuestaTransaccionBq75();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq75.class, RespuestaTransaccionBq75.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq75 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}
