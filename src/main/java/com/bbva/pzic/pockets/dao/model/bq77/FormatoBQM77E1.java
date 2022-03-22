package com.bbva.pzic.pockets.dao.model.bq77;


import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>BQM77E1</code> de la transacci&oacute;n <code>BQ77</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BQM77E1")
@RooJavaBean
@RooSerializable
public class FormatoBQM77E1 {

	/**
	 * <p>Campo <code>IDPOC</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idpoc;
	
}