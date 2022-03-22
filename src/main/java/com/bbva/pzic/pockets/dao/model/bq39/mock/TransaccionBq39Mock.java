package com.bbva.pzic.pockets.dao.model.bq39.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39E1;
import com.bbva.pzic.pockets.dao.model.bq39.FormatoBQM39S1;
import com.bbva.pzic.pockets.dao.model.bq39.PeticionTransaccionBq39;
import com.bbva.pzic.pockets.dao.model.bq39.RespuestaTransaccionBq39;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Invocador de la transacci&oacute;n <code>Bq39</code>
 *
 * @see com.bbva.pzic.pockets.dao.model.bq39.PeticionTransaccionBq39
 * @see com.bbva.pzic.pockets.dao.model.bq39.RespuestaTransaccionBq39
 */
@Component("transaccionBq39")
public class TransaccionBq39Mock implements InvocadorTransaccion<PeticionTransaccionBq39, RespuestaTransaccionBq39> {

    public static final String NO_DATA = "0987654321";
    public static final String NO_PAGINATION = "123456789";
    public static final String NO_DATA_AND_PAGINATION = "999999999";

    @Autowired
    private FormatBq29Mock mock;

    @Override
    public RespuestaTransaccionBq39 invocar(PeticionTransaccionBq39 transaccion) {
        final RespuestaTransaccionBq39 response = new RespuestaTransaccionBq39();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");
        
        FormatoBQM39E1 format = (FormatoBQM39E1) transaccion.getCuerpo().getPartes().get(0);
        String numecta = format.getNumcuen();

        if (numecta != null) {

            if (numecta.equalsIgnoreCase(NO_DATA_AND_PAGINATION)) {
                return response;
            }

            if (numecta.equalsIgnoreCase(NO_PAGINATION)) {
                response.getCuerpo().getPartes().addAll(buildDataCopies());
                return response;
            }

            if (numecta.equalsIgnoreCase(NO_DATA)) {
                response.getCuerpo().getPartes().add(buildDataPagination());
                return response;
            }
        }

        response.getCuerpo().getPartes().addAll(buildDataCopies());
        response.getCuerpo().getPartes().add(buildDataPagination());
        return response;
    }

    @Override
    public RespuestaTransaccionBq39 invocarCache(PeticionTransaccionBq39 transaccion) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }

    private List<CopySalida> buildDataCopies() {
        List<FormatoBQM39S1> formats = mock.getFormatoBQM39S1();
        List<CopySalida> copies = new ArrayList<>();
        for (FormatoBQM39S1 format : formats) {
            copies.add(buildData(format));
        }
        return copies;
    }

    private CopySalida buildDataPagination() {
        return buildData(mock.getFormatoBQM39P1());
    }

    private CopySalida buildData(Object object) {
        CopySalida copy = new CopySalida();
        copy.setCopy(object);
        return copy;
    }
}