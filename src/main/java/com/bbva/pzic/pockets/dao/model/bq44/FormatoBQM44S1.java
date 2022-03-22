package com.bbva.pzic.pockets.dao.model.bq44;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;


/**
 * Formato de datos <code>BQM44S1</code> de la transacci&oacute;n <code>BQ44</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BQM44S1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBQM44S1 {

	/**
	 * <p>Campo <code>NUMOPE</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "NUMOPE", tipo = TipoCampo.ENTERO, longitudMinima = 7, longitudMaxima = 7)
	private Integer numope;

	/**
	 * <p>Campo <code>DETMOV</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "DETMOV", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 40, longitudMaxima = 40)
	private String detmov;

	/**
	 * <p>Campo <code>TIPOPE</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "TIPOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String tipope;

	/**
	 * <p>Campo <code>DESTIPO</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "DESTIPO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String destipo;

	/**
	 * <p>Campo <code>MONMOV</code>, &iacute;ndice: <code>5</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 5, nombre = "MONMOV", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal monmov;

	/**
	 * <p>Campo <code>MONEDA</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "MONEDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String moneda;

	/**
	 * <p>Campo <code>FECHMOV</code>, &iacute;ndice: <code>7</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 7, nombre = "FECHMOV", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechmov;

}