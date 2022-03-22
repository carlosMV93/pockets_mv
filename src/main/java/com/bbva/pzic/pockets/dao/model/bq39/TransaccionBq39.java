package com.bbva.pzic.pockets.dao.model.bq39;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ39</code>
 * 
 * @see PeticionTransaccionBq39
 * @see RespuestaTransaccionBq39
 */
@Component("transaccionBq39")
public class TransaccionBq39 implements InvocadorTransaccion<PeticionTransaccionBq39,RespuestaTransaccionBq39> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq39 invocar(PeticionTransaccionBq39 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq39.class, RespuestaTransaccionBq39.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq39 invocarCache(PeticionTransaccionBq39 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq39.class, RespuestaTransaccionBq39.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}