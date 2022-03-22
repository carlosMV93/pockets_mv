package com.bbva.pzic.pockets.dao.model.bq40;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ40</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq40 {

    @InjectMocks
    private TransaccionBq40 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {
        PeticionTransaccionBq40 peticion = new PeticionTransaccionBq40();
        RespuestaTransaccionBq40 respuesta = new RespuestaTransaccionBq40();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq40.class, RespuestaTransaccionBq40.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq40 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}