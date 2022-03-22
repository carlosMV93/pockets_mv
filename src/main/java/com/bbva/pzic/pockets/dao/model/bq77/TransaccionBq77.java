package com.bbva.pzic.pockets.dao.model.bq77;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ77</code>
 * 
 * @see PeticionTransaccionBq77
 * @see RespuestaTransaccionBq77
 */
@Component
public class TransaccionBq77 implements InvocadorTransaccion<PeticionTransaccionBq77,RespuestaTransaccionBq77> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq77 invocar(PeticionTransaccionBq77 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq77.class, RespuestaTransaccionBq77.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq77 invocarCache(PeticionTransaccionBq77 transaccion) {
		return servicioTransacciones.invocar(PeticionTransaccionBq77.class, RespuestaTransaccionBq77.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {
		//this method does not have to be used anymore
	}
}