// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.pzic.pockets.dao.model.bq81;

import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.pzic.pockets.dao.model.bq81.RespuestaTransaccionBq81;

privileged aspect RespuestaTransaccionBq81_Roo_JavaBean {
    
    /**
     * Gets codigoRetorno value
     * 
     * @return String
     */
    public String RespuestaTransaccionBq81.getCodigoRetorno() {
        return this.codigoRetorno;
    }
    
    /**
     * Sets codigoRetorno value
     * 
     * @param codigoRetorno
     * @return RespuestaTransaccionBq81
     */
    public RespuestaTransaccionBq81 RespuestaTransaccionBq81.setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
        return this;
    }
    
    /**
     * Gets codigoControl value
     * 
     * @return String
     */
    public String RespuestaTransaccionBq81.getCodigoControl() {
        return this.codigoControl;
    }
    
    /**
     * Sets codigoControl value
     * 
     * @param codigoControl
     * @return RespuestaTransaccionBq81
     */
    public RespuestaTransaccionBq81 RespuestaTransaccionBq81.setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
        return this;
    }
    
    /**
     * Sets cuerpo value
     * 
     * @param cuerpo
     * @return RespuestaTransaccionBq81
     */
    public RespuestaTransaccionBq81 RespuestaTransaccionBq81.setCuerpo(CuerpoMultiparte cuerpo) {
        this.cuerpo = cuerpo;
        return this;
    }
    
}
