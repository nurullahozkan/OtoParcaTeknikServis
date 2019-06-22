/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author nurullah
 */
public class Musteri {
    private Long musteri_id;
    private String adi;
    private String soyadi;
    private String telno;
    private String email;

    public Musteri() {
    }

    public Musteri(Long musteri_id, String adi, String soyadi, String telno, String email) {
        this.musteri_id = musteri_id;
        this.adi = adi;
        this.soyadi = soyadi;
        this.telno = telno;
        this.email = email;
    }

    public Long getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(Long musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Musteri{" + "musteri_id=" + musteri_id + ", adi=" + adi + ", soyadi=" + soyadi + ", telno=" + telno + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.musteri_id);
        hash = 53 * hash + Objects.hashCode(this.adi);
        hash = 53 * hash + Objects.hashCode(this.soyadi);
        hash = 53 * hash + Objects.hashCode(this.telno);
        hash = 53 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Musteri other = (Musteri) obj;
        if (!Objects.equals(this.adi, other.adi)) {
            return false;
        }
        if (!Objects.equals(this.soyadi, other.soyadi)) {
            return false;
        }
        if (!Objects.equals(this.telno, other.telno)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.musteri_id, other.musteri_id)) {
            return false;
        }
        return true;
    }
    
}
