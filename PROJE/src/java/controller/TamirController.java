/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ParcaDao;
import dao.TamirDao;
import entity.Parca;
import entity.Tamir;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author nurullah
 */
@Named
@SessionScoped
public class TamirController implements Serializable{
    private Tamir tamir;
    private List<Tamir> tamirlist;
    private TamirDao tamirDao;
    
    private List<Parca> parcaList;
    
    private ParcaDao parcaDao;
    
    private Long selectedParca;
    
    public void clear(){
        this.tamir = new Tamir();
    }
    
    public void create(){
        this.getTamirDao().insert(this.tamir, selectedParca);
        this.clear();
    }
    
    public void updateForm(Tamir t){
        this.tamir = t;
        this.selectedParca = this.tamir.getParca().getParca_id();        
    }
    
    public void update(){
        this.getTamirDao().update(this.tamir, selectedParca);
        this.clear();
    }
    
    public void delete(){
        this.getTamirDao().delete(this.tamir);
        this.clear();
    }

    public Tamir getTamir() {
        if(this.tamir == null)
            this.tamir = new Tamir();
        return tamir;
    }

    public void setTamir(Tamir tamir) {
        this.tamir = tamir;
    }

    public List<Tamir> getTamirlist() {
        this.tamirlist = this.getTamirDao().findAll();
        return tamirlist;
    }

    public void setTamirlist(List<Tamir> tamirlist) {
        this.tamirlist = tamirlist;
    }

    public TamirDao getTamirDao() {
        if(this.tamirDao == null);
        this.tamirDao = new TamirDao();
        return tamirDao;
    }

    public void setTamirDao(TamirDao tamirDao) {
        this.tamirDao = tamirDao;
    }

    public Long getSelectedParca() {
        return selectedParca;
    }

    public void setSelectedParca(Long selectedParca) {
        this.selectedParca = selectedParca;
    }

    public ParcaDao getParcaDao() {
        if(this.parcaDao == null)
            this.parcaDao = new ParcaDao();
        return parcaDao;
    }

    public List<Parca> getParcaList() {
        this.parcaList = this.getParcaDao().findall();
        return parcaList;
    }

    public void setParcaList(List<Parca> parcaList) {
        this.parcaList = parcaList;
    }
    
    
    
}
