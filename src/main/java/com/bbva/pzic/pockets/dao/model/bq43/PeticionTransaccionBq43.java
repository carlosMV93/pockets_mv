package com.bbva.pzic.pockets.dao.model.bq43;

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
 * <p>Transacci&oacute;n <code>BQ43</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq43</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq43</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ43.D1170505
 * BQ43MODIFICAR POCKET DE AHORRO         BG        BQ2C0430PBDBGPO BQM43E1             BQ43  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-03-27XP86234 2017-03-3111.40.01XP86234 2017-03-27-09.18.49.732834XP86234 0001-01-010001-01-01
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM43E1.D1170505
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�01�00001�IDPOC  �ID POCKET           �A�023�0�R�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�02�00024�NOMPOC �NOMBRE LARGO POCKET �A�060�0�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�03�00084�NOMCOR �NOMBRE CORTO POCKET �A�020�0�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�04�00104�MONPOC �MONTO TOTAL AHORRO  �N�015�2�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�05�00119�MONEDA �MONEDA DE AHORRO    �A�003�0�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�06�00122�FECHPOC�FECHA FINAL AHORRO  �A�010�0�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�07�00132�PRIPOC �PRIORIDAD DE POCKET �N�003�0�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�08�00135�TIPPOC �TIPO DE POCKET      �N�003�0�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�09�00138�FLAGPOC�FLAG AUTOMATICO     �A�001�0�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�10�00139�IMPAUT �IMPORTE AUTOMATICO  �N�015�2�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�11�00154�MONIMP �MONEDA DE IMPORTE   �A�003�0�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�12�00157�PERAUT �PERIODICIDAD APORTE �A�001�0�O�        �
 * BQM43E1 �MODIFICAR POCKET DE AHORRO    �F�13�00159�13�00158�DIAAUTO�FECHA APORTE 1      �A�002�0�O�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ43.D1170505
</pre></code>
 *
 * @see RespuestaTransaccionBq43
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ43",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq43.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM43E1.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq43 implements MensajeMultiparte {

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