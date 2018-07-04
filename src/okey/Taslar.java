/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okey;

import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Enes
 */
public class Taslar implements TasInterface {

    private List<Tas> taslar;
    private List<Oyuncular> oyuncuListesi;
    private Random rn = new Random();
    private Integer oky;

    //Taslarin yaratildiği class
    @Override
    public List<Tas> taslariYarat() {
        int tasSayisi = 13;
        List<Tas> taslar = new ArrayList<Tas>();
        List<String> renkler = new ArrayList<String>();
        renkler.add("SARI");
        renkler.add("MAVI");
        renkler.add("SIYAH");
        renkler.add("KIRMIZI");
        int sayac = 0;
        for (int i = 0; i <= 4; i++) {
            for (int k = 1; k <= tasSayisi; k++) {
                if (i < 1) {
                    taslar.add(new Tas(sayac, "SARI", k));
                    taslar.add(new Tas(sayac, "SARI", k));
                    sayac++;
                } else if (i < 2) {
                    taslar.add(new Tas(sayac, "MAVI", k));
                    taslar.add(new Tas(sayac, "MAVI", k));
                    sayac++;
                } else if (i < 3) {
                    taslar.add(new Tas(sayac, "SIYAH", k));
                    taslar.add(new Tas(sayac, "SIYAH", k));
                    sayac++;
                } else if (i < 4) {
                    taslar.add(new Tas(sayac, "KIRMIZI", k));
                    taslar.add(new Tas(sayac, "KIRMIZI", k));
                    sayac++;
                }
            }

        }
        taslar.add(new Tas(0, "SAHTEOKEY", 52));
        taslar.add(new Tas(0, "SAHTEOKEY", 52));
        return taslar;
    }

    //Taslar oyunculara dagitiliyor
    @Override
    public List<Oyuncu> taslariDagit(List<Tas> t) {

        int ilk = rn.nextInt(4);
        List<Tas> ilktaslar = t.subList(0, 15);
        List<Tas> ikincitaslar = t.subList(15, 29);
        List<Tas> ucuncutaslar = t.subList(29, 43);
        List<Tas> dorduncutaslar = t.subList(43, 57);

        Oyuncu oyuncu1 = new Oyuncu("Oyuncu1", ilktaslar, 1);
        Oyuncu oyuncu2 = new Oyuncu("Oyuncu2", ikincitaslar, 2);
        Oyuncu oyuncu3 = new Oyuncu("Oyuncu3", ucuncutaslar, 3);
        Oyuncu oyuncu4 = new Oyuncu("Oyuncu4", dorduncutaslar, 4);
        List<Oyuncu> oyuncuListesi = new ArrayList<Oyuncu>();
        oyuncuListesi.add(oyuncu1);
        oyuncuListesi.add(oyuncu2);
        oyuncuListesi.add(oyuncu3);
        oyuncuListesi.add(oyuncu4);

        return oyuncuListesi;

    }

    @Override
    public Tas okeyBul(List<Tas> t) {
        Tas okeyTasi = new Tas(0, "", 0);
        oky = rn.nextInt(53);
        //Sahte Okey gelirse Sahte okey gelmeyene kadar random sayi üretiyorum.
        while (oky == 52) {
            oky = rn.nextInt(53);
        }
        for (Tas tas : t) {
            if (Objects.equals(tas.gercekDeger, oky)) {
                if (tas.deger == 13) {
                    okeyTasi.setDeger(1);
                    okeyTasi.setGercekDeger(tas.gercekDeger - 12);
                    okeyTasi.setRenk(tas.getRenk());
                    System.out.println(okeyTasi.getRenk() + " 13 Geldi OKEY TAŞI: " + okeyTasi.getRenk() + " " + okeyTasi.getDeger().toString());
                } else{
                    okeyTasi.setDeger(tas.getDeger() + 1);
                    okeyTasi.setGercekDeger(tas.getGercekDeger() + 1);
                    okeyTasi.setRenk(tas.getRenk());
                }
            }

        }
        System.out.println("OKEY TAŞI: " + okeyTasi.getRenk() + " " + okeyTasi.getDeger().toString());

        return okeyTasi;
    }
}
