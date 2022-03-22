package com.bbva.pzic.pockets.dao.model.bq40;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;


/**
 * Formato de datos <code>BQM40S1</code> de la transacci&oacute;n <code>BQ40</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BQM40S1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBQM40S1 {

	/**
	 * <p>Campo <code>POCKET</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "POCKET", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String pocket;

	/**
	 * <p>Campo <code>NUMCUEN</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMCUEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcuen;

	/**
	 * <p>Campo <code>NOMPOC</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "NOMPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 60, longitudMaxima = 60)
	private String nompoc;

	/**
	 * <p>Campo <code>NOMCOR</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "NOMCOR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nomcor;

	/**
	 * <p>Campo <code>MONPOC</code>, &iacute;ndice: <code>5</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 5, nombre = "MONPOC", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal monpoc;

	/**
	 * <p>Campo <code>FLAPOC</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "FLAPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String flapoc;

	/**
	 * <p>Campo <code>FECHPOC</code>, &iacute;ndice: <code>7</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 7, nombre = "FECHPOC", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechpoc;

	/**
	 * <p>Campo <code>MONEDA</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "MONEDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String moneda;

	/**
	 * <p>Campo <code>PRIPOC</code>, &iacute;ndice: <code>9</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 9, nombre = "PRIPOC", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3)
	private Integer pripoc;

	/**
	 * <p>Campo <code>AHOPOC</code>, &iacute;ndice: <code>10</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 10, nombre = "AHOPOC", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal ahopoc;

	/**
	 * <p>Campo <code>MONAHO</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "MONAHO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String monaho;

	/**
	 * <p>Campo <code>TIPPOC</code>, &iacute;ndice: <code>12</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 12, nombre = "TIPPOC", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3)
	private Integer tippoc;

	/**
	 * <p>Campo <code>DESTIPO</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "DESTIPO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String destipo;

	/**
	 * <p>Campo <code>ESTPOC</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "ESTPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estpoc;

	/**
	 * <p>Campo <code>DESEST</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "DESEST", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String desest;

	/**
	 * <p>Campo <code>IMPAUT</code>, &iacute;ndice: <code>16</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 16, nombre = "IMPAUT", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal impaut;

	/**
	 * <p>Campo <code>MONIMP</code>, &iacute;ndice: <code>17</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 17, nombre = "MONIMP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String monimp;

	/**
	 * <p>Campo <code>PERAUT</code>, &iacute;ndice: <code>18</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 18, nombre = "PERAUT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String peraut;

	/**
	 * <p>Campo <code>DESPERI</code>, &iacute;ndice: <code>19</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 19, nombre = "DESPERI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String desperi;

	/**
	 * <p>Campo <code>DIAAUTO</code>, &iacute;ndice: <code>20</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 20, nombre = "DIAAUTO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String diaauto;

}