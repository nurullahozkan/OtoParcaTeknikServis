/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KargosirketiDao;
import dao.SiparisDao;
import entity.Kargosirketi;
import entity.Siparis;
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
public class SiparisController implements Serializable{
    private Siparis siparis;
    private List<Siparis> siparislist;
    private SiparisDao siparisDao;
    
    private List<Kargosirketi> sirketList;
    
    private KargosirketiDao kargosirketiDao;

    private Long selectedSirket;
    
    public void clear(){
        this.siparis = new Siparis();
    }
    
    public void delete(){
        this.getSiparisDao().delete(this.siparis);
        this.selectedSirket =null;
        this.clear();
    }
    
    public void updateForm(Siparis s){
        this.siparis = s;
        this.selectedSirket = this.siparis.getKargosirketi().getSirket_id();
    }
    
    public void update(){
        this.getSiparisDao().update(this.siparis,selectedSirket);
        this.clear();
    }
    
    public void create(){
        this.getSiparisDao().insert(this.siparis,selectedSirket);
        this.clear();

    }
    
    public Siparis getSiparis() {
        if(this.siparis == null)
            this.siparis = new Siparis();
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }

    public List<Siparis> getSiparislist() {
        this.siparislist = this.getSiparisDao().findAll();
        return siparislist;
    }

    public void setSiparislist(List<Siparis> siparislist) {
        this.siparislist = siparislist;
    }

    public SiparisDao getSiparisDao() {
        if(this.siparisDao == null)
            this.siparisDao = new SiparisDao();
        return siparisDao;
    }

    public void setSiparisDao(SiparisDao siparisDao) {
        this.siparisDao = siparisDao;
    }

    public Long getSelectedSirket() {
        return selectedSirket;
    }

    public void setSelectedSirket(Long selectedSirket) {
        this.selectedSirket = selectedSirket;
    }

    public KargosirketiDao getKargosirketiDao() {
        if(this.kargosirketiDao == null)
            this.kargosirketiDao = new KargosirketiDao();
        return kargosirketiDao;
    }

    public List<Kargosirketi> getSirketList() {
        this.sirketList = this.getKargosirketiDao().findall();
        return sirketList;
    }

    public void setSirketList(List<Kargosirketi> sirketList) {
        this.sirketList = sirketList;
    }

}
