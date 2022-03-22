package com.bbva.pzic.pockets.dao.model.bq72;

import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;


/**
 * Formato de datos <code>BGMQ721</code> de la transacci&oacute;n <code>BQ72</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ721")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBGMQ721 {

	/**
	 * <p>Campo <code>IDAFILI</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDAFILI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String idafili;

	/**
	 * <p>Campo <code>IDCTAFI</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "IDCTAFI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String idctafi;

	/**
	 * <p>Campo <code>NUMECTA</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "NUMECTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numecta;

	/**
	 * <p>Campo <code>TIPRODT</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "TIPRODT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tiprodt;

	/**
	 * <p>Campo <code>IDETICO</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "IDETICO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idetico;

	/**
	 * <p>Campo <code>IDEPRRE</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "IDEPRRE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String ideprre;

	/**
	 * <p>Campo <code>RELTYID</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "RELTYID", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltyid;

	/**
	 * <p>Campo <code>RELNAME</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "RELNAME", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String relname;

	/**
	 * <p>Campo <code>FECHAFI</code>, &iacute;ndice: <code>9</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 9, nombre = "FECHAFI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechafi;

}