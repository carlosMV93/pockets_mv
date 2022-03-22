package com.bbva.pzic.pockets.dao.model.bq38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>BQ38</code>
 * 
 * @see PeticionTransaccionBq38
 * @see RespuestaTransaccionBq38
 */
@Component("transaccionBq38")
public class TransaccionBq38 implements InvocadorTransaccion<PeticionTransaccionBq38,RespuestaTransaccionBq38> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionBq38 invocar(PeticionTransaccionBq38 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq38.class, RespuestaTransaccionBq38.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionBq38 invocarCache(PeticionTransaccionBq38 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionBq38.class, RespuestaTransaccionBq38.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}