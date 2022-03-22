package com.bbva.pzic.pockets.dao.model.bq73;


import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>BGMQ730</code> de la transacci&oacute;n <code>BQ73</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ730")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBGMQ730 {

	/**
	 * <p>Campo <code>IDEPOCK</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDEPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idepock;

	/**
	 * <p>Campo <code>NUMECTA</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMECTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numecta;

}