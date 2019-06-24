/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KargosirketiDao;
import entity.Kargosirketi;
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
public class KargosirketiController implements Serializable{
    List<Kargosirketi> kargosirketilist;
    private KargosirketiDao kargosirketiDao;
    private Kargosirketi kargosirketi;
    
    
    public void clear(){
        this.kargosirketi = new Kargosirketi();
    }
    
    public void create(){
        this.getKargosirketiDao().insert(this.kargosirketi);
        this.clear();
    }
    
    public void updateForm(Kargosirketi k){
        this.kargosirketi = k;
    }
    
    public void update(){
        this.getKargosirketiDao().update(this.kargosirketi);
        this.clear();
        
    }
    
    public void delete(){
        this.getKargosirketiDao().delete(this.kargosirketi);
        this.clear();
    }

    public List<Kargosirketi> getKargosirketilist() {
        this.kargosirketilist = this.getKargosirketiDao().findAll();
        return kargosirketilist;
    }

    public void setKargosirketilist(List<Kargosirketi> kargosirketilist) {
        this.kargosirketilist = kargosirketilist;
    }

    public KargosirketiDao getKargosirketiDao() {
         if(this.kargosirketiDao == null)
            this.kargosirketiDao = new KargosirketiDao();
        return kargosirketiDao;
    }

    public void setKargosirketiDao(KargosirketiDao kargosirketiDao) {
        this.kargosirketiDao = kargosirketiDao;
    }

    public Kargosirketi getKargosirketi() {
        if(this.kargosirketi == null)
            this.kargosirketi = new Kargosirketi();
        return kargosirketi;
    }

    public void setKargosirketi(Kargosirketi kargosirketi) {
        this.kargosirketi = kargosirketi;
    }
    
    
}
