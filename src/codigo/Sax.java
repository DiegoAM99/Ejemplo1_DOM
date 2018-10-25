/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Diego Álvarez
 */
public class Sax {
    public int abrir_XML_SAX(File fichero){                 //Se crea un objeto SAXParser para interpretar el documento XML.
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            sh = new ManejadorSAX();
            ficheroXML = fichero;
            return 0;
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}

class ManejadorSAX extends DefaultHandler{
    
}