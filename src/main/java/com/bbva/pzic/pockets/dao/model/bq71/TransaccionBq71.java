package com.bbva.pzic.pockets.dao.model.bq71;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ71</code>
 *
 * @see PeticionTransaccionBq71
 * @see RespuestaTransaccionBq71
 */
@Component("transaccionBq71")
public class TransaccionBq71 implements InvocadorTransaccion<PeticionTransaccionBq71, RespuestaTransaccionBq71> {

    @Autowired
    private ServicioTransacciones servicioTransacciones;

    @Override
    public RespuestaTransaccionBq71 invocar(PeticionTransaccionBq71 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq71.class, RespuestaTransaccionBq71.class, transaccion);
    }

    @Override
    public RespuestaTransaccionBq71 invocarCache(PeticionTransaccionBq71 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq71.class, RespuestaTransaccionBq71.class, transaccion);
    }

    @Override
    public void vaciarCache() {
    }
}