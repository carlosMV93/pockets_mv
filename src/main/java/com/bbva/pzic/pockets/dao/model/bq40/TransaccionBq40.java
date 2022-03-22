package com.bbva.pzic.pockets.dao.model.bq40;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ40</code>
 * 
 * @see PeticionTransaccionBq40
 * @see RespuestaTransaccionBq40
 */
@Component("transaccionBq40")
public class TransaccionBq40 implements InvocadorTransaccion<PeticionTransaccionBq40,RespuestaTransaccionBq40> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq40 invocar(PeticionTransaccionBq40 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq40.class, RespuestaTransaccionBq40.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq40 invocarCache(PeticionTransaccionBq40 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq40.class, RespuestaTransaccionBq40.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}