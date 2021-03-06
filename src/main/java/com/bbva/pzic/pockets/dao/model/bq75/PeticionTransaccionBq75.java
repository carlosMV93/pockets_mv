package com.bbva.pzic.pockets.dao.model.bq75;

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
 * <p>Transacci&oacute;n <code>BQ75</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq75</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq75</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ75.D1190905.txt
 * BQ75LISTAR MOVIMIENTOS DE POCKETS      BG        BQ2C0750PBDBGPO BGMQ750             BQ75  NS3000CNNNNN    SSTN    C   SNNSSNNN  NN                2018-07-10XP87051 2018-11-1514.23.25XP87051 2018-07-10-15.41.04.882254XP87051 0001-01-010001-01-01
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BGMQ750.D1190905.txt
 * BGMQ750 �FORMATO ENTRADA BQ75          �F�03�00046�01�00001�IDEPOCK�IDE. POCKET         �A�023�0�R�        �
 * BGMQ750 �FORMATO ENTRADA BQ75          �F�03�00046�02�00024�IDPAGIN�IDE. PAGINACION     �A�020�0�O�        �
 * BGMQ750 �FORMATO ENTRADA BQ75          �F�03�00046�03�00044�TAMPAGI�TAMA#O DE PAGINA    �N�003�0�O�        �
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BGMQ751.D1190905.txt
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�01�00001�NUMEOPE�NUMERO OPERACION    �N�007�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�02�00008�DETMOVI�DETALLE MOVIMIENTO  �A�040�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�03�00048�TIPOPER�TIPO DE OPERACION   �A�020�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�04�00068�DESTIPO�DESC TIPO OPERACION �A�001�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�05�00069�MTOMOVI�IMPORTE MOVIMIENTO  �N�015�2�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�06�00084�DIVMOVI�MONEDA  MOVIMIENTO  �A�003�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�07�00087�FCHMOVI�FECHA DE MOVIMIENTO �A�010�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�08�00097�NOMESTA�NOMBRE ESTABLECIMTO �A�060�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�09�00157�NUMECTA�NUMERO CUENTA ORIGEN�A�020�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�10�00177�IDEPOCK�IDE. POCKET         �A�023�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�11�00200�IDETICO�IDE. TIPO CONTRATO  �A�001�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�12�00201�DESTICO�DES. TIPO CONTRATO  �A�010�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�13�00211�IDEPRRE�IDE. TIPO PRODUCTO  �A�001�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�14�00212�DESPRRE�DES. TIPO PRODUCTO  �A�020�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�15�00232�RELTYID�IDE. RELACION CUENTA�A�020�0�S�        �
 * BGMQ751 �FORMATO SALIDA 1 BQ75         �X�16�00271�16�00252�RELNAME�DES. NOMBRE RELACION�A�020�0�S�        �
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BGMQ752.D1190905.txt
 * BGMQ752 �FORMATO SALIDA 2 BQ75         �X�02�00023�01�00001�IDPAGIN�IDE. PAGINACION     �A�020�0�S�        �
 * BGMQ752 �FORMATO SALIDA 2 BQ75         �X�02�00023�02�00021�TAMPAGI�TAMA#O PAGINACION   �N�003�0�S�        �
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ75.D1190905.txt
 * BQ75BGMQ751 BGWC0751BQ2C07501S                             XP87051 2018-07-10-16.40.57.368724XP87051 2018-07-11-16.41.30.422761
 * BQ75BGMQ752 BGWC0752BQ2C07501S                             XP87051 2018-07-10-16.41.29.186817XP87051 2018-07-11-16.41.38.067446
</pre></code>
 * 
 * @see RespuestaTransaccionBq75
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ75",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq75.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBGMQ750.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq75 implements MensajeMultiparte {
	
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