package com.bbva.pzic.pockets.dao.model.bq72;

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
 * <p>Transacci&oacute;n <code>BQ72</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq72</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq72</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBD.QGFD.FIX.QGDTCCT.BQ72.D1180813.txt
 * BQ72LISTAR POCKET                      BG        BQ2C0720PBDBGPO BGMQ720             BQ72  NS3000CNNNNN    SSTN    C   SNNSSNNN  NN                2018-07-10XP87051 2018-08-1310.27.40XP87051 2018-07-10-09.32.13.695425XP87051 0001-01-010001-01-01
 *
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.BGMQ720.D1180813.txt
 * BGMQ720 �FORMATO ENTRADA TRX BQ72      �F�01�00023�01�00001�IDEPOCK�IDE. POCKET         �A�023�0�R�        �
 *
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.BGMQ721.D1180813.txt
 * BGMQ721 �FORMATO SALIDA TRX BQ76       �X�09�00117�01�00001�IDAFILI�IDE. AFILIACION     �A�018�0�S�        �
 * BGMQ721 �FORMATO SALIDA TRX BQ76       �X�09�00117�02�00019�IDCTAFI�IDE. CTA AFILIADA   �A�018�0�S�        �
 * BGMQ721 �FORMATO SALIDA TRX BQ76       �X�09�00117�03�00037�NUMECTA�NRO. CUENTA AFILIADA�A�018�0�S�        �
 * BGMQ721 �FORMATO SALIDA TRX BQ76       �X�09�00117�04�00055�TIPRODT�TIP. DE CUENTA      �A�002�0�S�        �
 * BGMQ721 �FORMATO SALIDA TRX BQ76       �X�09�00117�05�00057�IDETICO�IDE. TIPO CUENTA    �A�010�0�S�        �
 * BGMQ721 �FORMATO SALIDA TRX BQ76       �X�09�00117�06�00067�IDEPRRE�IDE. TIPO RELAC.    �A�001�0�S�        �
 * BGMQ721 �FORMATO SALIDA TRX BQ76       �X�09�00117�07�00068�RELTYID�IDE. TIPO RELACION  �A�020�0�S�        �
 * BGMQ721 �FORMATO SALIDA TRX BQ76       �X�09�00117�08�00088�RELNAME�DES. TIPO RELACION  �A�020�0�S�        �
 * BGMQ721 �FORMATO SALIDA TRX BQ76       �X�09�00117�09�00108�FECHAFI�FECHA AFILIACION    �A�010�0�S�        �
 *
 * FICHERO: PEBD.QGFD.FIX.QGDTFDX.BQ72.D1180813.txt
 * BQ72BGMQ721 BGWC0721BQ2C07201S                             XP87051 2018-08-03-09.34.35.562920XP87051 2018-08-13-10.26.29.248818
 *
</pre></code>
 *
 * @see RespuestaTransaccionBq72
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ72",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq72.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBGMQ720.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq72 implements MensajeMultiparte {

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