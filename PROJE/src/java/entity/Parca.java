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
public class Parca {
    private Long parca_id;
    private String adi;
    private int adet;
    private int alis_fiyati;
    private int satis_fiyati;
    
    private Firma firma;
    private Tur tur;
    private Depo depo;
    private Siparis siparis;
    

    public Long getParca_id() {
        return parca_id;
    }

    public void setParca_id(Long parca_id) {
        this.parca_id = parca_id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getAlis_fiyati() {
        return alis_fiyati;
    }

    public void setAlis_fiyati(int alis_fiyati) {
        this.alis_fiyati = alis_fiyati;
    }

    public int getSatis_fiyati() {
        return satis_fiyati;
    }

    public void setSatis_fiyati(int satis_fiyati) {
        this.satis_fiyati = satis_fiyati;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Tur getTur() {
        return tur;
    }

    public void setTur(Tur tur) {
        this.tur = tur;
    }

    public Depo getDepo() {
        return depo;
    }

    public void setDepo(Depo depo) {
        this.depo = depo;
    }

    public Siparis getSiparis() {
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }

}
