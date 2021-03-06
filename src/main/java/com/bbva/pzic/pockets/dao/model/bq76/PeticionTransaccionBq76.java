package com.bbva.pzic.pockets.dao.model.bq76;

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
 * <p>Transacci&oacute;n <code>BQ76</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq76</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq76</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ76.D1191113.txt
 * BQ76CREAR META DE AHORRO               BG        BQ2C0760PBDBGPO BQM76E1             BQ76  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2018-10-04XP95276 2018-10-1216.35.28XP91947 2018-10-04-16.09.13.590124XP95276 0001-01-010001-01-01
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM76E1.D1191113.txt
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?01?00001?NUMCUEN?CUENTA DE AHORRO    ?A?020?0?R?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?02?00021?TIPPOCK?TIPO DE POCKET      ?A?003?0?R?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?03?00024?NOMCOR ?NOMBRE POCKET       ?A?060?0?R?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?04?00084?MONPOC ?MONTO TOTAL AHORRO  ?N?015?2?O?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?05?00099?MONEDA ?MONEDA DE POCKET    ?A?003?0?O?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?06?00102?FLAGPOC?FLAG AUTOMATICO     ?A?001?0?R?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?07?00103?FECHPOC?FECHA FINAL AHORRO  ?A?010?0?R?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?08?00113?IMPAUT ?IMPORTE AUTOMATICO  ?N?015?2?O?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?09?00128?MONIMP ?MONEDA DE IMPORTE   ?A?003?0?O?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?10?00131?PERAUT ?PERIODICIDAD APORTE ?A?001?0?O?        ?
 * BQM76E1 ?CREAR POCKET DE AHORRO        ?F?11?00133?11?00132?DIAAUTO?DIA DE APORTE AUTOM.?N?002?0?O?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM76S1.D1191113.txt
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?01?00001?IDPOC  ?ID POCKET           ?A?023?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?02?00024?TIPPOCK?TIPO DE POCKET      ?A?003?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?03?00027?NOMCOR ?NOMBRE POCKET       ?A?060?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?04?00087?MONPOC ?MONTO POCKET        ?N?015?2?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?05?00102?MONEDA ?MONEDA POCKET       ?A?003?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?06?00105?FLAGPOC?FLAG POCKET AUTOMATI?A?001?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?07?00106?FECHPOC?FECHA FIN POCKET    ?A?010?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?08?00116?IMPAUT ?IMPORTE AUTOMATICO  ?N?015?2?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?09?00131?MONIMP ?MONEDA IMPORTE AUTOM?A?003?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?10?00134?PERAUT ?PERIODIC APORTE AUTO?A?001?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?11?00135?DIAAUTO?DIA APORTE AUTOMATIC?N?002?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?12?00137?FECHCRE?FEC.CREAC. POCKET   ?A?010?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?13?00147?ESTADO ?ESTADO DE POCKET    ?A?001?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?14?00148?NUMCUEN?CUENTA DE AHORRO    ?A?020?0?S?        ?
 * BQM76S1 ?CREAR META DE AHORRO          ?X?15?00175?15?00168?HORAOPE?HORA DE OPERACION   ?A?008?0?S?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ76.D1191113.txt
 * BQ76BQM76S1 BQWC76S1BQ2C07601S                             XP95276 2018-10-04-17.44.35.974637XP95276 2018-10-04-17.44.35.974658
</pre></code>
 * 
 * @see RespuestaTransaccionBq76
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ76",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq76.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM76E1.class})
@RooJavaBean
@RooSerializable
public class PeticionTransaccionBq76 implements MensajeMultiparte {
	
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