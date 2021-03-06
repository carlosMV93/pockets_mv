package com.bbva.pzic.pockets.dao.model.bq40;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.Transaccion;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.roo.addon.javabean.annotations.RooToString;

/**
 * <p>Transacci&oacute;n <code>BQ40</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq40</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq40</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ40.D1170504
 * BQ40CONSULTA DETALLE DE POCKET         BG        BQ2C0400PBDBGPO BQM40E1             BQ40  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-04-03XP86234 2017-04-0317.33.54XP86234 2017-04-03-17.33.34.694778XP86234 0001-01-010001-01-01
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM40E1.D1170504
 * BQM40E1 �CONSUL DETALLE POCKET(ENTRADA)�F�01�00023�01�00001�IDPOC  �ID POCKET           �A�023�0�R�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM40S1.D1170504
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�01�00001�POCKET �ID POCKET           �A�023�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�02�00024�NUMCUEN�CUENTA AHORRO CLIENT�A�018�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�03�00042�NOMPOC �NOMBRE DE POCKET LAR�A�060�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�04�00102�NOMCOR �NOMBRE DE POCKET COR�A�020�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�05�00122�MONPOC �MONTO POCKET        �N�015�2�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�06�00137�FLAPOC �FLAG POCKET AUTOMATI�A�001�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�07�00138�FECHPOC�FECHA FIN POCKET    �A�010�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�08�00148�MONEDA �MONEDA DE POCKET    �A�003�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�09�00151�PRIPOC �PRIORIDAD           �N�003�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�10�00154�AHOPOC �MONTO AHORRADO POCKE�N�015�2�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�11�00169�MONAHO �MONEDA AHORRADO POCK�A�003�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�12�00172�TIPPOC �TIPO DE POCKET      �N�003�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�13�00175�DESTIPO�DESCRI. TIPO POCKET �A�020�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�14�00195�ESTPOC �ESTADO DE POCKET    �A�001�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�15�00196�DESEST �DESCR ESTADO POCKET �A�020�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�16�00216�IMPAUT �IMPORTE AUTOMATICO  �N�015�2�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�17�00231�MONIMP �MONEDA IMPORTE AUTOM�A�003�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�18�00234�PERAUT �PERIODICIDAD AUTOMA �A�001�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�19�00235�DESPERI�DESCRI. DE PERIOCIDA�A�010�0�S�        �
 * BQM40S1 �CONSUL DETALLE POCKET(SALIDA) �X�20�00246�20�00245�DIAAUTO�DIA DE APORTE AUTOM1�A�002�0�S�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ40.D1170504
 * BQ40BQM40S1 BQWC40S1BQ2C04001S                             XP86234 2017-04-03-17.44.37.591621XP86234 2017-04-03-17.44.37.638389
 *
</pre></code>
 *
 * @see RespuestaTransaccionBq40
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ40",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq40.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM40E1.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq40 implements MensajeMultiparte {

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