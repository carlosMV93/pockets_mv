package com.bbva.pzic.pockets.dao.model.bq40.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40E1;
import com.bbva.pzic.pockets.dao.model.bq40.FormatoBQM40S1;
import com.bbva.pzic.pockets.dao.model.bq40.PeticionTransaccionBq40;
import com.bbva.pzic.pockets.dao.model.bq40.RespuestaTransaccionBq40;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created on 9/05/2017.
 *
 * @author Entelgy
 */
@Component("transaccionBq40")
public class TransaccionBq40Mock implements InvocadorTransaccion<PeticionTransaccionBq40, RespuestaTransaccionBq40> {

    public static final String NULL_CASE = "99999";

    private FormatBq40Mock mock;

    @PostConstruct
    private void init() {
        mock = new FormatBq40Mock();
    }

    @Override
    public RespuestaTransaccionBq40 invocar(PeticionTransaccionBq40 transaccion) {
        final RespuestaTransaccionBq40 respuestaTransaccionBq40 = new RespuestaTransaccionBq40();
        respuestaTransaccionBq40.setCodigoControl("OK");
        respuestaTransaccionBq40.setCodigoRetorno("OK_COMMIT");

        FormatoBQM40E1 formatoBQM40E1 = transaccion.getCuerpo().getParte(FormatoBQM40E1.class);
        if (NULL_CASE.equalsIgnoreCase(formatoBQM40E1.getIdpoc())) {
            return respuestaTransaccionBq40;
        }
        try {
            respuestaTransaccionBq40.getCuerpo().getPartes().add(createFormatoSalidaDefault());
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
        return respuestaTransaccionBq40;
    }

    @Override
    public RespuestaTransaccionBq40 invocarCache(PeticionTransaccionBq40 transaccion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }

    private CopySalida createFormatoSalidaDefault() throws IOException {

        FormatoBQM40S1 formatoBQM40S1 = mock.getFormatoBQM40S1();

        CopySalida copySalida = new CopySalida();

        copySalida.setCopy(formatoBQM40S1);

        return copySalida;
    }
}
