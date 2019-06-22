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
public class Siparis {
    private Long siparis_id;
    private int adet;
    private String sipari_tarihi;
    
    private Kargosirketi kargosirketi;

    public Long getSiparis_id() {
        return siparis_id;
    }

    public void setSiparis_id(Long siparis_id) {
        this.siparis_id = siparis_id;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public String getSipari_tarihi() {
        return sipari_tarihi;
    }

    public void setSipari_tarihi(String sipari_tarihi) {
        this.sipari_tarihi = sipari_tarihi;
    }

    public Kargosirketi getKargosirketi() {
        return kargosirketi;
    }

    public void setKargosirketi(Kargosirketi kargosirketi) {
        this.kargosirketi = kargosirketi;
    }
    
    
    
}
