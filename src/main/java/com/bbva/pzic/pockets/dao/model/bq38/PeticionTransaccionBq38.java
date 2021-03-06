package com.bbva.pzic.pockets.dao.model.bq38;

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
 * <p>Transacci&oacute;n <code>BQ38</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq38</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq38</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ38.D1170504
 * BQ38CREAR POCKET DE AHORRO             BG        BQ2C0380PBDBGPO BQM38E1             BQ38  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-03-24XP86234 2017-04-0710.43.42XP86234 2017-03-24-13.34.14.701490XP86234 0001-01-010001-01-01
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM38E1.D1170504
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�01�00001�NUMCUEN�CUENTA DE AHORRO    �A�018�0�R�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�02�00019�TIPPOCK�TIPO DE POCKET      �N�003�0�R�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�03�00022�NOMPOC �NOMBRE LARGO POCKET �A�060�0�R�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�04�00082�NOMCOR �NOMBRE CORTO POCKET �A�020�0�R�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�05�00102�MONPOC �MONTO TOTAL AHORRO  �N�015�2�R�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�06�00117�MONEDA �MONEDA DE POCKET    �A�003�0�R�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�07�00120�FLAGPOC�FLAG AUTOMATICO     �A�001�0�R�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�08�00121�FECHPOC�FECHA FINAL AHORRO  �A�010�0�R�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�09�00131�IMPAUT �IMPORTE AUTOMATICO  �N�015�2�O�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�10�00146�MONIMP �MONEDA DE IMPORTE   �A�003�0�O�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�11�00149�PERAUT �PERIODICIDAD APORTE �A�001�0�O�        �
 * BQM38E1 �CREAR POCKET DE AHORRO        �F�12�00151�12�00150�DIAAUTO�FECHA APORTE 1      �A�002�0�O�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM38S1.D1170504
 * BQM38S1 �CREAR POCKET DE AHORRO        �X�01�00023�01�00001�IDPOC  �ID POCKET           �A�023�0�S�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ38.D1170504
 * BQ38BQM38S1 BQWC38S1BQ2C03801S                             XP86234 2017-03-24-15.02.39.896312XP86234 2017-03-24-15.02.39.896330
 *
</pre></code>
 *
 * @see RespuestaTransaccionBq38
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ38",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq38.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM38E1.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq38 implements MensajeMultiparte {

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