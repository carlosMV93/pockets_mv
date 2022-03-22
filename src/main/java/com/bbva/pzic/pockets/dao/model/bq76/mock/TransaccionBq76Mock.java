package com.bbva.pzic.pockets.dao.model.bq76.mock;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76E1;
import com.bbva.pzic.pockets.dao.model.bq76.FormatoBQM76S1;
import com.bbva.pzic.pockets.dao.model.bq76.PeticionTransaccionBq76;
import com.bbva.pzic.pockets.dao.model.bq76.RespuestaTransaccionBq76;
import com.bbva.pzic.pockets.util.Errors;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("transaccionBq76")
public class TransaccionBq76Mock  implements InvocadorTransaccion<PeticionTransaccionBq76, RespuestaTransaccionBq76> {


    public static final String TEST_EMPTY_RESPONSE = "666666";


    @Override
    public RespuestaTransaccionBq76 invocar(PeticionTransaccionBq76 transaccion) throws ExcepcionTransaccion {
        RespuestaTransaccionBq76 response = new RespuestaTransaccionBq76();
        response.setCodigoControl("OK");
        response.setCodigoRetorno("OK_COMMIT");

        FormatoBQM76E1 format = transaccion.getCuerpo().getParte(FormatoBQM76E1.class);
        if( TEST_EMPTY_RESPONSE.equals(format.getNumcuen())){
            return response;
        }
        try {
            response.getCuerpo().getPartes().add(createFormatoSalidaDefault(format.getFlagpoc()));
            return response;

        }catch (IOException e) {
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }

    }

    @Override
    public RespuestaTransaccionBq76 invocarCache(PeticionTransaccionBq76 peticionTransaccionBq76) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {
    }


    private CopySalida createFormatoSalidaDefault(String flagpoc) throws IOException{
        FormatoBQM76S1 outFormat =FormatsBq76Mock.getInstance().getFormatoBQM76S1();
        outFormat.setFlagpoc(flagpoc);
        CopySalida copySalida = new CopySalida();
        copySalida.setCopy(outFormat);
        return copySalida;
    }

}
