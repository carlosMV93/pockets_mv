package com.bbva.pzic.pockets.dao.model.bq72;


import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>BGMQ720</code> de la transacci&oacute;n <code>BQ72</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ720")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBGMQ720 {

	/**
	 * <p>Campo <code>IDEPOCK</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDEPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idepock;

}