package com.bbva.pzic.pockets.dao.model.bq78;

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
 * <p>Transacci&oacute;n <code>BQ78</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionBq78</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionBq78</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: PEBT.QGFD.FIX.QGDTCCT.BQ78.D1191113.txt
 * BQ78CONTRIBUCION A LA META DE AHORRO   BG        BQ2C0780PBDBGPO BQM78E1             BQ78  NN3000CNNNNN    SSTN     E  NNNSSNNN  NN                2018-10-04XP95276 2018-10-0419.48.32XP95276 2018-10-04-18.38.32.487439XP95276 0001-01-010001-01-01
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM78E1.D1191113.txt
 * BQM78E1 ?APORTE/LIBERACION POCKET (ENT)?F?03?00041?01?00001?IDPOC  ?IDENTIF DE POCKET   ?A?023?0?R?        ?
 * BQM78E1 ?APORTE/LIBERACION POCKET (ENT)?F?03?00041?02?00024?IMPORTE?IMP. APORTE O LIBERA?N?015?2?R?        ?
 * BQM78E1 ?APORTE/LIBERACION POCKET (ENT)?F?03?00041?03?00039?MONEDA ?MONEDA              ?A?003?0?R?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDF.BQM78S1.D1191113.txt
 * BQM78S1 ?CONTRIB.  META DE AHORRO (SAL)?X?05?00043?01?00001?IMPORTE?IMP. APORTE O LIBERA?N?015?2?S?        ?
 * BQM78S1 ?CONTRIB.  META DE AHORRO (SAL)?X?05?00043?02?00016?MONEDA ?MONEDA DE POCKET    ?A?003?0?S?        ?
 * BQM78S1 ?CONTRIB.  META DE AHORRO (SAL)?X?05?00043?03?00019?NUMOPE ?NUMERO DE OPERACION ?N?007?0?S?        ?
 * BQM78S1 ?CONTRIB.  META DE AHORRO (SAL)?X?05?00043?04?00026?FECHOPE?FECHA DE OPERACION  ?A?010?0?S?        ?
 * BQM78S1 ?CONTRIB.  META DE AHORRO (SAL)?X?05?00043?05?00036?HORAOPE?HORA DE OPERACION   ?A?008?0?S?        ?
 * FICHERO: PEBT.QGFD.FIX.QGDTFDX.BQ78.D1191113.txt
 * BQ78BQM78S1 BQWC78S1BQ2C07801S                             XP95276 2018-10-04-19.55.27.055452XP95276 2018-10-04-19.55.27.055484
</pre></code>
 * 
 * @see RespuestaTransaccionBq78
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "BQ78",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionBq78.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoBQM78E1.class})
@RooJavaBean
@RooSerializable
public class PeticionTransaccionBq78 implements MensajeMultiparte {
	
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