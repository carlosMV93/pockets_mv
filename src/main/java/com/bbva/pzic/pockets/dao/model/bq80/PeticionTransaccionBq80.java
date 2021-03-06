package com.bbva.pzic.pockets.dao.model.bq80;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.Transaccion;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;


/**
 * <p>Transacci&oacute;n <code>BQ80</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq80</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq80</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ80.D1191111.txt
 * BQ80BAJA DE LA META DE AHORRO          BQ        BQ2C0800PBDBGPO BQM80E1             BQ80  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2018-10-04XP95276 2018-10-2614.48.20XP91947 2018-10-04-18.36.11.968058XP95276 0001-01-010001-01-01
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM80E1.D1191111.txt
 * BQM80E1 ?BAJA META DE AHORRO(ENTRADA)  ?F?01?00023?01?00001?IDPOC  ?IDENTIFICADOR POCKET?A?023?0?R?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM80S1.D1191111.txt
 * BQM80S1 ?BAJA META DE AHORRO (SALIDA)  ?X?05?00043?01?00001?NUMOPE ?NUMERO DE OPERACION ?N?007?0?S?        ?
 * BQM80S1 ?BAJA META DE AHORRO (SALIDA)  ?X?05?00043?02?00008?FECHOPE?FECHA DE OPERACION  ?A?010?0?S?        ?
 * BQM80S1 ?BAJA META DE AHORRO (SALIDA)  ?X?05?00043?03?00018?IMPORTE?IMPORTE ACTUAL      ?N?015?2?S?        ?
 * BQM80S1 ?BAJA META DE AHORRO (SALIDA)  ?X?05?00043?04?00033?MONEDA ?MONEDA DE POCKET    ?A?003?0?S?        ?
 * BQM80S1 ?BAJA META DE AHORRO (SALIDA)  ?X?05?00043?05?00036?HORAOPE?HORA DE OPERACION   ?A?008?0?S?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ80.D1191111.txt
 * BQ80BQM80S1 BQWC80S1BQ2C08001S                             XP95276 2018-10-05-15.17.02.248982XP95276 2018-10-05-15.17.02.249017
</pre></code>
 * 
 * @see RespuestaTransaccionBq80
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ80",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq80.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM80E1.class})
@RooJavaBean
@RooSerializable
public class PeticionTransaccionBq80 implements MensajeMultiparte {
	
	/**
	 * <p>Cuerpo del mensaje de petici&oacute;n multiparte</p>
	 */
	@Cuerpo
	private CuerpoMultiparte cuerpo = new CuerpoMultiparte();
	
	/**
	 * <p>Permite obtener el cuerpo del mensaje de petici&oacute;n multiparte</p>
	 */
	@Override
	public CuerpoMultiparte getCuerpo() {
		return cuerpo;
	}
	
}