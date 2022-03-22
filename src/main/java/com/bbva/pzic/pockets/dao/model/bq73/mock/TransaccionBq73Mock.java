package com.bbva.pzic.pockets.dao.model.bq73.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.pzic.pockets.dao.model.bq73.PeticionTransaccionBq73;
import com.bbva.pzic.pockets.dao.model.bq73.RespuestaTransaccionBq73;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ73</code>
 *
 * @see com.bbva.pzic.pockets.dao.model.bq73.PeticionTransaccionBq73
 * @see com.bbva.pzic.pockets.dao.model.bq73.RespuestaTransaccionBq73
 */
@Component("transaccionBq73")
public class TransaccionBq73Mock implements InvocadorTransaccion<PeticionTransaccionBq73, RespuestaTransaccionBq73> {

    @Override
    public RespuestaTransaccionBq73 invocar(PeticionTransaccionBq73 peticion) throws ExcepcionTransaccion {
        RespuestaTransaccionBq73 response = new RespuestaTransaccionBq73();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        return response;
    }

    @Override
    public RespuestaTransaccionBq73 invocarCache(PeticionTransaccionBq73 peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
