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

public class Backup5ConsultaCorreos {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse("contacto.xml");
            XPath xpath = XPathFactory.newInstance().newXPath();
            String expresion = "//contacto/correo/text()";

            NodeList correos = (NodeList) xpath.evaluate(expresion, d, XPathConstants.NODESET);
            for(int i = 0; i < correos.getLength(); i++){
                System.out.println(correos.item(i).getNodeValue());
            }
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}