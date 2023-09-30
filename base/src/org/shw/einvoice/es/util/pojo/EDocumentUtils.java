/**
 * 
 */
package org.shw.einvoice.es.util.pojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MSysConfig;

/**
 * Utils common to all documents
 */
public class EDocumentUtils {
	public static String ABSDIRECTORY = MSysConfig.getValue("EI_PATH");	
	
	public static final String IDENTIFICACION 		= "identificacion";
	public static final String EMISOR 				= "emisor";
	public static final String RESUMEN 				= "resumen";
	public static final String CUERPODOCUMENTO 		= "cuerpoDocumento";
	public static final String DOCUMENTORELACIONADO = "documentoRelacionado";
	public static final String OTROSDOCUMENTOS 		= "otrosDocumentos";
	public static final String RECEPTOR 			= "receptor";
	public static final String VENTATERCERO 		= "ventaTercero";        
	public static final String EXTENSION 			= "extension";
	public static final String APENDICE 			= "apendice";
	public static final String DOCUMENTO 			= "documento";
	public static final String MOTIVO 				= "motivo";
	
	public static final String NUMEROCONTROL 		=  "numeroControl";
	public static final String CODIGOGENERACION 	=  "codigoGeneracion";
	public static final String TIPOMODELO 			=  "tipoModelo";
	public static final String TIPOOPERACION 		=  "tipoOperacion";
	public static final String FECEMI 				=  "fecEmi";
	public static final String HOREMI 				=  "horEmi";
	public static final String TIPOMONEDA 			=  "tipoMoneda";
	public static final String NIT 					=  "nit";
	public static final String NRC 					=  "nrc";
	public static final String NOMBRE 				=  "nombre";
	public static final String CODACTIVIDAD 		=  "codActividad";
	public static final String DESCACTIVIDAD 		=  "descActividad";
	public static final String NOMBRECOMERCIAL 		=  "nombreComercial";
	public static final String TIPOESTABLECIMIENTO =  "tipoEstablecimiento";
	public static final String DEPARTAMENTO 		=  "departamento";
	public static final String MUNICIPIO 			=  "municipio";
	public static final String COMPLEMENTO 			=  "complemento";
	public static final String TELEFONO 			=  "telefono";
	public static final String CORREO 				=  "correo";
	public static final String TIPODOCUMENTO 		=  "tipoDocumento";
	public static final String NUMDOCUMENTO 		=  "numDocumento";
	public static final String NUMITEM 				= "numItem";
	public static final String TIPOITEM 			= "tipoItem";
	public static final String NUMERODOCUMENTO 		= "numeroDocumento";
	public static final String CANTIDAD 			= "cantidad";
	public static final String CODIGO 				= "codigo";
	public static final String CODIGOTRIBUTO 		= "codigoTributo";
	public static final String AMBIENTE 			= "ambiente";

	public static final String UNIMEDIDA 			= "uniMedida";
	public static final String DESCRIPCION 			= "descripcion";
	public static final String PRECIOUNI 			= "precioUni";
	public static final String MONTODESCU 			= "montoDescu";
	public static final String VENTANOSUJ 			= "ventaNoSuj";
	public static final String VENTAEXENTA 			= "ventaExenta";
	public static final String VENTAGRAVADA 		= "ventaGravada";
	public static final String IVAITEM 				= "ivaItem";
	public static final String PSV 					= "psv";
	public static final String NOGRAVADO 			= "noGravado";


	public static final String TOTALNOSUJ 			= "totalNoSuj";
	public static final String TOTALEXENTA 			= "totalExenta";
	public static final String TOTALGRAVADA 		= "totalGravada";
	public static final String SUBTOTALVENTAS 		= "subTotalVentas";
	public static final String DESCUNOSUJ 			= "descuNoSuj";
	public static final String DESCUEXENTA 			= "descuExenta";
	public static final String DESCUGRAVADA 		= "descuGravada";
	public static final String PORCENTAJEDESCUENTO 	= "porcentajeDescuento";
	public static final String SUBTOTAL 			= "subTotal";
	public static final String IVARETE1 			= "ivaRete1";
	public static final String MONTOTOTALOPERACION 	= "montoTotalOperacion";
	public static final String TOTALNOGRAVADO 		= "totalNoGravado";
	public static final String TOTALPAGAR 			= "totalPagar";
	public static final String TOTALLETRAS 			= "totalLetras";
	public static final String SALDOFAVOR 			= "saldoFavor";
	public static final String CONDICIONOPERACION 	= "condicionOperacion";
	public static final String TOTALDESCU 			= "totalDescu";
	public static final String RETERENTA 			= "reteRenta";
	public static final String TOTALIVA 			= "totalIva";
	public static final String MONTOPAGO 			= "montoPago";
	public static final String REFERENCIA 			= "referencia";
	public static final String PLAZO 				= "plazo";
	public static final String PERIODO 				= "periodo";
	public static final String TRIBUTOS				= "tributos";
	public static final String PAGOS				= "pagos";
	public static final String DIRECCION			= "direccion";
	
	public static final String ERRORMESSAGES 		= "errorMessages";

	static public boolean writeToFile (String json, MInvoice invoice, String directory)
	{
		try
		{
    		Path rootpath = Paths.get(directory);
    		if (!Files.exists(rootpath)) {
    			return false;
    		}    	
    		
			directory = (directory.endsWith("/")
					|| directory.endsWith("\\"))
					? directory:directory + "/";
			Path path = Paths.get(directory + invoice.getDateAcct().toString().substring(0, 10) + "/");
			Files.createDirectories(path);
			//java.nio.file.Files;
			Files.createDirectories(path);
			String filename = path +"/" + invoice.getDocumentNo().replace(" ", "") + ".json"; 
			File out = new File (filename);
			Writer fw = new OutputStreamWriter(new FileOutputStream(out, false), "UTF-8");
			fw.write(json);
			fw.flush ();
			fw.close ();
			float size = out.length();
			size /= 1024;
			System.out.println("File size: " + out.getAbsolutePath() + " - " + size + " kB");
			System.out.println("Printed To: " + filename);
			return true;
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	static public String getNumeroControl(Integer id, MOrgInfo orgInfo, String prefix) {
		String idIdentification  = StringUtils.leftPad(id.toString(), 15,"0");
		String duns = orgInfo.getDUNS().replace("-", "");
		String numeroControl = prefix + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
		return numeroControl;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
