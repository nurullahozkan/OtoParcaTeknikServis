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
public class Arac {
    private Long sasino;
    private String plaka;
    private String renk;
    private int motorno;
    
    private Musteri musteri;

    public Long getSasino() {
        return sasino;
    }

    public void setSasino(Long sasino) {
        this.sasino = sasino;
    }


    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getMotorno() {
        return motorno;
    }

    public void setMotorno(int motorno) {
        this.motorno = motorno;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }
    
    
    
}
