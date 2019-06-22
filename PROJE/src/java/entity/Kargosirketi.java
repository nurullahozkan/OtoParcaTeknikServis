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
public class Kargosirketi {
    private Long sirket_id;
    private String adi;
    private String telno;

    public Kargosirketi() {
    }

    public Kargosirketi(Long sirket_id, String adi, String telno) {
        this.sirket_id = sirket_id;
        this.adi = adi;
        this.telno = telno;
    }

    public Long getSirket_id() {
        return sirket_id;
    }

    public void setSirket_id(Long sirket_id) {
        this.sirket_id = sirket_id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    @Override
    public String toString() {
        return "Kargosirketi{" + "sirket_id=" + sirket_id + ", adi=" + adi + ", telno=" + telno + '}';
    }
    
    
}
