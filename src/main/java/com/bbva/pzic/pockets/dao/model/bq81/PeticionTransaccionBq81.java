package com.bbva.pzic.pockets.dao.model.bq81;

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
 * <p>Transacci&oacute;n <code>BQ81</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq81</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq81</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ81.D1191118.txt
 * BQ81MODIFICACION DE LA META DE AHORRO  BQ        BQ2C0810PBDBGPO BQM81E1             BQ81  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2018-10-04XP95276 2018-10-2614.48.07XP91947 2018-10-04-18.37.14.717701XP95276 0001-01-010001-01-01
 * 
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM81E1.D1191118.txt
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?01?00001?IDPOC  ?ID POCKET           ?A?023?0?R?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?02?00024?NOMCOR ?NOMBRE POCKET       ?A?060?0?O?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?03?00084?MONPOC ?MONTO POCKET        ?N?015?2?O?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?04?00099?MONEDA ?MONEDA DE POCKET    ?A?003?0?O?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?05?00102?FECHPOC?FECHA FIN POCKET    ?A?010?0?O?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?06?00112?PRIPOC ?PRIORIDAD           ?A?003?0?R?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?07?00115?TIPPOC ?TIPO DE POCKET      ?A?003?0?O?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?08?00118?FLAGPOC?FLAG POCKET AUTOMATI?A?001?0?O?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?09?00119?IMPAUT ?IMPORTE AUTOMATICO  ?N?015?2?O?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?10?00134?MONIMP ?MONEDA IMPORTE AUTOM?A?003?0?O?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?11?00137?PERAUT ?PERIODIC APORTE AUTO?A?001?0?O?        ?
 * BQM81E1 ?MODIFICAR META DE AHORRO (ENT)?F?12?00139?12?00138?DIAAUTO?DIA APORTE AUTOMATIC?N?002?0?O?        ?
 * 
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM81S1.D1191118.txt
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?01?00001?IDPOC  ?ID POCKET           ?A?023?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?02?00024?NOMCOR ?NOMBRE POCKET       ?A?060?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?03?00084?MONPOC ?MONTO POCKET        ?N?015?2?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?04?00099?MONEDA ?MONEDA DE POCKET    ?A?003?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?05?00102?FECHPOC?FECHA FIN POCKET    ?A?010?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?06?00112?PRIPOC ?PRIORIDAD           ?A?003?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?07?00115?TIPPOC ?TIPO DE POCKET      ?A?003?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?08?00118?FLAGPOC?FLAG POCKET AUTOMATI?A?001?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?09?00119?IMPAUT ?IMPORTE AUTOMATICO  ?N?015?2?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?10?00134?MONIMP ?MONEDA IMPORTE AUTOM?A?003?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?11?00137?PERAUT ?PERIODIC APORTE AUTO?A?001?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?12?00138?DIAAUTO?DIA APORTE AUTOMATIC?N?002?0?S?        ?
 * BQM81S1 ?MODIFICAR META DE AHORRO (SAL)?X?13?00140?13?00140?ESTADO ?ESTADO DE POCKET    ?A?001?0?S?        ?
 * 
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ81.D1191118.txt
 * BQ81BQM81S1 BQWC81S1BQ2C08101S                             XP95276 2018-10-05-15.54.32.530832XP95276 2018-10-05-15.54.32.530931
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionBq81
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ81",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq81.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM81E1.class})
@RooJavaBean
@RooSerializable
public class PeticionTransaccionBq81 implements MensajeMultiparte {
	
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