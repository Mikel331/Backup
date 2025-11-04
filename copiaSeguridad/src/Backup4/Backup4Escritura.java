package Backup4;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Backup4Escritura{
    public static void main(String[] args){
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // creamos una instancia en el DocumentBuilderFactory
            DocumentBuilder db = dbf.newDocumentBuilder(); // y lo enlazamos con el DocumentBuilder
            Document d = db.newDocument(); // se crea el documento

            // se crea la raíz del xml
            Element contactos = d.createElement("contactos"); 
            d.appendChild(contactos);

            // metemos un contacto dentro de contactos
            Element contacto1 = d.createElement("contacto"); 
            contactos.appendChild(contacto1);

            // creamos el elemento de nombre
            Element nombre1 = d.createElement("nombre");
            nombre1.setAttribute("id","1"); // y le añadimos un atributo con su id
            nombre1.setTextContent("Miguel Gomez"); // le asignamos el texto al elemento
            contacto1.appendChild(nombre1); // y lo metemos dentro del contacto

            // le asignamos el correo al contacto
            Element correo1 = d.createElement("correo");
            correo1.setTextContent("Miguel.Gomez@TechSolutions.com"); // texto que va dentro del correo
            contacto1.appendChild(correo1);

            // le asignamos el telefono al contacto
            Element telefono1 = d.createElement("telefono");
            telefono1.setTextContent("678 901 234"); // el contenido del telefono
            contacto1.appendChild(telefono1);        // y lo vinculamos con el contacto

            // creamos el segundo contacto y lo metemos en la raíz para que no choque con el primero
            Element contacto2 = d.createElement("contacto");
            contactos.appendChild(contacto2);

            // creamos el elemento de nombre para el segundo contacto
            Element nombre2 = d.createElement("nombre");
            nombre2.setAttribute("id","2"); // atributo dentro del elemento para la id
            nombre2.setTextContent("Ana Rodríguez"); // le asignamos el texto al elemento
            contacto2.appendChild(nombre2); // lo metemos dentro del segundo contacto

            // le asignamos el correo al contacto2 y lo metemos en el
            Element correo2 = d.createElement("correo");
            correo2.setTextContent("ana.rodriguez@TechSolutions.com"); // contenido del correo
            contacto2.appendChild(correo2);

            // le asignamos el telefono al contacto2 y lo metemos en su respectivo contacto
            Element telefono2 = d.createElement("telefono");
            telefono2.setTextContent("911 223 344"); // contenido del contacto
            contacto2.appendChild(telefono2);

            TransformerFactory tf = TransformerFactory.newInstance(); // se crea una instancia en la TransformerFactory
            Transformer t = tf.newTransformer(); // crea el dom en un archivo xml

            DOMSource source = new DOMSource(d); // se crea la fuente de datos
            File fichero = new File("contacto.xml"); // el fichero en el cual se escribiran los datos
            StreamResult result = new StreamResult(fichero); // el resultado se escribe en el fichero "contacto.xml"
            t.transform(source, result); // y transforma el resultado

        }catch(ParserConfigurationException e){ // excepcion por si hay algún problema con el parser XML
            e.printStackTrace();
        }catch(TransformerConfigurationException e){ // excepción para cuando hay un error al configurar el Transformer
            e.printStackTrace();
        }catch(TransformerException e){ // excepción por si ocurre un error al escribir el XML o transformar el DOM
            e.printStackTrace();
        }
    }
}