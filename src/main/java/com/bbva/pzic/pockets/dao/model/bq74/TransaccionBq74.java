package com.bbva.pzic.pockets.dao.model.bq74;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ74</code>
 * 
 * @see PeticionTransaccionBq74
 * @see RespuestaTransaccionBq74
 */
@Component
public class TransaccionBq74 implements InvocadorTransaccion<PeticionTransaccionBq74,RespuestaTransaccionBq74> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq74 invocar(PeticionTransaccionBq74 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq74.class, RespuestaTransaccionBq74.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq74 invocarCache(PeticionTransaccionBq74 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq74.class, RespuestaTransaccionBq74.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {
		//this method does not have to be used anymore
	}
}