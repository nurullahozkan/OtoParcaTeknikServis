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
public class Tamir {
    private Long tamir_id;
    private int tbi_ucret;
    
    private Parca parca;

    public Long getTamir_id() {
        return tamir_id;
    }

    public void setTamir_id(Long tamir_id) {
        this.tamir_id = tamir_id;
    }

    public int getTbi_ucret() {
        return tbi_ucret;
    }

    public void setTbi_ucret(int tbi_ucret) {
        this.tbi_ucret = tbi_ucret;
    }

    public Parca getParca() {
        return parca;
    }

    public void setParca(Parca parca) {
        this.parca = parca;
    }
    
    
}
