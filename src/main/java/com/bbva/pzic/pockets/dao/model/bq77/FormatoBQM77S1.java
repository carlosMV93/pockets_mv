package com.bbva.pzic.pockets.dao.model.bq77;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;



/**
 * Formato de datos <code>BQM77S1</code> de la transacci&oacute;n <code>BQ77</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BQM77S1")
@RooJavaBean
@RooSerializable
public class FormatoBQM77S1 {
	
	/**
	 * <p>Campo <code>IDPOC</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idpoc;
	
	/**
	 * <p>Campo <code>NOMCOR</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NOMCOR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nomcor;
	
	/**
	 * <p>Campo <code>MONPOC</code>, &iacute;ndice: <code>3</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 3, nombre = "MONPOC", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal monpoc;
	
	/**
	 * <p>Campo <code>FLAPOC</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "FLAPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String flapoc;
	
	/**
	 * <p>Campo <code>FECHPOC</code>, &iacute;ndice: <code>5</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 5, nombre = "FECHPOC", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechpoc;
	
	/**
	 * <p>Campo <code>MONEDA</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "MONEDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String moneda;
	
	/**
	 * <p>Campo <code>PRIPOC</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "PRIPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String pripoc;
	
	/**
	 * <p>Campo <code>AHOPOC</code>, &iacute;ndice: <code>8</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 8, nombre = "AHOPOC", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal ahopoc;
	
	/**
	 * <p>Campo <code>MONAHO</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "MONAHO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String monaho;
	
	/**
	 * <p>Campo <code>IDPRESP</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "IDPRESP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String idpresp;
	
	/**
	 * <p>Campo <code>NOMPRES</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "NOMPRES", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nompres;
	
	/**
	 * <p>Campo <code>TIPPOC</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "TIPPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String tippoc;
	
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
	 * <p>Campo <code>IMPAUT</code>, &iacute;ndice: <code>15</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 15, nombre = "IMPAUT", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal impaut;
	
	/**
	 * <p>Campo <code>MONIMP</code>, &iacute;ndice: <code>16</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 16, nombre = "MONIMP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String monimp;
	
	/**
	 * <p>Campo <code>PERAUT</code>, &iacute;ndice: <code>17</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 17, nombre = "PERAUT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String peraut;
	
	/**
	 * <p>Campo <code>DESPERI</code>, &iacute;ndice: <code>18</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 18, nombre = "DESPERI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String desperi;
	
	/**
	 * <p>Campo <code>DIAAUTO</code>, &iacute;ndice: <code>19</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 19, nombre = "DIAAUTO", tipo = TipoCampo.ENTERO, longitudMinima = 2, longitudMaxima = 2)
	private Integer diaauto;
	
	/**
	 * <p>Campo <code>NUMCUEN</code>, &iacute;ndice: <code>20</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 20, nombre = "NUMCUEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcuen;
	
	/**
	 * <p>Campo <code>FECHCRE</code>, &iacute;ndice: <code>21</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 21, nombre = "FECHCRE", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechcre;
	
	/**
	 * <p>Campo <code>FLAAXR</code>, &iacute;ndice: <code>22</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 22, nombre = "FLAAXR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String flaaxr;
	
	/**
	 * <p>Campo <code>IDINTER</code>, &iacute;ndice: <code>23</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 23, nombre = "IDINTER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String idinter;
	
	/**
	 * <p>Campo <code>IMPINTE</code>, &iacute;ndice: <code>24</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 24, nombre = "IMPINTE", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal impinte;
	
	/**
	 * <p>Campo <code>IDTPRE</code>, &iacute;ndice: <code>25</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 25, nombre = "IDTPRE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String idtpre;
	
	/**
	 * <p>Campo <code>MTOPOCK</code>, &iacute;ndice: <code>26</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 26, nombre = "MTOPOCK", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal mtopock;
	
	/**
	 * <p>Campo <code>DIASRES</code>, &iacute;ndice: <code>27</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 27, nombre = "DIASRES", tipo = TipoCampo.ENTERO, longitudMinima = 5, longitudMaxima = 5)
	private Integer diasres;
	
	/**
	 * <p>Campo <code>DIASTOT</code>, &iacute;ndice: <code>28</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 28, nombre = "DIASTOT", tipo = TipoCampo.ENTERO, longitudMinima = 5, longitudMaxima = 5)
	private Integer diastot;
	
	/**
	 * <p>Campo <code>HORAOPE</code>, &iacute;ndice: <code>29</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 29, nombre = "HORAOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String horaope;
	
}