package com.bbva.pzic.pockets.dao.model.bq74.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ740;
import com.bbva.pzic.pockets.dao.model.bq74.FormatoBGMQ741;
import com.bbva.pzic.pockets.dao.model.bq74.PeticionTransaccionBq74;
import com.bbva.pzic.pockets.dao.model.bq74.RespuestaTransaccionBq74;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Invocador de la transacci&oacute;n <code>BQ74</code>
 *
 * @see PeticionTransaccionBq74
 * @see RespuestaTransaccionBq74
 */
@Component("transaccionBq74")
public class TransaccionBq74Mock implements InvocadorTransaccion<PeticionTransaccionBq74, RespuestaTransaccionBq74> {

    public static final String TEST_NOT_RESPONSE = "666666";
    public static final String TEST_NOT_PAGINATION = "666665";

    @Override
    public RespuestaTransaccionBq74 invocar(PeticionTransaccionBq74 peticion) {
        final RespuestaTransaccionBq74 response = new RespuestaTransaccionBq74();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBGMQ740 format = peticion.getCuerpo().getParte(FormatoBGMQ740.class);

        if (TEST_NOT_RESPONSE.equalsIgnoreCase(format.getNumcuen()))
            return response;

        try {
            if (TEST_NOT_PAGINATION.equalsIgnoreCase(format.getNumcuen())) {
                response.getCuerpo().getPartes().addAll(buildDataCopies());

            } else {
                response.getCuerpo().getPartes().addAll(buildDataCopies());
                response.getCuerpo().getPartes().add(buildDataPagination());
            }

            return response;
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    @Override
    public RespuestaTransaccionBq74 invocarCache(PeticionTransaccionBq74 transaccion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }

    private List<CopySalida> buildDataCopies() throws IOException {
        List<FormatoBGMQ741> formats = FormatsBq74Mock.getInstance().getFormatoBGMQ741();

        List<CopySalida> copies = new ArrayList<>();
        for (FormatoBGMQ741 format : formats) {
            CopySalida copy = new CopySalida();
            copy.setCopy(format);
            copies.add(copy);
        }
        return copies;
    }

    private CopySalida buildDataPagination() {
        CopySalida copy = new CopySalida();
        copy.setCopy(FormatsBq74Mock.getInstance().getFormatoBGMQ742());
        return copy;
    }
}