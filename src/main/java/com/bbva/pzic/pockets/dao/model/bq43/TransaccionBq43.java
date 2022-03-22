package com.bbva.pzic.pockets.dao.model.bq43;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ43</code>
 * 
 * @see PeticionTransaccionBq43
 * @see RespuestaTransaccionBq43
 */
@Component("transaccionBq43")
public class TransaccionBq43 implements InvocadorTransaccion<PeticionTransaccionBq43,RespuestaTransaccionBq43> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq43 invocar(PeticionTransaccionBq43 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq43.class, RespuestaTransaccionBq43.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq43 invocarCache(PeticionTransaccionBq43 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq43.class, RespuestaTransaccionBq43.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}