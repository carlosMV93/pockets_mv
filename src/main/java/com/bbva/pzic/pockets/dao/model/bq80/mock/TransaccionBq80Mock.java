package com.bbva.pzic.pockets.dao.model.bq80.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq80.FormatoBQM80E1;
import com.bbva.pzic.pockets.dao.model.bq80.PeticionTransaccionBq80;
import com.bbva.pzic.pockets.dao.model.bq80.RespuestaTransaccionBq80;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("transaccionBq80")
public class TransaccionBq80Mock implements InvocadorTransaccion<PeticionTransaccionBq80, RespuestaTransaccionBq80> {

    public static final String TEST_NOT_RESPONSE = "666666";

    @Override
    public RespuestaTransaccionBq80 invocar(PeticionTransaccionBq80 transaccion) throws ExcepcionTransaccion {
        final RespuestaTransaccionBq80 response = new RespuestaTransaccionBq80();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBQM80E1 format = transaccion.getCuerpo().getParte(FormatoBQM80E1.class);

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
        copy.setCopy(FormatsBq80Mock.getInstance().getFormatoBQM80S1());
        return copy;
    }

    @Override
    public RespuestaTransaccionBq80 invocarCache(PeticionTransaccionBq80 peticionTransaccionBq80) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
