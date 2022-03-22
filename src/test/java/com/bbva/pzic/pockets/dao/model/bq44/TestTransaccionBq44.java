package com.bbva.pzic.pockets.dao.model.bq44;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ44</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq44 {

    @InjectMocks
    private TransaccionBq44 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionBq44 peticion = new PeticionTransaccionBq44();
        RespuestaTransaccionBq44 respuesta = new RespuestaTransaccionBq44();

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq44.class, RespuestaTransaccionBq44.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq44 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}