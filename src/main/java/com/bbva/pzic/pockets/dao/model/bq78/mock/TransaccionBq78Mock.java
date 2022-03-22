package com.bbva.pzic.pockets.dao.model.bq78.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq78.FormatoBQM78E1;
import com.bbva.pzic.pockets.dao.model.bq78.PeticionTransaccionBq78;
import com.bbva.pzic.pockets.dao.model.bq78.RespuestaTransaccionBq78;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("transaccionBq78")
public class TransaccionBq78Mock implements InvocadorTransaccion<PeticionTransaccionBq78, RespuestaTransaccionBq78> {

    public static final String TEST_NOT_RESPONSE = "666666";

    @Override
    public RespuestaTransaccionBq78 invocar(PeticionTransaccionBq78 transaccion) throws ExcepcionTransaccion {
        final RespuestaTransaccionBq78 response = new RespuestaTransaccionBq78();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBQM78E1 format = transaccion.getCuerpo().getParte(FormatoBQM78E1.class);

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
        copy.setCopy(FormatsBq78Mock.getInstance().getFormatoBQM78S1());
        return copy;
    }

    @Override
    public RespuestaTransaccionBq78 invocarCache(PeticionTransaccionBq78 peticionTransaccionBq78) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
