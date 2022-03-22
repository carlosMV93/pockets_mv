package com.bbva.pzic.pockets.dao.model.bq76;


import java.math.BigDecimal;
import java.util.Date;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>BQM76E1</code> de la transacci&oacute;n <code>BQ76</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BQM76E1")
@RooJavaBean
@RooSerializable
public class FormatoBQM76E1 {

	/**
	 * <p>Campo <code>NUMCUEN</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCUEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcuen;
	
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
	
}