package com.bbva.pzic.pockets.dao.model.bq81.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81E1;
import com.bbva.pzic.pockets.dao.model.bq81.FormatoBQM81S1;
import com.bbva.pzic.pockets.dao.model.bq81.PeticionTransaccionBq81;
import com.bbva.pzic.pockets.dao.model.bq81.RespuestaTransaccionBq81;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("transaccionBq81")
public class TransaccionBq81Mock implements InvocadorTransaccion<PeticionTransaccionBq81, RespuestaTransaccionBq81> {

    public static final String TEST_EMPTY_RESPONSE = "666666";

    @Override
    public RespuestaTransaccionBq81 invocar(PeticionTransaccionBq81 transaccion) throws ExcepcionTransaccion {
        RespuestaTransaccionBq81 response = new RespuestaTransaccionBq81();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBQM81E1 format = transaccion.getCuerpo().getParte(FormatoBQM81E1.class);
        if (TEST_EMPTY_RESPONSE.equals(format.getIdpoc())) {
            return response;
        }

        try {
            response.getCuerpo().getPartes().add(createFormatoSalidaDefault(format.getFlagpoc()));
            return response;

        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    @Override
    public RespuestaTransaccionBq81 invocarCache(PeticionTransaccionBq81 peticionTransaccionBq81) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }

    private CopySalida createFormatoSalidaDefault(String flagpoc) throws IOException {
        FormatoBQM81S1 outFormat = FormatsBq81Mock.getInstance().getFormatoBQM81S1();
        outFormat.setFlagpoc(flagpoc);
        CopySalida copySalida = new CopySalida();
        copySalida.setCopy(outFormat);
        return copySalida;
    }
}
