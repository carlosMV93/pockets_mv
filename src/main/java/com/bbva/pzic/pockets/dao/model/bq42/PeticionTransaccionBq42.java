package com.bbva.pzic.pockets.dao.model.bq42;

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
 * <p>Transacci&oacute;n <code>BQ42</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq42</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq42</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ42.D1170504.txt
 * BQ42BAJA DE POCKET                     BQ        BQ2C0420PBDBGPO BQM42E1             BQ42  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-03-27XP90405 2017-05-0414.21.53XP90405 2017-03-27-10.54.26.928925XP90405 0001-01-010001-01-01
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM42E1.D1170504.txt
 * BQM42E1 �BAJA DE POCKET (ENTRADA)      �F�01�00023�01�00001�IDPOC  �IDENTIFICADOR POCKET�A�023�0�R�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ42.D1170504.txt
</pre></code>
 *
 * @see RespuestaTransaccionBq42
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ42",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq42.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM42E1.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq42 implements MensajeMultiparte {

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