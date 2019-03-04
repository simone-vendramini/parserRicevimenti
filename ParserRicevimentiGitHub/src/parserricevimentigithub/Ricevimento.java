/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserricevimentigithub;

/**
 *
 * @author LENOVO
 */
public class Ricevimento {
    int codice;
    String nome, giorno, ora;
    
    public Ricevimento() {
        codice = 0;
        ora = "";
        nome = "";
        giorno = "";
    }

    public Ricevimento(int codice, String ora, String nome, String giorno) {
        this.codice = codice;
        this.ora = ora;
        this.nome = nome;
        this.giorno = giorno;
    }

    public int getCodice() {
        return codice;
    }

    public String getOra() {
        return ora;
    }

    public String getNome() {
        return nome;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }
    
    public String toString(){
        return codice+" - "+nome+" - "+giorno+" - "+ora;
    }
    
    public String toCsv(){
        return codice+";"+nome+";"+giorno+";"+ora;
    }
}
