package com.bbva.pzic.pockets.dao.model.bq74;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;



/**
 * Formato de datos <code>BGMQ741</code> de la transacci&oacute;n <code>BQ74</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ741")
@RooJavaBean
@RooSerializable
public class FormatoBGMQ741 {
	
	/**
	 * <p>Campo <code>IDEPOCK</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDEPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idepock;
	
	/**
	 * <p>Campo <code>NUMCUEN</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMCUEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcuen;
	
	/**
	 * <p>Campo <code>IDTIPOC</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "IDTIPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 6, longitudMaxima = 6)
	private String idtipoc;
	
	/**
	 * <p>Campo <code>NOMCUEN</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "NOMCUEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String nomcuen;
	
	/**
	 * <p>Campo <code>IDEPRRE</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "IDEPRRE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String ideprre;
	
	/**
	 * <p>Campo <code>DESPRRE</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "DESPRRE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String desprre;
	
	/**
	 * <p>Campo <code>NOMPOCK</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "NOMPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nompock;
	
	/**
	 * <p>Campo <code>MTOPOCK</code>, &iacute;ndice: <code>8</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 8, nombre = "MTOPOCK", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal mtopock;
	
	/**
	 * <p>Campo <code>DIVPOCK</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "DIVPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String divpock;
	
	/**
	 * <p>Campo <code>PRIPOCK</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "PRIPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String pripock;
	
	/**
	 * <p>Campo <code>FEFPOCK</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "FEFPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String fefpock;
	
	/**
	 * <p>Campo <code>AHOPOCK</code>, &iacute;ndice: <code>12</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 12, nombre = "AHOPOCK", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal ahopock;
	
	/**
	 * <p>Campo <code>DIVAHOR</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "DIVAHOR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String divahor;
	
	/**
	 * <p>Campo <code>ESTPOCK</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "ESTPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estpock;
	
	/**
	 * <p>Campo <code>DESESTA</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "DESESTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String desesta;
	
	/**
	 * <p>Campo <code>CODAFIL</code>, &iacute;ndice: <code>16</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 16, nombre = "CODAFIL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String codafil;
	
	/**
	 * <p>Campo <code>CODCATE</code>, &iacute;ndice: <code>17</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 17, nombre = "CODCATE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String codcate;
	
	/**
	 * <p>Campo <code>NOMCATE</code>, &iacute;ndice: <code>18</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 18, nombre = "NOMCATE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nomcate;
	
	/**
	 * <p>Campo <code>INDEPOC</code>, &iacute;ndice: <code>19</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 19, nombre = "INDEPOC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String indepoc;
	
	/**
	 * <p>Campo <code>MONTDEP</code>, &iacute;ndice: <code>20</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 20, nombre = "MONTDEP", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal montdep;
	
	/**
	 * <p>Campo <code>DIVDEPO</code>, &iacute;ndice: <code>21</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 21, nombre = "DIVDEPO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String divdepo;
	
	/**
	 * <p>Campo <code>PERDEPO</code>, &iacute;ndice: <code>22</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 22, nombre = "PERDEPO", tipo = TipoCampo.ENTERO, longitudMinima = 2, longitudMaxima = 2)
	private Integer perdepo;
	
	/**
	 * <p>Campo <code>FRECDEP</code>, &iacute;ndice: <code>23</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 23, nombre = "FRECDEP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String frecdep;
	
	/**
	 * <p>Campo <code>NOMFREC</code>, &iacute;ndice: <code>24</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 24, nombre = "NOMFREC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nomfrec;
	
	/**
	 * <p>Campo <code>STAPOCK</code>, &iacute;ndice: <code>25</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 25, nombre = "STAPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String stapock;
	
	/**
	 * <p>Campo <code>IDPRESP</code>, &iacute;ndice: <code>26</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 26, nombre = "IDPRESP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String idpresp;
	
	/**
	 * <p>Campo <code>NOMPRES</code>, &iacute;ndice: <code>27</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 27, nombre = "NOMPRES", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nompres;
	
	/**
	 * <p>Campo <code>IDPERCN</code>, &iacute;ndice: <code>28</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 28, nombre = "IDPERCN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String idpercn;
	
	/**
	 * <p>Campo <code>NOMPERC</code>, &iacute;ndice: <code>29</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 29, nombre = "NOMPERC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nomperc;
	
	/**
	 * <p>Campo <code>PERCENT</code>, &iacute;ndice: <code>30</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 30, nombre = "PERCENT", tipo = TipoCampo.ENTERO, longitudMinima = 5, longitudMaxima = 5)
	private Integer percent;
	
	/**
	 * <p>Campo <code>IDINTER</code>, &iacute;ndice: <code>31</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 31, nombre = "IDINTER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String idinter;
	
	/**
	 * <p>Campo <code>NOMINTE</code>, &iacute;ndice: <code>32</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 32, nombre = "NOMINTE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nominte;
	
	/**
	 * <p>Campo <code>IMPINTE</code>, &iacute;ndice: <code>33</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 33, nombre = "IMPINTE", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, decimales = 2)
	private BigDecimal impinte;
	
	/**
	 * <p>Campo <code>DIVISAD</code>, &iacute;ndice: <code>34</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 34, nombre = "DIVISAD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String divisad;
	
	/**
	 * <p>Campo <code>FECPOCK</code>, &iacute;ndice: <code>35</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 35, nombre = "FECPOCK", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecpock;
	
	/**
	 * <p>Campo <code>DIASRES</code>, &iacute;ndice: <code>36</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 36, nombre = "DIASRES", tipo = TipoCampo.ENTERO, longitudMinima = 5, longitudMaxima = 5)
	private Integer diasres;
	
	/**
	 * <p>Campo <code>DIASTOT</code>, &iacute;ndice: <code>37</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 37, nombre = "DIASTOT", tipo = TipoCampo.ENTERO, longitudMinima = 5, longitudMaxima = 5)
	private Integer diastot;
	
}