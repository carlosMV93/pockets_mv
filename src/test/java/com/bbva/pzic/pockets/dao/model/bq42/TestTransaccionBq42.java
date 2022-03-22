package com.bbva.pzic.pockets.dao.model.bq42;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ42</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq42 {

    @InjectMocks
    private TransaccionBq42 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionBq42 peticion = new PeticionTransaccionBq42();
        RespuestaTransaccionBq42 respuesta = new RespuestaTransaccionBq42();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq42.class, RespuestaTransaccionBq42.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq42 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}