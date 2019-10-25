/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AracDao;
import dao.TamirDao;
import dao.UstaAracDao;
import dao.UstaDao;
import entity.Arac;
import entity.Tamir;
import entity.Usta;
import entity.UstaArac;
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
public class UstaAracController implements  Serializable{
    private UstaArac ustaarac;
    private List<UstaArac> ustaaraclist;
    private UstaAracDao ustaaracDao;
    
    private UstaDao ustaDao;
    private List<Usta> ustaList;
    
    private AracDao aracDao;
    private List<Arac> aracList;
    
    private TamirDao tamirDAo;
    private List<Tamir> tamirList;
    
    private Long selectedUsta;
    private Long selectedArac;
    private Long selectedTamir;
    
    public void clear(){
        this.ustaarac = new UstaArac();
    }
    
    public void create(){
        this.getUstaaracDao().insert(this.ustaarac, selectedUsta, selectedArac, selectedTamir);
        this.clear();
    }

    public void updateForm(UstaArac ua){
        this.ustaarac = ua; 
        this.selectedUsta = this.ustaarac.getUsta().getTcno();
        this.selectedArac = this.ustaarac.getArac().getSasino();
        this.selectedTamir = this.ustaarac.getTamir().getTamir_id();
    }

    public void update(){
        this.getUstaaracDao().update(this.ustaarac, selectedArac, selectedUsta, selectedTamir);
        this.clear();
    }
    
        public void delete(){
            this.getUstaaracDao().delete(this.ustaarac);
            this.clear();
        }
    
    public UstaArac getUstaarac() {
        if(this.ustaarac == null)
            this.ustaarac = new UstaArac();
        return ustaarac;
    }

    public void setUstaarac(UstaArac ustaarac) {
        this.ustaarac = ustaarac;
    }

    public List<UstaArac> getUstaaraclist() {
        this.ustaaraclist = this.getUstaaracDao().findAll();
        return ustaaraclist;
    }

    public void setUstaaraclist(List<UstaArac> ustaaraclist) {
        this.ustaaraclist = ustaaraclist;
    }

    public UstaAracDao getUstaaracDao() {
        if(this.ustaaracDao == null)
            this.ustaaracDao = new UstaAracDao();
        return ustaaracDao;
    }

    public void setUstaaracDao(UstaAracDao ustaaracDao) {
        this.ustaaracDao = ustaaracDao;
    }

    public Long getSelectedUsta() {
        return selectedUsta;
    }

    public void setSelectedUsta(Long selectedUsta) {
        this.selectedUsta = selectedUsta;
    }

    public Long getSelectedArac() {
        return selectedArac;
    }

    public void setSelectedArac(Long selectedArac) {
        this.selectedArac = selectedArac;
    }

    public Long getSelectedTamir() {
        return selectedTamir;
    }

    public void setSelectedTamir(Long selectedTamir) {
        this.selectedTamir = selectedTamir;
    }

    public UstaDao getUstaDao() {
        if(this.ustaDao == null)
            this.ustaDao = new UstaDao();
        return ustaDao;
    }

    public List<Usta> getUstaList() {
        this.ustaList = this.getUstaDao().findall();
        return ustaList;
    }

    public void setUstaList(List<Usta> ustaList) {
        this.ustaList = ustaList;
    }

    public AracDao getAracDao() {
        if(this.aracDao == null)
            this.aracDao = new AracDao();
        return aracDao;
    }
    
    public List<Arac> getAracList() {
        this.aracList = this.getAracDao().findall();
        return aracList;
    }

    public void setAracList(List<Arac> aracList) {
        this.aracList = aracList;
    }

    public TamirDao getTamirDAo() {
        if(this.tamirDAo == null)
            this.tamirDAo = new TamirDao();
        return tamirDAo;
    }

    public List<Tamir> getTamirList() {
        this.tamirList = this.getTamirDAo().findall();
        return tamirList;
    }

    public void setTamirList(List<Tamir> tamirList) {
        this.tamirList = tamirList;
    }
    
    
    
    
}
