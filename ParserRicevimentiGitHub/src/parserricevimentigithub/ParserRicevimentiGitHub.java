/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserricevimentigithub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author LENOVO
 */
public class ParserRicevimentiGitHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BufferedReader inFromUser = null;
        try {
            List<Ricevimento> Ricevimenti = null;
            Parser dom = new Parser();
            String percorso="Ricevimenti.xml";
            Ricevimenti = dom.parseDocument(percorso);
            inFromUser = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            System.out.println("Inserire giorno");
            String risposta=inFromUser.readLine();
            for (Ricevimento ric:Ricevimenti) {
                if(ric.getGiorno().equals(risposta)){
                    System.out.println(ric.toString());
                }
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ParserRicevimentiGitHub.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ParserRicevimentiGitHub.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ParserRicevimentiGitHub.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParserRicevimentiGitHub.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inFromUser.close();
            } catch (IOException ex) {
                Logger.getLogger(ParserRicevimentiGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
