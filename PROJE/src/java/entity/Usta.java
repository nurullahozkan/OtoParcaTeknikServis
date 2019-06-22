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
public class Usta {
    private Long tcno;
    private String adi;
    private String soyadi;
    private String adres;
    private int tecrube;
    private int usta_maas;
    
    private Firma firma;

    public Long getTcno() {
        return tcno;
    }

    public void setTcno(Long tcno) {
        this.tcno = tcno;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getTecrube() {
        return tecrube;
    }

    public void setTecrube(int tecrube) {
        this.tecrube = tecrube;
    }

    public int getUsta_maas() {
        return usta_maas;
    }

    public void setUsta_maas(int usta_maas) {
        this.usta_maas = usta_maas;
    }

    
    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
    
    
     
    
}
