package com.bbva.pzic.pockets.dao.model.bq74;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ74</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq74 {

    @InjectMocks
    private TransaccionBq74 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionBq74 peticion = new PeticionTransaccionBq74();

        RespuestaTransaccionBq74 respuesta = new RespuestaTransaccionBq74();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq74.class, RespuestaTransaccionBq74.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq74 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}