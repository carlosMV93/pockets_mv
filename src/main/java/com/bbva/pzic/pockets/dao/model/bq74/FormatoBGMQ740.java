package com.bbva.pzic.pockets.dao.model.bq74;


import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>BGMQ740</code> de la transacci&oacute;n <code>BQ74</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ740")
@RooJavaBean
@RooSerializable
public class FormatoBGMQ740 {

	/**
	 * <p>Campo <code>NUMCUEN</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCUEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcuen;
	
	/**
	 * <p>Campo <code>OPCION</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "OPCION", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String opcion;
	
	/**
	 * <p>Campo <code>IDPAGIN</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "IDPAGIN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idpagin;
	
	/**
	 * <p>Campo <code>TAMPAGI</code>, &iacute;ndice: <code>4</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 4, nombre = "TAMPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3)
	private Integer tampagi;
	
}