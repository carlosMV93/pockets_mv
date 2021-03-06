package com.bbva.pzic.pockets.dao.model.bq71;

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
 * <p>Transacci&oacute;n <code>BQ71</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq71</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq71</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBD.QGFD.FIX.QGDTCCT.BQ71.D1180809.txt
 * BQ71AFILIACION AHORRO POR REDONDEO     BG        BQ2C0710PBDBGPO BGMQ710             BQ71  NS3000CNNNNN    SSTN    C   SNNSSNNN  NN                2018-07-09XP87051 2018-08-0814.56.42XP87051 2018-07-09-19.00.10.474886XP87051 0001-01-010001-01-01
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.BGMQ710.D1180809.txt
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�01�00001�IDEPOCK�IDE. POCKET         �A�023�0�R�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�02�00024�NUMCTA1�NUMERO DE CUENTA 01 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�03�00042�TIPCTA1�TIPO DE CUENTA   01 �A�002�0�R�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�04�00044�IDETIC1�IDE. TIPO CONT.  01 �A�001�0�R�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�05�00045�IDEPRE1�IDE. PROD RELA.  01 �A�001�0�R�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�06�00046�RELTID1�IDE. TIPO RELA.  01 �A�020�0�R�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�07�00066�NUMCTA2�NUMERO DE CUENTA 02 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�08�00084�TIPCTA2�TIPO DE CUENTA   02 �A�002�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�09�00086�IDETIC2�IDE. TIPO CONT.  02 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�10�00087�IDEPRE2�IDE. PROD RELA.  02 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�11�00088�RELTID2�IDE. TIPO RELA.  02 �A�020�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�12�00108�NUMCTA3�NUMERO DE CUENTA 03 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�13�00126�TIPCTA3�TIPO DE CUENTA   03 �A�002�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�14�00128�IDETIC3�IDE. TIPO CONT.  03 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�15�00129�IDEPRE3�IDE. PROD RELA.  03 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�16�00130�RELTID3�IDE. TIPO RELA.  03 �A�020�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�17�00150�NUMCTA4�NUMERO DE CUENTA 04 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�18�00168�TIPCTA4�TIPO DE CUENTA   04 �A�002�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�19�00170�IDETIC4�IDE. TIPO CONT.  04 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�20�00171�IDEPRE4�IDE. PROD RELA.  04 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�21�00172�RELTID4�IDE. TIPO RELA.  04 �A�020�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�22�00192�NUMCTA5�NUMERO DE CUENTA 05 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�23�00210�TIPCTA5�TIPO DE CUENTA   05 �A�002�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�24�00212�IDETIC5�IDE. TIPO CONT.  05 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�25�00213�IDEPRE5�IDE. PROD RELA.  05 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�26�00214�RELTID5�IDE. TIPO RELA.  05 �A�020�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�27�00234�NUMCTA6�NUMERO DE CUENTA 06 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�28�00252�TIPCTA6�TIPO DE CUENTA   06 �A�002�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�29�00254�IDETIC6�IDE. TIPO CONT.  06 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�30�00255�IDEPRE6�IDE. PROD RELA.  06 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�31�00256�RELTID6�IDE. TIPO RELA.  06 �A�020�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�32�00276�NUMCTA7�NUMERO DE CUENTA 07 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�33�00294�TIPCTA7�TIPO DE CUENTA   07 �A�002�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�34�00296�IDETIC7�IDE. TIPO CONT.  07 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�35�00297�IDEPRE7�IDE. PROD RELA.  07 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�36�00298�RELTID7�IDE. TIPO RELA.  07 �A�020�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�37�00318�NUMCTA8�NUMERO DE CUENTA 08 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�38�00336�TIPCTA8�TIPO DE CUENTA   08 �A�002�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�39�00338�IDETIC8�IDE. TIPO CONT.  08 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�40�00339�IDEPRE8�IDE. PROD RELA.  08 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�41�00340�RELTID8�IDE. TIPO RELA.  08 �A�020�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�42�00360�NUMCTA9�NUMERO DE CUENTA 09 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�43�00378�TIPCTA9�TIPO DE CUENTA   09 �A�002�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�44�00380�IDETIC9�IDE. TIPO CONT.  09 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�45�00381�IDEPRE9�IDE. PROD RELA.  09 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�46�00382�RELTID9�IDE. TIPO RELA.  09 �A�020�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�47�00402�NUMCTA0�NUMERO DE CUENTA 10 �A�018�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�48�00420�TIPCTA0�TIPO DE CUENTA   10 �A�002�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�49�00422�IDETIC0�IDE. TIPO CONT.  10 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�50�00423�IDEPRE0�IDE. PROD RELA.  10 �A�001�0�O�        �
 * BGMQ710 �FORMATO ENTRADA BQ71          �F�51�00443�51�00424�RELTID0�IDE. TIPO RELA.  10 �A�020�0�O�        �
 * FICHERO: PEBD.QGFD.FIX.QGDTFDF.BGMQ711.D1180809.txt
 * BGMQ711 �FORMATO SALIDA 1 BQ71         �X�01�00018�01�00001�IDNMCTA�CUENTA AFILIADA     �A�018�0�S�        �
 * FICHERO: PEBD.QGFD.FIX.QGDTFDX.BQ71.D1180809.txt
 * BQ71BGMQ711 BGWC0711BG2C07101S                             XP87051 2018-08-08-14.52.48.141279XP87051 2018-08-08-14.54.08.590020
</pre></code>
 *
 * @see RespuestaTransaccionBq71
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ71",
	tipo = 1,
	subtipo = 1,
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq71.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBGMQ710.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionBq71 implements MensajeMultiparte {

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