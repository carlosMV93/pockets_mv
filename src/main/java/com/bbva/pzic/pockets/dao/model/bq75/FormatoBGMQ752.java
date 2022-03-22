package com.bbva.pzic.pockets.dao.model.bq75;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;


/**
 * Formato de datos <code>BGMQ752</code> de la transacci&oacute;n <code>BQ75</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ752")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBGMQ752 {

	/**
	 * <p>Campo <code>IDPAGIN</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDPAGIN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String idpagin;

	/**
	 * <p>Campo <code>TAMPAGI</code>, &iacute;ndice: <code>2</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 2, nombre = "TAMPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3)
	private Integer tampagi;

}
