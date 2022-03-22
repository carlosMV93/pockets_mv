package com.bbva.pzic.pockets.dao.model.bq74;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;


import com.bbva.jee.arq.spring.core.host.Cabecera;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.NombreCabecera;
import com.bbva.jee.arq.spring.core.host.RespuestaTransaccion;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;

/**
 * Bean de respuesta para la transacci&oacute;n <code>BQ74</code>
 * 
 * @see PeticionTransaccionBq74
 * 
 * @author Arquitectura Spring BBVA
 */
@RespuestaTransaccion
@Multiformato(formatos = {FormatoBGMQ742.class, FormatoBGMQ741.class})
@RooJavaBean
@RooSerializable
public class RespuestaTransaccionBq74 implements MensajeMultiparte {
	
	/**
	 * <p>Cabecera <code>serviceResponse</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.CODIGO_RETORNO)
	private String codigoRetorno;
	
	/**
	 * <p>Cabecera <code>processControl</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.CODIGO_CONTROL)
	private String codigoControl;
	
	/**
	 * <p>Cuerpo del mensaje de respuesta multiparte</p>
	 */
	@Cuerpo
	private CuerpoMultiparte cuerpo = new CuerpoMultiparte();
	
	/**
	 * <p>Permite obtener el cuerpo del mensaje de petici&oacute;n multiparte</p>
	 */
	@Override
	public CuerpoMultiparte getCuerpo() {
		return cuerpo;
	}
	
}
