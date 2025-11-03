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
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.newDocument();

            Element contactos = d.createElement("contactos");
            d.appendChild(contactos);

            Element contacto1 = d.createElement("contacto");
            contactos.appendChild(contacto1);

            Element nombre1 = d.createElement("nombre");
            nombre1.setAttribute("id","1");
            nombre1.setTextContent("Miguel Gomez");
            contacto1.appendChild(nombre1);

            Element correo1 = d.createElement("correo");
            correo1.setTextContent("Miguel.Gomez@TechSolutions.com");
            contacto1.appendChild(correo1);

            Element telefono1 = d.createElement("telefono");
            telefono1.setTextContent("678 901 234");
            contacto1.appendChild(telefono1);

            Element contacto2 = d.createElement("contacto");
            contactos.appendChild(contacto2);

            Element nombre2 = d.createElement("nombre");
            nombre2.setAttribute("id","2");
            nombre2.setTextContent("Ana Rodríguez");
            contacto2.appendChild(nombre2);

            Element correo2 = d.createElement("correo");
            correo2.setTextContent("ana.rodriguez@TechSolutions.com");
            contacto2.appendChild(correo2);

            Element telefono2 = d.createElement("telefono");
            telefono2.setTextContent("911 223 344");
            contacto2.appendChild(telefono2);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            DOMSource source = new DOMSource(d);
            File fichero = new File("contacto.xml");
            StreamResult result = new StreamResult(fichero);
            t.transform(source, result);

        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }catch(TransformerConfigurationException e){
            e.printStackTrace();
        }catch(TransformerException e){
            e.printStackTrace();
        }
    }
}