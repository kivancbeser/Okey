/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okey;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Enes
 */
public class Oyuncular implements OyuncuInterface {

    @Override
    public Oyuncu bitir(List<Oyuncu> oyuncular, Tas okeyTasi) {
        //Oyuncuda okey var mı diye bakmak lazım
        //Elindeki listeyi sort et
        List<Oyuncu> list = oyuncular;
        for (int i = 0; i < oyuncular.size(); i++) {
            List<Tas> taslar = oyuncular.get(i).getOyuncununTaslari();

            //Sahte Okey Okeye döndürüldü.
            for (Tas tas : taslar) {
                if (tas.renk == "SAHTEOKEY") {
                    tas.setGercekDeger(okeyTasi.getGercekDeger());
                }
            }

            //Taşlar gerçek degerine göre ardışık olarak sıralandı.
            Collections.sort(taslar, new Comparator<Tas>() {
                @Override
                public int compare(final Tas object1, final Tas object2) {
                    return object1.gercekDeger.compareTo(object2.gercekDeger);
                }
            });

            System.out.println(oyuncular.get(i).getAd() + " Taslari" + "\n");

            oyuncular.get(i).setPuan(puanHesapla(taslar, okeyTasi));

        }
       
        Collections.sort(oyuncular, new Comparator<Oyuncu>() {
                @Override
                public int compare(final Oyuncu oyuncu1, final Oyuncu oyuncu2) {
                    return oyuncu1.getPuan().compareTo(oyuncu2.getPuan());
                }
        });
        
        return oyuncular.get(0);
    }
    
    public Integer puanHesapla(List<Tas> oyuncununTaslari, Tas okeyTasi){
        Integer puan = 0;
        for (int i = 1; i < oyuncununTaslari.size(); i++) {
            Integer tmpArdisik = 0;
            //Hem rengi aynı hemde 1 Fazlası ise
            //ardışık 2 lisi varsa
            if(oyuncununTaslari.get(i-1).deger.equals(oyuncununTaslari.get(i).deger - 1) && oyuncununTaslari.get(i-1).renk.equals(oyuncununTaslari.get(i).renk) && !oyuncununTaslari.get(i-1).deger.equals(okeyTasi.deger)){
                tmpArdisik++;
            }
            else{
                tmpArdisik = 0;
            }
            if(tmpArdisik.equals(1)){
                puan++;
                tmpArdisik = 0;
            }
            //okeyi varsa
            if (oyuncununTaslari.get(i-1).deger.equals(okeyTasi.deger)) {
                puan = puan + 2;
            }
            System.out.println(oyuncununTaslari.get(i).deger);
            System.out.println(oyuncununTaslari.get(i).renk);
            
        }
        System.out.println("Puanı:" + puan + "n");
        return puan;
    }

}
