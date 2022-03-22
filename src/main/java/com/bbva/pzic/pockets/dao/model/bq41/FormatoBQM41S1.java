package com.bbva.pzic.pockets.dao.model.bq41;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;


/**
 * Formato de datos <code>BQM41S1</code> de la transacci&oacute;n <code>BQ41</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BQM41S1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBQM41S1 {

	/**
	 * <p>Campo <code>NUMOPE</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "NUMOPE", tipo = TipoCampo.ENTERO, longitudMinima = 7, longitudMaxima = 7)
	private Integer numope;

}