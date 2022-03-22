package com.bbva.pzic.pockets.dao.model.bq38;

import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test de la transacci&oacute;n <code>BQ38</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq38 {

    @InjectMocks
    private TransaccionBq38 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);

    @Test
    public void test() {

        PeticionTransaccionBq38 peticion = new PeticionTransaccionBq38();

        RespuestaTransaccionBq38 response = new RespuestaTransaccionBq38();
        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq38.class, RespuestaTransaccionBq38.class,
                peticion)).thenReturn(response);

        RespuestaTransaccionBq38 result = transaccion.invocar(peticion);
        Assert.assertEquals(result, response);
    }
}