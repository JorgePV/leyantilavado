package com.ph.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ph.config.Conexion;
import com.ph.model.Cliente;

public class GenXml {
	
	private Conexion con;
	private Connection connection;
	
	private Document document;
	
	public GenXml() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.newDocument();
	}
	
	public void generarDocumento(String fecha) throws SQLException {
		con = new Conexion();
        try {
        	String sql = "SELECT inf.mesreportado,inf.clavesujetoobligado,inf.claveactividad,inf.referenciaaviso,inf.prioridad,alr.tipoalerta,alr.descripcion,NOMBRE,APELLIDOPATERNO,NVL(APELLIDOMATERNO, 'X') APELLIDOMATERNO, nvl(to_char(TO_DATE(FECHANACIMIENTO,'dd/mm/yy'),'yyyymmdd'),to_date('20020101','YYYYMMDD')) fechanacimiento,nacionalidad,'clave exom' CLAVEECONOMICA\r\n" + 
        			"    		,NVL(COLONIA, 'X') COLONIA, NVL(CALLE, 'X') CALLE,NVL(NUMEROEXTERIOR, 'X') NUMEROEXTERIOR, NVL(CODIGOPOSTAL, 'X') CODIGOPOSTAL, NVL(CLAVEPAIS, 'X') CLAVEPAIS, NVL(TELEFONO, 'X') TELEFONO, NVL(FECHAPERIODO, to_date('20020101','YYYYMMDD')) FECHAPERIODO, NVL(TIPOOPERACION, 0) TIPOOPERACION, NVL(TIPOTARJETA, 'X') TIPOTARJETA, NVL(NUMIDENTIFICADOR, 0) NUMIDENTIFICADOR,MONTOGASTO\r\n" + 
        			"    		FROM T_SDETCLIENTE DTC, T_SINFORME INF,t_salerta ALR\r\n" + 
        			"    		where inf.informeid=dtc.informeid\r\n" + 
        			"    		and alr.alertaid=alr.alertaid and dtc.reginfid < 50001 order by dtc.reginfid";
        	
        	con.conectar();
    		connection = con.getJdbcConnection();
    		Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery(sql);
    		
            System.out.println("+++++++++");
            rs.next();
            System.out.println(rs.getString("mesreportado"));
            System.out.println("+++++++++");
            
            Element  archivo = document.createElement("archivo");
    		document.appendChild(archivo);
            
    		Element  informe = document.createElement("informe");
    		archivo.appendChild(informe);
    		
    		Element  mesreportado = document.createElement("mes_reportado");
    		mesreportado.appendChild(document.createTextNode(rs.getString("mesreportado")));
    		informe.appendChild(mesreportado);
    		
    		Element  sujetoobligado = document.createElement("sujeto_obligado");    		
    		informe.appendChild(sujetoobligado);
    		
    		Element  clavesujetoobligado = document.createElement("clave_sujeto_obligado");
    		clavesujetoobligado.appendChild(document.createTextNode(rs.getString("clavesujetoobligado")));
    		sujetoobligado.appendChild(clavesujetoobligado);
    		
    		Element  claveactividad = document.createElement("clave-actividad");
    		claveactividad.appendChild(document.createTextNode(rs.getString("claveactividad")));
    		sujetoobligado.appendChild(claveactividad);
    		
    		while (rs.next()) {
    			
    		Element  aviso = document.createElement("aviso");
    		informe.appendChild(aviso);
    		
    		Element  referenciaaviso = document.createElement("referencia_aviso");
    		referenciaaviso.appendChild(document.createTextNode(rs.getString("referenciaaviso")));
    		aviso.appendChild(referenciaaviso);
    		
    		Element  prioridad = document.createElement("prioridad");
    		prioridad.appendChild(document.createTextNode(rs.getString("prioridad")));
    		aviso.appendChild(prioridad);
    		
    		Element  alerta = document.createElement("alerta");
    		aviso.appendChild(alerta);
    		
    		Element  tipoalerta = document.createElement("tipo_alerta");
    		tipoalerta.appendChild(document.createTextNode(rs.getString("tipoalerta")));
    		alerta.appendChild(tipoalerta);
    		
    		Element  descripcionalerta = document.createElement("descripcion_alerta");
    		descripcionalerta.appendChild(document.createTextNode(rs.getString("descripcion")));
    		alerta.appendChild(descripcionalerta);
    		
    		Element  personaaviso = document.createElement("persona_aviso");
    		aviso.appendChild(personaaviso);
    		
    		Element  tipopersona = document.createElement("tipo_persona");
    		personaaviso.appendChild(tipopersona);
    		
    		Element  personalfisica = document.createElement("persona_fisica");
    		tipopersona.appendChild(personalfisica);
    		
    		Element  nombre = document.createElement("nombre");
    		nombre.appendChild(document.createTextNode(rs.getString("nombre")));
    		personalfisica.appendChild(nombre);
    		
    		Element  apelllidopaterno = document.createElement("apellido_paterno");
    		apelllidopaterno.appendChild(document.createTextNode(rs.getString("apellidopaterno")));
    		personalfisica.appendChild(apelllidopaterno);
    		
    		Element  apelllidomaterno = document.createElement("apellido_materno");
    		apelllidomaterno.appendChild(document.createTextNode(rs.getString("apellidomaterno")));
    		personalfisica.appendChild(apelllidomaterno);
    		
    		Element  fechanacimiento = document.createElement("fecha_nacimiento");
    		fechanacimiento.appendChild(document.createTextNode(rs.getString("fechanacimiento")));
    		personalfisica.appendChild(fechanacimiento);
    		
    		Element  paisnacionalidad = document.createElement("pais_nacionalidad");
    		paisnacionalidad.appendChild(document.createTextNode(rs.getString("nacionalidad")));
    		personalfisica.appendChild(paisnacionalidad);
    		
    		Element  actividadeconomica = document.createElement("actividad_economica");
    		actividadeconomica.appendChild(document.createTextNode(rs.getString("CLAVEECONOMICA")));
    		personalfisica.appendChild(actividadeconomica);
    		
    		Element  tipodomicilio = document.createElement("tipo_domicilio");
    		personaaviso.appendChild(tipodomicilio);
    		
    		Element  nacionalidad = document.createElement("nacionalidad");
    		tipodomicilio.appendChild(nacionalidad);
    		
    		Element  colonia = document.createElement("colonia");
    		colonia.appendChild(document.createTextNode(rs.getString("colonia")));
    		nacionalidad.appendChild(colonia);
    		
    		Element  calle = document.createElement("calle");
    		calle.appendChild(document.createTextNode(rs.getString("calle")));
    		nacionalidad.appendChild(calle);
    		
    		Element  numexterion = document.createElement("numero_exterior");
    		numexterion.appendChild(document.createTextNode(rs.getString("NUMEROEXTERIOR")));
    		nacionalidad.appendChild(numexterion);
    		
    		Element  codigopostal = document.createElement("codigo_postal");
    		codigopostal.appendChild(document.createTextNode(rs.getString("CODIGOPOSTAL")));
    		nacionalidad.appendChild(codigopostal);
    		
    		Element  telefono = document.createElement("telefono");
    		personaaviso.appendChild(telefono);
    		
    		Element  clavepais = document.createElement("clave_pais");
    		clavepais.appendChild(document.createTextNode(rs.getString("CLAVEPAIS")));
    		telefono.appendChild(clavepais);
    		
    		Element  numtelefono = document.createElement("numero_telefono");
    		numtelefono.appendChild(document.createTextNode(rs.getString("telefono")));
    		telefono.appendChild(numtelefono);
    		
    		Element  detalleoperaciones = document.createElement("detalle_operaciones");
    		aviso.appendChild(detalleoperaciones);
    		
    		Element  datosoperacion = document.createElement("datos_operacion");
    		detalleoperaciones.appendChild(datosoperacion);
    		
    		Element  fechaperiodo = document.createElement("fecha_periodo");
    		fechaperiodo.appendChild(document.createTextNode(rs.getString("FECHAPERIODO")));
    		datosoperacion.appendChild(fechaperiodo);
    		
    		Element  tipooperacion = document.createElement("tipo_operacion");
    		tipooperacion.appendChild(document.createTextNode(rs.getString("TIPOOPERACION")));
    		datosoperacion.appendChild(tipooperacion);
    		
    		Element  tipotarjeta = document.createElement("tipo_tarjeta");
    		tipotarjeta.appendChild(document.createTextNode(rs.getString("TIPOTARJETA")));
    		datosoperacion.appendChild(tipotarjeta);
    		
    		Element  numeroidentificador = document.createElement("numero_identificador");
    		numeroidentificador.appendChild(document.createTextNode(rs.getString("NUMIDENTIFICADOR")));
    		datosoperacion.appendChild(numeroidentificador);
    		
    		Element  montogasto = document.createElement("monto_gasto");
    		montogasto.appendChild(document.createTextNode(rs.getString("MONTOGASTO")));
    		datosoperacion.appendChild(montogasto);
            }

        } catch (Exception e) {
            System.out.println(e);
        } 
		
		
		con.desconectar();
		System.out.println("desconecta y teemrina xml");
		
	}
	
	public void generarXml() throws TransformerException, IOException {
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();
		
		transf.setOutputProperty(OutputKeys.ENCODING, "windows-1252");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		DOMSource source = new DOMSource(document);		
		File myFile = new File("D:\\Proyectos\\spring_maven\\propiedades_antilavado\\archivos_xm.xml");
		FileWriter fw= new FileWriter(myFile);
		PrintWriter pw = new PrintWriter(fw);
		StreamResult file = new StreamResult(pw);
		transf.transform(source, file);
		System.out.println("termino");
	}
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SQLException {		
		GenXml pr = new GenXml();
		pr.principal();
	}
	public void principal() throws ParserConfigurationException, TransformerException, IOException, SQLException {
		
		GenXml gen = new GenXml();
		String fecha="dia";
		gen.generarDocumento(fecha);
		gen.generarXml();
	}
}
