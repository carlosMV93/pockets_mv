// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.pockets.dao.model.bq76;

import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.pzic.pockets.dao.model.bq76.RespuestaTransaccionBq76;

privileged aspect RespuestaTransaccionBq76_Roo_JavaBean {
    
    /**
     * Gets codigoRetorno value
     * 
     * @return String
     */
    public String RespuestaTransaccionBq76.getCodigoRetorno() {
        return this.codigoRetorno;
    }
    
    /**
     * Sets codigoRetorno value
     * 
     * @param codigoRetorno
     * @return RespuestaTransaccionBq76
     */
    public RespuestaTransaccionBq76 RespuestaTransaccionBq76.setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
        return this;
    }
    
    /**
     * Gets codigoControl value
     * 
     * @return String
     */
    public String RespuestaTransaccionBq76.getCodigoControl() {
        return this.codigoControl;
    }
    
    /**
     * Sets codigoControl value
     * 
     * @param codigoControl
     * @return RespuestaTransaccionBq76
     */
    public RespuestaTransaccionBq76 RespuestaTransaccionBq76.setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
        return this;
    }
    
    /**
     * Sets cuerpo value
     * 
     * @param cuerpo
     * @return RespuestaTransaccionBq76
     */
    public RespuestaTransaccionBq76 RespuestaTransaccionBq76.setCuerpo(CuerpoMultiparte cuerpo) {
        this.cuerpo = cuerpo;
        return this;
    }
    
}
