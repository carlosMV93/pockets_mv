package com.bbva.pzic.pockets.dao.model.bq74;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.Transaccion;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;


/**
 * <p>Transacci&oacute;n <code>BQ74</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq74</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq74</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ74.D1191111.txt
 * BQ74LISTAR POCKETS                     BG        BQ2C0740PBDBGPO BGMQ740             BQ74  NS3000CNNNNN    SSTN    C   SNNSSNNN  NN                2018-07-10XP87051 2018-10-1711.38.09XP94662 2018-07-10-10.01.44.441337XP87051 0001-01-010001-01-01
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BGMQ740.D1191111.txt
 * BGMQ740 ?FORMATO ENTRADA BQ74          ?F?04?00047?01?00001?NUMCUEN?NUMERO DE CUENTA    ?A?020?0?O?        ?
 * BGMQ740 ?FORMATO ENTRADA BQ74          ?F?04?00047?02?00021?OPCION ?OPCION FILTRO POCKET?A?001?0?O?        ?
 * BGMQ740 ?FORMATO ENTRADA BQ74          ?F?04?00047?03?00022?IDPAGIN?IDENTIF. PAGINACION ?A?023?0?O?        ?
 * BGMQ740 ?FORMATO ENTRADA BQ74          ?F?04?00047?04?00045?TAMPAGI?TAMA#O DE PAGINA    ?N?003?0?O?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BGMQ741.D1191111.txt
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?01?00001?IDEPOCK?IDENTICACION POCKET ?A?023?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?02?00024?NUMCUEN?NUMERO DE CUENTA    ?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?03?00044?IDTIPOC?IDENTIFICADOR CUENTA?A?006?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?04?00050?NOMCUEN?NOMBRE DE CUENTA    ?A?030?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?05?00080?IDEPRRE?ID PRODUCTO RELACION?A?001?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?06?00081?DESPRRE?DESCID PROD RELACION?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?07?00101?NOMPOCK?NOMBRE DE POCKET    ?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?08?00121?MTOPOCK?MONTO  DE POCKET    ?N?015?2?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?09?00136?DIVPOCK?MONEDA DE POCKET    ?A?003?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?10?00139?PRIPOCK?PRIORIDAD POCKET    ?A?003?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?11?00142?FEFPOCK?FECHA FIN POCKET    ?A?010?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?12?00152?AHOPOCK?MONTO AHORRO POCKET ?N?015?2?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?13?00167?DIVAHOR?MONEDA AHORRO POCKET?A?003?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?14?00170?ESTPOCK?ESTADO DE POCKET    ?A?001?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?15?00171?DESESTA?DES. ESTADO POCKET  ?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?16?00191?CODAFIL?COD. DE AFILIACION  ?A?001?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?17?00192?CODCATE?COD. CATEGORIA POCKT?A?003?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?18?00195?NOMCATE?DES. CATEGORIA POCKT?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?19?00215?INDEPOC?IND. DEP. AUTOMATICO?A?001?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?20?00216?MONTDEP?MTO. DEP. AUTOMATICO?N?015?2?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?21?00231?DIVDEPO?DIV. DEP. AUTOMATICO?A?003?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?22?00234?PERDEPO?DIA DE DEPOSITO     ?N?002?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?23?00236?FRECDEP?FRECUENCIA DEPOSITO ?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?24?00256?NOMFREC?NOMBRE DE FRECUENCIA?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?25?00276?STAPOCK?ESTADO DEL POCKET   ?A?001?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?26?00277?IDPRESP?IDE. MONTO ACTUAL   ?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?27?00297?NOMPRES?DES. MONTO ACTUAL   ?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?28?00317?IDPERCN?IDE. PORC META GANAD?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?29?00337?NOMPERC?DES. PORC GANADO    ?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?30?00357?PERCENT?VAL. PORC GANADO    ?N?005?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?31?00362?IDINTER?IDE. INTERES GANADO ?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?32?00382?NOMINTE?DES. INTERES GANADO ?A?020?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?33?00402?IMPINTE?IMP. INTERES GANADO ?N?015?2?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?34?00417?DIVISAD?DIVISA  DEPOSITO    ?A?003?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?35?00420?FECPOCK?FECHA ALTA POCKET   ?A?010?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?36?00430?DIASRES?DIAS RESTANTES VCTO ?N?005?0?S?        ?
 * BGMQ741 ?FORMATO SALIDA 1 BQ74         ?X?37?00439?37?00435?DIASTOT?DIAS TOTALES A VCTO ?N?005?0?S?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BGMQ742.D1191111.txt
 * BGMQ742 ?FORMATO SALIDA 2 BQ74         ?X?02?00026?01?00001?IDPAGIN?ID. PAGINACION      ?A?023?0?S?        ?
 * BGMQ742 ?FORMATO SALIDA 2 BQ74         ?X?02?00026?02?00024?TAMPAGI?TAMA#O PAGINACION   ?N?003?0?S?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ74.D1191111.txt
 * BQ74BGMQ741 BGWC0741BQ2C07401S                             XP87051 2018-07-10-16.40.17.277204XP87051 2018-07-11-16.41.05.568282
 * BQ74BGMQ742 BGWC0742BQ2C07401S                             XP87051 2018-07-10-16.40.31.589729XP87051 2018-07-11-16.40.31.278789
</pre></code>
 * 
 * @see RespuestaTransaccionBq74
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ74",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq74.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBGMQ740.class})
@RooJavaBean
@RooSerializable
public class PeticionTransaccionBq74 implements MensajeMultiparte {
	
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