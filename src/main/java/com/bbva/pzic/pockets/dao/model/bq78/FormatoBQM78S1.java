package com.bbva.pzic.pockets.dao.model.bq78;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;



/**
 * Formato de datos <code>BQM78S1</code> de la transacci&oacute;n <code>BQ78</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BQM78S1")
@RooJavaBean
@RooSerializable
public class FormatoBQM78S1 {
	
	/**
	 * <p>Campo <code>IMPORTE</code>, &iacute;ndice: <code>1</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 1, nombre = "IMPORTE", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal importe;
	
	/**
	 * <p>Campo <code>MONEDA</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "MONEDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String moneda;
	
	/**
	 * <p>Campo <code>NUMOPE</code>, &iacute;ndice: <code>3</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 3, nombre = "NUMOPE", tipo = TipoCampo.ENTERO, longitudMinima = 7, longitudMaxima = 7)
	private Integer numope;
	
	/**
	 * <p>Campo <code>FECHOPE</code>, &iacute;ndice: <code>4</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 4, nombre = "FECHOPE", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechope;
	
	/**
	 * <p>Campo <code>HORAOPE</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "HORAOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String horaope;
	
}