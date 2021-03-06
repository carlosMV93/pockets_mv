package com.bbva.pzic.pockets.dao.model.bq39;

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
 * <p>Transacci&oacute;n <code>BQ39</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq39</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq39</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ39.D1170505
 * BQ39LISTA DE POCKET                    BG        BQ2C0390PBDBGPO BQM39E1             BQ39  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-04-03XP86234 2017-04-0315.10.44XP86234 2017-04-03-15.10.15.898548XP86234 0001-01-010001-01-01
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM39E1.D1170505
 * BQM39E1 �CONSULTA LISTA POCKET(ENTRADA)�F�04�00042�01�00001�NUMCUEN�CUEN. AHORRO CLIENTE�A�018�0�O�        �
 * BQM39E1 �CONSULTA LISTA POCKET(ENTRADA)�F�04�00042�02�00019�OPCION �OPCION FILTRO POCKET�A�001�0�O�        �
 * BQM39E1 �CONSULTA LISTA POCKET(ENTRADA)�F�04�00042�03�00020�IDPAGIN�IDENTIFICACION PAGIN�A�020�0�O�        �
 * BQM39E1 �CONSULTA LISTA POCKET(ENTRADA)�F�04�00042�04�00040�TAMPAGI�TAMA�O DE PAGINA    �N�003�0�O�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM39P1.D1170505
 * BQM39P1 �CONSULTA LISTA POCKET(PAGINA) �X�02�00023�01�00001�IDPAGIN�IDENTIFICACION PAGIN�A�020�0�S�        �
 * BQM39P1 �CONSULTA LISTA POCKET(PAGINA) �X�02�00023�02�00021�TAMPAGI�TAMA�O DE PAGINA    �N�003�0�S�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM39S1.D1170505
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�01�00001�IDPOC  �ID POCKET           �A�023�0�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�02�00024�NUMCUEN�CUE. AHORRO CLIENTE �A�018�0�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�03�00042�NOMCOR �NOMBRE DE POCKET    �A�020�0�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�04�00062�MONPOC �MONTO POCKET        �N�015�2�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�05�00077�MONEDA �MONEDA DE POCKET    �A�003�0�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�06�00080�PRIPOC �PRIORIDAD           �N�003�0�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�07�00083�FECHPOC�FECHA FIN POCKET    �A�010�0�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�08�00093�AHOPOC �MONTO AHORRA POCKET �N�015�2�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�09�00108�MONAHO �MONEDA MONTO AHORRAD�A�003�0�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�10�00111�ESTPOC �ESTADO DEL POCKET   �A�001�0�S�        �
 * BQM39S1 �CONSULTA LISTA POCKET(SALIDA) �X�11�00131�11�00112�DESEST �DESCR ESTADO POCKET �A�020�0�S�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ39.D1170505
 * BQ39BQM39P1 BQWC39P1BQ2C03901S                             XP86234 2017-04-03-15.19.56.762532XP86234 2017-04-03-15.19.56.763161
 * BQ39BQM39S1 BQWC39S1BQ2C03901S                             XP86234 2017-04-03-15.20.11.808827XP86234 2017-04-03-15.20.11.809007
 *
</pre></code>
 *
 * @see RespuestaTransaccionBq39
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ39",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq39.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM39E1.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq39 implements MensajeMultiparte {

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