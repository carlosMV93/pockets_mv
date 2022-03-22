package com.bbva.pzic.pockets.dao.model.bq74;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;



/**
 * Formato de datos <code>BGMQ742</code> de la transacci&oacute;n <code>BQ74</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ742")
@RooJavaBean
@RooSerializable
public class FormatoBGMQ742 {
	
	/**
	 * <p>Campo <code>IDPAGIN</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDPAGIN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idpagin;
	
	/**
	 * <p>Campo <code>TAMPAGI</code>, &iacute;ndice: <code>2</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 2, nombre = "TAMPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3)
	private Integer tampagi;
	
}