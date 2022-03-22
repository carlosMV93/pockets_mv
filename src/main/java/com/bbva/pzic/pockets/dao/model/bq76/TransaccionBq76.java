package com.bbva.pzic.pockets.dao.model.bq76;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ76</code>
 * 
 * @see PeticionTransaccionBq76
 * @see RespuestaTransaccionBq76
 */
@Component
public class TransaccionBq76 implements InvocadorTransaccion<PeticionTransaccionBq76,RespuestaTransaccionBq76> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq76 invocar(PeticionTransaccionBq76 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq76.class, RespuestaTransaccionBq76.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq76 invocarCache(PeticionTransaccionBq76 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq76.class, RespuestaTransaccionBq76.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {
		//this method does not have to be used anymore
	}
}