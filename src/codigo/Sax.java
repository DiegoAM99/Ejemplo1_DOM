/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;


import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Diego Álvarez
 */
public class Sax {
     SAXParser parser;
     ManejadorSAX sh;
     File ficheroXML;
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


class ManejadorSAX extends DefaultHandler{
    int ultimoelement;
    String cadena_resultado="";
    
    public ManejadorSAX(){
        ultimoelement=0;
    }
    
    public void startElement(String uri, String localName, String qName, Attributes atts)throws SAXException{
    if (qName.equals("Libros")){
                cadena_resultado = cadena_resultado + "Libros encontrados:" 
                     + "\n" + "-------------------" + "\n" ;
            }
            
            
            else if (qName.equals("Libro")) {
                cadena_resultado = cadena_resultado + "\nPublicado en: "
                        + atts.getValue(atts.getQName(0)) + "\n";
                ultimoelement = 1;
            } else if (qName.equals("Titulo")) {
                ultimoelement = 2;
                cadena_resultado = cadena_resultado.trim() + "\n"+ "El tÃ­tulo es: ";
            } else if (qName.equals("Autor")) {
                ultimoelement = 3;
                cadena_resultado = cadena_resultado.trim() + "\n"+"El autor es: ";
            }
    }
     public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equals("Libro")) {
                System.out.println("Final de elemento.");
                cadena_resultado = cadena_resultado + "\n -------------------";
            }
        }
     
    public void characters(char[] ch, int start, int length) throws
                SAXException {
            if (ultimoelement == 2) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                }
            } else if (ultimoelement == 3) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                } 
                
            } else if (ultimoelement == 4) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                }
        }
    }
    
}

public String recorrerSAX() {
        try {
            parser.parse(ficheroXML, sh);
            return sh.cadena_resultado;
        } catch (SAXException e) {
            e.printStackTrace();
            return "Error parseando SAX";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error parseando SAX";
        }
    }
}