package com.bbva.pzic.pockets.dao.model.bq71.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.pzic.pockets.dao.model.bq71.FormatoBGMQ710;
import com.bbva.pzic.pockets.dao.model.bq71.PeticionTransaccionBq71;
import com.bbva.pzic.pockets.dao.model.bq71.RespuestaTransaccionBq71;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>BQ71</code>
 *
 * @see PeticionTransaccionBq71
 * @see RespuestaTransaccionBq71
 */
@Component("transaccionBq71")
public class TransaccionBq71Mock implements InvocadorTransaccion<PeticionTransaccionBq71, RespuestaTransaccionBq71> {

    public final static String TEST_EMPTY = "9999999999999";

    @Override
    public RespuestaTransaccionBq71 invocar(PeticionTransaccionBq71 transaccion) {
        final RespuestaTransaccionBq71 response = new RespuestaTransaccionBq71();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBGMQ710 formatoBQM38E1 = transaccion.getCuerpo().getParte(FormatoBGMQ710.class);

        if (TEST_EMPTY.equalsIgnoreCase(formatoBQM38E1.getIdepock())) {
            return response;
        }

        CopySalida copySalida = new CopySalida();
        copySalida.setCopy(FormatsBq71Mock.getInstance().getFormatoBGMQ711());
        response.getCuerpo().getPartes().add(copySalida);
        return response;
    }

    @Override
    public RespuestaTransaccionBq71 invocarCache(PeticionTransaccionBq71 transaccion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }
}