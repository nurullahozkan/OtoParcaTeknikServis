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
public class Firma {
    private Long firma_id;
    private String adi;

    public Firma() {
    }

    public Firma(Long firma_id, String adi) {
        this.firma_id = firma_id;
        this.adi = adi;
    }

    public Long getFirma_id() {
        return firma_id;
    }

    public void setFirma_id(Long firma_id) {
        this.firma_id = firma_id;
    }

  
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }



 
}
