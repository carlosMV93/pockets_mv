package com.bbva.pzic.pockets.dao.model.bq77;

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
 * <p>Transacci&oacute;n <code>BQ77</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq77</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq77</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ77.D1191125.txt
 * BQ77CONSULTA DETALLE META DE AHORRO    BG        BQ2C0770PBDBGPO BQM77E1             BQ77  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2018-10-04XP95276 2018-10-1216.35.41XP91947 2018-10-04-12.14.14.348509XP95276 0001-01-010001-01-01
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM77E1.D1191125.txt
 * BQM77E1 ?CONSUL DETA. META AHO(ENTRADA)?F?01?00023?01?00001?IDPOC  ?ID POCKET           ?A?023?0?R?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM77S1.D1191125.txt
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?01?00001?IDPOC  ?ID POCKET           ?A?023?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?02?00024?NOMCOR ?NOMBRE DE POCKET    ?A?020?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?03?00044?MONPOC ?MONTO POCKET        ?N?015?2?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?04?00059?FLAPOC ?FLAG POCKET AUTOMATI?A?001?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?05?00060?FECHPOC?FECHA FIN POCKET    ?A?010?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?06?00070?MONEDA ?MONEDA DE POCKET    ?A?003?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?07?00073?PRIPOC ?PRIORIDAD           ?A?003?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?08?00076?AHOPOC ?MONTO AHORRADO POCKE?N?015?2?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?09?00091?MONAHO ?MONEDA AHORRADO POCK?A?003?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?10?00094?IDPRESP?ID PRESEN MONTO ACT ?A?020?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?11?00114?NOMPRES?TIPO PRES MONTO ACT ?A?020?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?12?00134?TIPPOC ?TIPO DE POCKET      ?A?003?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?13?00137?DESTIPO?DESCRI. TIPO POCKET ?A?020?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?14?00157?ESTPOC ?ESTADO DE POCKET    ?A?001?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?15?00158?IMPAUT ?IMPORTE AUTOMATICO  ?N?015?2?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?16?00173?MONIMP ?MONEDA IMPORTE AUTOM?A?003?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?17?00176?PERAUT ?PERIODICIDAD AUTOMA ?A?001?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?18?00177?DESPERI?DESCRI. DE PERIOCIDA?A?010?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?19?00187?DIAAUTO?DIA DE APORTE AUTOM1?N?002?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?20?00189?NUMCUEN?CUENTA AHORRO CLIENT?A?020?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?21?00209?FECHCRE?FECHA CREACION POCKE?A?010?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?22?00219?FLAAXR ?FLAG AHORRO X REDOND?A?001?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?23?00220?IDINTER?ID PRESEN INTERES   ?A?020?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?24?00240?IMPINTE?IMPORTE INT GANADO  ?N?015?2?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?25?00255?IDTPRE ?ID PRESEN MON TOTAL ?A?020?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?26?00275?MTOPOCK?MONTO TOTAL DE META ?N?015?2?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?27?00290?DIASRES?DIAS RESTANTES FIN  ?N?005?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?28?00295?DIASTOT?DIAS TOTALES A FIN  ?N?005?0?S?        ?
 * BQM77S1 ?CONSUL DETA. META AHO(SALIDA) ?X?29?00307?29?00300?HORAOPE?HORA DE OPERACION   ?A?008?0?S?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ77.D1191125.txt
 * BQ77BQM77S1 BQWC77S1BQ2C07701S                             XP95276 2018-10-04-18.23.27.049613XP95276 2018-10-04-18.23.27.049688
</pre></code>
 * 
 * @see RespuestaTransaccionBq77
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ77",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq77.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM77E1.class})
@RooJavaBean
@RooSerializable
public class PeticionTransaccionBq77 implements MensajeMultiparte {
	
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