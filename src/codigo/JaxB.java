/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.List;
import java.io.File;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author Diego Álvarez
 */
public class JaxB {
    public int abrir_XML_JAXB(File fichero, Libros misLibros){
        JAXBContext contexto;
        try{
            //Crea una instancia JAXB
            contexto = JAXBContext.newInstance(Libros.class);
            //Crea un objeto Unmarsheller.
            Unmarsheller u = contexto.createUnmarshaller();
            //Deserializa (unmarshal) el fichero
            misLibros = (Libros) u.unmarshal(fichero);
            return 0;
        }catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }
    
    public String recorrerJAXByMostrar(){
        String datos_nodo[]=null;
        String cadena_resultado="";
        
        //Crea una lista con objetos de tipo libro
        List<Libros.Libro>|Libros=misLibros.getLibro();
        //Recorre la lista para sacar los valores
        for(int=0;i<|Libros.size();i++){
        
    }
    }
}
