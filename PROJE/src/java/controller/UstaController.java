/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FirmaDao;
import dao.UstaDao;
import entity.Firma;
import entity.Usta;
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
public class UstaController implements Serializable{
    private Usta usta;
    private List<Usta> ustalist;
    private UstaDao ustaDao;
    
    private List<Firma> firmaList;

    
    private FirmaDao firmaDao;
    
    private Long selectedFirma;
    
    public void clear(){
        this.usta = new Usta();
    }
    
    public void updateForm(Usta u){
        this.usta = u;
        this.selectedFirma = this.usta.getFirma().getFirma_id();  
        
    }
    
    public void update(){
        this.getUstaDao().update(this.usta, selectedFirma);
        this.clear();
    }
    
    public void create(){
        this.getUstaDao().insert(this.usta, selectedFirma);
        this.clear();
        
    }
    
    public void delete(){
        this.getUstaDao().delete(this.usta);
        this.clear();
    }

    public Usta getUsta() {
        if(this.usta == null)
            this.usta = new Usta();
        return usta;
    }

    public void setUsta(Usta usta) {
        this.usta = usta;
    }

    public List<Usta> getUstalist() {
        this.ustalist = this.getUstaDao().findAll();
        return ustalist;
    }

    public void setUstalist(List<Usta> ustalist) {
        this.ustalist = ustalist;
    }

    public UstaDao getUstaDao() {
        if(this.ustaDao == null)
            this.ustaDao = new UstaDao();
        return ustaDao;
    }

    public void setUstaDao(UstaDao ustaDao) {
        this.ustaDao = ustaDao;
    }

    public Long getSelectedFirma() {
        return selectedFirma;
    }

    public void setSelectedFirma(Long selectedFirma) {
        this.selectedFirma = selectedFirma;
    }

    public FirmaDao getFirmaDao() {
        if(this.firmaDao == null)
            this.firmaDao = new FirmaDao();
        return firmaDao;
    }

    public List<Firma> getFirmaList() {
        this.firmaList = this.getFirmaDao().findall();
        return firmaList;
    }

    public void setFirmaList(List<Firma> firmaList) {
        this.firmaList = firmaList;
    }
    
    
    
    
}
