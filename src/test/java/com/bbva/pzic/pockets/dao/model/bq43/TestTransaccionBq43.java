package com.bbva.pzic.pockets.dao.model.bq43;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ43</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq43 {

    @InjectMocks
    private TransaccionBq43 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionBq43 peticion = new PeticionTransaccionBq43();
        RespuestaTransaccionBq43 respuesta = new RespuestaTransaccionBq43();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq43.class, RespuestaTransaccionBq43.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq43 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}