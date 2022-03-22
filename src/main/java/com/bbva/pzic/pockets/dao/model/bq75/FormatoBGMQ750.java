package com.bbva.pzic.pockets.dao.model.bq75;


import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>BGMQ750</code> de la transacci&oacute;n <code>BQ75</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ750")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBGMQ750 {

	/**
	 * <p>Campo <code>IDEPOCK</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDEPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idepock;

	/**
	 * <p>Campo <code>IDPAGIN</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "IDPAGIN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String idpagin;

	/**
	 * <p>Campo <code>TAMPAGI</code>, &iacute;ndice: <code>3</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 3, nombre = "TAMPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3)
	private Integer tampagi;

}
