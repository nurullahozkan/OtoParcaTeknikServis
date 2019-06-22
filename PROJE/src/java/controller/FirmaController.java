/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FirmaDao;
import entity.Firma;
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
public class FirmaController implements Serializable{
    private List<Firma> firmalist;
    private FirmaDao firmaDao;
    
    private Firma firma;
    
    public void updateForm(Firma f){
        this.firma = f;
       
    }
    
    public void update(){
        this.getFirmaDao().update(this.firma);
        this.firma = new Firma();
    }
    
    public void clearForm(){
        this.firma = new Firma();
       
    }
    
    public void create(){
        this.getFirmaDao().insert(this.firma);
        this.firma = new Firma();

    }
    
    public void delete(){
        this.getFirmaDao().delete(this.firma);
         this.clearForm();    
    }

    public List<Firma> getFirmalist() {
        this.firmalist = this.getFirmaDao().findAll();
        return firmalist;
    }

    public void setFirmalist(List<Firma> firmalist) {
        this.firmalist = firmalist;
    }

    public FirmaDao getFirmaDao() {
       if(this.firmaDao == null)
            this.firmaDao = new FirmaDao();
        return firmaDao;
    }

    public void setFirmaDao(FirmaDao firmaDao) {
        this.firmaDao = firmaDao;
    }

    public Firma getFirma() {
          if(this.firma == null)
            this.firma = new Firma();
        return firma;    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
    
    
    
    
}
