package com.bbva.pzic.pockets.dao.model.bq38.mock;

import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38E1;
import com.bbva.pzic.pockets.dao.model.bq38.FormatoBQM38S1;
import com.bbva.pzic.pockets.dao.model.bq38.PeticionTransaccionBq38;
import com.bbva.pzic.pockets.dao.model.bq38.RespuestaTransaccionBq38;
import org.springframework.stereotype.Component;

/**
 * Created on 10/05/2017.
 *
 * @author Entelgy
 */
@Component("transaccionBq38")
public class TransaccionBq38Mock implements InvocadorTransaccion<PeticionTransaccionBq38, RespuestaTransaccionBq38> {

    public final static String TEST_EMPTY = "666";

    @Override
    public RespuestaTransaccionBq38 invocar(PeticionTransaccionBq38 peticionTransaccionBq38) {
        final RespuestaTransaccionBq38 response = new RespuestaTransaccionBq38();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBQM38E1 formatoBQM38E1 = peticionTransaccionBq38.getCuerpo().getParte(FormatoBQM38E1.class);
        if (TEST_EMPTY.equalsIgnoreCase(formatoBQM38E1.getNompoc())) {
            return response;
        }
        response.getCuerpo().getPartes().add(createFormatoSalidaDefault());
        return response;
    }

    @Override
    public RespuestaTransaccionBq38 invocarCache(PeticionTransaccionBq38 peticionTransaccionBq38) {
        return null;
    }

    @Override
    public void vaciarCache() {
    }

    private CopySalida createFormatoSalidaDefault() {
        FormatoBQM38S1 outFormat = new FormatoBQM38S1();
        outFormat.setIdpoc("00110241029996285000001");
        CopySalida copySalida = new CopySalida();
        copySalida.setCopy(outFormat);
        return copySalida;
    }
}
