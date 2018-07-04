/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okey;

import java.util.List;

/**
 *
 * @author Enes
 */
public class Oyuncu {
     private String ad;
   private List<Tas> oyuncununTaslari;
   private Integer oturmaSirasi;
   private Integer puan;
   
    public Integer getOturmaSirasi() {
        return oturmaSirasi;
    }

    public void setOturmaSirasi(Integer oturmaSirasi) {
        this.oturmaSirasi = oturmaSirasi;
    }

    public Oyuncu(String ad, List<Tas> oyuncununTaslari, Integer oturmaSirasi) {
        this.ad = ad;
        this.oyuncununTaslari = oyuncununTaslari;
        this.oturmaSirasi = oturmaSirasi;
    }

    public Oyuncu() {
    }
    

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Integer getPuan() {
        return puan;
    }

    public void setPuan(Integer puan) {
        this.puan = puan;
    }

    public List<Tas> getOyuncununTaslari() {
        return oyuncununTaslari;
    }

    public void setOyuncununTaslari(List<Tas> oyuncununTaslari) {
        this.oyuncununTaslari = oyuncununTaslari;
    }
}
