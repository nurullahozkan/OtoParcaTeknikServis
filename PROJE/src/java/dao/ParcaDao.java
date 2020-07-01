/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Parca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author nurullah
 */
public class ParcaDao {
    
     private Connector connector ;
     private Connection connection ;
     
     private FirmaDao firmaDao;
     private TurDao turDao;
     private DepoDao depoDao;
     private SiparisDao siparisDao;
    
    public List<Parca> findAll() {
         List<Parca> parcalist = new ArrayList<>();
        
         try{
             
             PreparedStatement pst = this.getConnection().prepareStatement("select * from parca");
             ResultSet rs = pst.executeQuery();
             
             while(rs.next()){
                 Parca tmp = new Parca();
                 tmp.setParca_id(rs.getLong("parca_id"));
                 tmp.setAdi(rs.getString("adi"));
                 tmp.setAdet(rs.getInt("adet"));
                 tmp.setAlis_fiyati(rs.getInt("alis_fiyati"));
                 tmp.setSatis_fiyati(rs.getInt("satis_fiyati"));
                 
                 tmp.setFirma(this.getFirmaDao().find(rs.getLong("firma_id")));
                 tmp.setTur(this.getTurDao().find(rs.getLong("tur_id")));
                 tmp.setDepo(this.getDepoDao().find(rs.getLong("depo_id")));
                 tmp.setSiparis(this.getSiparisDao().find(rs.getLong("siparis_id")));
                 
                 
                 parcalist.add(tmp);
             }
             
         }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return parcalist;
    }
    
    public List<Parca> findall(){
        List<Parca> plist = new ArrayList<>();
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("select * from parca");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Parca tmp = new Parca();
                tmp.setParca_id(rs.getLong("parca_id"));
                tmp.setAdi(rs.getString("adi"));
                tmp.setAdet(rs.getInt("adet"));
                tmp.setAlis_fiyati(rs.getInt("alis_fiyati"));
                tmp.setSatis_fiyati(rs.getInt("satis_fiyati"));
                tmp.setFirma(this.getFirmaDao().find(rs.getLong("firma_id")));
                tmp.setTur(this.getTurDao().find(rs.getLong("tur_id")));
                tmp.setDepo(this.getDepoDao().find(rs.getLong("depo_id")));
                tmp.setSiparis(this.getSiparisDao().find(rs.getLong("siparis_id")));
                
                
                plist.add(tmp);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return plist;
    }
    
     public Parca find(Long id) {
    
        Parca p = null;
   
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from parca where parca_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            rs.next();
                 
          p = new Parca();
          p.setParca_id(rs.getLong("parca_id"));
          p.setAdi(rs.getString("adi"));
          p.setAdet(rs.getInt("adet"));
          p.setAlis_fiyati(rs.getInt("alis_fiyati"));
          p.setSatis_fiyati(rs.getInt("satis_fiyati"));
          p.setFirma(this.getFirmaDao().find(rs.getLong("firma_id")));
          p.setTur(this.getTurDao().find(rs.getLong("tur_id")));
          p.setDepo(this.getDepoDao().find(rs.getLong("depo_id")));
          p.setSiparis(this.getSiparisDao().find(rs.getLong("siparis_id")));
             
          

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;
    }
    
        public void insert(Parca parca, Long selectedFirma, Long selectedTur, Long selectedDepo, Long selectedSiparis) {
            try{
                
                PreparedStatement pst = this.getConnection().prepareStatement("insert into parca(firma_id, tur_id, depo_id, siparis_id, adi, adet, alis_fiyati, satis_fiyati) "
                        + "values(?, ?, ?, ?, ?, ?, ?, ?)");
                
                pst.setLong(1, selectedFirma);
                pst.setLong(2, selectedTur);
                pst.setLong(3, selectedDepo);
                pst.setLong(4, selectedSiparis);
                pst.setString(5, parca.getAdi());
                pst.setInt(6, parca.getAdet());
                pst.setInt(7, parca.getAlis_fiyati());
                pst.setInt(8, parca.getSatis_fiyati());
                
                pst.executeUpdate();
                
            }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
        
        
    public void update(Parca parca, Long selectedFirma, Long selectedDepo, Long selectedSiparis, Long selectedTur) {

        try{ 
        
            PreparedStatement pst = this.getConnection().prepareStatement("update parca set adi=?, adet=?, alis_fiyati=?,"
                    + " satis_fiyati=?, firma_id=?, tur_id=?, depo_id=?, siparis_id=? where parca_id =?");
            
            pst.setString(1,parca.getAdi());
            pst.setInt(2, parca.getAdet());
            pst.setInt(3, parca.getAlis_fiyati());
            pst.setInt(4, parca.getSatis_fiyati());
            pst.setLong(5,parca.getFirma().getFirma_id());
            pst.setLong(6, parca.getTur().getTur_id());
            pst.setLong(7, parca.getDepo().getDepo_id());
            pst.setLong(8, parca.getSiparis().getSiparis_id());
            pst.setLong(9, parca.getParca_id());
            
            pst.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Parca parca) {
     
        try{ 
        
            PreparedStatement pst = this.getConnection().prepareStatement("delete from parca where parca_id=?");
            pst.setLong(1, parca.getParca_id());
            pst.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
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

      public Connector getConnector() {
        if(this.connector == null)
            this.connector = new Connector();
        return connector;
    }

    public Connection getConnection() {
        if(this.connection == null)
            this.connection = this.getConnector().connect();
        return connection;
    }
 
}
