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

public class Backup5ConsultaTelefonoAna {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // creamos una instancia del DocumentBuilderFactory
            DocumentBuilder db = dbf.newDocumentBuilder(); // y la enlazamos con el DocumentBuilder
            Document d = db.parse("contacto.xml"); // parseamos el fichero xml en el documento
            XPath xpath = XPathFactory.newInstance().newXPath(); // creamos la instancia de XPath
            String expresion = "//contacto[nombre='Ana Rodríguez']/telefono/text()"; // expresion para coger el telefono del contacto Ana
            // ejecutamos la consulta
            NodeList telefono = (NodeList) xpath.evaluate(expresion, d, XPathConstants.NODESET);
            // recorremos el NodeList del telefono
            for (int i = 0; i < telefono.getLength(); i++) {
                System.out.println(telefono.item(i).getNodeValue()); // cogemos el valor deseado
            }
        // excepciones para los diferentes errores que nos pueden salir
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}