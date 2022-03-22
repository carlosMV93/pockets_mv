package com.bbva.pzic.pockets.dao.model.bq81;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Test de la transacci&oacute;n <code>BQ81</code>
 *
 * @author Arquitectura Spring BBVA
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTransaccionBq81 {

    private static final Log LOG = LogFactory.getLog(TestTransaccionBq81.class);

    @InjectMocks
    private TransaccionBq81 transaccion;

    @Spy
    private ServicioTransacciones servicioTransacciones = Mockito.mock(ServicioTransacciones.class);


    @Test
    public void test() throws ExcepcionTransaccion {

        PeticionTransaccionBq81 peticion = new PeticionTransaccionBq81();

        RespuestaTransaccionBq81 respuesta = transaccion.invocar(peticion);

        Mockito.when(servicioTransacciones.invocar(PeticionTransaccionBq81.class, RespuestaTransaccionBq81.class,
                peticion)).thenReturn(respuesta);

        RespuestaTransaccionBq81 result = transaccion.invocar(peticion);

        Assert.assertEquals(result, respuesta);
    }
}