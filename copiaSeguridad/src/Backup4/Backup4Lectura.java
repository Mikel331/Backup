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
            File fichero = new File("contacto.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(fichero);

            System.out.println(d.getDocumentElement().getNodeName());

            NodeList nl = d.getElementsByTagName("contacto");

            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                System.out.println(n.getNodeName());

                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;

                    NodeList nombreLista = e.getElementsByTagName("nombre");
                    if (nombreLista.getLength() > 0) {
                        Element nombre = (Element) nombreLista.item(0);
                        System.out.println("Nombre: " + nombre.getTextContent());
                        System.out.println("ID: " + nombre.getAttribute("id"));
                    }

                    NodeList correoLista = e.getElementsByTagName("correo");
                    if (correoLista.getLength() > 0) {
                        Element correo = (Element) correoLista.item(0);
                        System.out.println("Correo: " + correo.getTextContent());
                    }

                    NodeList telefonoLista = e.getElementsByTagName("telefono");
                    if (telefonoLista.getLength() > 0) {
                        Element telefono = (Element) telefonoLista.item(0);
                        System.out.println("Teléfono: " + telefono.getTextContent());
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
