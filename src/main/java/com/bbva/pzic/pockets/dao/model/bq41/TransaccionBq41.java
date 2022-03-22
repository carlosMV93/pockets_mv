package com.bbva.pzic.pockets.dao.model.bq41;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ41</code>
 * 
 * @see PeticionTransaccionBq41
 * @see RespuestaTransaccionBq41
 */
@Component("transaccionBq41")
public class TransaccionBq41 implements InvocadorTransaccion<PeticionTransaccionBq41,RespuestaTransaccionBq41> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq41 invocar(PeticionTransaccionBq41 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq41.class, RespuestaTransaccionBq41.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq41 invocarCache(PeticionTransaccionBq41 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq41.class, RespuestaTransaccionBq41.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}