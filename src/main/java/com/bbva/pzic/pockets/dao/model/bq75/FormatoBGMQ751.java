package com.bbva.pzic.pockets.dao.model.bq75;

import java.math.BigDecimal;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;


/**
 * Formato de datos <code>BGMQ751</code> de la transacci&oacute;n <code>BQ75</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ751")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBGMQ751 {

	/**
	 * <p>Campo <code>NUMEOPE</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "NUMEOPE", tipo = TipoCampo.ENTERO, longitudMinima = 7, longitudMaxima = 7)
	private Integer numeope;

	/**
	 * <p>Campo <code>DETMOVI</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "DETMOVI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 40, longitudMaxima = 40)
	private String detmovi;

	/**
	 * <p>Campo <code>TIPOPER</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "TIPOPER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String tipoper;

	/**
	 * <p>Campo <code>DESTIPO</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "DESTIPO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String destipo;

	/**
	 * <p>Campo <code>MTOMOVI</code>, &iacute;ndice: <code>5</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 5, nombre = "MTOMOVI", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal mtomovi;

	/**
	 * <p>Campo <code>DIVMOVI</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "DIVMOVI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String divmovi;

	/**
	 * <p>Campo <code>FCHMOVI</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "FCHMOVI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String fchmovi;

	/**
	 * <p>Campo <code>NOMESTA</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "NOMESTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 60, longitudMaxima = 60)
	private String nomesta;

	/**
	 * <p>Campo <code>NUMECTA</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "NUMECTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numecta;

	/**
	 * <p>Campo <code>IDEPOCK</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "IDEPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idepock;

	/**
	 * <p>Campo <code>IDETICO</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "IDETICO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetico;

	/**
	 * <p>Campo <code>DESTICO</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "DESTICO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String destico;

	/**
	 * <p>Campo <code>IDEPRRE</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "IDEPRRE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String ideprre;

	/**
	 * <p>Campo <code>DESPRRE</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "DESPRRE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String desprre;

	/**
	 * <p>Campo <code>RELTYID</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "RELTYID", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltyid;

	/**
	 * <p>Campo <code>RELNAME</code>, &iacute;ndice: <code>16</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 16, nombre = "RELNAME", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String relname;

}
