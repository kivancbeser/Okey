/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okey;

/**
 *
 * @author Enes
 */
public class Tas{

    Integer deger;//Tasin 1-13(13 Dahil) Arasi Degeri
    String renk;//Tasin Rengi
    Integer gercekDeger;//Tasin 0-52(52 Dahil) Arasi Bize Göre Gerçek Değeri

    public Integer getDeger() {
        return deger;
    }

    public void setDeger(Integer deger) {
        this.deger = deger;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public Integer getGercekDeger() {
        return gercekDeger;
    }

    public void setGercekDeger(Integer gercekDeger) {
        this.gercekDeger = gercekDeger;
    }

    public Tas(Integer gercekDeger, String renk, Integer deger) {
        this.deger = deger;
        this.renk = renk;
        this.gercekDeger = gercekDeger;
    }
    
}
