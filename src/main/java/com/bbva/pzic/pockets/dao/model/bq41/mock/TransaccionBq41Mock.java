package com.bbva.pzic.pockets.dao.model.bq41.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41E1;
import com.bbva.pzic.pockets.dao.model.bq41.FormatoBQM41S1;
import com.bbva.pzic.pockets.dao.model.bq41.PeticionTransaccionBq41;
import com.bbva.pzic.pockets.dao.model.bq41.RespuestaTransaccionBq41;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created on 9/05/2017.
 *
 * @author Entelgy
 */
@Component("transaccionBq41")
public class TransaccionBq41Mock implements InvocadorTransaccion<PeticionTransaccionBq41, RespuestaTransaccionBq41> {

    public static final String NULL_CASE = "7777";

    private FormatBq41Mock mock;

    @PostConstruct
    private void init() {
        mock = new FormatBq41Mock();
    }

    @Override
    public RespuestaTransaccionBq41 invocar(PeticionTransaccionBq41 transaccion) {
        final RespuestaTransaccionBq41 respuestaTransaccionBq41 = new RespuestaTransaccionBq41();
        respuestaTransaccionBq41.setCodigoControl("OK");
        respuestaTransaccionBq41.setCodigoRetorno("OK_COMMIT");

        FormatoBQM41E1 formatoBQM41E1 = transaccion.getCuerpo().getParte(FormatoBQM41E1.class);
        if (NULL_CASE.equalsIgnoreCase(formatoBQM41E1.getIdpoc())) {
            return respuestaTransaccionBq41;
        }
        try {
            respuestaTransaccionBq41.getCuerpo().getPartes().add(createFormatoSalidaDefault());
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
        return respuestaTransaccionBq41;
    }

    @Override
    public RespuestaTransaccionBq41 invocarCache(PeticionTransaccionBq41 transaccion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }

    private CopySalida createFormatoSalidaDefault() throws IOException {

        FormatoBQM41S1 formatoBQM41S1 = mock.getFormatoBQM41S1();

        CopySalida copySalida = new CopySalida();

        copySalida.setCopy(formatoBQM41S1);

        return copySalida;
    }
}
