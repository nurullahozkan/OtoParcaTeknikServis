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
public class UstaArac {
    private Long usta_arac_id;
    private String tarih;
    
    private Arac arac;
    private Tamir tamir;
    private Usta usta;

    public Long getUsta_arac_id() {
        return usta_arac_id;
    }

    public void setUsta_arac_id(Long usta_arac_id) {
        this.usta_arac_id = usta_arac_id;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public Tamir getTamir() {
        return tamir;
    }

    public void setTamir(Tamir tamir) {
        this.tamir = tamir;
    }

    public Usta getUsta() {
        return usta;
    }

    public void setUsta(Usta usta) {
        this.usta = usta;
    }
    
    
}
