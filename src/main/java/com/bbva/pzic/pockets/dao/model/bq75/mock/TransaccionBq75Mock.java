package com.bbva.pzic.pockets.dao.model.bq75.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ750;
import com.bbva.pzic.pockets.dao.model.bq75.FormatoBGMQ751;
import com.bbva.pzic.pockets.dao.model.bq75.PeticionTransaccionBq75;
import com.bbva.pzic.pockets.dao.model.bq75.RespuestaTransaccionBq75;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("transaccionBq75")
public class TransaccionBq75Mock implements InvocadorTransaccion<PeticionTransaccionBq75, RespuestaTransaccionBq75> {

    public static final String TEST_NOT_RESPONSE = "666666";
    public static final String TEST_NOT_PAGINATION = "666665";

    @Override
    public RespuestaTransaccionBq75 invocar(PeticionTransaccionBq75 transaccion) throws ExcepcionTransaccion {
        final RespuestaTransaccionBq75 response = new RespuestaTransaccionBq75();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBGMQ750 format = transaccion.getCuerpo().getParte(FormatoBGMQ750.class);

        if (TEST_NOT_RESPONSE.equalsIgnoreCase(format.getIdepock()))
            return response;

        try {
            if (TEST_NOT_PAGINATION.equalsIgnoreCase(format.getIdepock())) {
                response.getCuerpo().getPartes().addAll(buildDataCopies());

            } else {
                response.getCuerpo().getPartes().addAll(buildDataCopies());
                response.getCuerpo().getPartes().add(buildDataPagination());
            }
        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }

        return response;
    }

    @Override
    public RespuestaTransaccionBq75 invocarCache(PeticionTransaccionBq75 peticion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }

    private List<CopySalida> buildDataCopies() throws IOException {
        List<FormatoBGMQ751> formats = FormatsBq75Mock.getInstance().getFormatoBGMQ751();

        List<CopySalida> copies = new ArrayList<>();
        for (FormatoBGMQ751 format : formats) {
            CopySalida copy = new CopySalida();
            copy.setCopy(format);
            copies.add(copy);
        }
        return copies;
    }

    private CopySalida buildDataPagination() throws IOException {
        CopySalida copy = new CopySalida();
        copy.setCopy(FormatsBq75Mock.getInstance().getFormatoBGMQ752());
        return copy;
    }
}
