/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MusteriDao;
import entity.Musteri;
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
public class MusteriController implements Serializable{
    private List<Musteri> musterilist;
    private MusteriDao musteriDao;
    private Musteri musteri;
    
    private int page = 1;
    private int pageSize = 4;
    private int pageCount;
    
    public void updateForm(Musteri m){
        this.musteri = m;
    }
    
    public void update(){
        this.getMusteriDao().update(this.musteri);
        this.clear();
    }
    
    public void delete(){
        this.getMusteriDao().delete(this.musteri);
        this.clear();
    }
            
    public void clear(){
        this.musteri = new Musteri();
    }
    
      public void create(){
        this.getMusteriDao().insert(this.musteri);
        this.clear();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getMusteriDao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public void next(){
        if(this.page == this.getPageCount())
            this.page = 1;
        else
        this.page ++;
    }
    public void previous(){
        if(this.page == 1)
            this.page = this.getPageCount();
        else
        this.page --;
    }
      
    public List<Musteri> getMusterilist() {
        this.musterilist = this.getMusteriDao().findAll(page, pageSize);
        return musterilist;
    }

    public void setMusterilist(List<Musteri> musterilist) {
        this.musterilist = musterilist;
    }

    public MusteriDao getMusteriDao() {
        if(this.musteriDao == null)
            this.musteriDao = new MusteriDao();
        return musteriDao;
    }

    public void setMusteriDao(MusteriDao musteriDao) {
        this.musteriDao = musteriDao;
    }

    public Musteri getMusteri() {
        if(this.musteri == null)
            this.musteri = new Musteri();
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }
 
    
    
}
