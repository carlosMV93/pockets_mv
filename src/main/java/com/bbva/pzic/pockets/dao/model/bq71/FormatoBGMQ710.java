package com.bbva.pzic.pockets.dao.model.bq71;


import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>BGMQ710</code> de la transacci&oacute;n <code>BQ71</code>
 *
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "BGMQ710")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoBGMQ710 {

	/**
	 * <p>Campo <code>IDEPOCK</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDEPOCK", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String idepock;

	/**
	 * <p>Campo <code>NUMCTA1</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMCTA1", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta1;

	/**
	 * <p>Campo <code>TIPCTA1</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "TIPCTA1", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta1;

	/**
	 * <p>Campo <code>IDETIC1</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "IDETIC1", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic1;

	/**
	 * <p>Campo <code>IDEPRE1</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "IDEPRE1", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre1;

	/**
	 * <p>Campo <code>RELTID1</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "RELTID1", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid1;

	/**
	 * <p>Campo <code>NUMCTA2</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "NUMCTA2", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta2;

	/**
	 * <p>Campo <code>TIPCTA2</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "TIPCTA2", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta2;

	/**
	 * <p>Campo <code>IDETIC2</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "IDETIC2", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic2;

	/**
	 * <p>Campo <code>IDEPRE2</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "IDEPRE2", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre2;

	/**
	 * <p>Campo <code>RELTID2</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "RELTID2", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid2;

	/**
	 * <p>Campo <code>NUMCTA3</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "NUMCTA3", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta3;

	/**
	 * <p>Campo <code>TIPCTA3</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "TIPCTA3", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta3;

	/**
	 * <p>Campo <code>IDETIC3</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "IDETIC3", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic3;

	/**
	 * <p>Campo <code>IDEPRE3</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "IDEPRE3", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre3;

	/**
	 * <p>Campo <code>RELTID3</code>, &iacute;ndice: <code>16</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 16, nombre = "RELTID3", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid3;

	/**
	 * <p>Campo <code>NUMCTA4</code>, &iacute;ndice: <code>17</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 17, nombre = "NUMCTA4", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta4;

	/**
	 * <p>Campo <code>TIPCTA4</code>, &iacute;ndice: <code>18</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 18, nombre = "TIPCTA4", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta4;

	/**
	 * <p>Campo <code>IDETIC4</code>, &iacute;ndice: <code>19</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 19, nombre = "IDETIC4", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic4;

	/**
	 * <p>Campo <code>IDEPRE4</code>, &iacute;ndice: <code>20</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 20, nombre = "IDEPRE4", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre4;

	/**
	 * <p>Campo <code>RELTID4</code>, &iacute;ndice: <code>21</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 21, nombre = "RELTID4", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid4;

	/**
	 * <p>Campo <code>NUMCTA5</code>, &iacute;ndice: <code>22</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 22, nombre = "NUMCTA5", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta5;

	/**
	 * <p>Campo <code>TIPCTA5</code>, &iacute;ndice: <code>23</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 23, nombre = "TIPCTA5", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta5;

	/**
	 * <p>Campo <code>IDETIC5</code>, &iacute;ndice: <code>24</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 24, nombre = "IDETIC5", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic5;

	/**
	 * <p>Campo <code>IDEPRE5</code>, &iacute;ndice: <code>25</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 25, nombre = "IDEPRE5", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre5;

	/**
	 * <p>Campo <code>RELTID5</code>, &iacute;ndice: <code>26</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 26, nombre = "RELTID5", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid5;

	/**
	 * <p>Campo <code>NUMCTA6</code>, &iacute;ndice: <code>27</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 27, nombre = "NUMCTA6", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta6;

	/**
	 * <p>Campo <code>TIPCTA6</code>, &iacute;ndice: <code>28</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 28, nombre = "TIPCTA6", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta6;

	/**
	 * <p>Campo <code>IDETIC6</code>, &iacute;ndice: <code>29</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 29, nombre = "IDETIC6", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic6;

	/**
	 * <p>Campo <code>IDEPRE6</code>, &iacute;ndice: <code>30</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 30, nombre = "IDEPRE6", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre6;

	/**
	 * <p>Campo <code>RELTID6</code>, &iacute;ndice: <code>31</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 31, nombre = "RELTID6", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid6;

	/**
	 * <p>Campo <code>NUMCTA7</code>, &iacute;ndice: <code>32</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 32, nombre = "NUMCTA7", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta7;

	/**
	 * <p>Campo <code>TIPCTA7</code>, &iacute;ndice: <code>33</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 33, nombre = "TIPCTA7", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta7;

	/**
	 * <p>Campo <code>IDETIC7</code>, &iacute;ndice: <code>34</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 34, nombre = "IDETIC7", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic7;

	/**
	 * <p>Campo <code>IDEPRE7</code>, &iacute;ndice: <code>35</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 35, nombre = "IDEPRE7", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre7;

	/**
	 * <p>Campo <code>RELTID7</code>, &iacute;ndice: <code>36</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 36, nombre = "RELTID7", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid7;

	/**
	 * <p>Campo <code>NUMCTA8</code>, &iacute;ndice: <code>37</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 37, nombre = "NUMCTA8", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta8;

	/**
	 * <p>Campo <code>TIPCTA8</code>, &iacute;ndice: <code>38</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 38, nombre = "TIPCTA8", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta8;

	/**
	 * <p>Campo <code>IDETIC8</code>, &iacute;ndice: <code>39</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 39, nombre = "IDETIC8", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic8;

	/**
	 * <p>Campo <code>IDEPRE8</code>, &iacute;ndice: <code>40</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 40, nombre = "IDEPRE8", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre8;

	/**
	 * <p>Campo <code>RELTID8</code>, &iacute;ndice: <code>41</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 41, nombre = "RELTID8", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid8;

	/**
	 * <p>Campo <code>NUMCTA9</code>, &iacute;ndice: <code>42</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 42, nombre = "NUMCTA9", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta9;

	/**
	 * <p>Campo <code>TIPCTA9</code>, &iacute;ndice: <code>43</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 43, nombre = "TIPCTA9", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta9;

	/**
	 * <p>Campo <code>IDETIC9</code>, &iacute;ndice: <code>44</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 44, nombre = "IDETIC9", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic9;

	/**
	 * <p>Campo <code>IDEPRE9</code>, &iacute;ndice: <code>45</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 45, nombre = "IDEPRE9", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre9;

	/**
	 * <p>Campo <code>RELTID9</code>, &iacute;ndice: <code>46</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 46, nombre = "RELTID9", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid9;

	/**
	 * <p>Campo <code>NUMCTA0</code>, &iacute;ndice: <code>47</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 47, nombre = "NUMCTA0", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcta0;

	/**
	 * <p>Campo <code>TIPCTA0</code>, &iacute;ndice: <code>48</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 48, nombre = "TIPCTA0", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipcta0;

	/**
	 * <p>Campo <code>IDETIC0</code>, &iacute;ndice: <code>49</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 49, nombre = "IDETIC0", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idetic0;

	/**
	 * <p>Campo <code>IDEPRE0</code>, &iacute;ndice: <code>50</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 50, nombre = "IDEPRE0", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String idepre0;

	/**
	 * <p>Campo <code>RELTID0</code>, &iacute;ndice: <code>51</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 51, nombre = "RELTID0", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String reltid0;

}