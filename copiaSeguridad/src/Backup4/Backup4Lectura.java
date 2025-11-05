package Backup4;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Backup4Lectura {
    public static void main(String[] args) {
        try {
            File fichero = new File("C:\\Users\\ikamindeguia24\\Desktop\\backup-reto\\Backup\\Backup\\copiaSeguridad\\src\\Backup4\\contacto.xml"); // fichero que se va a leer
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // creamos una instancia en el DocumentBuilderFactory
            DocumentBuilder db = dbf.newDocumentBuilder(); // y la enlazamos con el DocumentBuilder
            Document d = db.parse(fichero); // creamos el documento

            // muestra el nombre del elemento raíz del xml
            System.out.println(d.getDocumentElement().getNodeName());

            // obtenemos una lista de todos los nodos del contacto
            NodeList nl = d.getElementsByTagName("contacto");

            // recorremos los elementos contacto con un bucle for
            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i); // obtenemos el nodo actual
                System.out.println(n.getNodeName()); // se imprime el nombre

                // si el nodo es un elemento creamos un elemento
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;

                    // lectura del nombre
                    NodeList nombreLista = e.getElementsByTagName("nombre"); 
                    if (nombreLista.getLength() > 0) { // si el nombre existe:
                        Element nombre = (Element) nombreLista.item(0); // enlazamos el elemento nombre con el NodeList
                        System.out.println("Nombre: " + nombre.getTextContent()); // mostramos el texto del nombre
                        System.out.println("ID: " + nombre.getAttribute("id"));   // y el atributo ID 
                    }

                    // lectura del correo
                    NodeList correoLista = e.getElementsByTagName("correo");
                    if (correoLista.getLength() > 0) { // si el correo existe:
                        Element correo = (Element) correoLista.item(0); // enlazamos el elemento correo con el NodeList
                        System.out.println("Correo: " + correo.getTextContent()); // mostramos el texto del correo
                    }

                    // lectura del telefono
                    NodeList telefonoLista = e.getElementsByTagName("telefono"); 
                    if (telefonoLista.getLength() > 0) { // si el telefono existe: 
                        Element telefono = (Element) telefonoLista.item(0); // enlazamos el elemento telefono con el NodeList
                        System.out.println("Teléfono: " + telefono.getTextContent()); // mostramos el texto del telefono
                    }
                }
            }
        } catch (ParserConfigurationException e) { // excepción para el parseo
            e.printStackTrace();
        } catch (SAXException e) { // excepción para errores SAX
            e.printStackTrace();
        } catch (IOException e) { // excepción de lectura y escritura
            e.printStackTrace();
        }
    }
}
