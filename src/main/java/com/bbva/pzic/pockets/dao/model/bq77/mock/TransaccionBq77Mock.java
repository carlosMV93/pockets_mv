package com.bbva.pzic.pockets.dao.model.bq77.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77E1;
import com.bbva.pzic.pockets.dao.model.bq77.FormatoBQM77S1;
import com.bbva.pzic.pockets.dao.model.bq77.PeticionTransaccionBq77;
import com.bbva.pzic.pockets.dao.model.bq77.RespuestaTransaccionBq77;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("transaccionBq77")
public class TransaccionBq77Mock implements InvocadorTransaccion<PeticionTransaccionBq77, RespuestaTransaccionBq77> {

    public static final String TEST_NOT_RESPONSE = "666666";
    public static final String TEST_NOT_ISSCHEDULED = "111111";
    public static final String TEST_NULL_ISSCHEDULED = "222222";

    @Override
    public RespuestaTransaccionBq77 invocar(PeticionTransaccionBq77 transaccion) throws ExcepcionTransaccion {
        final RespuestaTransaccionBq77 response= new RespuestaTransaccionBq77();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBQM77E1 formatoBQM77E1 = transaccion.getCuerpo().getParte(FormatoBQM77E1.class);
        if( TEST_NOT_RESPONSE.equals(formatoBQM77E1.getIdpoc()) ){
            return response;
        }

        try {
            if( TEST_NOT_ISSCHEDULED.equals(formatoBQM77E1.getIdpoc()) ){
                response.getCuerpo().getPartes().add(buildDataCopy("N"));

            } else if ( TEST_NULL_ISSCHEDULED.equals(formatoBQM77E1.getIdpoc()) ) {
                response.getCuerpo().getPartes().add(buildDataCopy(null));

            } else {
                response.getCuerpo().getPartes().add(buildDataCopy("S"));
            }

        } catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }

        return response;
    }

    private CopySalida buildDataCopy(String flaPoc) throws IOException {
        CopySalida copy = new CopySalida();
        FormatoBQM77S1 formatoBQM77S1 =  FormatsBq77Mock.getInstance().getFormatoBQM77S1();
        formatoBQM77S1.setFlapoc(flaPoc);
        copy.setCopy(formatoBQM77S1);
        return copy;
    }

    @Override
    public RespuestaTransaccionBq77 invocarCache(PeticionTransaccionBq77 peticionTransaccionBq77) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {
    }



}