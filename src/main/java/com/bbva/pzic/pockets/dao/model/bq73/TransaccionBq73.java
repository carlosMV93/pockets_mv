package com.bbva.pzic.pockets.dao.model.bq73;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ73</code>
 *
 * @see PeticionTransaccionBq73
 * @see RespuestaTransaccionBq73
 */
@Component("transaccionBq73")
public class TransaccionBq73 implements InvocadorTransaccion<PeticionTransaccionBq73, RespuestaTransaccionBq73> {

    @Autowired
    private ServicioTransacciones servicioTransacciones;

    @Override
    public RespuestaTransaccionBq73 invocar(PeticionTransaccionBq73 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq73.class, RespuestaTransaccionBq73.class, transaccion);
    }

    @Override
    public RespuestaTransaccionBq73 invocarCache(PeticionTransaccionBq73 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq73.class, RespuestaTransaccionBq73.class, transaccion);
    }

    @Override
    public void vaciarCache() {
    }
}