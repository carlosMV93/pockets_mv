package com.bbva.pzic.pockets.dao.model.bq42;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ42</code>
 *
 * @see PeticionTransaccionBq42
 * @see RespuestaTransaccionBq42
 */
@Component("transaccionBq42")
public class TransaccionBq42 implements InvocadorTransaccion<PeticionTransaccionBq42, RespuestaTransaccionBq42> {

    @Autowired
    private ServicioTransacciones servicioTransacciones;

    @Override
    public RespuestaTransaccionBq42 invocar(PeticionTransaccionBq42 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq42.class, RespuestaTransaccionBq42.class, transaccion);
    }

    @Override
    public RespuestaTransaccionBq42 invocarCache(PeticionTransaccionBq42 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq42.class, RespuestaTransaccionBq42.class, transaccion);
    }

    @Override
    public void vaciarCache() {
    }
}