/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TurDao;
import entity.Tur;
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
public class TurController implements Serializable{
    private List<Tur> turlist;
    private TurDao turDao;
    
    private Tur tur;
    
    public void updateForm(Tur t){
        this.tur = t;
       
    }
    
    public void update(){
        this.getTurDao().update(this.tur);
        this.tur = new Tur();
    }
    
    public void clearForm(){
        this.tur = new Tur();
       
    }
    
    public void create(){
        this.getTurDao().insert(this.tur);
        this.tur = new Tur();

    }
    
    public void delete(){
        this.getTurDao().delete(this.tur);
         this.clearForm();    
    }
    
    public List<Tur> getTurlist() {
         this.turlist = this.getTurDao().findAll();
        return turlist;
    }

    public void setTurlist(List<Tur> turlist) {
        this.turlist = turlist;
    }

    public TurDao getTurDao() {
        if(this.turDao == null)
            this.turDao = new TurDao();
        return turDao;
    }

    public void setTurDao(TurDao turDao) {
        this.turDao = turDao;
    }

    public Tur getTur() {
        if(this.tur == null)
            this.tur = new Tur();
        return tur;
    }

    public void setTur(Tur tur) {
        this.tur = tur;
    }


    
    
    
}
