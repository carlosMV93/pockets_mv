package com.bbva.pzic.pockets.dao.model.bq81;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ81</code>
 * 
 * @see PeticionTransaccionBq81
 * @see RespuestaTransaccionBq81
 */
@Component
public class TransaccionBq81 implements InvocadorTransaccion<PeticionTransaccionBq81,RespuestaTransaccionBq81> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq81 invocar(PeticionTransaccionBq81 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq81.class, RespuestaTransaccionBq81.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq81 invocarCache(PeticionTransaccionBq81 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq81.class, RespuestaTransaccionBq81.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {
		//this method does not have to be used anymore
	}
}