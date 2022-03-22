package com.bbva.pzic.pockets.dao.model.bq78;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ78</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq78 {

    @InjectMocks
    private TransaccionBq78 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionBq78 peticion = new PeticionTransaccionBq78();

        RespuestaTransaccionBq78 respuesta = new RespuestaTransaccionBq78();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq78.class, RespuestaTransaccionBq78.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq78 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);

    }
}