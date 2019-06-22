/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author nurullah
 */
public class Depo {
    private Long depo_id;
    private String adres;

    public Depo() {
    }

    public Depo(Long depo_id, String adres) {
        this.depo_id = depo_id;
        this.adres = adres;
    }

    public Long getDepo_id() {
        return depo_id;
    }

    public void setDepo_id(Long depo_id) {
        this.depo_id = depo_id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Depo{" + "depo_id=" + depo_id + ", adres=" + adres + '}';
    }
    
    
    
    
}
