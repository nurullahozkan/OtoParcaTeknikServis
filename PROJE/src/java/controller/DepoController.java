/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepoDao;
import entity.Depo;
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
public class DepoController implements Serializable{
    private List<Depo> depolist;
    private DepoDao depoDao;
    private Depo depo;

    public void create(){
        this.getDepoDao().insert(this.depo);
    }
    
    public List<Depo> getDepolist() {
        this.depolist = this.getDepoDao().findAll();
        return depolist;
    }

    public void setDepolist(List<Depo> depolist) {
        this.depolist = depolist;
    }

    public DepoDao getDepoDao() {
        if(this.depoDao == null)
            this.depoDao = new DepoDao();
        return depoDao;
    }

    public void setDepoDao(DepoDao depoDao) {
        this.depoDao = depoDao;
    }

    public Depo getDepo() {
        if(this.depo == null)
            this.depo = new Depo();
        return depo;
    }

    public void setDepo(Depo depo) {
        this.depo = depo;
    }
    
    
    
}
