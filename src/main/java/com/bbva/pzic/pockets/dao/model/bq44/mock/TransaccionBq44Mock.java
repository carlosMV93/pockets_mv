package com.bbva.pzic.pockets.dao.model.bq44.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq44.*;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 11/05/2017.
 *
 * @author Entelgy
 */
@Component("transaccionBq44")
public class TransaccionBq44Mock implements InvocadorTransaccion<PeticionTransaccionBq44, RespuestaTransaccionBq44> {

    public static final String TEST_NOT_PAGINATION = "1";
    public static final String TEST_EMPTY = "2";

    @Autowired
    private FormatsBq44Mock mock;

    @Override
    public RespuestaTransaccionBq44 invocar(PeticionTransaccionBq44 peticion) {
        final RespuestaTransaccionBq44 respuestaTransaccionMpl3 = new RespuestaTransaccionBq44();
        respuestaTransaccionMpl3.setCodigoControl("OK");
        respuestaTransaccionMpl3.setCodigoRetorno("OK_COMMIT");

        final FormatoBQM44E1 formatoBQM44E1 = (FormatoBQM44E1) peticion.getCuerpo().getPartes().get(0);

        if (TEST_EMPTY.equalsIgnoreCase(formatoBQM44E1.getIdpagin())) {
            return respuestaTransaccionMpl3;
        }

        List<CopySalida> copySalidaBQM44S1;
        try {
            copySalidaBQM44S1 = createFormatoBQM44S1();
            if (TEST_NOT_PAGINATION.equalsIgnoreCase(formatoBQM44E1.getIdpagin())) {
                respuestaTransaccionMpl3.getCuerpo().getPartes().addAll(copySalidaBQM44S1);
            } else {
                CopySalida copySalidaBQM44P1 = createFormatoBQM44P1();
                respuestaTransaccionMpl3.getCuerpo().getPartes().addAll(copySalidaBQM44S1);
                respuestaTransaccionMpl3.getCuerpo().getPartes().add(copySalidaBQM44P1);
            }
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
        return respuestaTransaccionMpl3;
    }

    private CopySalida createFormatoBQM44P1() throws IOException {
        FormatoBQM44P1 formatoMPMS2L3Salida = mock.getFormatoBQM44P1();
        CopySalida copySalida = new CopySalida();
        copySalida.setCopy(formatoMPMS2L3Salida);

        return copySalida;
    }

    private List<CopySalida> createFormatoBQM44S1() throws IOException {
        List<FormatoBQM44S1> formats = mock.getFormatoBQM44S1();

        List<CopySalida> copies = new ArrayList<>();
        for (FormatoBQM44S1 format : formats) {
            CopySalida copy = new CopySalida();
            copy.setCopy(format);
            copies.add(copy);
        }
        return copies;
    }

    @Override
    public RespuestaTransaccionBq44 invocarCache(PeticionTransaccionBq44 peticion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }
}
