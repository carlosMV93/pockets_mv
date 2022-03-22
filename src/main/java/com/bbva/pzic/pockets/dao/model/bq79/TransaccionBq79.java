package com.bbva.pzic.pockets.dao.model.bq79;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ79</code>
 * 
 * @see PeticionTransaccionBq79
 * @see RespuestaTransaccionBq79
 */
@Component
public class TransaccionBq79 implements InvocadorTransaccion<PeticionTransaccionBq79,RespuestaTransaccionBq79> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq79 invocar(PeticionTransaccionBq79 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq79.class, RespuestaTransaccionBq79.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq79 invocarCache(PeticionTransaccionBq79 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq79.class, RespuestaTransaccionBq79.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {
		//this method does not have to be used anymore
	}
}