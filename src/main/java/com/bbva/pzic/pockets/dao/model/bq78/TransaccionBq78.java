package com.bbva.pzic.pockets.dao.model.bq78;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ78</code>
 * 
 * @see PeticionTransaccionBq78
 * @see RespuestaTransaccionBq78
 */
@Component
public class TransaccionBq78 implements InvocadorTransaccion<PeticionTransaccionBq78,RespuestaTransaccionBq78> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq78 invocar(PeticionTransaccionBq78 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq78.class, RespuestaTransaccionBq78.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq78 invocarCache(PeticionTransaccionBq78 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq78.class, RespuestaTransaccionBq78.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {
		//this method does not have to be used anymore
	}
}