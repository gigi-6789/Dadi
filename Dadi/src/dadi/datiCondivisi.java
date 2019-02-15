/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadi;

/**
 *
 * @author ingarozza_luigi
 */
public class datiCondivisi {

    int nRuota1;
    int nRuota2;
    int nRuota3;
    String[] schermo;
    int posizione;

    public datiCondivisi(int nRuota1, int nRuota2, int nRuota3) {
        this.nRuota1 = nRuota1;
        this.nRuota2 = nRuota2;
        this.nRuota3 = nRuota3;
        schermo = new String[20000];
        posizione = 0;
    }

    public datiCondivisi() {
        schermo = new String[20000];
    }

    public void aggiungiRiga(String txt) {
        schermo[posizione] = txt;
        posizione++;
    }

    public int getPosizione() {
        return posizione;
    }

    public String getRiga(int posizione) {
        return schermo[posizione];
    }

    public int getnRuota1() {
        return nRuota1;
    }

    public int getnRuota2() {
        return nRuota2;
    }

    public int getnRuota3() {
        return nRuota3;
    }

    public void setnRuota1(int nRuota1) {
        this.nRuota1 = nRuota1;
    }

    public void setnRuota2(int nRuota2) {
        this.nRuota2 = nRuota2;
    }

    public void setnRuota3(int nRuota3) {
        this.nRuota3 = nRuota3;
    }

}
