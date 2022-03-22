package com.bbva.pzic.pockets.dao.model.bq76;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;
import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;



/**
 * Formato de datos <code>BQM76S1</code> de la transacci&oacute;n <code>BQ76</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BQM76S1")
@RooJavaBean
@RooSerializable
public class FormatoBQM76S1 {
	
	/**
	 * <p>Campo <code>IDPOC</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idpoc;
	
	/**
	 * <p>Campo <code>TIPPOCK</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "TIPPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String tippock;
	
	/**
	 * <p>Campo <code>NOMCOR</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "NOMCOR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 60, longitudMaxima = 60)
	private String nomcor;
	
	/**
	 * <p>Campo <code>MONPOC</code>, &iacute;ndice: <code>4</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 4, nombre = "MONPOC", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal monpoc;
	
	/**
	 * <p>Campo <code>MONEDA</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "MONEDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String moneda;
	
	/**
	 * <p>Campo <code>FLAGPOC</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "FLAGPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String flagpoc;
	
	/**
	 * <p>Campo <code>FECHPOC</code>, &iacute;ndice: <code>7</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 7, nombre = "FECHPOC", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechpoc;
	
	/**
	 * <p>Campo <code>IMPAUT</code>, &iacute;ndice: <code>8</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 8, nombre = "IMPAUT", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal impaut;
	
	/**
	 * <p>Campo <code>MONIMP</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "MONIMP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String monimp;
	
	/**
	 * <p>Campo <code>PERAUT</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "PERAUT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String peraut;
	
	/**
	 * <p>Campo <code>DIAAUTO</code>, &iacute;ndice: <code>11</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 11, nombre = "DIAAUTO", tipo = TipoCampo.ENTERO, longitudMinima = 2, longitudMaxima = 2)
	private Integer diaauto;
	
	/**
	 * <p>Campo <code>FECHCRE</code>, &iacute;ndice: <code>12</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 12, nombre = "FECHCRE", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechcre;
	
	/**
	 * <p>Campo <code>ESTADO</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "ESTADO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estado;
	
	/**
	 * <p>Campo <code>NUMCUEN</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@DatoAuditable(omitir = true)
	@Campo(indice = 14, nombre = "NUMCUEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcuen;
	
	/**
	 * <p>Campo <code>HORAOPE</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "HORAOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String horaope;
	
}