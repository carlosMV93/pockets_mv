package com.bbva.pzic.pockets.dao.model.bq80;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ80</code>
 * 
 * @see PeticionTransaccionBq80
 * @see RespuestaTransaccionBq80
 */
@Component
public class TransaccionBq80 implements InvocadorTransaccion<PeticionTransaccionBq80,RespuestaTransaccionBq80> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq80 invocar(PeticionTransaccionBq80 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq80.class, RespuestaTransaccionBq80.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq80 invocarCache(PeticionTransaccionBq80 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq80.class, RespuestaTransaccionBq80.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {
		//this method does not have to be used anymore
	}
}