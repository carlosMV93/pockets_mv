package com.bbva.pzic.pockets.dao.model.bq73;

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
 * <p>Transacci&oacute;n <code>BQ73</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq73</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq73</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBD.QGFD.FIX.QGDTCCT.BQ73.D1180726.txt
 * BQ73DESAFILIAR CUENTAS ORIGEN          BG        BQ2C0730PBDBGPO BGMQ730             BQ73  NS3000CNNNNN    SSTN    C   SNNSSNNN  NN                2018-07-10XP87051 2018-07-2418.03.13XP87051 2018-07-10-09.51.09.567169XP87051 0001-01-010001-01-01
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.BGMQ730.D1180726.txt
 * BGMQ730 �FORMATO ENTRADA BQ73          �F�02�00041�01�00001�IDEPOCK�IDE. POCKET         �A�023�0�R�        �
 * BGMQ730 �FORMATO ENTRADA BQ73          �F�02�00041�02�00024�NUMECTA�NUMERO CUENTA ORIGEN�A�018�0�R�        �
</pre></code>
 *
 * @see RespuestaTransaccionBq73
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ73",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq73.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBGMQ730.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq73 implements MensajeMultiparte {

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