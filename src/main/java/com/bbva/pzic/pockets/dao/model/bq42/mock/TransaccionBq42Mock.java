package com.bbva.pzic.pockets.dao.model.bq42.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.dao.model.bq42.PeticionTransaccionBq42;
import com.bbva.pzic.pockets.dao.model.bq42.RespuestaTransaccionBq42;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ42</code>
 *
 * @see com.bbva.pzic.pockets.dao.model.bq42.PeticionTransaccionBq42
 * @see com.bbva.pzic.pockets.dao.model.bq42.RespuestaTransaccionBq42
 */
@Component("transaccionBq42")
public class TransaccionBq42Mock implements InvocadorTransaccion<PeticionTransaccionBq42, RespuestaTransaccionBq42> {

    @Override
    public RespuestaTransaccionBq42 invocar(PeticionTransaccionBq42 transaccion) {
        RespuestaTransaccionBq42 response = new RespuestaTransaccionBq42();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        return response;
    }

    @Override
    public RespuestaTransaccionBq42 invocarCache(PeticionTransaccionBq42 transaccion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }
}