/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FirmaDao;
import dao.PersonelDao;
import entity.Firma;
import entity.Personel;
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
public class PersonelController implements Serializable{
    private Personel personel;
    private List<Personel> personellist;
    private PersonelDao personelDao;
    
    private List<Firma> firmaList;
    
    private FirmaDao firmaDao;
    
    private Long selectedFirma;
    
    public void clear(){
        this.personel = new Personel();
    }
    
    public void updateForm(Personel p){
        this.personel = p;
    }
    
    public void update(){
        this.getPersonelDao().update(this.personel);
        this.clear();
    }
    
    public void delete(){
        this.getPersonelDao().delete(this.personel);
        this.clear();
    }
    
    public void create(){
        this.getPersonelDao().create(this.personel, selectedFirma);
        this.clear();
        
    }

    public Personel getPersonel() {
        if(this.personel == null)
            this.personel = new Personel();
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public List<Personel> getPersonellist() {
        this.personellist = this.getPersonelDao().findAll();
        return personellist;
    }

    public void setPersonellist(List<Personel> personellist) {
        this.personellist = personellist;
    }


    public PersonelDao getPersonelDao() {
        if(this.personelDao == null)
            this.personelDao = new PersonelDao();
        return personelDao;
    }

    public void setPersonelDao(PersonelDao personelDao) {
        this.personelDao = personelDao;
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
