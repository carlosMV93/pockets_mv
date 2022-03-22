package com.bbva.pzic.pockets.dao.model.bq72.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ720;
import com.bbva.pzic.pockets.dao.model.bq72.FormatoBGMQ721;
import com.bbva.pzic.pockets.dao.model.bq72.PeticionTransaccionBq72;
import com.bbva.pzic.pockets.dao.model.bq72.RespuestaTransaccionBq72;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Invocador de la transacci&oacute;n <code>BQ72</code>
 *
 * @see PeticionTransaccionBq72
 * @see RespuestaTransaccionBq72
 */
@Component("transaccionBq72")
public class TransaccionBq72Mock implements InvocadorTransaccion<PeticionTransaccionBq72, RespuestaTransaccionBq72> {

    public static final String TEST_NOT_RESPONSE = "99999999999";

    @Override
    public RespuestaTransaccionBq72 invocar(PeticionTransaccionBq72 peticion) throws ExcepcionTransaccion {
        RespuestaTransaccionBq72 response = new RespuestaTransaccionBq72();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBGMQ720 format = peticion.getCuerpo().getParte(FormatoBGMQ720.class);

        if (TEST_NOT_RESPONSE.equalsIgnoreCase(format.getIdepock()))
            return response;

        try {
            List<FormatoBGMQ721> formats = FormatsBq72Mock.getInstance().getFormatoBGMQ721();

            List<CopySalida> copies = new ArrayList<>();
            for (FormatoBGMQ721 f : formats) {
                CopySalida copy = new CopySalida();
                copy.setCopy(f);
                copies.add(copy);
            }

            response.getCuerpo().getPartes().addAll(copies);
            return response;
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    @Override
    public RespuestaTransaccionBq72 invocarCache(PeticionTransaccionBq72 transaccion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {
    }
}