package com.bbva.pzic.pockets.dao.model.bq41;


import java.math.BigDecimal;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>BQM41E1</code> de la transacci&oacute;n <code>BQ41</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BQM41E1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBQM41E1 {

	/**
	 * <p>Campo <code>IDPOC</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idpoc;

	/**
	 * <p>Campo <code>TIPOPE</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "TIPOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String tipope;

	/**
	 * <p>Campo <code>IMPORTE</code>, &iacute;ndice: <code>3</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 3, nombre = "IMPORTE", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal importe;

	/**
	 * <p>Campo <code>MONEDA</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "MONEDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String moneda;

}