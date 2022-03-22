package com.bbva.pzic.pockets.dao.model.bq79.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq79.FormatoBQM79E1;
import com.bbva.pzic.pockets.dao.model.bq79.PeticionTransaccionBq79;
import com.bbva.pzic.pockets.dao.model.bq79.RespuestaTransaccionBq79;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("transaccionBq79")
public class TransaccionBq79Mock implements InvocadorTransaccion<PeticionTransaccionBq79, RespuestaTransaccionBq79> {

    public static final String TEST_NOT_RESPONSE = "666666";

    @Override
    public RespuestaTransaccionBq79 invocar(PeticionTransaccionBq79 transaccion) throws ExcepcionTransaccion {
        final RespuestaTransaccionBq79 response = new RespuestaTransaccionBq79();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBQM79E1 format = transaccion.getCuerpo().getParte(FormatoBQM79E1.class);

        if (TEST_NOT_RESPONSE.equalsIgnoreCase(format.getIdpoc()))
            return response;

        try {
            response.getCuerpo().getPartes().add(buildDataCopy());
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }

        return response;
    }

    private CopySalida buildDataCopy() throws IOException {
        CopySalida copy = new CopySalida();
        copy.setCopy(FormatsBq79Mock.getInstance().getFormatoBQM79S1());
        return copy;
    }

    @Override
    public RespuestaTransaccionBq79 invocarCache(PeticionTransaccionBq79 peticionTransaccionBq79) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
