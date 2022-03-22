package com.bbva.pzic.pockets.dao.model.bq39;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Test de la transacci&oacute;n <code>BQ39</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq39 {

    @InjectMocks
    private TransaccionBq39 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionBq39 peticion = new PeticionTransaccionBq39();
        RespuestaTransaccionBq39 respuesta = new RespuestaTransaccionBq39();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq39.class, RespuestaTransaccionBq39.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq39 result = transaccion.invocar(peticion);

        assertEquals(result, respuesta);
    }
}