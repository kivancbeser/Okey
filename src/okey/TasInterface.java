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
public interface TasInterface {
    public List<Oyuncu> taslariDagit(List<Tas> t);
    public List<Tas> taslariYarat();
    public Tas okeyBul(List<Tas> t);
}


