package com.bbva.pzic.pockets.dao.model.bq41;

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
 * <p>Transacci&oacute;n <code>BQ41</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq41</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq41</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ41.D1170504
 * BQ41APORTE Y LIBERACION POCKET         BG        BQ2C0410PBDBGPO BQM41E1             BQ41  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-03-24XP90405 2017-05-0414.40.58XP90405 2017-03-24-15.55.23.778259XP90405 0001-01-010001-01-01
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM41E1.D1170504
 * BQM41E1 �APORTE/LIBERACION POCKET (ENT)�F�04�00042�01�00001�IDPOC  �IDENTIF DE POCKET   �A�023�0�R�        �
 * BQM41E1 �APORTE/LIBERACION POCKET (ENT)�F�04�00042�02�00024�TIPOPE �TIPO DE OPERACION   �A�001�0�R�        �
 * BQM41E1 �APORTE/LIBERACION POCKET (ENT)�F�04�00042�03�00025�IMPORTE�IMPORTE OPERACION   �N�015�2�R�        �
 * BQM41E1 �APORTE/LIBERACION POCKET (ENT)�F�04�00042�04�00040�MONEDA �MONEDA              �A�003�0�R�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM41S1.D1170504
 * BQM41S1 �APORTE/LIBERACION POCKET (SAL)�X�01�00007�01�00001�NUMOPE �NUMERO DE OPERACION �N�007�0�S�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ41.D1170504
 * BQ41BQM41S1 BQWC41S1BQ2C04101S                             XP90405 2017-03-24-16.36.34.168736XP90405 2017-03-24-16.36.34.168834
 *
</pre></code>
 *
 * @see RespuestaTransaccionBq41
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ41",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq41.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM41E1.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq41 implements MensajeMultiparte {

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