/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepoDao;
import dao.FirmaDao;
import dao.ParcaDao;
import dao.SiparisDao;
import dao.TurDao;
import entity.Depo;
import entity.Firma;
import entity.Parca;
import entity.Siparis;
import entity.Tur;
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
public class ParcaController implements Serializable{
    private Parca parca;
    private List<Parca> parcalist;
    private ParcaDao parcaDao;
    
    private List<Firma> firmaList;
    private List<Tur> turList;
    private List<Depo> depoList;
    private List<Siparis> siparisList;
    
    private FirmaDao firmaDao;
    private TurDao turDao;
    private DepoDao depoDao;
    private SiparisDao siparisDao;
    
    private Long selectedFirma;
    private Long selectedTur;
    private Long selectedDepo;
    private Long selectedSiparis;
    
    public void clear(){
        this.parca = new Parca();
    }
    
    public void create(){
        this.getParcaDao().insert(this.parca, selectedFirma, selectedTur, selectedDepo, selectedSiparis);
        this.clear();
    }

    public Parca getParca() {
        if(this.parca == null)
            this.parca = new Parca();
        return parca;
    }

    public void setParca(Parca parca) {
        this.parca = parca;
    }

    public List<Parca> getParcalist() {
        this.parcalist = this.getParcaDao().findAll();
        return parcalist;
    }

    public void setParcalist(List<Parca> parcalist) {
        this.parcalist = parcalist;
    }

    public ParcaDao getParcaDao() {
        if(this.parcaDao == null)
            this.parcaDao = new ParcaDao();
        return parcaDao;
    }

    public void setParcaDao(ParcaDao parcaDao) {
        this.parcaDao = parcaDao;
    }

    public Long getSelectedFirma() {
        return selectedFirma;
    }

    public void setSelectedFirma(Long selectedFirma) {
        this.selectedFirma = selectedFirma;
    }

    public Long getSelectedTur() {
        return selectedTur;
    }

    public void setSelectedTur(Long selectedTur) {
        this.selectedTur = selectedTur;
    }

    public Long getSelectedDepo() {
        return selectedDepo;
    }

    public void setSelectedDepo(Long selectedDepo) {
        this.selectedDepo = selectedDepo;
    }

    public Long getSelectedSiparis() {
        return selectedSiparis;
    }

    public void setSelectedSiparis(Long selectedSiparis) {
        this.selectedSiparis = selectedSiparis;
    }

    public FirmaDao getFirmaDao() {
        if(this.firmaDao == null)
            this.firmaDao = new FirmaDao();
        return firmaDao;
    }

    public TurDao getTurDao() {
        if(this.turDao == null)
            this.turDao = new TurDao();
        return turDao;
    }

    public DepoDao getDepoDao() {
        if(this.depoDao == null)
            this.depoDao = new DepoDao();
        return depoDao;
    }

    public SiparisDao getSiparisDao() {
        if(this.siparisDao == null)
            this.siparisDao = new SiparisDao();
        return siparisDao;
    }

    public List<Firma> getFirmaList() {
        this.firmaList = this.getFirmaDao().findall();
        return firmaList;
    }

    public void setFirmaList(List<Firma> firmaList) {
        this.firmaList = firmaList;
    }

    public List<Tur> getTurList() {
        this.turList = this.getTurDao().findall();
        return turList;
    }

    public void setTurList(List<Tur> turList) {
        this.turList = turList;
    }

    public List<Depo> getDepoList() {
        this.depoList = this.getDepoDao().findall();
        return depoList;
    }

    public void setDepoList(List<Depo> depoList) {
        this.depoList = depoList;
    }

    public List<Siparis> getSiparisList() {
        this.siparisList = this.getSiparisDao().findall();  
        return siparisList;
    }

    public void setSiparisList(List<Siparis> siparisList) {
        this.siparisList = siparisList;
    }
    
    
    
}
