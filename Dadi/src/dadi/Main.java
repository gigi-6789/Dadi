/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadi;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ingarozza_luigi
 * @version 2.0
 */
public class Main {

    /**
     * @author ingarozza_luigi
     * @brief main per la gestione dadi
     * se i numeri dei tre dadi sarà uguale si vincerà altimenti si perderà
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            java.io.BufferedReader console = new BufferedReader (new java.io.InputStreamReader(System.in));
            datiCondivisi dati = new datiCondivisi();
            boolean Sleep = false;
            boolean Yield = true;
            
            Semaforo s=new Semaforo(1);
            
            ThDado ruota1 = new ThDado(Sleep,Yield, "d1", dati,s);
            ThDado ruota2 = new ThDado(Sleep,Yield, "d2", dati,s);
            ThDado ruota3 = new ThDado(Sleep,Yield, "d3", dati,s);
            
            
            ruota1.start();
            ruota2.start();
            ruota3.start();
            
            console.readLine();
            ruota1.interrupt();
            ruota2.interrupt();
            ruota3.interrupt();
            System.out.println("ciao alla prossima");
            
            int nRuota1 = dati.getnRuota1();
            int nRuota2 = dati.getnRuota2();
            int nRuota3 = dati.getnRuota3();
            System.out.println("|" + nRuota1 + "|" + nRuota2 + "|" + nRuota3 + "|");
            if(nRuota1 == nRuota2 && nRuota2 == nRuota3 && nRuota3 == nRuota1){
                System.out.println("hai vinto");
            }
            else{
                System.out.println("hai perso");
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
