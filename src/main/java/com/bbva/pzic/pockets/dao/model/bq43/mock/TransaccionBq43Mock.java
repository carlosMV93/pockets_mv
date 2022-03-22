package com.bbva.pzic.pockets.dao.model.bq43.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.dao.model.bq43.PeticionTransaccionBq43;
import com.bbva.pzic.pockets.dao.model.bq43.RespuestaTransaccionBq43;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ43</code>
 *
 * @see PeticionTransaccionBq43
 * @see RespuestaTransaccionBq43
 */
@Component("transaccionBq43")
public class TransaccionBq43Mock implements InvocadorTransaccion<PeticionTransaccionBq43, RespuestaTransaccionBq43> {

    @Override
    public RespuestaTransaccionBq43 invocar(PeticionTransaccionBq43 transaccion) {
        RespuestaTransaccionBq43 response = new RespuestaTransaccionBq43();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        return response;
    }

    @Override
    public RespuestaTransaccionBq43 invocarCache(PeticionTransaccionBq43 transaccion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }
}