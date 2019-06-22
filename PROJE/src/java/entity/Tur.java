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
public class Tur {
    private Long tur_id;
    private String adi;

    public Tur() {
    }

    public Tur(Long tur_id, String adi) {
        this.tur_id = tur_id;
        this.adi = adi;
    }

    public Long getTur_id() {
        return tur_id;
    }

    public void setTur_id(Long tur_id) {
        this.tur_id = tur_id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Override
    public String toString() {
        return "Tur{" + "tur_id=" + tur_id + ", adi=" + adi + '}';
    }    
}
