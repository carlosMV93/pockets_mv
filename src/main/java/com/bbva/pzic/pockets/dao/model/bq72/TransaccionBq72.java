package com.bbva.pzic.pockets.dao.model.bq72;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ72</code>
 *
 * @see PeticionTransaccionBq72
 * @see RespuestaTransaccionBq72
 */
@Component("transaccionBq72")
public class TransaccionBq72 implements InvocadorTransaccion<PeticionTransaccionBq72, RespuestaTransaccionBq72> {

    @Autowired
    private ServicioTransacciones servicioTransacciones;

    @Override
    public RespuestaTransaccionBq72 invocar(PeticionTransaccionBq72 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq72.class, RespuestaTransaccionBq72.class, transaccion);
    }

    @Override
    public RespuestaTransaccionBq72 invocarCache(PeticionTransaccionBq72 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq72.class, RespuestaTransaccionBq72.class, transaccion);
    }

    @Override
    public void vaciarCache() {
    }
}