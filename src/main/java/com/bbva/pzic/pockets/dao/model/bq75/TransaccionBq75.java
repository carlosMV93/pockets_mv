package com.bbva.pzic.pockets.dao.model.bq75;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ75</code>
 *
 * @see PeticionTransaccionBq75
 * @see RespuestaTransaccionBq75
 */
@Component("transaccionBq75")
public class TransaccionBq75 implements InvocadorTransaccion<PeticionTransaccionBq75, RespuestaTransaccionBq75> {

    @Autowired
    private ServicioTransacciones servicioTransacciones;

    @Override
    public RespuestaTransaccionBq75 invocar(PeticionTransaccionBq75 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq75.class, RespuestaTransaccionBq75.class, transaccion);
    }

    @Override
    public RespuestaTransaccionBq75 invocarCache(PeticionTransaccionBq75 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq75.class, RespuestaTransaccionBq75.class, transaccion);
    }

    @Override
    public void vaciarCache() {
    }
}
