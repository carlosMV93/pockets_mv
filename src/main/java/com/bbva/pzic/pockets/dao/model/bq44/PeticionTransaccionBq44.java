package com.bbva.pzic.pockets.dao.model.bq44;

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
 * <p>Transacci&oacute;n <code>BQ44</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq44</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq44</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ44.D1170505.txt
 * BQ44MOVIMIENTOS POCKET                 BG        BQ2C0440PBDBGPO BQM44E1             BQ44  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2017-03-27XP86234 2017-04-0311.29.55XP86234 2017-03-27-08.56.29.741967XP86234 0001-01-010001-01-01
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM44E1.D1170505.txt
 * BQM44E1 �MOVIMIENTOS POCKET            �F�03�00046�01�00001�IDPOC  �ID POCKET DE AHORRO �A�023�0�R�        �
 * BQM44E1 �MOVIMIENTOS POCKET            �F�03�00046�02�00024�IDPAGIN�IDICADOR DE PAGINA  �A�020�0�O�        �
 * BQM44E1 �MOVIMIENTOS POCKET            �F�03�00046�03�00044�TAMPAGI�TAMA�O DE PAGINA    �N�003�0�O�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM44P1.D1170505.txt
 * BQM44P1 �MODIFICAR POCKET DE AHORRO    �X�02�00023�01�00001�IDPAGIN�INDICADOR DE PAGINA �A�020�0�S�        �
 * BQM44P1 �MODIFICAR POCKET DE AHORRO    �X�02�00023�02�00021�TAMPAGI�TAMA�O DE PAGINA    �N�003�0�S�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM44S1.D1170505.txt
 * BQM44S1 �MOVIMIENTOS DE POCKET         �X�07�00077�01�00001�NUMOPE �NUMERO DE OPERACION �N�007�0�S�        �
 * BQM44S1 �MOVIMIENTOS DE POCKET         �X�07�00077�02�00008�DETMOV �DETALLE MOVIMIENTO  �A�040�0�S�        �
 * BQM44S1 �MOVIMIENTOS DE POCKET         �X�07�00077�03�00048�TIPOPE �TIPO DE OPERACION   �A�001�0�S�        �
 * BQM44S1 �MOVIMIENTOS DE POCKET         �X�07�00077�04�00049�DESTIPO�DESC. TIPO OPERAC.  �A�001�0�S�        �
 * BQM44S1 �MOVIMIENTOS DE POCKET         �X�07�00077�05�00050�MONMOV �MONTO DE MOVIMIENTO �N�015�2�S�        �
 * BQM44S1 �MOVIMIENTOS DE POCKET         �X�07�00077�06�00065�MONEDA �MONEDA DE MOVIMIENTO�A�003�0�S�        �
 * BQM44S1 �MOVIMIENTOS DE POCKET         �X�07�00077�07�00068�FECHMOV�FECHA DE MOVIMIENTO �A�010�0�S�        �
 *
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ44.D1170505.txt
 * BQ44BQM44P1 BQWC44P1BQ2C04401S                             XP86234 2017-04-03-11.29.15.891049XP86234 2017-04-03-11.29.15.892309
 * BQ44BQM44S1 BQWC44S1BQ2C04401S                             XP86234 2017-03-27-09.12.52.897863XP86234 2017-03-27-09.12.52.897902
 *
</pre></code>
 *
 * @see RespuestaTransaccionBq44
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ44",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq44.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM44E1.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq44 implements MensajeMultiparte {

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