package com.bbva.pzic.pockets.dao.model.bq41;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ41</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq41 {

    @InjectMocks
    private TransaccionBq41 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {
        PeticionTransaccionBq41 peticion = new PeticionTransaccionBq41();
        RespuestaTransaccionBq41 respuesta = new RespuestaTransaccionBq41();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq41.class, RespuestaTransaccionBq41.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq41 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}