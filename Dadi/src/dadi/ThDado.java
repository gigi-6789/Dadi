/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadi;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ingarozza_luigi
 */
public class ThDado extends Thread {

    Random rand = new Random();
    boolean faiSleep;
    boolean faiYield;
    datiCondivisi dati;
    String nomeDado;
    Semaforo s;

    /**
     * @author ingarozza_luigi
     * @brief costruttore che assegna i valori
     * @param s viene utilizzata per attivare o disattivare lo Sleep
     * @param y viene utilizzata per attivare o disattivare lo Yield
     */
    public ThDado(boolean s, boolean y, String nomeDado, datiCondivisi ptrDati,Semaforo sem) {
        faiSleep = s;
        faiYield = y;
        this.nomeDado = nomeDado;
        this.dati = ptrDati;
        this.s=sem;
    }

    /**
     * @author ingarozza_luigi
     * @brief classe che lancia il dado
     */
    public void lanciaDado() {

        try {
            while (true) {

                if (Thread.currentThread().isInterrupted()) {
                    return;
                }

                int numero = rand.nextInt(6) + 1;

                if (nomeDado.equals("d1")) {
                    s.Wait();
                    dati.setnRuota1(numero);
                    s.Signal();                    
                }
                
                if (nomeDado.equals("d2")) {
                    s.Wait();
                    dati.setnRuota2(numero);
                    s.Signal();             
                }
                if (nomeDado.equals("d3")) {
                    s.Wait();
                    dati.setnRuota3(numero);
                    s.Signal();             
                }
                System.out.println(nomeDado + " " + numero);
                if (faiSleep) {
                    sleep(1000);
                }
                if (faiYield) {
                    Thread.yield();
                }

            }
        } catch (InterruptedException ex) {
        }

    }
    /**
     * @author ingarozza_luigi
     * @brief metodo che richiama lanciaDado()
     */
    public void run() {
        lanciaDado();
    }
    
}
