package parserricevimentigithub;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Parser {
     private List ricevimenti;

    public Parser() {
        ricevimenti = new ArrayList();
    }

    public List parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Ricevimento ricevimento;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                if(i!=0&&i!=1){
                    element = (Element) nodelist.item(i);
                    ricevimento = getRicevimento(element);
                    ricevimenti.add(ricevimento);
                }
            }
        }
        return ricevimenti;
    }

    private Ricevimento getRicevimento(Element element) {
        Ricevimento ricevimento;
        NodeList nodelist;
        int codice=0;
        String nome="", giorno="", ora="";
        Element td;
        
        nodelist = element.getElementsByTagName("td");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                td = (Element) nodelist.item(i);
                if(td!=null){
                    if(codice!=157){
                        if(codice==0){
                            codice=Integer.parseInt(getTextValue(td));
                        }else if(nome==""||nome==null){
                            nome=getTextValue(td);
                        }else if(giorno==""||giorno==null){
                            giorno=getTextValue(td);
                        }else if(ora==""||ora==null){
                            ora=getTextValue(td);
                        }
                    }
                }
            }
        }
        ricevimento = new Ricevimento(codice, ora, nome, giorno);
        return ricevimento;
    }
    
    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element) {
        String value = null;
        if (element != null ) {
            Node el = element.getFirstChild();
            if(el!=null){
                value = el.getNodeValue();
            }
        }
        return value;
    }
}
