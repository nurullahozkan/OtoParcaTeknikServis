/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AracDao;
import dao.MusteriDao;
import entity.Arac;
import entity.Musteri;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author nurullah
 */
@Named
@SessionScoped
public class AracController implements Serializable{
    private Arac arac;
    private List<Arac> araclist;
    private AracDao aracDao;
    
    private Long selectedMusteri;
    
    private MusteriDao musteriDao;
    
    private List<Musteri> musteriList;
    
    public void clear(){
        this.arac = new Arac();
    }
    
    public void create(){
        this.getAracDao().insert(this.arac, selectedMusteri);
        this.clear();
    }
    
    public void delete(){
        this.getAracDao().delete(this.arac);
    }

    public void updateForm(Arac a){
        this.arac = a; 
        this.selectedMusteri = this.arac.getMusteri().getMusteri_id();
    }
    
    public Arac getArac() {
        if(this.arac == null)
            this.arac = new Arac();
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public List<Arac> getAraclist() {
        this.araclist = this.getAracDao().findAll();
        return araclist;
    }

    public void setAraclist(List<Arac> araclist) {
        this.araclist = araclist;
    }

    public AracDao getAracDao() {
        if(this.aracDao == null)
            this.aracDao = new AracDao();
        return aracDao;
    }

    public void setAracDao(AracDao aracDao) {
        this.aracDao = aracDao;
    }

    public Long getSelectedMusteri() {
        return selectedMusteri;
    }

    public void setSelectedMusteri(Long selectedMusteri) {
        this.selectedMusteri = selectedMusteri;
    }

    public MusteriDao getMusteriDao() {
        if(this.musteriDao == null)
            this.musteriDao = new MusteriDao();
        return musteriDao;
    }

    public List<Musteri> getMusteriList() {
        this.musteriList = this.getMusteriDao().findall();
        return musteriList;
    }

    public void setMusteriList(List<Musteri> musteriList) {
        this.musteriList = musteriList;
    }

}
