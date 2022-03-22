package com.bbva.pzic.pockets.dao.model.bq44;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ44</code>
 *
 * @see PeticionTransaccionBq44
 * @see RespuestaTransaccionBq44
 */
@Component("transaccionBq44")
public class TransaccionBq44 implements InvocadorTransaccion<PeticionTransaccionBq44, RespuestaTransaccionBq44> {

    @Autowired
    private ServicioTransacciones servicioTransacciones;

    @Override
    public RespuestaTransaccionBq44 invocar(PeticionTransaccionBq44 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq44.class, RespuestaTransaccionBq44.class, transaccion);
    }

    @Override
    public RespuestaTransaccionBq44 invocarCache(PeticionTransaccionBq44 transaccion) throws ExcepcionTransaccion {
        return servicioTransacciones.invocar(PeticionTransaccionBq44.class, RespuestaTransaccionBq44.class, transaccion);
    }

    @Override
    public void vaciarCache() {
    }
}