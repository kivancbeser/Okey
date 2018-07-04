/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okey;

import java.util.*;

/**
 *
 * @author Enes
 */
public class Okey {
    
    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        Taslar t = new Taslar();
        Oyuncular o = new Oyuncular();
        Tas okeyTasi=null;
        Oyuncu oyuncu = new Oyuncu();
        List<Tas> taslar = t.taslariYarat();
        Collections.shuffle(taslar);
        okeyTasi = t.okeyBul(taslar);
        List<Oyuncu> oyuncular = t.taslariDagit(taslar);
        oyuncu = o.bitir(oyuncular,okeyTasi);
        
        System.out.println("Belki kazanır : " + oyuncu.getAd());
        System.out.println("Belki kazanır : " + oyuncu.getPuan());
        
        
        
                
    }
    
}
