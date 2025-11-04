package Backup5;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Backup5ConsultaNombres {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // creamos una instancia del DocumentBuilderFactory
            DocumentBuilder db = dbf.newDocumentBuilder(); // y la enlazamos con el DocumentBuilder
            Document d = db.parse("contacto.xml"); // parseamos el fichero xml en el documento
            XPath xpath = XPathFactory.newInstance().newXPath(); // creamos la instancia de XPath
            String expresion = "/contactos/contacto/nombre/text()"; // expresión para coger el nombre de los contactos
            // ejecutamos la consulta
            NodeList nombres = (NodeList) xpath.evaluate(expresion, d, XPathConstants.NODESET);
            // recorremos el NodeList de nombres
            for (int i = 0; i < nombres.getLength(); i++) {
                System.out.println(nombres.item(i).getNodeValue()); // y conseguimos el valor deseado
            }
        // excepciones para los diferentes errores que nos pueden salir
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}