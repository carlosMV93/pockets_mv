package com.bbva.pzic.pockets.dao.model.bq71;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;


/**
 * Formato de datos <code>BGMQ711</code> de la transacci&oacute;n <code>BQ71</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ711")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBGMQ711 {

	/**
	 * <p>Campo <code>IDNMCTA</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDNMCTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String idnmcta;

}